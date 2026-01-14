package main

import (
	"fmt"
	"strconv"
)

// evalRPN evaluates Reverse Polish Notation expression.
// Time: O(N)
// Space: O(N)
func evalRPN(tokens []string) int {
	stack := []int{}
	
	for _, token := range tokens {
		switch token {
		case "+":
			b := stack[len(stack)-1]; stack = stack[:len(stack)-1]
			a := stack[len(stack)-1]; stack = stack[:len(stack)-1]
			stack = append(stack, a+b)
		case "-":
			b := stack[len(stack)-1]; stack = stack[:len(stack)-1]
			a := stack[len(stack)-1]; stack = stack[:len(stack)-1]
			stack = append(stack, a-b)
		case "*":
			b := stack[len(stack)-1]; stack = stack[:len(stack)-1]
			a := stack[len(stack)-1]; stack = stack[:len(stack)-1]
			stack = append(stack, a*b)
		case "/":
			b := stack[len(stack)-1]; stack = stack[:len(stack)-1]
			a := stack[len(stack)-1]; stack = stack[:len(stack)-1]
			stack = append(stack, a/b)
		default:
			val, _ := strconv.Atoi(token)
			stack = append(stack, val)
		}
	}
	// Result is the last remaining element
	return stack[0]
}

func main() {
	tests := [][]string{
		{"2", "1", "+", "3", "*"},
		{"4", "13", "5", "/", "+"},
		{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"},
	}
	
	for i, tokens := range tests {
		result := evalRPN(tokens)
		fmt.Printf("Test %d: Input %v -> Got: %d\n", i+1, tokens, result)
	}
}
