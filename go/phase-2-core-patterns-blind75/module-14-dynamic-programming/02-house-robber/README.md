# House Robber

**Difficulty**: Medium
**Pattern**: DP

## Problem Statement

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. Adjacent houses have security systems connected, so you cannot rob two adjacent houses. Given an integer array `nums` representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

## Approach

### DP
`dp[i] = max(nums[i] + dp[i-2], dp[i-1])`

**Time**: O(N)
**Space**: O(1)

## Go Solution

```go
func rob(nums []int) int {
    rob1, rob2 := 0, 0
    for _, n := range nums {
        rob1, rob2 = rob2, max(n+rob1, rob2)
    }
    return rob2
}

func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}
```
