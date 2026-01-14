package main

import "fmt"

// isAnagram checks if two strings are anagrams.
// Time: O(n)
// Space: O(1) (fixed 26 chars)
func isAnagram(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}
	
	// Use array for O(1) overhead
	var counts [26]int
	
	for i := 0; i < len(s); i++ {
		counts[s[i]-'a']++
		counts[t[i]-'a']--
	}
	
	for _, count := range counts {
		if count != 0 {
			return false
		}
	}
	
	return true
}

// Unicode support version (Follow-up)
func isAnagramUnicode(s string, t string) bool {
	if len(s) != len(t) { // Byte length check (rough proxy)
		// Note: for unicode, rune count might differ even if byte len is same? 
		// Actually best to just rely on map counts.
	}
	
	counts := make(map[rune]int)
	for _, r := range s {
		counts[r]++
	}
	for _, r := range t {
		counts[r]--
		if counts[r] < 0 {
			return false
		}
	}
	return true
}

func main() {
	tests := []struct {
		s, t     string
		expected bool
	}{
		{"anagram", "nagaram", true},
		{"rat", "car", false},
		{"a", "ab", false},
	}

	for i, test := range tests {
		result := isAnagram(test.s, test.t)
		pass := result == test.expected
		status := "FAIL"
		if pass {
			status = "PASS"
		}
		fmt.Printf("Test %d: %s ('%s', '%s') -> %v\n", 
			i+1, status, test.s, test.t, result)
	}
}
