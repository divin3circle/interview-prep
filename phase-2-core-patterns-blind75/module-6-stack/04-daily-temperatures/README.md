# Daily Temperatures

**Difficulty**: Medium  
**Pattern**: Stack  
**Companies**: Google, Amazon, Facebook, Microsoft

## Problem Statement

Given an array of integers `temperatures` represents the daily temperatures, return an array `answer` such that `answer[i]` is the number of days you have to wait after the `i`th day to get a warmer temperature. If there is no future day for which this is possible, keep `answer[i] == 0` instead.

## Examples

### Example 1
```
Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
```

### Example 2
```
Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
```

### Example 3
```
Input: temperatures = [30,60,90]
Output: [1,1,0]
```

## Constraints

- `1 <= temperatures.length <= 10^5`
- `30 <= temperatures[i] <= 100`

## Theoretical Concepts

### Monotonic Stack
A monotonic stack is a stack that maintains its elements in a specific sorted order (increasing or decreasing).
- **Monotonic Decreasing Stack**: When a new element is larger than the top, we pop until the property is restored.
- **Next Greater Element**: This pattern is frequently used to find the "nearest element on the right that is larger than current".

### Why Monotonic Stack?
Instead of a nested loop (O(n²)) to find the next warmer day for each `i`, the stack keeps track of "unresolved" days. 
- A day is "resolved" when we encounter a warmer temperature.
- Because the stack is monotonic decreasing, if a new temperature is warmer than the top, it might also be warmer than elements below it.

### Index Tracking
We store **indices** in the stack rather than the temperature values themselves. This allows us to calculate the distance (`current_index - stored_index`).

## Approach

### Monotonic Decreasing Stack (Optimal)
**Time**: O(n), **Space**: O(n)

1. Initialize `ans` array of zeros.
2. Iterate through temperatures.
3. While `stack` is not empty and `currentTemp > temperatures[stack.peek()]`:
   - `prevIndex = stack.pop()`
   - `ans[prevIndex] = currentIndex - prevIndex`
4. Push `currentIndex` to stack.

**Why it's optimal**: Each element is pushed and popped exactly once, leading to linear time.

## Solution

See [solution.java](solution.java) for implementation.

## Key Insights

1. **Unresolved days**: The stack holds temperatures for which we haven't found a warmer day yet.
2. **Backwards resolution**: We resolve multiple days at once when a high temperature is found.
3. **Space-time tradeoff**: Use O(n) space to avoid O(n²) time.

## Edge Cases

- **Strictly decreasing**: `[90, 80, 70]` → `[0, 0, 0]`.
- **Strictly increasing**: `[70, 80, 90]` → `[1, 1, 0]`.
- **All same**: `[70, 70, 70]` → `[0, 0, 0]`.
- **Single temperature**: `[70]` → `[0]`.

## Related Problems

- Next Greater Element I (LeetCode 496)
- Online Stock Span (LeetCode 901)
- Largest Rectangle in Histogram (LeetCode 84)
