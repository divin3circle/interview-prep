package main

import (
	"fmt"
	"unicode"
)

// isPalindrome checks if string is palindrome (case-insensitive, ignoring non-alphanumeric).
// Time: O(N)
// Space: O(1)
func isPalindrome(s string) bool {
	l, r := 0, len(s)-1
	
	for l < r {
		// Use unicode package for robust checking (handles more than just ASCII)
		// but access by byte index implies we are taking a risk on multi-byte chars
		// unless we convert to rune slice.
		// For standard interview "Valid Palindrome", rune slice is safer.
		// Let's do the robust rune-slice approach for correctness.
		
		// Actually, converting to []rune takes O(N) space.
		// To keep O(1) space, we should iterate using range or handle UTF-8 decoding.
		// However, typical strict O(1) space solutions in Go for interviews often accept
		// ASCII or assume valid byte indexing.
		// Let's implement the standard rune slice version for correctness/ease,
		// and simple ASCII version as alternative.
		
		// Optimization: Just use ASCII assumption as it's standard for this specific LeetCode/Blind75 problem.
		// We will implement manual isAlphanumeric for bytes.
		
		for l < r && !isAlphanumeric(s[l]) {
			l++
		}
		for l < r && !isAlphanumeric(s[r]) {
			r--
		}
		
		if toLower(s[l]) != toLower(s[r]) {
			return false
		}
		l++
		r--
	}
	return true
}

func isAlphanumeric(b byte) bool {
	return (b >= 'a' && b <= 'z') || 
	       (b >= 'A' && b <= 'Z') || 
	       (b >= '0' && b <= '9')
}

func toLower(b byte) byte {
	if b >= 'A' && b <= 'Z' {
		return b + ('a' - 'A')
	}
	return b
}

// Unicode Safe Version (Allocates O(N) memory)
func isPalindromeUnicode(s string) bool {
	runes := []rune(s)
	l, r := 0, len(runes)-1
	for l < r {
		for l < r && !unicode.IsLetter(runes[l]) && !unicode.IsNumber(runes[l]) {
			l++
		}
		for l < r && !unicode.IsLetter(runes[r]) && !unicode.IsNumber(runes[r]) {
			r--
		}
		if unicode.ToLower(runes[l]) != unicode.ToLower(runes[r]) {
			return false
		}
		l++
		r--
	}
	return true
}

func main() {
	tests := []struct {
		input    string
		expected bool
	}{
		{"A man, a plan, a canal: Panama", true},
		{"race a car", false},
		{" ", true},
		{"0P", false},
	}
	
	for i, test := range tests {
		result := isPalindrome(test.input)
		status := "FAIL"
		if result == test.expected {
			status = "PASS"
		}
		fmt.Printf("Test %d: %s Input: %q -> Got: %v\n", i+1, status, test.input, result)
	}
}
