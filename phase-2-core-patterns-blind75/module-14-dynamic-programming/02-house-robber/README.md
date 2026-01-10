# House Robber

**Difficulty**: Medium  
**Pattern**: Dynamic Programming  
**Companies**: Google, Amazon, Microsoft, Facebook, Apple, Bloomberg, LinkedIn

## Problem Statement

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and **it will automatically contact the police if two adjacent houses were broken into on the same night**.

Given an integer array `nums` representing the amount of money of each house, return the maximum amount of money you can rob tonight **without alerting the police**.

## Examples

### Example 1
```
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
```

### Example 2
```
Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
```

## Constraints

- `1 <= nums.length <= 100`
- `0 <= nums[i] <= 400`

## Theoretical Concepts

### Decision at Each House
For each house `i`, you have two choices:
1. **Rob house `i`**: You get `nums[i]` plus the maximum money from houses `0` to `i-2`.
2. **Skip house `i`**: You get the maximum money from houses `0` to `i-1`.

### Recurrence Relation
`DP[i] = max(DP[i-2] + nums[i], DP[i-1])`

### Base Cases
- `DP[0] = nums[0]`
- `DP[1] = max(nums[0], nums[1])`

### Memory Optimization
Notice that `DP[i]` only depends on `DP[i-1]` and `DP[i-2]`. We can replace the DP array with two variables, reducing space complexity from O(n) to O(1).

## Approach

### Dynamic Programming (Space Optimized)
**Time**: O(n), **Space**: O(1)

1. Use two variables `rob1` and `rob2` to track the maximum money up to the previous two houses.
2. For each `n` in `nums`:
   - `temp = max(n + rob1, rob2)`
   - `rob1 = rob2`
   - `rob2 = temp`
3. Return `rob2`.

**Why it's optimal**: Linear scan with constant extra space.

## Solution

See [solution.java](solution.java) for implementation.

## Key Insights

1. **Greedy isn't enough**: Simply picking the highest value won't work because it restricts future choices.
2. **Subproblem definition**: The "state" is the maximum money robbed from the first `i` houses.
3. **Sequential decisions**: This is a classic example of making optimal sequential decisions.

## Edge Cases

- **Only one house**.
- **Two houses**.
- **All houses have same amount of money**.
- **House with 0 money**.
- **Strictly increasing amounts**.

## Related Problems

- House Robber II (LeetCode 213) - houses are in a circle.
- House Robber III (LeetCode 337) - houses are in a binary tree.
- Maximum Product Subarray (LeetCode 152)
