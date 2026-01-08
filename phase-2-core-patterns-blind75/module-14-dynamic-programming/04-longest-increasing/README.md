# Longest Increasing Subsequence

**Difficulty**: Medium  
**Pattern**: Dynamic Programming

## Problem Statement
Given an integer array `nums`, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements.

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

## Constraints
* `1 <= nums.length <= 2500`
* `-10^4 <= nums[i] <= 10^4`

## Approach

### 1. Dynamic Programming - O(n²)
`dp[i]` = length of LIS ending at index `i`.
* To find `dp[i]`, look at all previous indices `j < i`.
* If `nums[i] > nums[j]`, then we can extend the subsequence ending at `j`.
* `dp[i] = max(dp[i], 1 + dp[j])`.

### 2. Patience Sorting (Greedy + Binary Search) - O(n log n)
* Build the subsequence `sub`.
* For each num:
    * If num > all in `sub`, append it.
    * Else, replace the smallest element in `sub` that is >= num (Binary Search).
* This maintains the *potential* to form a longer subsequence, though the `sub` list itself might not look like the valid answer at the end, its length is correct.

## Solution

See [solution.java](solution.java) for the implementation.
