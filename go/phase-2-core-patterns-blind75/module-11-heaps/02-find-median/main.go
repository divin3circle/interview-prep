package main

import (
	"container/heap"
	"fmt"
)

// MaxHeap for smaller half
type MaxHeap []int

func (h MaxHeap) Len() int           { return len(h) }
func (h MaxHeap) Less(i, j int) bool { return h[i] > h[j] } // Max heap
func (h MaxHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }
func (h *MaxHeap) Push(x interface{}) {
	*h = append(*h, x.(int))
}
func (h *MaxHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

// MinHeap for larger half
type MinHeap []int

func (h MinHeap) Len() int           { return len(h) }
func (h MinHeap) Less(i, j int) bool { return h[i] < h[j] } // Min heap
func (h MinHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }
func (h *MinHeap) Push(x interface{}) {
	*h = append(*h, x.(int))
}
func (h *MinHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

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

func main() {
	mf := Constructor()
	mf.AddNum(1)
	mf.AddNum(2)
	fmt.Printf("Median: %.1f (Expected: 1.5)\n", mf.FindMedian())
	mf.AddNum(3)
	fmt.Printf("Median: %.1f (Expected: 2.0)\n", mf.FindMedian())
}
