package main

import "fmt"

func lengthOfLIS(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	dp := make([]int, len(nums))
	for i := range dp {
		dp[i] = 1
	}
	maxLen := 1
	
	for i := 1; i < len(nums); i++ {
		for j := 0; j < i; j++ {
			if nums[i] > nums[j] {
				dp[i] = max(dp[i], 1+dp[j])
			}
		}
		maxLen = max(maxLen, dp[i])
	}
	return maxLen
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func main() {
	fmt.Printf("LIS [10,9,2,5,3,7,101,18]: %d (Expected: 4)\n", lengthOfLIS([]int{10, 9, 2, 5, 3, 7, 101, 18}))
	fmt.Printf("LIS [0,1,0,3,2,3]: %d (Expected: 4)\n", lengthOfLIS([]int{0, 1, 0, 3, 2, 3}))
}
