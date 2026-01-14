# Word Search

**Difficulty**: Medium
**Pattern**: Backtracking (2D Grid)

## Problem Statement

Given an `m x n` grid of characters `board` and a string `word`, return `true` if `word` exists in the grid. The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

## Approach

### DFS Backtracking
1. Try starting from each cell.
2. For each cell, DFS in 4 directions.
3. Mark visited cells (modify board), backtrack by unmarking.

**Time**: O(M * N * 4^L) where L is word length
**Space**: O(L)

## Go Solution

```go
func exist(board [][]byte, word string) bool {
    for i := 0; i < len(board); i++ {
        for j := 0; j < len(board[0]); j++ {
            if dfs(board, word, i, j, 0) {
                return true
            }
        }
    }
    return false
}

func dfs(board [][]byte, word string, i, j, index int) bool {
    if index == len(word) {
        return true
    }
    if i < 0 || i >= len(board) || j < 0 || j >= len(board[0]) || board[i][j] != word[index] {
        return false
    }
    temp := board[i][j]
    board[i][j] = '#'
    found := dfs(board, word, i+1, j, index+1) ||
            dfs(board, word, i-1, j, index+1) ||
            dfs(board, word, i, j+1, index+1) ||
            dfs(board, word, i, j-1, index+1)
    board[i][j] = temp
    return found
}
```
