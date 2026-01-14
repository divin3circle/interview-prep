package main

import (
	"fmt"
)

// Stack is a generic stack implementation using a slice
type Stack[T any] struct {
	items []T
}

func NewStack[T any]() *Stack[T] {
	return &Stack[T]{
		items: make([]T, 0),
	}
}

// Push adds element to top - O(1)
func (s *Stack[T]) Push(val T) {
	s.items = append(s.items, val)
}

// Pop removes element from top - O(1)
func (s *Stack[T]) Pop() (T, bool) {
	if len(s.items) == 0 {
		var zero T
		return zero, false
	}
	lastIdx := len(s.items) - 1
	val := s.items[lastIdx]
	s.items = s.items[:lastIdx]
	return val, true
}

// Peek returns top element without removing - O(1)
func (s *Stack[T]) Peek() (T, bool) {
	if len(s.items) == 0 {
		var zero T
		return zero, false
	}
	return s.items[len(s.items)-1], true
}

// IsEmpty checks if stack is empty
func (s *Stack[T]) IsEmpty() bool {
	return len(s.items) == 0
}

func main() {
	fmt.Println("--- Stack Demo ---")
	
	// Create Integer Stack
	stack := NewStack[int]()
	stack.Push(10)
	stack.Push(20)
	stack.Push(30)
	
	if val, ok := stack.Peek(); ok {
		fmt.Printf("Peek: %d\n", val)
	}
	
	if val, ok := stack.Pop(); ok {
		fmt.Printf("Popped: %d\n", val)
	}
	
	fmt.Printf("Is Empty: %v\n", stack.IsEmpty())
	
	// String Stack
	strStack := NewStack[string]()
	strStack.Push("Hello")
	strStack.Push("World")
	val, _ := strStack.Pop()
	fmt.Printf("Popped String: %s\n", val)
}
