# Longest Increasing Subsequence

**Difficulty**: Medium
**Pattern**: DP

## Problem Statement

Given an integer array `nums`, return the length of the longest strictly increasing subsequence.

## Approach

### DP
`dp[i]` = length of LIS ending at index i.

**Time**: O(N²)
**Space**: O(N)

## Go Solution

```go
func lengthOfLIS(nums []int) int {
    if len(nums) == 0 {
        return 0
    }
    dp := make([]int, len(nums))
    for i := range dp {
        dp[i] = 1
    }
    maxLen := 1
    
    for i := 1; i < len(nums); i++ {
        for j := 0; j < i; j++ {
            if nums[i] > nums[j] {
                dp[i] = max(dp[i], 1+dp[j])
            }
        }
        maxLen = max(maxLen, dp[i])
    }
    return maxLen
}

func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}
```
