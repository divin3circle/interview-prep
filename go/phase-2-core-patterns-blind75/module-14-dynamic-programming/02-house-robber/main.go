package main

import "fmt"

func rob(nums []int) int {
	rob1, rob2 := 0, 0
	for _, n := range nums {
		rob1, rob2 = rob2, max(n+rob1, rob2)
	}
	return rob2
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func main() {
	fmt.Printf("Rob [1,2,3,1]: %d (Expected: 4)\n", rob([]int{1, 2, 3, 1}))
	fmt.Printf("Rob [2,7,9,3,1]: %d (Expected: 12)\n", rob([]int{2, 7, 9, 3, 1}))
}
