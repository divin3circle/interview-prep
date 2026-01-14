package main

import "fmt"

// searchMatrix finds target in a sorted 2D matrix.
// Time: O(log(M*N))
// Space: O(1)
func searchMatrix(matrix [][]int, target int) bool {
	rows := len(matrix)
	if rows == 0 {
		return false
	}
	cols := len(matrix[0])
	
	// Treat as 1D array from 0 to rows*cols-1
	left, right := 0, rows*cols-1
	
	for left <= right {
		mid := left + (right-left)/2
		
		// Map 1D index to 2D coordinates
		r := mid / cols
		c := mid % cols
		midVal := matrix[r][c]
		
		if midVal == target {
			return true
		}
		
		if midVal < target {
			left = mid + 1
		} else {
			right = mid - 1
		}
	}
	return false
}

func main() {
	matrix := [][]int{
		{1, 3, 5, 7},
		{10, 11, 16, 20},
		{23, 30, 34, 60},
	}
	
	tests := []struct {
		target int
		want   bool
	}{
		{3, true},
		{13, false},
		{1, true},
		{60, true},
		{0, false},
		{100, false},
	}
	
	for i, test := range tests {
		got := searchMatrix(matrix, test.target)
		status := "FAIL"
		if got == test.want {
			status = "PASS"
		}
		fmt.Printf("Test %d: %s Target: %d -> Got: %v\n", i+1, status, test.target, got)
	}
}
