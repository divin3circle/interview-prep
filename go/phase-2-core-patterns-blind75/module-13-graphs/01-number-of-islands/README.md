# Number of Islands

**Difficulty**: Medium
**Pattern**: DFS (Grid)

## Problem Statement

Given an `m x n` 2D binary grid which represents a map of '1's (land) and '0's (water), return the number of islands.

## Approach

### DFS
1. Iterate through grid.
2. When finding '1', increment count and DFS to mark entire island as '0'.

**Time**: O(M * N)
**Space**: O(M * N)

## Go Solution

```go
func numIslands(grid [][]byte) int {
    count := 0
    for i := 0; i < len(grid); i++ {
        for j := 0; j < len(grid[0]); j++ {
            if grid[i][j] == '1' {
                dfs(grid, i, j)
                count++
            }
        }
    }
    return count
}

func dfs(grid [][]byte, i, j int) {
    if i < 0 || j < 0 || i >= len(grid) || j >= len(grid[0]) || grid[i][j] == '0' {
        return
    }
    grid[i][j] = '0'
    dfs(grid, i+1, j)
    dfs(grid, i-1, j)
    dfs(grid, i, j+1)
    dfs(grid, i, j-1)
}
```
