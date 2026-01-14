# Binary Search

**Difficulty**: Easy
**Pattern**: Binary Search

## Problem Statement

Given an array of integers `nums` which is sorted in ascending order, and an integer `target`, write a function to search `target` in `nums`. If `target` exists, then return its index. Otherwise, return `-1`.

You must write an algorithm with `O(log n)` runtime complexity.

## Examples

### Example 1
```
Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
```

### Example 2
```
Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1
```

## Approach

### Basic Binary Search (Optimal)
We maintain a search interval `[left, right]`.
1. Find the midpoint `mid = left + (right - left) / 2`.
2. Compare `nums[mid]` with `target`.
   - If match, return `mid`.
   - If `nums[mid] < target`, the target must be in the right half: `left = mid + 1`.
   - If `nums[mid] > target`, the target must be in the left half: `right = mid - 1`.
3. If `left > right` (interval empty), return `-1`.

**Time**: O(log N)
**Space**: O(1)

## Go Solution

```go
func search(nums []int, target int) int {
    left, right := 0, len(nums)-1
    
    // <= because the search space includes equality (range of size 1)
    for left <= right {
        // mid calculation avoids integer overflow
        mid := left + (right-left)/2
        
        if nums[mid] == target {
            return mid
        }
        
        if nums[mid] < target {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    
    return -1
}
```

### Key Go Insights
- **Midpoint Overflow**: Although less common with 64-bit ints in Go, `left + (right-left)/2` is the idiomatic safe way to calculate mid.
- **Bounds**: Be careful with indices. `len(nums)-1` is the correct initial `right`.

## Edge Cases
- Target not found.
- Empty array (loop won't execute).
- Single element array.
