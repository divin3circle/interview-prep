package main

import "fmt"

// isValid checks if brackets are balanced using a stack.
// Time: O(N)
// Space: O(N)
func isValid(s string) bool {
	// Stack to store opening brackets
	stack := []rune{}
	
	// Map closing to opening for easy checking
	pairs := map[rune]rune{
		')': '(',
		']': '[',
		'}': '{',
	}
	
	for _, char := range s {
		// If current char is a closing bracket
		if open, isClose := pairs[char]; isClose {
			// Stack must not be empty
			if len(stack) == 0 {
				return false
			}
			
			// Pop the top element
			top := stack[len(stack)-1]
			stack = stack[:len(stack)-1]
			
			// Check if it matches
			if top != open {
				return false
			}
		} else {
			// It's an opening bracket, push to stack
			stack = append(stack, char)
		}
	}
	
	// Valid only if stack is empty at end
	return len(stack) == 0
}

func main() {
	tests := []struct {
		input    string
		expected bool
	}{
		{"()", true},
		{"()[]{}", true},
		{"(]", false},
		{"([)]", false},
		{"]", false},
		{"", true},
	}
	
	for i, test := range tests {
		result := isValid(test.input)
		status := "FAIL"
		if result == test.expected {
			status = "PASS"
		}
		fmt.Printf("Test %d: %s Input: %q -> Got: %v\n", i+1, status, test.input, result)
	}
}
