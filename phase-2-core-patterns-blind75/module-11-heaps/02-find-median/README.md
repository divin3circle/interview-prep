# Find Median from Data Stream

**Difficulty**: Hard  
**Pattern**: Two Heaps  
**Companies**: Google, Amazon, Microsoft, Facebook, Apple, Bloomberg, Uber

## Problem Statement

The **median** is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.

For example:
- For `arr = [2,3,4]`, the median is `3`.
- For `arr = [2,3]`, the median is `(2 + 3) / 2 = 2.5`.

Implement the `MedianFinder` class:
- `MedianFinder()` initializes the `MedianFinder` object.
- `void addNum(int num)` adds the integer `num` from the data stream to the data structure.
- `double findMedian()` returns the median of all elements so far. Answers within `10^-5` of the actual answer will be accepted.

## Examples

### Example 1
```
Input
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]
Output
[null, null, null, 1.5, null, 2.0]

Explanation
MedianFinder medianFinder = new MedianFinder();
medianFinder.addNum(1);    // arr = [1]
medianFinder.addNum(2);    // arr = [1, 2]
medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
medianFinder.addNum(3);    // arr[1, 2, 3]
medianFinder.findMedian(); // return 2.0
```

## Constraints

- `-10^5 <= num <= 10^5`
- There will be at least one element in the data structure before calling `findMedian`.
- At most `5 * 10^4` calls will be made to `addNum` and `findMedian`.

## Theoretical Concepts

### The Two-Heap Pattern
To find the median, we need quick access to the "middle" elements of a sorted sequence. We can achieve this by splitting the elements into two halves:
1. **Low Half (Max-Heap)**: Stores the smaller half of numbers. The largest among them (`low.peek()`) is one of the candidates for the median.
2. **High Half (Min-Heap)**: Stores the larger half of numbers. The smallest among them (`high.peek()`) is the other candidate for the median.

### Balancing the Heaps
To ensure the heaps correctly represent the two halves:
- The size difference between the two heaps must not exceed 1.
- Every element in the Max-Heap must be less than or equal to every element in the Min-Heap.

### Time Complexity Tradeoff
- **Sorting**: `addNum` is O(1), `findMedian` is O(N log N).
- **Insertion Sort**: `addNum` is O(N), `findMedian` is O(1).
- **Two Heaps**: `addNum` is O(log N), `findMedian` is O(1). This is the optimal balance for a streaming context.

## Approach

### Two Heaps (Optimal)
**Time**: `addNum` is O(log n), `findMedian` is O(1), **Space**: O(n)

1. Maintain `small` (max-heap) and `large` (min-heap).
2. For `addNum(n)`:
   - Add to `small`.
   - Pop from `small`, add to `large` (ensures `max(small) <= min(large)`).
   - If `large.size() > small.size()`, pop from `large`, add to `small` (ensures size balance).
3. For `findMedian()`:
   - If `small.size() > large.size()`, return `small.peek()`.
   - Else, return `(small.peek() + large.peek()) / 2.0`.

**Why it's optimal**: Logarithmic insertion is the best we can do for maintaining a partially sorted structure.

## Solution

See [solution.java](solution.java) for implementation.

## Key Insights

1. **Max-Heap for Left, Min-Heap for Right**: This puts both "middle" values at the roots of their respective heaps.
2. **Double Pushing**: Adding to one heap and then immediately moving the root to the other heap is a clean way to maintain the global sorting invariant.
3. **Data Stream**: This approach is designed for scenarios where data arrives one by one and we don't know the final size.

## Edge Cases

- **Even number of elements**.
- **Odd number of elements**.
- **All numbers are the same**.
- **Numbers added in strictly increasing/decreasing order**.
- **Floating point precision**: Be careful to return `double` (e.g., `2.0` not `2`).

## Related Problems

- Sliding Window Median (LeetCode 480)
- IPO (LeetCode 502) - uses two heaps for greedy optimization.
- Kth Largest Element in an Array (LeetCode 215)
