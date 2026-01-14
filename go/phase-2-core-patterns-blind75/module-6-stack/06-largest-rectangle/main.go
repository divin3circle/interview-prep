package main

import "fmt"

// largestRectangleArea returns the largest rectangle area in the histogram.
// Time: O(N)
// Space: O(N)
func largestRectangleArea(heights []int) int {
	// Append 0 height to ensure we process remaining items in stack
	// Note: We copy to avoid mutating the input slice visible to caller if capacity allows
	// But in competitive programming mutating local input is fine.
	// For purity, let's just append.
	hWithSentinel := append(heights, 0)
	stack := []int{}
	maxArea := 0
	
	for i, h := range hWithSentinel {
		// Maintain monotonic increasing stack
		for len(stack) > 0 && h < hWithSentinel[stack[len(stack)-1]] {
			height := hWithSentinel[stack[len(stack)-1]]
			stack = stack[:len(stack)-1]
			
			width := i
			if len(stack) > 0 {
				width = i - stack[len(stack)-1] - 1
			}
			
			area := height * width
			if area > maxArea {
				maxArea = area
			}
		}
		stack = append(stack, i)
	}
	
	return maxArea
}

func main() {
	tests := [][]int{
		{2, 1, 5, 6, 2, 3},
		{2, 4},
		{2, 1, 2},
	}
	
	for i, heights := range tests {
		// Pass a copy or recreate because our func appends to it
		// (though the func uses a new slice header, safe enough)
		h := make([]int, len(heights))
		copy(h, heights)
		result := largestRectangleArea(h)
		fmt.Printf("Test %d: Input %v -> Got: %d\n", i+1, heights, result)
	}
}
