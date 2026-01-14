# Module 14: Dynamic Programming

## Pattern Overview

Dynamic Programming breaks problems into subproblems and stores results to avoid re-computation.

## Core Techniques (Go Style)

### Bottom-Up (Tabulation)
```go
dp := make([]int, n+1)
dp[0] = base_case
for i := 1; i <= n; i++ {
    dp[i] = // compute from dp[i-1], dp[i-2], etc.
}
return dp[n]
```

### Top-Down (Memoization)
```go
memo := make(map[int]int)
var solve func(int) int
solve = func(n int) int {
    if val, exists := memo[n]; exists {
        return val
    }
    // compute result
    memo[n] = result
    return result
}
```

## Problems in This Module

### 1. Climbing Stairs
**Difficulty**: Easy
[View Problem](01-climbing-stairs/README.md)

### 2. House Robber
**Difficulty**: Medium
[View Problem](02-house-robber/README.md)

### 3. Coin Change
**Difficulty**: Medium
[View Problem](03-coin-change/README.md)

### 4. Longest Increasing Subsequence
**Difficulty**: Medium
[View Problem](04-longest-increasing/README.md)

### 5. Word Break
**Difficulty**: Medium
[View Problem](05-word-break/README.md)

### 6. Unique Paths
**Difficulty**: Medium
[View Problem](06-unique-paths/README.md)

## Key Takeaway
Identify overlapping subproblems and optimal substructure. Choose between top-down (memoization) and bottom-up (tabulation).
