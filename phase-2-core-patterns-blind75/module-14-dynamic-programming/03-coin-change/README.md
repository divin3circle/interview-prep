# Coin Change

**Difficulty**: Medium  
**Pattern**: Dynamic Programming (Unbounded Knapsack)  
**Companies**: Google, Amazon, Microsoft, Facebook, Apple, Bloomberg

## Problem Statement

You are given an integer array `coins` representing coins of different denominations and an integer `amount` representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return `-1`.

You may assume that you have an infinite number of each kind of coin.

## Examples

### Example 1
```
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
```

### Example 2
```
Input: coins = [2], amount = 3
Output: -1
```

### Example 3
```
Input: coins = [1], amount = 0
Output: 0
```

## Constraints

- `1 <= coins.length <= 12`
- `1 <= coins[i] <= 2^31 - 1`
- `0 <= amount <= 10^4`

## Theoretical Concepts

### Minimal Subproblem
To reach amount `A`, we must have come from amount `A - coin` for some `coin` in our denominations.
`MinCoins(A) = 1 + min(MinCoins(A - c1), MinCoins(A - c2), ...)`

### Greedy is NOT Optimal
Standard US denominations (1, 5, 10, 25) work with a greedy approach, but general denominations do not. For example:
- Coins: `[1, 3, 4]`, Target: `6`.
- Greedy: `4 + 1 + 1` (3 coins).
- Optimal: `3 + 3` (2 coins).
Thus, we must use Dynamic Programming to explore all paths.

### BFS Interpretation
This problem can also be viewed as finding the shortest path in a graph where:
- Nodes are amounts (0 to `amount`).
- Edges are coin values.
- We want the shortest path from node 0 to node `amount`.

## Approach

### Dynamic Programming (Tabulation)
**Time**: O(amount * n), **Space**: O(amount)

1. Create a `dp` array of size `amount + 1`.
2. Initialize `dp[0] = 0` and all other indexes to a large value (e.g., `amount + 1`).
3. For `i` from `1` to `amount`:
   - For each `coin` in `coins`:
     - If `i - coin >= 0`:
       - `dp[i] = min(dp[i], 1 + dp[i-coin])`
4. If `dp[amount]` is still the large value, return -1. Otherwise, return `dp[amount]`.

**Why it's optimal**: We systematically compute the minimum for every possible amount exactly once.

## Solution

See [solution.java](solution.java) for implementation.

## Key Insights

1. **Infinity substitute**: Using `amount + 1` as "infinity" is safer than `Integer.MAX_VALUE` because it avoids overflow when adding 1.
2. **Order of loops**: Iterating through amount then coins (or vice versa) works for "Minimum Coins", but the order matters for "Total Number of Ways" (Coin Change II).
3. **Zero amount base case**: Always requires 0 coins.

## Edge Cases

- **Amount is 0**.
- **No coin combination can reach the amount**.
- **A single coin is larger than the amount**.
- **One coin is exactly equal to the amount**.
- **Coins are not sorted**.

## Related Problems

- Coin Change II (LeetCode 518) - total number of combinations.
- Minimum Cost For Tickets (LeetCode 983)
- Perfect Squares (LeetCode 279)
