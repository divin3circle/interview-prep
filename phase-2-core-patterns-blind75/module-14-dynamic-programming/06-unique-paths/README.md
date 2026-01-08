# Unique Paths

**Difficulty**: Medium  
**Pattern**: Dynamic Programming (Grid)

## Problem Statement
There is a robot on an `m x n` grid. The robot is initially located at the top-left corner (i.e., `grid[0][0]`). The robot tries to move to the bottom-right corner (i.e., `grid[m-1][n-1]`). The robot can only move either down or right at any point in time.

Given the two integers `m` and `n`, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

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
Explanation:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
```

## Constraints
* `1 <= m, n <= 100`

## Approach

### 1. Dynamic Programming
Since we can only move Right or Down, a cell `(i, j)` can be reached from:
* Top: `(i-1, j)`
* Left: `(i, j-1)`
`dp[i][j] = dp[i-1][j] + dp[i][j-1]`

### 2. Space Optimization
We typically iterate row by row. Notice we only need the values from the *current row* (left neighbor) and the *previous row* (top neighbor).
We can reduce the 2D matrix to a 1D array.
`row[j] = row[j] (from top) + row[j-1] (from left)`

### 3. Math (Combinatorics)
Total moves needed: `(m-1)` downs + `(n-1)` rights = `m+n-2` total moves.
We need to choose `m-1` moves to be 'down'.
Result = `(m+n-2) Choose (m-1)`.

## Solution

See [solution.java](solution.java) for the implementation.
