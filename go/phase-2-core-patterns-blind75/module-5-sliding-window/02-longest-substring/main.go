package main

import "fmt"

// lengthOfLongestSubstring returns the length of the longest substring without repeating characters.
// Time: O(N)
// Space: O(min(N, M))
func lengthOfLongestSubstring(s string) int {
	// Using map of byte to int for ASCII optimization.
	// For full unicode, use map[rune]int and range loop.
	lastSeen := make(map[byte]int)
	maxLength := 0
	left := 0
	
	for right := 0; right < len(s); right++ {
		char := s[right]
		
		// If duplicate found in current window
		if idx, found := lastSeen[char]; found && idx >= left {
			left = idx + 1
		}
		
		lastSeen[char] = right
		
		currentLen := right - left + 1
		if currentLen > maxLength {
			maxLength = currentLen
		}
	}
	return maxLength
}

func main() {
	tests := []struct {
		input    string
		expected int
	}{
		{"abcabcbb", 3},
		{"bbbbb", 1},
		{"pwwkew", 3},
		{"", 0},
		{"au", 2},
	}
	
	for i, test := range tests {
		result := lengthOfLongestSubstring(test.input)
		status := "FAIL"
		if result == test.expected {
			status = "PASS"
		}
		fmt.Printf("Test %d: %s Input: %q -> Got: %d\n", i+1, status, test.input, result)
	}
}
