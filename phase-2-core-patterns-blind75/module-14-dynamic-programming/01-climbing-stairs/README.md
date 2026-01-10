# Climbing Stairs

**Difficulty**: Easy  
**Pattern**: Dynamic Programming (Fibonacci)  
**Companies**: Google, Amazon, Microsoft, Facebook, Apple, Bloomberg, Adobe

## Problem Statement

You are climbing a staircase. It takes `n` steps to reach the top.

Each time you can either climb `1` or `2` steps. In how many distinct ways can you climb to the top?

## Examples

### Example 1
```
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
```

### Example 2
```
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
```

## Constraints

- `1 <= n <= 45`

## Theoretical Concepts

### Optimal Substructure
To reach step `n`, you must have come from either:
- Step `n-1` (by taking 1 step)
- Step `n-2` (by taking 2 steps)
Therefore, `Ways(n) = Ways(n-1) + Ways(n-2)`. This is the same recurrence relation as the Fibonacci sequence.

### Overlapping Subproblems
A naive recursive solution would calculate `Ways(n-5)` many times. Dynamic programming saves these results to avoid redundant calculations.

### Memoization vs Tabulation
- **Memoization (Top-Down)**: Recurse from `n` to `1`, storing results in a map/array.
- **Tabulation (Bottom-Up)**: Build up from `1` to `n` using a loop.

### Space Optimization
Since we only need the last two values to calculate the current one, we can reduce space from O(n) to O(1) by using two variables instead of an entire array.

## Approach

### Dynamic Programming (Bottom-Up)
**Time**: O(n), **Space**: O(1)

1. Base cases: `n=1 -> 1`, `n=2 -> 2`.
2. Use two variables `one` and `two` to track `Ways(i-1)` and `Ways(i-2)`.
3. Iterate from `3` to `n`, updating variables.
4. Return `one`.

**Why it's optimal**: We calculate each step exactly once using constant extra memory.

## Solution

See [solution.java](solution.java) for implementation.

## Key Insights

1. **Relation to Fibonacci**: One of the simplest and most famous DP problems.
2. **Combinatorial interpretation**: The number of ways to sum to `n` using only 1s and 2s.
3. **Step-by-step building**: Large problems are solved by combining solutions to slightly smaller problems.

## Edge Cases

- **n = 1**.
- **n = 2**.
- **n = 45** (Max constraint, check for integer overflow—though 45 fits in a 32-bit signed integer).

## Related Problems

- Fibonacci Number (LeetCode 509)
- Min Cost Climbing Stairs (LeetCode 746)
- Decode Ways (LeetCode 91)
- Unique Paths (LeetCode 62)
