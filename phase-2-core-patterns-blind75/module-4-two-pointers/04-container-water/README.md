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

## Theoretical Concepts

### Area Calculation
Area of container formed by two lines:
```
area = min(height[left], height[right]) × (right - left)
     = water_height × width
```

- **Water height**: Limited by shorter of two lines
- **Width**: Distance between the two lines
- **Tradeoff**: Moving inward decreases width, but might increase height

### Greedy Two Pointer Strategy
Start with maximum width (left=0, right=n-1), then:
1. Calculate current area
2. **Move the shorter line inward**
3. Update maximum area

**Why move shorter line?**
- Moving taller line: Width decreases, height stays same or decreases → area definitely decreases
- Moving shorter line: Width decreases, but height might increase → area might increase

This greedy choice explores all potentially optimal solutions.

### Proof of Correctness
Let's say `height[left] < height[right]`:
- Any container using `left` with indices between `left+1` and `right-1` will have:
  - Smaller width than current
  - Height still limited by `height[left]`
  - Therefore smaller area
- So we can safely move `left` pointer without missing optimal solution

### Comparison with Brute Force

| Approach | Time | Space | Method |
|----------|------|-------|--------|
| Brute Force | O(n²) | O(1) | Check all pairs |
| Two Pointers | O(n) | O(1) | Greedy elimination |

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

## Edge Cases

- **Minimum length**: `[1,1]` → `1` (area = min(1,1) × 1 = 1)
- **One tall, one short**: `[1,100]` → `1` (limited by shorter)
- **All same height**: `[5,5,5,5]` → `15` (max width with same height)
- **Increasing heights**: `[1,2,3,4,5]` → `6` (indices 0 and 4: min(1,5) × 4)
- **Decreasing heights**: `[5,4,3,2,1]` → `6` (indices 0 and 4: min(5,1) × 4)
- **Zero height**: `[0,5,0]` → `0` (any container with 0 has 0 area)

## Related Problems

- Trapping Rain Water (LeetCode 42)
- Largest Rectangle in Histogram (LeetCode 84)
