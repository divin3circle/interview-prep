# Container With Most Water

**Difficulty**: Medium
**Pattern**: Two Pointers

## Problem Statement

You are given an integer array `height` of length `n`. There are `n` vertical lines drawn such that the two endpoints of the `i`th line are `(i, 0)` and `(i, height[i])`.

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

## Examples

### Example 1
```
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: Lines at index 1 and 8 form. Area = min(8,7) * (8-1) = 7 * 7 = 49.
```

### Example 2
```
Input: height = [1,1]
Output: 1
```

## Approach

### Two Pointers (Optimal)
We want to maximize `Area = min(height[left], height[right]) * (right - left)`.
1. Start with pointers at the widest possible width (`0` and `n-1`).
2. Calculate area.
3. To potentially find a greater area, we must trade width for height.
4. **Greedy Move**: Move the pointer pointing to the *shorter* line inward.
   - Why? If we move the taller line, the new line might be taller, but the height is still limited by the *shorter* line we kept (or even smaller). And width decreased. So area cannot increase.
   - By moving the shorter line, we hope to find a taller line that compensates for the width reduction.

**Time**: O(N)
**Space**: O(1)

## Go Solution

```go
func maxArea(height []int) int {
    left, right := 0, len(height)-1
    maxVal := 0
    
    for left < right {
        h := min(height[left], height[right])
        w := right - left
        area := h * w
        maxVal = max(maxVal, area)
        
        if height[left] < height[right] {
            left++
        } else {
            right--
        }
    }
    return maxVal
}

func min(a, b int) int {
    if a < b { return a }
    return b
}

func max(a, b int) int {
    if a > b { return a }
    return b
}
```

### Key Go Insights
- **`min/max`**: Go 1.21+ has built-in `min` and `max` for cmp types. For older Go versions, helper functions are needed.

## Edge Cases
- Two lines (minimum).
- All same height.
- Increasing/Decreasing heights.
