package main

import (
	"fmt"
	"sort"
)

// threeSum returns unique triplets summing to zero.
// Time: O(N^2)
// Space: O(1)
func threeSum(nums []int) [][]int {
	sort.Ints(nums)
	var res [][]int
	
	for i := 0; i < len(nums)-2; i++ {
		// Optimization: If current number > 0, we can't sum to 0
		if nums[i] > 0 {
			break
		}
		
		// Skip duplicate first element
		if i > 0 && nums[i] == nums[i-1] {
			continue
		}
		
		l, r := i+1, len(nums)-1
		for l < r {
			sum := nums[i] + nums[l] + nums[r]
			
			if sum == 0 {
				res = append(res, []int{nums[i], nums[l], nums[r]})
				// Skip duplicates for 2nd element
				for l < r && nums[l] == nums[l+1] {
					l++
				}
				// Skip duplicates for 3rd element
				for l < r && nums[r] == nums[r-1] {
					r--
				}
				l++
				r--
			} else if sum < 0 {
				l++
			} else {
				r--
			}
		}
	}
	return res
}

func main() {
	tests := [][]int{
		{-1, 0, 1, 2, -1, -4},
		{0, 1, 1},
		{0, 0, 0},
	}
	
	for i, nums := range tests {
		// Make a copy for printing input since sort modifies in-place
		inputCopy := make([]int, len(nums))
		copy(inputCopy, nums)
		
		result := threeSum(nums)
		fmt.Printf("Test %d: Input %v -> Output %v\n", i+1, inputCopy, result)
	}
}
