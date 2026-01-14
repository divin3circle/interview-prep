# Heaps

## Implementation
Go's `container/heap` package provides heap operations for any type that implements `heap.Interface`.
It requires defining `Len`, `Less`, `Swap`, `Push`, `Pop`.

This is more verbose than Java's `PriorityQueue` but offers more control.

## Complexity
- Push/Pop: O(log n)
- Init (Heapify): O(n)
