# Binary Search

**Difficulty**: Easy  
**Pattern**: Binary Search  
**Companies**: Google, Amazon, Facebook, Microsoft, Apple, Bloomberg

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

## Constraints

- `1 <= nums.length <= 10^4`
- `-10^4 < nums[i], target < 10^4`
- All the integers in `nums` are unique.
- `nums` is sorted in ascending order.

## Theoretical Concepts

### Divide and Conquer
Binary search is a classic divide-and-conquer algorithm. By comparing the target with the middle element of the sorted array, we can discard half of the search space in each step.

### Logarithmic Time Complexity
Because the search space is halved at each iteration, the number of steps required is `log2(n)`. This is incredibly efficient for large data sets (e.g., searching 1 billion items takes only 30 steps).

### Midpoint Calculation & Overflow
A common pitfall is calculating `mid = (left + right) / 2`. If `left` and `right` are large, their sum might exceed the maximum value of a 32-bit integer.
- **Safe version**: `mid = left + (right - left) / 2`
- **Bit manipulation version**: `mid = (left + right) >>> 1`

### Loop Invariants
- `left` and `right` define the current boundaries of the search space.
- The condition `while (left <= right)` ensures we check the last remaining element.
- If the loop finishes without returning, the element is not in the array.

## Approach

### Basic Binary Search (Optimal)
**Time**: O(log n), **Space**: O(1)

Repeatedly divide the search interval in half.

**Why it's optimal**: You cannot search a sorted array in less than logarithmic time without additional information or precomputation.

## Solution

See [solution.java](solution.java) for implementation.

## Key Insights

1. **Sorted property is mandatory**: Binary search only works on sorted data.
2. **Efficient reduction**: Discarding half the space per step is the core speed multiplier.
3. **Boundary conditions**: Pay close attention to `left <= right` vs `left < right` and whether to use `mid + 1` or `mid`.

## Edge Cases

- **Target is the first element**.
- **Target is the last element**.
- **Array has only one element**.
- **Target is not in the array**.
- **Target is smaller than the smallest element**.
- **Target is larger than the largest element**.

## Related Problems

- Search Insert Position (LeetCode 35)
- Find First and Last Position of Element in Sorted Array (LeetCode 34)
- Search in Rotated Sorted Array (LeetCode 33)
