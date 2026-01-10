# Find Minimum in Rotated Sorted Array

**Difficulty**: Medium  
**Pattern**: Binary Search  
**Companies**: Google, Amazon, Facebook, Microsoft

## Problem Statement

Suppose an array of length `n` sorted in ascending order is rotated between `1` and `n` times. For example, the array `nums = [0,1,2,4,5,6,7]` might become:
- `[4,5,6,7,0,1,2]` if it was rotated 4 times.
- `[0,1,2,4,5,6,7]` if it was rotated 7 times.

Notice that rotating an array `[a[0], a[1], a[2], ..., a[n-1]]` 1 time results in the array `[a[n-1], a[0], a[1], a[2], ..., a[n-2]]`.

Given the sorted rotated array `nums` of unique elements, return the minimum element of this array.

You must write an algorithm that runs in `O(log n)` time.

## Examples

### Example 1
```
Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.
```

### Example 2
```
Input: nums = [4,5,6,7,0,1,2]
Output: 0
Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
```

### Example 3
```
Input: nums = [11,13,15,17]
Output: 11
Explanation: The original array was [11,13,15,17] and it was rotated 4 times. 
```

## Constraints

- `n == nums.length`
- `1 <= n <= 5000`
- `-5000 <= nums[i] <= 5000`
- All the integers of `nums` are unique.
- `nums` is sorted and rotated between `1` and `n` times.

## Theoretical Concepts

### Inflection Point Identification
In a rotated sorted array, the minimum element is the only element that is smaller than its predecessor. This is the "inflection point".

### Binary Search for Minimum
Unlike a standard search where we look for a target value, here we look for a structural property:
- If `nums[mid] > nums[right]`, the minimum must be to the right of `mid` (because the left side is sorted and larger than the right side).
- If `nums[mid] < nums[right]`, the minimum could be `mid` itself or to the left of `mid`.

### Comparison with Right Boundary
Crucially, we often compare `nums[mid]` with `nums[right]` rather than `nums[left]` to avoid issues with already-sorted (non-rotated) arrays.

## Approach

### Binary Search on Inflection Point (Optimal)
**Time**: O(log n), **Space**: O(1)

Using binary search to narrow down the range until `left == right`.

**Why it's optimal**: We find the structural break in logarithmic time.

## Solution

See [solution.java](solution.java) for implementation.

## Key Insights

1. **Find the break in sorted order**: The minimum is the start of the original ascending sequence.
2. **Sorted arrays are rotations too**: The logic must handle the case where the array is rotated `n` times (effectively unrotated).
3. **No duplicates**: Ensures we can always make a binary decision about which direction to move.

## Edge Cases

- **Array is not rotated** (rotated `n` times).
- **Array size is 1 or 2**.
- **The maximum element is at the very beginning**.
- **The minimum element is at the very end**.

## Related Problems

- Find Minimum in Rotated Sorted Array II (LeetCode 154) - handling duplicates.
- Search in Rotated Sorted Array (LeetCode 33)
