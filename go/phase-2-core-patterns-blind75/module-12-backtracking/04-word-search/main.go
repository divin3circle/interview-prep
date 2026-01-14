package main

import "fmt"

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
	board[i][j] = '#' // Mark visited
	
	found := dfs(board, word, i+1, j, index+1) ||
		dfs(board, word, i-1, j, index+1) ||
		dfs(board, word, i, j+1, index+1) ||
		dfs(board, word, i, j-1, index+1)
	
	board[i][j] = temp // Backtrack
	return found
}

func main() {
	board := [][]byte{
		{'A', 'B', 'C', 'E'},
		{'S', 'F', 'C', 'S'},
		{'A', 'D', 'E', 'E'},
	}
	
	fmt.Printf("Word 'ABCCED' exists: %v (Expected: true)\n", exist(board, "ABCCED"))
	fmt.Printf("Word 'SEE' exists: %v (Expected: true)\n", exist(board, "SEE"))
	fmt.Printf("Word 'ABCB' exists: %v (Expected: false)\n", exist(board, "ABCB"))
}
