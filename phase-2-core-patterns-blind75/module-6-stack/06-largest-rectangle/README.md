# Largest Rectangle in Histogram

**Difficulty**: Hard  
**Pattern**: Monotonic Stack  
**Companies**: Google, Amazon, Facebook, Microsoft, Apple, Bloomberg

## Problem Statement

Given an array of integers `heights` representing the histogram's bar height where the width of each bar is 1, find the area of the largest rectangle in the histogram.

## Examples

### Example 1
```
Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The largest rectangle is shown in the shaded area, which has an area = 10 units (base = 2, height = 5).
```

### Example 2
```
Input: heights = [2,4]
Output: 4
```

## Constraints

- `1 <= heights.length <= 10^5`
- `0 <= heights[i] <= 10^4`

## Theoretical Concepts

### Rectangular Boundaries
For each bar at index `i` with height `h`, the largest rectangle using this height is bounded by:
1. The first bar to the left that is shorter than `h`.
2. The first bar to the right that is shorter than `h`.
`Area = height * (rightBoundary - leftBoundary - 1)`

### Monotonic Increasing Stack
We use a stack to maintain indices of bars with non-decreasing heights. 
- When we encounter a bar `current` that is **shorter** than the bar at the top of the stack, we know we've found the **right boundary** for the top bar.
- The **left boundary** for the top bar is simply the element immediately below it in the stack (since the stack is monotonic increasing).

### Sentinels / Exhausting the Stack
After iterating through all bars, some elements may remain in the stack (those that never found a smaller element to their right). We need to process them by assuming a "virtual" bar of height 0 at index `n`.

## Approach

### Monotonic Stack (Optimal)
**Time**: O(n), **Space**: O(n)

1. Iterate through `heights` (including an extra 0 at the end to flush the stack).
2. For each bar:
   - While the current bar is shorter than the bar at `stack.peek()`:
     - `h = heights[stack.pop()]`
     - `w = stack.isEmpty() ? i : i - stack.peek() - 1`
     - `maxArea = max(maxArea, h * w)`
   - Push current index.

**Why it's optimal**: Each bar is pushed and popped exactly once.

## Solution

See [solution.java](solution.java) for implementation.

## Key Insights

1. **Expanding as far as possible**: Every bar can be the "height" of some rectangle. The stack helps determine the width.
2. **Width calculation**: `i - stack.peek() - 1` is the distance between the left-smaller and right-smaller neighbors.
3. **Handling the end**: Either add a 0 at the end of the array or perform a cleanup loop to empty the stack.

## Edge Cases

- **Strictly increasing**: `[1, 2, 3, 4]`.
- **Strictly decreasing**: `[4, 3, 2, 1]`.
- **All same height**: `[5, 5, 5]`.
- **Single bar**.
- **Heights of zero**: `[2, 0, 2]`.

## Related Problems

- Maximal Rectangle (LeetCode 85)
- Daily Temperatures (LeetCode 739)
- Trapping Rain Water (LeetCode 42)
- Sum of Subarray Minimums (LeetCode 907)
