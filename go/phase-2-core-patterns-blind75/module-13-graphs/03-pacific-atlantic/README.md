# Pacific Atlantic Water Flow

**Difficulty**: Medium
**Pattern**: DFS from Borders

## Problem Statement

Given an `m x n` matrix of non-negative integers representing the height of each unit cell, find all cells from which water can flow to both the Pacific and Atlantic oceans.

## Approach

### Reverse DFS
Start from ocean borders and DFS inward.

**Time**: O(M * N)
**Space**: O(M * N)

## Go Solution

```go
func pacificAtlantic(heights [][]int) [][]int {
    if len(heights) == 0 {
        return [][]int{}
    }
    m, n := len(heights), len(heights[0])
    pacific := make([][]bool, m)
    atlantic := make([][]bool, m)
    for i := range pacific {
        pacific[i] = make([]bool, n)
        atlantic[i] = make([]bool, n)
    }
    
    var dfs func(int, int, [][]bool)
    dfs = func(i, j int, ocean [][]bool) {
        ocean[i][j] = true
        dirs := [][]int{{0,1},{0,-1},{1,0},{-1,0}}
        for _, d := range dirs {
            ni, nj := i+d[0], j+d[1]
            if ni >= 0 && ni < m && nj >= 0 && nj < n && !ocean[ni][nj] && heights[ni][nj] >= heights[i][j] {
                dfs(ni, nj, ocean)
            }
        }
    }
    
    for i := 0; i < m; i++ {
        dfs(i, 0, pacific)
        dfs(i, n-1, atlantic)
    }
    for j := 0; j < n; j++ {
        dfs(0, j, pacific)
        dfs(m-1, j, atlantic)
    }
    
    result := [][]int{}
    for i := 0; i < m; i++ {
        for j := 0; j < n; j++ {
            if pacific[i][j] && atlantic[i][j] {
                result = append(result, []int{i, j})
            }
        }
    }
    return result
}
```
