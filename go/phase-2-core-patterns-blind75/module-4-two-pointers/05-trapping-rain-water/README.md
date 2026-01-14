# Trapping Rain Water

**Difficulty**: Hard
**Pattern**: Two Pointers

## Problem Statement

Given `n` non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

## Examples

### Example 1
```
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
```

### Example 2
```
Input: height = [4,2,0,3,2,5]
Output: 9
```

## Approach

### 1. Dynamic Programming (O(N) space)
- Precompute `leftMax[i]` and `rightMax[i]` for each position.
- `water[i] = min(leftMax[i], rightMax[i]) - height[i]`.
- Space: O(N) for arrays.

### 2. Two Pointers (Optimal, O(1) space)
- We only need the minimum of (`leftMax`, `rightMax`) to calculate water.
- Use `left` and `right` pointers moving inward.
- Track `leftMax` (max height seen from left so far) and `rightMax`.
- If `leftMax < rightMax`, then for the `left` pointer, we know `leftMax` is the limiting factor (because there exists some `rightMax` >= `leftMax` on the right side). So we can compute water for `left`.
- Moves shorter side inward.

**Time**: O(N)
**Space**: O(1)

## Go Solution

```go
func trap(height []int) int {
    if len(height) == 0 { return 0 }
    
    l, r := 0, len(height)-1
    leftMax, rightMax := height[l], height[r]
    res := 0
    
    for l < r {
        if leftMax < rightMax {
            l++
            leftMax = max(leftMax, height[l])
            res += leftMax - height[l]
        } else {
            r--
            rightMax = max(rightMax, height[r])
            res += rightMax - height[r]
        }
    }
    return res
}
```

### Key Go Insights
- **Pointer logic**: Concise update logic inside the loop.
- **Nil slice check**: `if len(height) == 0` check is good practice.

## Edge Cases
- No water trapped (sorted asc/desc).
- Valley (V shape).
