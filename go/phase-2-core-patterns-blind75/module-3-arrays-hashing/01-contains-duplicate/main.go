package main

import "fmt"

// containsDuplicate checks if any value appears at least twice.
// Time: O(n)
// Space: O(n)
func containsDuplicate(nums []int) bool {
	// Use map[int]struct{} for set behavior (0 bytes for value)
	seen := make(map[int]struct{}, len(nums))
	
	for _, num := range nums {
		if _, exists := seen[num]; exists {
			return true
		}
		seen[num] = struct{}{}
	}
	
	return false
}

func main() {
	// Test Cases
	tests := []struct {
		nums     []int
		expected bool
	}{
		{[]int{1, 2, 3, 1}, true},
		{[]int{1, 2, 3, 4}, false},
		{[]int{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}, true},
		{[]int{}, false},
	}

	for i, test := range tests {
		result := containsDuplicate(test.nums)
		pass := result == test.expected
		status := "FAIL"
		if pass {
			status = "PASS"
		}
		fmt.Printf("Test %d: %s (Input: %v, Got: %v, Expected: %v)\n", 
			i+1, status, test.nums, result, test.expected)
	}
}
