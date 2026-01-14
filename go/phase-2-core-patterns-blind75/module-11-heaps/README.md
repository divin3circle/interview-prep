# Module 11: Heaps / Priority Queue

## Pattern Overview

Heaps (Priority Queues) allow O(1) access to min/max element and O(log n) insertion/deletion. Useful for "Top K" problems or finding medians.

## Core Techniques (Go Style)

### Using container/heap
Go provides `container/heap` package. You need to implement the `heap.Interface`:
```go
type IntHeap []int

func (h IntHeap) Len() int           { return len(h) }
func (h IntHeap) Less(i, j int) bool { return h[i] < h[j] } // Min heap
func (h IntHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }
func (h *IntHeap) Push(x interface{}) { *h = append(*h, x.(int)) }
func (h *IntHeap) Pop() interface{} {
    old := *h
    n := len(old)
    x := old[n-1]
    *h = old[0 : n-1]
    return x
}
```

### Max Heap
For max heap, reverse the `Less` function: `return h[i] > h[j]`

## Problems in This Module

### 1. Kth Largest Element in an Array
**Difficulty**: Medium
[View Problem](01-kth-largest/README.md)

### 2. Find Median from Data Stream
**Difficulty**: Hard
[View Problem](02-find-median/README.md)

## Key Takeaway
Use heaps when you need continuous access to max/min elements.
