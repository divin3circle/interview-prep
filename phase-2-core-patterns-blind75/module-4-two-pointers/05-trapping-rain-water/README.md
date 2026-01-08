# Trapping Rain Water

**Difficulty**: Hard  
**Pattern**: Two Pointers  
**Companies**: Google, Amazon, Facebook, Microsoft, Apple

## Problem Statement

Given `n` non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

## Examples

### Example 1
```
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The elevation map traps 6 units of water
```

### Example 2
```
Input: height = [4,2,0,3,2,5]
Output: 9
```

## Constraints

- `n == height.length`
- `1 <= n <= 2 * 10^4`
- `0 <= height[i] <= 10^5`

## Approach

### Two Pointers (Optimal)
**Time**: O(n), **Space**: O(1)

Use two pointers with max height tracking. Water at position depends on minimum of max heights to left and right.

**Why it's optimal**: Single pass with constant space, no need for auxiliary arrays.

## Solution

See [solution.java](solution.java) for implementation.

## Key Insights

1. **Water at position = min(leftMax, rightMax) - height[i]**: Bounded by shorter wall
2. **Two pointers with max tracking**: Process from both ends
3. **Move pointer with smaller max**: Guarantees water calculation is correct
4. **No auxiliary space**: Track maxes with variables only

## Related Problems

- Container With Most Water (LeetCode 11)
- Product of Array Except Self (LeetCode 238)
