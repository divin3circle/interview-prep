# Climbing Stairs

**Difficulty**: Easy
**Pattern**: DP (Fibonacci)

## Problem Statement

You are climbing a staircase. It takes `n` steps to reach the top. Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

## Approach

### DP (Fibonacci Pattern)
`dp[i] = dp[i-1] + dp[i-2]`

**Time**: O(N)
**Space**: O(1)

## Go Solution

```go
func climbStairs(n int) int {
    if n <= 1 {
        return 1
    }
    prev, curr := 1, 1
    for i := 2; i <= n; i++ {
        prev, curr = curr, prev+curr
    }
    return curr
}
```
