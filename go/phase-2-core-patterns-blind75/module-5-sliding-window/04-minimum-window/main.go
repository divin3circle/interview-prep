package main

import "fmt"

// minWindow returns the minimum window in s containing all chars from t.
// Time: O(M + N)
// Space: O(1) (charset size limited)
func minWindow(s string, t string) string {
	if len(t) == 0 {
		return ""
	}
	
	target := make(map[byte]int)
	for i := 0; i < len(t); i++ {
		target[t[i]]++
	}
	
	window := make(map[byte]int)
	have, need := 0, len(target)
	
	// Result tracking: length and start index. Init leng to infinity.
	resLen := len(s) + 1
	resStart := -1
	
	l := 0
	for r := 0; r < len(s); r++ {
		char := s[r]
		window[char]++
		
		// Only check if it satisfies requirement (== is sufficient because we increment)
		if count, ok := target[char]; ok && window[char] == count {
			have++
		}
		
		// While valid window, shrink
		for have == need {
			// Update result if smaller
			if (r - l + 1) < resLen {
				resLen = r - l + 1
				resStart = l
			}
			
			// Pop from left
			leftChar := s[l]
			window[leftChar]--
			
			if count, ok := target[leftChar]; ok && window[leftChar] < count {
				have--
			}
			l++
		}
	}
	
	if resLen > len(s) {
		return ""
	}
	return s[resStart : resStart+resLen]
}

func main() {
	tests := []struct {
		s, t, expected string
	}{
		{"ADOBECODEBANC", "ABC", "BANC"},
		{"a", "a", "a"},
		{"a", "aa", ""},
		{"a", "b", ""},
	}
	
	for i, test := range tests {
		result := minWindow(test.s, test.t)
		status := "FAIL"
		if result == test.expected {
			status = "PASS"
		}
		fmt.Printf("Test %d: %s Input: s=%q, t=%q -> Got: %q\n", i+1, status, test.s, test.t, result)
	}
}
