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

## Theoretical Concepts

### Water Level Calculation
Water trapped at position `i`:
```
water[i] = max(0, min(leftMax[i], rightMax[i]) - height[i])
```

Where:
- `leftMax[i]` = maximum height from index 0 to i
- `rightMax[i]` = maximum height from index i to n-1
- Water level is limited by the shorter of the two walls

### Approach Evolution

#### 1. Brute Force: O(n²) time, O(1) space
For each position, scan left and right to find max heights.

#### 2. Dynamic Programming: O(n) time, O(n) space
Precompute `leftMax[]` and `rightMax[]` arrays:
```
leftMax[i] = max(leftMax[i-1], height[i])
rightMax[i] = max(rightMax[i+1], height[i])
water[i] = min(leftMax[i], rightMax[i]) - height[i]
```

#### 3. Two Pointers: O(n) time, O(1) space (Optimal)
Instead of storing all max values, track them with variables:
```
leftMax = 0, rightMax = 0
left = 0, right = n-1

while (left < right):
    if (height[left] < height[right]):
        if (height[left] >= leftMax):
            leftMax = height[left]
        else:
            water += leftMax - height[left]
        left++
    else:
        if (height[right] >= rightMax):
            rightMax = height[right]
        else:
            water += rightMax - height[right]
        right--
```

**Key insight**: If `height[left] < height[right]`, then `rightMax >= height[right] > height[left]`, so water at `left` is determined by `leftMax` only.

#### 4. Stack: O(n) time, O(n) space (Alternative)
Use monotonic decreasing stack to find boundaries.

### Two Pointer Decision Logic
Move pointer with smaller height because:
- If `height[left] < height[right]`:
  - We know `rightMax >= height[right]`
  - Water at `left` depends only on `leftMax` and `height[left]`
  - Safe to calculate water at `left` and move pointer

### Comparison Table

| Approach | Time | Space | Complexity |
|----------|------|-------|------------|
| Brute Force | O(n²) | O(1) | Simple but slow |
| DP Arrays | O(n) | O(n) | Clear but uses space |
| Two Pointers | O(n) | O(1) | Optimal |
| Stack | O(n) | O(n) | Alternative perspective |

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

## Edge Cases

- **No water**: `[1,2,3,4,5]` → `0` (monotonically increasing)
- **No water**: `[5,4,3,2,1]` → `0` (monotonically decreasing)
- **Valley**: `[3,0,2]` → `2` (water fills valley)
- **Multiple valleys**: `[3,0,2,0,4]` → `7` (2 + 3 + 2)
- **Flat top**: `[3,3,3]` → `0` (no valleys)
- **Single element**: `[5]` → `0` (need at least 2 bars)
- **All zeros**: `[0,0,0]` → `0` (no height to trap water)

## Related Problems

- Container With Most Water (LeetCode 11)
- Product of Array Except Self (LeetCode 238)
