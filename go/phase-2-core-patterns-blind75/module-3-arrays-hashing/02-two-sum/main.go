package main

import "fmt"

// twoSum returns indices of two numbers summing to target.
// Time: O(n)
// Space: O(n)
func twoSum(nums []int, target int) []int {
	// Map to store value -> index
	seen := make(map[int]int)
	
	for i, num := range nums {
		complement := target - num
		
		// Check if complement exists in map
		if idx, found := seen[complement]; found {
			return []int{idx, i}
		}
		
		// Add current number to map
		seen[num] = i
	}
	
	return nil // Should not be reached given constraints
}

func main() {
	// Test Cases
	type TestCase struct {
		nums     []int
		target   int
		expected []int
	}

	tests := []TestCase{
		{[]int{2, 7, 11, 15}, 9, []int{0, 1}},
		{[]int{3, 2, 4}, 6, []int{1, 2}},
		{[]int{3, 3}, 6, []int{0, 1}},
	}

	for i, test := range tests {
		result := twoSum(test.nums, test.target)
		// Basic validation: sum check (indices might be swapped order but problem allows any)
		pass := false
		if len(result) == 2 {
			if test.nums[result[0]]+test.nums[result[1]] == test.target {
				pass = true
			}
		}
		
		status := "FAIL"
		if pass {
			status = "PASS"
		}
		fmt.Printf("Test %d: %s (Input: %v, Target: %d, Got: %v)\n", 
			i+1, status, test.nums, test.target, result)
	}
}
