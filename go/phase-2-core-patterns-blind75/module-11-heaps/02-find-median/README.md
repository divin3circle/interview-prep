# Find Median from Data Stream

**Difficulty**: Hard
**Pattern**: Two Heaps

## Problem Statement

The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.

Implement the MedianFinder class:
- `MedianFinder()` initializes the object.
- `void addNum(int num)` adds the integer `num` from the data stream.
- `double findMedian()` returns the median of all elements so far.

## Approach

### Two Heaps (Optimal)
Use two heaps:
1. **Max Heap (small)**: Contains smaller half of numbers.
2. **Min Heap (large)**: Contains larger half of numbers.

Keep heaps balanced (size difference ≤ 1).
- If total is odd, median is top of larger heap.
- If even, median is average of both tops.

**Time**: O(log n) add, O(1) findMedian
**Space**: O(n)

## Go Solution

```go
type MedianFinder struct {
    small *MaxHeap // smaller half
    large *MinHeap // larger half
}

func Constructor() MedianFinder {
    small := &MaxHeap{}
    large := &MinHeap{}
    heap.Init(small)
    heap.Init(large)
    return MedianFinder{small: small, large: large}
}

func (this *MedianFinder) AddNum(num int) {
    heap.Push(this.small, num)
    // Balance: ensure max of small <= min of large
    if this.small.Len() > 0 && this.large.Len() > 0 && (*this.small)[0] > (*this.large)[0] {
        val := heap.Pop(this.small).(int)
        heap.Push(this.large, val)
    }
    // Balance sizes
    if this.small.Len() > this.large.Len()+1 {
        val := heap.Pop(this.small).(int)
        heap.Push(this.large, val)
    }
    if this.large.Len() > this.small.Len()+1 {
        val := heap.Pop(this.large).(int)
        heap.Push(this.small, val)
    }
}

func (this *MedianFinder) FindMedian() float64 {
    if this.small.Len() > this.large.Len() {
        return float64((*this.small)[0])
    }
    if this.large.Len() > this.small.Len() {
        return float64((*this.large)[0])
    }
    return (float64((*this.small)[0]) + float64((*this.large)[0])) / 2.0
}
```
