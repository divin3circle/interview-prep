package main

import "fmt"

// search finds target in rotated sorted array.
// Time: O(log N)
// Space: O(1)
func search(nums []int, target int) int {
	left, right := 0, len(nums)-1
	
	for left <= right {
		mid := left + (right-left)/2
		
		if nums[mid] == target {
			return mid
		}
		
		// Determine which side is sorted
		if nums[left] <= nums[mid] {
			// Left side is sorted
			if target >= nums[left] && target < nums[mid] {
				right = mid - 1
			} else {
				left = mid + 1
			}
		} else {
			// Right side is sorted
			if target > nums[mid] && target <= nums[right] {
				left = mid + 1
			} else {
				right = mid - 1
			}
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
		{[]int{4, 5, 6, 7, 0, 1, 2}, 0, 4},
		{[]int{4, 5, 6, 7, 0, 1, 2}, 3, -1},
		{[]int{1}, 0, -1},
		{[]int{1, 3}, 3, 1},
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
