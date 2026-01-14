package main

import "fmt"

// trap returns amount of trapped rain water.
// Time: O(N)
// Space: O(1)
func trap(height []int) int {
	if len(height) == 0 {
		return 0
	}
	
	l, r := 0, len(height)-1
	leftMax, rightMax := height[l], height[r]
	res := 0
	
	for l < r {
		if leftMax < rightMax {
			l++
			// Update leftMax
			if height[l] > leftMax {
				leftMax = height[l]
			}
			// Add water: difference between limiting height and current height
			// Note: if height[l] was new max, this adds 0
			res += leftMax - height[l]
		} else {
			r--
			// Update rightMax
			if height[r] > rightMax {
				rightMax = height[r]
			}
			// Add water
			res += rightMax - height[r]
		}
	}
	return res
}

func main() {
	tests := [][]int{
		{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1},
		{4, 2, 0, 3, 2, 5},
		{1, 2, 3, 4, 5}, // No water
	}
	
	for i, h := range tests {
		result := trap(h)
		fmt.Printf("Test %d: Input %v -> Trapped: %d\n", i+1, h, result)
	}
}
