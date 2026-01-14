# Kth Largest Element in a Stream

**Difficulty**: Easy
**Pattern**: Min Heap

## Problem Statement

Design a class to find the `kth` largest element in a stream. Note that it is the `kth` largest element in the sorted order, not the `kth` distinct element.

## Approach

### Min Heap of Size K
Maintain a min heap of size k containing the k largest elements.
- The root of this heap is the kth largest element.
- When adding a new element, if heap size > k, remove the smallest.

**Time**: O(log k) per add
**Space**: O(k)

## Go Solution

```go
type KthLargest struct {
    k    int
    heap *MinHeap
}

func Constructor(k int, nums []int) KthLargest {
    h := &MinHeap{}
    heap.Init(h)
    kth := KthLargest{k: k, heap: h}
    for _, num := range nums {
        kth.Add(num)
    }
    return kth
}

func (this *KthLargest) Add(val int) int {
    heap.Push(this.heap, val)
    if this.heap.Len() > this.k {
        heap.Pop(this.heap)
    }
    return (*this.heap)[0]
}
```
