package main

import "fmt"

func permute(nums []int) [][]int {
	result := [][]int{}
	used := make([]bool, len(nums))
	var backtrack func([]int)
	backtrack = func(path []int) {
		if len(path) == len(nums) {
			result = append(result, append([]int{}, path...))
			return
		}
		for i := 0; i < len(nums); i++ {
			if used[i] {
				continue
			}
			used[i] = true
			backtrack(append(path, nums[i]))
			used[i] = false
		}
	}
	backtrack([]int{})
	return result
}

func main() {
	nums := []int{1, 2, 3}
	result := permute(nums)
	fmt.Printf("Permutations of %v:\n", nums)
	for _, perm := range result {
		fmt.Println(perm)
	}
}
