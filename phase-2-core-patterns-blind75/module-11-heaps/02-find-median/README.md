# Find Median from Data Stream
**Difficulty**: Hard | **Pattern**: Heaps (Two Heaps)

## Solution
```java
import java.util.*;

class MedianFinder {
    private PriorityQueue<Integer> small; // Max heap for lower half
    private PriorityQueue<Integer> large; // Min heap for upper half

    public MedianFinder() {
        small = new PriorityQueue<>((a, b) -> b - a);
        large = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        small.add(num);
        if (!small.isEmpty() && !large.isEmpty() && small.peek() > large.peek()) {
            large.add(small.poll());
        }
        
        if (small.size() > large.size() + 1) {
            large.add(small.poll());
        }
        if (large.size() > small.size() + 1) {
            small.add(large.poll());
        }
    }
    
    public double findMedian() {
        if (small.size() > large.size()) return small.peek();
        if (large.size() > small.size()) return large.peek();
        return (small.peek() + large.peek()) / 2.0;
    }
}
```
**Time**: O(log n) add, O(1) find | **Space**: O(n)
