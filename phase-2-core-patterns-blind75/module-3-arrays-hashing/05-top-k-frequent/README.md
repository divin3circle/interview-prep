# Top K Frequent Elements

**Difficulty**: Medium  
**Pattern**: Arrays & Hashing  
**Companies**: Google, Amazon, Facebook, Microsoft, Apple

## Problem Statement

Given an integer array `nums` and an integer `k`, return the `k` most frequent elements. You may return the answer in any order.

## Examples

### Example 1
```
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Explanation: 1 appears 3 times, 2 appears 2 times, 3 appears 1 time
```

### Example 2
```
Input: nums = [1], k = 1
Output: [1]
```

## Constraints

- `1 <= nums.length <= 10^5`
- `-10^4 <= nums[i] <= 10^4`
- `k` is in the range `[1, number of unique elements]`
- Answer is guaranteed to be unique

## Theoretical Concepts

### Frequency Counting
First step for any "top k frequent" problem:
- Use HashMap to count occurrences: `Map<Element, Frequency>`
- Time: O(n), Space: O(unique elements)

### Bucket Sort
Bucket sort works when values have limited range:
- Create array of buckets where `bucket[i]` = list of elements with frequency `i`
- Frequency range: [1, n] where n = array length
- Collect from highest frequency buckets until we have k elements
- **Time**: O(n) - single pass to count, single pass to collect
- **Space**: O(n) - frequency map + buckets

### Min Heap Approach
Use a min heap (priority queue) of size k:
- Iterate through frequency map
- Add element to heap; if size > k, remove minimum
- Final heap contains k most frequent elements
- **Time**: O(n log k) - n insertions, each O(log k)
- **Space**: O(n) for frequency map + O(k) for heap

### Quickselect (Alternative)
Partition-based selection algorithm:
- Similar to quicksort but only recurse on one side
- Average **Time**: O(n), Worst **Time**: O(n²)
- More complex to implement than heap or bucket sort

### Approach Comparison

| Approach | Time | Space | Best When |
|----------|------|-------|-----------|
| Bucket Sort | O(n) | O(n) | k is large, want optimal time |
| Min Heap | O(n log k) | O(n) | k is small (k << n) |
| Quickselect | O(n) avg | O(n) | Need in-place, can handle worst case |
| Sorting | O(n log n) | O(n) | Simple implementation, k close to n |

## Edge Cases

- **All same frequency**: `[1,2,3], k=2` → Any 2 elements valid
- **Single element**: `[1], k=1` → `[1]`
- **k equals unique count**: Return all unique elements
- **All elements unique**: `[1,2,3,4,5], k=3` → Any 3 elements (all frequency 1)
- **Negative numbers**: Works same as positive numbers
- **k = 1**: Most frequent element only

## Approach

### Heap (Priority Queue)
**Time**: O(n log k), **Space**: O(n)

Count frequencies, then use min-heap of size k to track top k elements.

**Why it works**: Heap maintains k largest frequencies efficiently.

### Bucket Sort (Optimal)
**Time**: O(n), **Space**: O(n)

Count frequencies, then use bucket sort where index = frequency. Collect from highest frequency buckets.

**Why it's optimal**: Linear time by exploiting frequency range [1, n].

## Solution

See [solution.java](solution.java) for implementations.

## Key Insights

1. **Frequency counting is first step**: HashMap to count occurrences
2. **Bucket sort exploits constraints**: Frequency is bounded by array length
3. **Heap is more general**: Works when k is small relative to n
4. **Trade-off**: Heap O(n log k) vs Bucket O(n) but more space

## Follow-Up Questions

**Q**: What if k is very large (close to n)?  
**A**: Bucket sort is better; heap advantage diminishes.

**Q**: What if we need elements in frequency order?  
**A**: Bucket sort naturally provides this; heap needs sorting.

**Q**: How would you handle streaming data?  
**A**: Maintain frequency map and heap, update as new elements arrive.

## Related Problems

- Kth Largest Element in an Array (LeetCode 215)
- Sort Characters By Frequency (LeetCode 451)
- Top K Frequent Words (LeetCode 692)
