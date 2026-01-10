# Unique Paths

**Difficulty**: Medium  
**Pattern**: Dynamic Programming (Grid)  
**Companies**: Google, Amazon, Microsoft, Facebook, Apple, Bloomberg, Adobe

## Problem Statement

There is a robot on an `m x n` grid. The robot is initially located at the **top-left corner** (`grid[0][0]`). The robot tries to move to the **bottom-right corner** (`grid[m - 1][n - 1]`). The robot can only move either **down** or **right** at any point in time.

Given the two integers `m` and `n`, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to `2 * 10^9`.

## Examples

### Example 1
```
Input: m = 3, n = 7
Output: 28
```

### Example 2
```
Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
```

## Constraints

- `1 <= m, n <= 100`

## Theoretical Concepts

### Combination Problem (Math)
This problem can be solved using combinatorics. To get from `(0,0)` to `(m-1, n-1)`, the robot must take exactly `m-1` down moves and `n-1` right moves.
The total number of moves is `(m-1) + (n-1)`.
The number of unique paths is the number of ways to choose the `m-1` down moves out of the total moves:
`Ways = C(m + n - 2, m - 1)`

### DP Recurrence Relation
Because the robot can only arrive at cell `(r, c)` from either `(r-1, c)` or `(r, c-1)`:
`Paths(r, c) = Paths(r-1, c) + Paths(r, c-1)`

### Base Cases
- Any cell in the first row has only 1 path (always move right).
- Any cell in the first column has only 1 path (always move down).

### Space Optimization
We only need the previous row to calculate the current row. We can reduce space complexity to O(n) by using a single 1D array and updating it in-place.

## Approach

### Dynamic Programming (Tabulation)
**Time**: O(m * n), **Space**: O(n)

1. Create a 1D `dp` array of size `n` initialized to 1s (representing the first row).
2. For each row from `1` to `m-1`:
   - For each column from `1` to `n-1`:
     - `dp[c] = dp[c] + dp[c-1]`
3. Return `dp[n-1]`.

**Why it's optimal**: We visit each cell once and use minimal memory.

## Solution

See [solution.java](solution.java) for implementation.

## Key Insights

1. **Directional constraint**: Only being able to move Down and Right prevents cycles and makes DP very natural.
2. **Pascal's Triangle**: The grid literally fills up with Pascal's Triangle values if you look at it diagonally.
3. **Additive nature**: The number of ways to reach a point is the sum of the ways to reach all its immediate predecessors.

## Edge Cases

- **Grid is 1x1** (1 path).
- **Grid is a single row** (1 path).
- **Grid is a single column** (1 path).
- **Large grid** (up to 100x100).

## Related Problems

- Unique Paths II (LeetCode 63) - with obstacles.
- Minimum Path Sum (LeetCode 64)
- Dungeon Game (LeetCode 174)
- Cherry Pickup (LeetCode 741)
