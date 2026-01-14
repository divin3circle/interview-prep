# Search in Rotated Sorted Array

**Difficulty**: Medium
**Pattern**: Binary Search

## Problem Statement

There is an integer array `nums` sorted in ascending order (with distinct values).

Prior to being passed to your function, `nums` is possibly rotated at an unknown pivot index `k` (`1 <= k < nums.length`) such that the resulting array is `[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]` (0-indexed).

Given the array `nums` after the possible rotation and an integer `target`, return the index of `target` if it is in `nums`, or `-1` if it is not in `nums`.

You must write an algorithm with `O(log n)` runtime complexity.

## Examples

### Example 1
```
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
```

### Example 2
```
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
```

## Approach

### Modified Binary Search (Optimal)
In a rotated sorted array, if we split the array at `mid`, *at least one half* must be sorted.
1. Find `mid`.
2. Check if `nums[left] <= nums[mid]` (Left half is sorted).
   - If `nums[left] <= target < nums[mid]`: Target is in the left half (`right = mid - 1`).
   - Else: Target is in the right half (`left = mid + 1`).
3. Else (Right half is sorted).
   - If `nums[mid] < target <= nums[right]`: Target is in the right half (`left = mid + 1`).
   - Else: Target is in the left half (`right = mid - 1`).

**Time**: O(log N)
**Space**: O(1)

## Go Solution

```go
func search(nums []int, target int) int {
    left, right := 0, len(nums)-1
    
    for left <= right {
        mid := left + (right-left)/2
        
        if nums[mid] == target {
            return mid
        }
        
        // Left portion is sorted
        if nums[left] <= nums[mid] {
            if target >= nums[left] && target < nums[mid] {
                right = mid - 1
            } else {
                left = mid + 1
            }
        } else {
            // Right portion is sorted
            if target > nums[mid] && target <= nums[right] {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
    }
    return -1
}
```

### Key Go Insights
- **Condition `nums[left] <= nums[mid]`**: Correctly identifies if the pivot is to the right of `mid`.

## Edge Cases
- No rotation (algorithm works naturally).
- Pivot is at corners.
- Target not found.
