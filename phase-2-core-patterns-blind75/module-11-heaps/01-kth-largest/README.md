# Kth Largest Element in a Stream
**Difficulty**: Easy | **Pattern**: Heaps

> Note: If the problem is "Kth Largest Element in an Array", QuickSelect (O(n)) is optimal, but Heap (O(n log k)) is acceptable. This solution assumes the **Stream** version (LeetCode 703) or Heap approach for Array (LeetCode 215).

## Solution (Stream - KthLargest Class)
```java
import java.util.*;

class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();
        for (int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
```
**Time**: O(log k) per add | **Space**: O(k)
