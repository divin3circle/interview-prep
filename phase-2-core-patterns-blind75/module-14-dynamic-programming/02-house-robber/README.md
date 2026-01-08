# House Robber

**Difficulty**: Medium  
**Pattern**: Dynamic Programming

## Problem Statement
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and **it will automatically contact the police if two adjacent houses were broken into on the same night**.

Given an integer array `nums` representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

## Examples

### Example 1
```
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3). Total = 1 + 3 = 4.
```

### Example 2
```
Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (2), house 3 (9), and house 5 (1). Total = 2 + 9 + 1 = 12.
```

## Constraints
* `1 <= nums.length <= 100`
* `0 <= nums[i] <= 400`

## Approach

### 1. Recurrence Relation
For each house `i`, you have two choices:
1.  **Rob house `i`**: You gain `nums[i]`, but you cannot rob house `i-1`. You add this to the max money from `i-2`.
2.  **Skip house `i`**: You gain 0 from this house, but keep the max money accumulated up to `i-1`.

`dp[i] = max(nums[i] + dp[i-2], dp[i-1])`

### 2. Optimization
Notice we only need the previous two values (`rob1`, `rob2`) to calculate the next. We can reduce space complexity to O(1).

## Solution

See [solution.java](solution.java) for the implementation.
