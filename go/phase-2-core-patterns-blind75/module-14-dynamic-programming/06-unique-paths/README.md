# Unique Paths

**Difficulty**: Medium
**Pattern**: DP (Grid)

## Problem Statement

There is a robot on an `m x n` grid. The robot is initially located at the top-left corner. The robot tries to move to the bottom-right corner. The robot can only move either down or right at any point in time. Given the two integers `m` and `n`, return the number of possible unique paths.

## Approach

### DP
`dp[i][j] = dp[i+1][j] + dp[i][j+1]`

**Time**: O(M * N)
**Space**: O(N)

## Go Solution

```go
func uniquePaths(m int, n int) int {
    row := make([]int, n)
    for i := range row {
        row[i] = 1
    }
    
    for i := 0; i < m-1; i++ {
        newRow := make([]int, n)
        newRow[n-1] = 1
        for j := n - 2; j >= 0; j-- {
            newRow[j] = newRow[j+1] + row[j]
        }
        row = newRow
    }
    return row[0]
}
```
