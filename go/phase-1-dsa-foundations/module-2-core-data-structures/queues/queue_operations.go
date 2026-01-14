package main

import (
	"fmt"
)

// Queue is a generic queue implementation using a slice
// Note: For heavy production use, slice re-slicing can cause memory leaks
// (underlying array stays). For interviews, this is usually acceptable,
// but mentioning "ring buffer" or "container/list" is bonus points.
type Queue[T any] struct {
	items []T
}

func NewQueue[T any]() *Queue[T] {
	return &Queue[T]{
		items: make([]T, 0),
	}
}

// Enqueue adds to rear - O(1)
func (q *Queue[T]) Enqueue(val T) {
	q.items = append(q.items, val)
}

// Dequeue removes from front - O(1) amortized / O(n) depending on implementation details
// Strictly slice[1:] is O(1) for the operation, but eventually we might reallocate.
func (q *Queue[T]) Dequeue() (T, bool) {
	if len(q.items) == 0 {
		var zero T
		return zero, false
	}
	val := q.items[0]
	q.items = q.items[1:]
	// Optional: Compact memory if capacity >> size to avoid leak (O(n))
	return val, true
}

// Peek returns front element
func (q *Queue[T]) Peek() (T, bool) {
	if len(q.items) == 0 {
		var zero T
		return zero, false
	}
	return q.items[0], true
}

func (q *Queue[T]) IsEmpty() bool {
	return len(q.items) == 0
}

func main() {
	fmt.Println("--- Queue Demo ---")
	
	q := NewQueue[string]()
	q.Enqueue("First")
	q.Enqueue("Second")
	q.Enqueue("Third")
	
	if val, ok := q.Peek(); ok {
		fmt.Printf("Head: %s\n", val)
	}
	
	if val, ok := q.Dequeue(); ok {
		fmt.Printf("Dequeued: %s\n", val) // First
	}
	
	if val, ok := q.Dequeue(); ok {
		fmt.Printf("Dequeued: %s\n", val) // Second
	}
}
