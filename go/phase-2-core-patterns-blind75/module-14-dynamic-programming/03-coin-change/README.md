# Coin Change

**Difficulty**: Medium
**Pattern**: DP (Unbounded Knapsack)

## Problem Statement

You are given an integer array `coins` representing coins of different denominations and an integer `amount` representing a total amount of money. Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return `-1`.

## Approach

### DP
`dp[i] = min(dp[i], 1 + dp[i-coin])`

**Time**: O(amount * coins)
**Space**: O(amount)

## Go Solution

```go
func coinChange(coins []int, amount int) int {
    dp := make([]int, amount+1)
    for i := range dp {
        dp[i] = amount + 1
    }
    dp[0] = 0
    
    for a := 1; a <= amount; a++ {
        for _, c := range coins {
            if a-c >= 0 {
                dp[a] = min(dp[a], 1+dp[a-c])
            }
        }
    }
    
    if dp[amount] > amount {
        return -1
    }
    return dp[amount]
}

func min(a, b int) int {
    if a < b {
        return a
    }
    return b
}
```
