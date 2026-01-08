# Container With Most Water

**Difficulty**: Medium  
**Pattern**: Two Pointers  
**Companies**: Google, Amazon, Facebook, Microsoft

## Problem Statement

You are given an integer array `height` of length `n`. There are `n` vertical lines drawn such that the two endpoints of the `i`th line are `(i, 0)` and `(i, height[i])`.

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

## Examples

### Example 1
```
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: Lines at index 1 and 8 form container with area = min(8,7) * (8-1) = 7 * 7 = 49
```

### Example 2
```
Input: height = [1,1]
Output: 1
```

## Constraints

- `n == height.length`
- `2 <= n <= 10^5`
- `0 <= height[i] <= 10^4`

## Approach

### Two Pointers (Optimal)
**Time**: O(n), **Space**: O(1)

Start with widest container (left = 0, right = n-1). Move pointer with smaller height inward, tracking maximum area.

**Why it works**: Moving the shorter line might find a taller line, potentially increasing area. Moving the taller line cannot increase area.

## Solution

See [solution.java](solution.java) for implementation.

## Key Insights

1. **Area = min(height[left], height[right]) × (right - left)**: Width × minimum height
2. **Move shorter line**: Only way to potentially increase area
3. **Greedy approach**: Always move pointer that limits current area
4. **Single pass**: O(n) time with two pointers

## Related Problems

- Trapping Rain Water (LeetCode 42)
- Largest Rectangle in Histogram (LeetCode 84)
