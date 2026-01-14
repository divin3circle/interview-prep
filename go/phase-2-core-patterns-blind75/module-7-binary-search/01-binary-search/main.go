package main

import "fmt"

// search finds the target in a sorted array using binary search.
// Time: O(log N)
// Space: O(1)
func search(nums []int, target int) int {
	left, right := 0, len(nums)-1
	
	for left <= right {
		// Prevent potential overflow for very large N, though rarely an issue on 64-bit systems
		mid := left + (right-left)/2
		
		if nums[mid] == target {
			return mid
		}
		
		if nums[mid] < target {
			left = mid + 1
		} else {
			right = mid - 1
		}
	}
	
	return -1
}

func main() {
	tests := []struct {
		nums   []int
		target int
		want   int
	}{
		{[]int{-1, 0, 3, 5, 9, 12}, 9, 4},
		{[]int{-1, 0, 3, 5, 9, 12}, 2, -1},
		{[]int{5}, 5, 0},
	}
	
	for i, test := range tests {
		got := search(test.nums, test.target)
		status := "FAIL"
		if got == test.want {
			status = "PASS"
		}
		fmt.Printf("Test %d: %s Input: nums=%v, target=%d -> Got: %d\n", i+1, status, test.nums, test.target, got)
	}
}
