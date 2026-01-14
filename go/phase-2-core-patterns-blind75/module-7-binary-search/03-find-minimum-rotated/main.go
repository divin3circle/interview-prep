package main

import "fmt"

// findMin returns the minimum element in a rotated sorted array.
// Time: O(log N)
// Space: O(1)
func findMin(nums []int) int {
	left, right := 0, len(nums)-1
	
	for left < right {
		mid := left + (right-left)/2
		
		// If mid element is greater than right element, 
		// the minimum must be in the right unsuccesful half.
		if nums[mid] > nums[right] {
			left = mid + 1
		} else {
			// If mid element is less than (or equal) right element,
			// the right half is sorted, so minimum is at mid or to the left.
			right = mid
		}
	}
	// left == right is the index of the minimum element
	return nums[left]
}

func main() {
	tests := []struct {
		nums []int
		want int
	}{
		{[]int{3, 4, 5, 1, 2}, 1},
		{[]int{4, 5, 6, 7, 0, 1, 2}, 0},
		{[]int{11, 13, 15, 17}, 11},
		{[]int{1}, 1},
		{[]int{2, 1}, 1},
	}
	
	for i, test := range tests {
		got := findMin(test.nums)
		status := "FAIL"
		if got == test.want {
			status = "PASS"
		}
		fmt.Printf("Test %d: %s Input: nums=%v -> Got: %d\n", i+1, status, test.nums, got)
	}
}
