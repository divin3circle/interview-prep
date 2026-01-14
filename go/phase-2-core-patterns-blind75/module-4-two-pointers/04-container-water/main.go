package main

import "fmt"

// maxArea returns the maximum water a container can store.
// Time: O(N)
// Space: O(1)
func maxArea(height []int) int {
	left, right := 0, len(height)-1
	maxArea := 0
	
	for left < right {
		// Calculate area
		// Go 1.21+ has built-in min/max, but explicit helpers ensure compatibility
		h := min(height[left], height[right])
		w := right - left
		area := h * w
		
		maxArea = max(maxArea, area)
		
		// Move pointer with smaller height
		if height[left] < height[right] {
			left++
		} else {
			right--
		}
	}
	return maxArea
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func main() {
	tests := [][]int{
		{1, 8, 6, 2, 5, 4, 8, 3, 7},
		{1, 1},
		{4, 3, 2, 1, 4},
	}
	
	for i, height := range tests {
		result := maxArea(height)
		fmt.Printf("Test %d: Input %v -> Max Area: %d\n", i+1, height, result)
	}
}
