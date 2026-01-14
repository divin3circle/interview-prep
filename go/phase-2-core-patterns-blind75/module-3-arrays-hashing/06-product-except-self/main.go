package main

import "fmt"

// productExceptSelf returns product of all elements except self.
// Time: O(N)
// Space: O(1) (output array excluded)
func productExceptSelf(nums []int) []int {
	n := len(nums)
	res := make([]int, n)
	
	// 1. Prefix pass: res[i] contains product of 0...i-1
	res[0] = 1
	for i := 1; i < n; i++ {
		res[i] = res[i-1] * nums[i-1]
	}
	
	// 2. Suffix pass: multiply by product of i+1...n-1
	suffix := 1
	for i := n - 1; i >= 0; i-- {
		res[i] *= suffix
		suffix *= nums[i]
	}
	
	return res
}

func main() {
	tests := [][]int{
		{1, 2, 3, 4},
		{-1, 1, 0, -3, 3},
	}
	
	for i, nums := range tests {
		result := productExceptSelf(nums)
		fmt.Printf("Test %d: Input %v -> Output %v\n", i+1, nums, result)
	}
}
