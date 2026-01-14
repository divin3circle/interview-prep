package main

import "fmt"

func combinationSum(candidates []int, target int) [][]int {
	result := [][]int{}
	var backtrack func(int, int, []int)
	backtrack = func(start, remain int, path []int) {
		if remain < 0 {
			return
		}
		if remain == 0 {
			result = append(result, append([]int{}, path...))
			return
		}
		for i := start; i < len(candidates); i++ {
			backtrack(i, remain-candidates[i], append(path, candidates[i]))
		}
	}
	backtrack(0, target, []int{})
	return result
}

func main() {
	candidates := []int{2, 3, 6, 7}
	target := 7
	result := combinationSum(candidates, target)
	fmt.Printf("Combinations that sum to %d:\n", target)
	for _, combo := range result {
		fmt.Println(combo)
	}
}
