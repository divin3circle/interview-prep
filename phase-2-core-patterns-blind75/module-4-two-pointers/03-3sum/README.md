# 3Sum

**Difficulty**: Medium  
**Pattern**: Two Pointers  
**Companies**: Google, Amazon, Facebook, Microsoft, Apple

## Problem Statement

Given an integer array `nums`, return all the triplets `[nums[i], nums[j], nums[k]]` such that `i != j`, `i != k`, and `j != k`, and `nums[i] + nums[j] + nums[k] == 0`.

Notice that the solution set must not contain duplicate triplets.

## Examples

### Example 1
```
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
- nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0
- nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0
- nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0
Distinct triplets are [-1,0,1] and [-1,-1,2]
```

### Example 2
```
Input: nums = [0,1,1]
Output: []
Explanation: No triplet sums to 0
```

### Example 3
```
Input: nums = [0,0,0]
Output: [[0,0,0]]
```

## Constraints

- `3 <= nums.length <= 3000`
- `-10^5 <= nums[i] <= 10^5`

## Theoretical Concepts

### Reduction to Two Sum
The key insight is reducing 3Sum to a Two Sum problem:
1. **Fix one element** at index `i`
2. **Find two elements** in remaining array that sum to `-nums[i]`
3. Use two pointers on sorted array for the two-element search

This transforms O(n³) brute force into O(n²) solution.

### Duplicate Handling
Critical for avoiding duplicate triplets:
```
// Skip duplicate first elements
if (i > 0 && nums[i] == nums[i-1]) continue;

// Skip duplicate second elements
while (left < right && nums[left] == nums[left+1]) left++;

// Skip duplicate third elements
while (left < right && nums[right] == nums[right-1]) right--;
```

### Why Sorting Enables Optimization
Sorting provides:
1. **Two pointer technique**: Can find pairs in O(n)
2. **Duplicate skipping**: Adjacent duplicates are easy to detect
3. **Early termination**: If `nums[i] > 0`, no more solutions possible

### Complexity Analysis
- **Sorting**: O(n log n)
- **Outer loop**: O(n) iterations
- **Inner two pointers**: O(n) per iteration
- **Total**: O(n²) dominates O(n log n)

## Edge Cases

- **All zeros**: `[0,0,0]` → `[[0,0,0]]`
- **No solution**: `[1,2,3]` → `[]` (all positive, can't sum to 0)
- **Duplicates in result**: `[-1,-1,2]` → `[[-1,-1,2]]` (one triplet)
- **Multiple solutions**: `[-2,0,0,2,2]` → `[[-2,0,2]]`
- **Minimum length**: `[0,0,0]` → `[[0,0,0]]` (exactly 3 elements)
- **Large array with duplicates**: Skipping duplicates is crucial for performance

## Approach

### Sort + Two Pointers (Optimal)
**Time**: O(n²), **Space**: O(1) excluding output

Sort array, fix one element, use two pointers for remaining two elements. Skip duplicates to avoid duplicate triplets.

**Why it's optimal**: Cannot do better than O(n²) for finding all triplets.

## Solution

See [solution.java](solution.java) for implementation.

## Key Insights

1. **Sort first**: Enables two pointers and duplicate skipping
2. **Fix one element**: Reduces to Two Sum II problem
3. **Skip duplicates**: Critical for avoiding duplicate triplets
4. **Early termination**: If first element > 0, no solution possible

## Related Problems

- Two Sum (LeetCode 1)
- Two Sum II (LeetCode 167)
- 4Sum (LeetCode 18)
- 3Sum Closest (LeetCode 16)
