package main

import "fmt"

// characterReplacement returns length of longest same-char substring after k replacements.
// Time: O(N)
// Space: O(1)
func characterReplacement(s string, k int) int {
	counts := make([]int, 26)
	maxFreq := 0
	maxLength := 0
	left := 0
	
	for right := 0; right < len(s); right++ {
		charIdx := s[right] - 'A'
		counts[charIdx]++
		
		if counts[charIdx] > maxFreq {
			maxFreq = counts[charIdx]
		}
		
		// If replacements needed exceed k, shrink window
		if (right - left + 1) - maxFreq > k {
			counts[s[left]-'A']--
			left++
		}
		
		// Update max length
		currentLen := right - left + 1
		if currentLen > maxLength {
			maxLength = currentLen
		}
	}
	return maxLength
}

func main() {
	tests := []struct {
		s        string
		k        int
		expected int
	}{
		{"ABAB", 2, 4},
		{"AABABBA", 1, 4},
	}
	
	for i, test := range tests {
		result := characterReplacement(test.s, test.k)
		status := "FAIL"
		if result == test.expected {
			status = "PASS"
		}
		fmt.Printf("Test %d: %s Input: s=%q, k=%d -> Got: %d\n", i+1, status, test.s, test.k, result)
	}
}
