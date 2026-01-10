# Kth Largest Element in an Array

**Difficulty**: Medium  
**Pattern**: Heap / Quickselect  
**Companies**: Google, Amazon, Microsoft, Facebook, Apple, Bloomberg, Uber

## Problem Statement

Given an integer array `nums` and an integer `k`, return the `k`th largest element in the array.

Note that it is the `k`th largest element in the sorted order, not the `k`th distinct element.

Can you solve it without sorting?

## Examples

### Example 1
```
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
```

### Example 2
```
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
```

## Constraints

- `1 <= k <= nums.length <= 10^5`
- `-10^4 <= nums[i] <= 10^4`

## Theoretical Concepts

### Min-Heap for K-Largest
If we need the k largest elements, a **min-heap** of size `k` is efficient:
1. Iterate through the array.
2. Push each element into the heap.
3. If the heap size exceeds `k`, pop the smallest element (the minimum).
4. After processing all elements, the heap contains the `k` largest values. The `k`th largest is at the top (`heap.peek()`).

### Max-Heap Alternative
Using a max-heap of all `n` elements and popping `k-1` times also works, but takes O(n log n) in the worst case if `k` is near `n`.

### Quickselect (Hoare's Selection Algorithm)
Quickselect is a selection algorithm that finds the `k`th smallest/largest element in an unordered list. It is related to Quicksort.
- **Average Time**: O(n).
- **Worst Time**: O(n²), though this can be mitigated with random pivot selection.
- Unlike heaps, Quickselect can be done in-place.

## Approach

### Min-Heap (Practical Optimal)
**Time**: O(n log k), **Space**: O(k)

Maintain a min-heap of size `k`.

**Why it's used**: Very reliable performance and easy to implement with built-in libraries like `java.util.PriorityQueue`.

### Quickselect (Theoretical Optimal)
**Time**: O(n) average, **Space**: O(1)

Partition the array similar to quicksort but only recurse into one half.

**Why it's optimal**: Reaches linear time on average.

## Solution

See [solution.java](solution.java) for implementation.

## Key Insights

1. **Size K Heap**: The min-heap effectively acts as a "filter" that only allows the largest `k` elements to stay.
2. **K-th largest vs K-th smallest**: K-th largest is equivalent to (n-k+1)-th smallest.
3. **Sorting is overkill**: Complete sorting takes O(n log n), which is worse than the heap or Quickselect approaches when `k << n`.

## Edge Cases

- **k = 1** (Maximum element).
- **k = nums.length** (Minimum element).
- **Array with all duplicate values**.
- **Array with negative numbers**.
- **k is larger than the number of distinct elements**.

## Related Problems

- Top K Frequent Elements (LeetCode 347)
- Kth Largest Element in a Stream (LeetCode 703)
- Find Median from Data Stream (LeetCode 295)
