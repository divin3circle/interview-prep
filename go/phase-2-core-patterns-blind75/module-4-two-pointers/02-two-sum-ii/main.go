package main

import "fmt"

// twoSum returns 1-based indices of two numbers summing to target.
// Time: O(N)
// Space: O(1)
func twoSum(numbers []int, target int) []int {
	l, r := 0, len(numbers)-1
	
	for l < r {
		sum := numbers[l] + numbers[r]
		
		if sum == target {
			// Return 1-based indices
			return []int{l + 1, r + 1}
		} else if sum < target {
			// Sum too small, need larger numbers (move right)
			l++
		} else {
			// Sum too large, need smaller numbers (move left)
			r--
		}
	}
	
	// Should not be reached per problem constraints
	return nil
}

func main() {
	tests := []struct {
		numbers []int
		target  int
		expected []int
	}{
		{[]int{2, 7, 11, 15}, 9, []int{1, 2}},
		{[]int{2, 3, 4}, 6, []int{1, 3}},
		{[]int{-1, 0}, -1, []int{1, 2}},
	}
	
	for i, test := range tests {
		result := twoSum(test.numbers, test.target)
		// Check equality
		pass := false
		if len(result) == 2 && result[0] == test.expected[0] && result[1] == test.expected[1] {
			pass = true
		}
		status := "FAIL"
		if pass {
			status = "PASS"
		}
		
		fmt.Printf("Test %d: %s Input: %v Target: %d -> Got: %v\n", 
			i+1, status, test.numbers, test.target, result)
	}
}
