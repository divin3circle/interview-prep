# Longest Increasing Subsequence

**Difficulty**: Medium  
**Pattern**: Dynamic Programming / Binary Search  
**Companies**: Google, Amazon, Facebook, Microsoft, Apple, Bloomberg

## Problem Statement

Given an integer array `nums`, return the length of the longest strictly increasing subsequence.

A **subsequence** is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, `[3,6,2,7]` is a subsequence of the array `[0,3,1,6,2,2,7]`.

## Examples

### Example 1
```
Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
```

### Example 2
```
Input: nums = [0,1,0,3,2,3]
Output: 4
```

### Example 3
```
Input: nums = [7,7,7,7,7,7,7]
Output: 1
```

## Constraints

- `1 <= nums.length <= 2500`
- `-10^4 <= nums[i] <= 10^4`

## Theoretical Concepts

### Subsequence vs Subarray
- **Subarray**: Must be contiguous.
- **Subsequence**: Elements must appear in the same relative order but don't need to be adjacent.

### Base DP Approach: O(n²)
For each element `i`, the longest increasing subsequence ending at `i` is `1 + max(DP[j])` for all `j < i` where `nums[j] < nums[i]`.
- This is simple to understand but slow for large arrays.

### Patient Sorting / Binary Search Approach: O(n log n)
We maintain a list `tails` where `tails[i]` is the smallest tail of all increasing subsequences of length `i + 1`. 
1. For each `x` in `nums`:
   - If `x` is larger than all elements in `tails`, append it.
   - Otherwise, find the smallest element in `tails` that is >= `x` and replace it with `x`.
2. The length of `tails` at the end is the length of the LIS.

## Approach

### Dynamic Programming (Standard)
**Time**: O(n²), **Space**: O(n)

1. Initialize `dp` array with 1 (each element is a subsequence of length 1).
2. For each `i`:
   - For each `j < i`:
     - If `nums[j] < nums[i]`: `dp[i] = max(dp[i], dp[j] + 1)`
3. Return `max(dp)`.

**Why it's used**: It's the classic DP educational approach.

### Binary Search (Optimal)
**Time**: O(n log n), **Space**: O(n)

Maintain a dynamic list of "tails" and use binary search (`Collections.binarySearch` or manual) to find replacement points.

## Solution

See [solution.java](solution.java) for implementation.

## Key Insights

1. **Strictly increasing**: Equals are not allowed in the subsequence.
2. **Global maximum**: The answer isn't necessarily `dp[n-1]`; it's the maximum value across the entire `dp` array.
3. **Patience Sorting**: The log n approach is inspired by the card game Patience.

## Edge Cases

- **Array with all identical elements**.
- **Array already sorted ascending**.
- **Array sorted descending**.
- **Empty input** (returns 0).
- **Single element array**.

## Related Problems

- Longest Common Subsequence (LeetCode 1143)
- Number of Longest Increasing Subsequences (LeetCode 673)
- Maximum Height by Stacking Cuboids (LeetCode 1689)
- Russian Doll Envelopes (LeetCode 354)
