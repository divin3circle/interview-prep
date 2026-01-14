# Find Minimum in Rotated Sorted Array

**Difficulty**: Medium
**Pattern**: Binary Search

## Problem Statement

Suppose an array of length `n` sorted in ascending order is rotated between `1` and `n` times. Given the sorted rotated array `nums` of unique elements, return the minimum element of this array.

You must write an algorithm that runs in `O(log n)` time.

## Examples

### Example 1
```
Input: nums = [3,4,5,1,2]
Output: 1
Explanation: Original [1,2,3,4,5] rotated 3 times.
```

### Example 2
```
Input: nums = [4,5,6,7,0,1,2]
Output: 0
```

### Example 3
```
Input: nums = [11,13,15,17]
Output: 11
```

## Approach

### Binary Search (Find Inflection Point)
We need to find the element which is smaller than its predecessor (the "pivot").
1. Initialize `left`, `right`.
2. Loop while `left < right`:
   - `mid = left + (right-left)/2`
   - Compare `nums[mid]` vs `nums[right]`.
     - If `nums[mid] > nums[right]`: The minimum must be to the right of `mid`. `left = mid + 1`.
     - If `nums[mid] < nums[right]`: The minimum is `mid` or to the left. `right = mid`.
     - Note: `nums[mid] == nums[right]` impossible as elements are unique.
3. When loop ends, `left == right`, which points to the minimum.

**Time**: O(log N)
**Space**: O(1)

## Go Solution

```go
func findMin(nums []int) int {
    left, right := 0, len(nums)-1
    
    // We stop when left == right
    for left < right {
        mid := left + (right-left)/2
        
        // If mid is greater than right, the minimum value is in the right side
        if nums[mid] > nums[right] {
            left = mid + 1
        } else {
            // Mid is smaller than right, so minimum is at mid or to the left
            right = mid
        }
    }
    return nums[left]
}
```

### Key Go Insights
- **Loop Condition**: `left < right` because we narrow the search space to a single element (the minimum) rather than searching for a specific target value.
- **Boundaries**: `right = mid` (inclusive) vs `left = mid + 1` (exclusive) is crucial.

## Edge Cases
- Not rotated (already sorted).
- 1 element.
- 2 elements.
