package main

import "fmt"

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

func main() {
	fmt.Printf("Unique paths 3x7: %d (Expected: 28)\n", uniquePaths(3, 7))
	fmt.Printf("Unique paths 3x2: %d (Expected: 3)\n", uniquePaths(3, 2))
}
