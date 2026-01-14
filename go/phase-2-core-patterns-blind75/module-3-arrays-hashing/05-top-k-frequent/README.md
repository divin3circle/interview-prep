# Top K Frequent Elements

**Difficulty**: Medium
**Pattern**: Arrays & Hashing

## Problem Statement

Given an integer array `nums` and an integer `k`, return the `k` most frequent elements.

## Examples

### Example 1
```
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
```

### Example 2
```
Input: nums = [1], k = 1
Output: [1]
```

## Approach

### 1. Heap (Priority Queue)
- Count frequencies: O(N).
- maintain Min-Heap of size K: O(N log K).
- **Time**: O(N log K)

### 2. Bucket Sort (Optimal)
- Count frequencies: O(N).
- Create buckets where index is frequency count. `buckets[count] = list of numbers`.
- Size of buckets array is `len(nums) + 1` (max frequency is N).
- Iterate buckets from end (highest freq) to start to pick K elements.
- **Time**: O(N)
- **Space**: O(N)

## Go Solution

```go
func topKFrequent(nums []int, k int) []int {
    counts := make(map[int]int)
    for _, n := range nums {
        counts[n]++
    }
    
    // Bucket sort: index = frequency
    // Since freq can be at most len(nums), make slice of size len(nums)+1
    buckets := make([][]int, len(nums)+1)
    for n, count := range counts {
        buckets[count] = append(buckets[count], n)
    }
    
    var res []int
    // Iterate from highest frequency down
    for i := len(buckets) - 1; i > 0 && len(res) < k; i-- {
        if len(buckets[i]) > 0 {
            res = append(res, buckets[i]...)
        }
    }
    
    // If we added slightly more than k (e.g. k=2, but last bucket had 2 items makes total 3)
    // Problem usually implies unique answer, but just in case:
    if len(res) > k {
        res = res[:k]
    }
    return res
}
```

### Key Go Insights
- **Slice of Slices**: `make([][]int, len(nums)+1)` creates the buckets structure efficiently.
- **Append**: `append(res, buckets[i]...)` expands the slice into arguments.

## Edge Cases
- `k == len(unique)`: Return all.
- `k == 1`: Return single most frequent.
