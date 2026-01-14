package main

import (
	"container/heap"
	"fmt"
)

// An IntHeap is a min-heap of ints.
type IntHeap []int

func (h IntHeap) Len() int           { return len(h) }
func (h IntHeap) Less(i, j int) bool { return h[i] < h[j] }
func (h IntHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }

func (h *IntHeap) Push(x any) {
	// Push and Pop use pointer receivers because they modify the slice's length,
	// not just its contents.
	*h = append(*h, x.(int))
}

func (h *IntHeap) Pop() any {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

// MaxHeap wraps IntHeap but inverts Less
type MaxHeap struct{ IntHeap }

func (h MaxHeap) Less(i, j int) bool { return h.IntHeap[i] > h.IntHeap[j] }

func DemonstrateMinHeap() {
	fmt.Println("--- Min Heap ---")
	h := &IntHeap{5, 1, 10}
	heap.Init(h)
	
	fmt.Printf("Min: %d\n", (*h)[0]) // Peek
	
	fmt.Print("Popping: ")
	for h.Len() > 0 {
		fmt.Printf("%d ", heap.Pop(h))
	}
	fmt.Println()
}

func DemonstrateTopK() {
	fmt.Println("\n--- Top K Largest Pattern ---")
	nums := []int{3, 2, 1, 5, 6, 4}
	k := 3
	
	// Keep Min Heap of size K
	h := &IntHeap{}
	heap.Init(h)
	
	for _, num := range nums {
		heap.Push(h, num)
		if h.Len() > k {
			heap.Pop(h) // Remove smallest
		}
	}
	
	// Heap contains top K largest elements
	fmt.Printf("Top %d elements: %v\n", k, *h)
}

func main() {
	DemonstrateMinHeap()
	DemonstrateTopK()
}
