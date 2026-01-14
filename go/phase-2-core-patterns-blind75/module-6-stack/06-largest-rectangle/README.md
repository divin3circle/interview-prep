# Largest Rectangle in Histogram

**Difficulty**: Hard
**Pattern**: Monotonic Stack

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

## Approach

### Monotonic Increasing Stack (Optimal)
We use a stack to keep track of the indices of bars with increasing heights.
1. Iterate through `heights`. Append a `0` height at the end to force processing of remaining stack elements.
2. For each bar `i` with height `h`:
   - While the stack is not empty and `h < heights[stack.top()]`:
     - This means the bar at `stack.top()` cannot extend further to the right. It's "bounded" by the current bar.
     - Pop the top index `j`. The height of the rectangle is `heights[j]`.
     - The width is determined by the *new* top of the stack (which is the boundary to the left).
       - If stack is empty: width = `i` (extends from 0 to i).
       - Else: width = `i - stack.top() - 1`.
     - Update max area.
   - Push current index `i`.

**Time**: O(N)
**Space**: O(N)

## Go Solution

```go
func largestRectangleArea(heights []int) int {
    // Append 0 to handle remaining bars in stack naturally
    heights = append(heights, 0)
    stack := []int{}
    maxArea := 0
    
    for i, h := range heights {
        for len(stack) > 0 && h < heights[stack[len(stack)-1]] {
            height := heights[stack[len(stack)-1]]
            stack = stack[:len(stack)-1]
            
            width := i
            if len(stack) > 0 {
                width = i - stack[len(stack)-1] - 1
            }
            
            area := height * width
            if area > maxArea {
                maxArea = area
            }
        }
        stack = append(stack, i)
    }
    return maxArea
}
```

### Key Go Insights
- **Sentinel Value**: Appending `0` simplifies logic, avoiding a second loop for remaining stack items.
- **Slice modification**: `append` creates a new slice, so the original passed slice isn't affected outside (though the underlying array might be if capacity allows, which is fine here).

## Edge Cases
- All increasing: processed at end by sentinel 0.
- All decreasing: processed immediately at each step.
- Single bar.
