package main

import "fmt"

// dailyTemperatures returns number of days to wait for warmer temp.
// Time: O(N)
// Space: O(N)
func dailyTemperatures(temperatures []int) []int {
	n := len(temperatures)
	res := make([]int, n)
	// Stack stores indices
	stack := []int{}
	
	for i, t := range temperatures {
		// Monotonic Decreasing Stack:
		// If current temp is greater than stack top, we found the next warmer day for stack top
		for len(stack) > 0 && t > temperatures[stack[len(stack)-1]] {
			idx := stack[len(stack)-1]
			stack = stack[:len(stack)-1]
			res[idx] = i - idx
		}
		stack = append(stack, i)
	}
	
	return res
}

func main() {
	tests := [][]int{
		{73, 74, 75, 71, 69, 72, 76, 73},
		{30, 40, 50, 60},
		{30, 60, 90},
	}
	
	for i, temps := range tests {
		result := dailyTemperatures(temps)
		fmt.Printf("Test %d: Input %v -> Got: %v\n", i+1, temps, result)
	}
}
