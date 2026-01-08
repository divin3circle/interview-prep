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
