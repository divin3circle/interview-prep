# Coin Change

**Difficulty**: Medium  
**Pattern**: Dynamic Programming (Unbounded Knapsack)

## Problem Statement
You are given an integer array `coins` representing coins of different denominations and an integer `amount` representing a total amount of money. Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return `-1`.

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

## Constraints
* `1 <= coins.length <= 12`
* `1 <= coins[i] <= 2^31 - 1`
* `0 <= amount <= 10^4`

## Approach

### 1. BFS (Greedy FAILS)
Using a Greedy approach (always taking largest coin) fails. Example: Coins `[1, 3, 4]`, Amount `6`. Greedy takes `4, 1, 1` (3 coins). Optimal is `3, 3` (2 coins).
BFS can find the shortest path in a graph where nodes are amounts and edges are coin values, but DP is more standard here.

### 2. Dynamic Programming (Bottom-Up)
`dp[i]` = minimum coins to make amount `i`.
* Base Case: `dp[0] = 0`
* Recurrence: `dp[i] = min(dp[i], 1 + dp[i - coin])` for every coin.
* Initialize array with `amount + 1` (a value larger than any possible solution) to represent infinity.

## Solution

See [solution.java](solution.java) for the implementation.
