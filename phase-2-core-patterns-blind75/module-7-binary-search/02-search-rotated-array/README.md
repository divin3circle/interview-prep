# Search in Rotated Sorted Array

**Difficulty**: Medium  
**Pattern**: Binary Search  
**Companies**: Google, Amazon, Facebook, Microsoft, Apple, Uber

## Problem Statement

There is an integer array `nums` sorted in ascending order (with distinct values).

Prior to being passed to your function, `nums` is possibly rotated at an unknown pivot index `k` (`1 <= k < nums.length`) such that the resulting array is `[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]` (0-indexed). For example, `[0,1,2,4,5,6,7]` might be rotated at pivot index `3` and become `[4,5,6,7,0,1,2]`.

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

### Example 3
```
Input: nums = [1], target = 0
Output: -1
```

## Constraints

- `1 <= nums.length <= 5000`
- `-10^4 <= nums[i] <= 10^4`
- All values of `nums` are unique.
- `nums` is an ascending array that is possibly rotated.
- `-10^4 <= target <= 10^4`

## Theoretical Concepts

### Partial Sorting Invariant
Even in a rotated sorted array, if we pick any index `mid`, at least one of the two halves (`[left, mid]` or `[mid, right]`) **must** be sorted.
- If `nums[left] <= nums[mid]`, the left half is sorted.
- Otherwise, the right half must be sorted.

### Binary Search Adaptation
We can still use binary search by checking which side is sorted and if the `target` falls within that sorted range.
- If the left side is sorted and `nums[left] <= target < nums[mid]`, search left.
- Otherwise, search right.
- Symmetric logic applies if the right side is sorted.

### Inflection Point (Pivot)
The "inflection point" is where the sorting order breaks (e.g., `7` followed by `0`). This point determines the rotation depth.

## Approach

### Single-Pass Modified Binary Search (Optimal)
**Time**: O(log n), **Space**: O(1)

One binary search pass where we identify the sorted half at each step.

**Why it's optimal**: We maintain the O(log n) property by discarding half the search space in each step despite the rotation.

## Solution

See [solution.java](solution.java) for implementation.

## Key Insights

1. **At least one half is always sorted**: The fundamental insight for rotation problems.
2. **Exclusion logic**: Use the sorted half to decide whether to stay in that half or jump to the other.
3. **Distinct values**: The problem is simpler because values are unique (duplicates would require O(n) in the worst case).

## Edge Cases

- **No rotation**: Standard binary search behavior.
- **Rotation by 1**: `[2, 3, 4, 1]`.
- **Target is the pivot element**.
- **Array size is 1 or 2**.
- **Target is smaller or larger than all elements**.

## Related Problems

- Find Minimum in Rotated Sorted Array (LeetCode 153)
- Search in Rotated Sorted Array II (LeetCode 81) - handling duplicates.
