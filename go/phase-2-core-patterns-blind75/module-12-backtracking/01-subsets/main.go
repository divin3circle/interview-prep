package main

import "fmt"

func subsets(nums []int) [][]int {
	result := [][]int{}
	var backtrack func(int, []int)
	backtrack = func(start int, path []int) {
		// Add current subset
		result = append(result, append([]int{}, path...))
		for i := start; i < len(nums); i++ {
			backtrack(i+1, append(path, nums[i]))
		}
	}
	backtrack(0, []int{})
	return result
}

func main() {
	nums := []int{1, 2, 3}
	result := subsets(nums)
	fmt.Printf("Subsets of %v:\n", nums)
	for _, subset := range result {
		fmt.Println(subset)
	}
}
