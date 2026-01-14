# Daily Temperatures

**Difficulty**: Medium
**Pattern**: Stack (Monotonic)

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

## Approach

### Monotonic Decreasing Stack (Optimal)
We need to find the **next greater element** for each day.
1. Use a stack to store **indices** of temperatures.
2. Iterate through the array.
3. While the current temperature is **greater** than the temperature at the index on top of the stack:
   - This means we found a warmer day for the day at `stack.top()`.
   - Pop `prevIndex` from stack.
   - `answer[prevIndex] = currentIndex - prevIndex`.
4. Push `currentIndex` to stack.

**Time**: O(N) (Each element pushed and popped at most once)
**Space**: O(N)

## Go Solution

```go
func dailyTemperatures(temperatures []int) []int {
    res := make([]int, len(temperatures))
    // Stack stores indices
    stack := []int{}
    
    for i, t := range temperatures {
        // while stack not empty and current temp > temp at top of stack
        for len(stack) > 0 && t > temperatures[stack[len(stack)-1]] {
            idx := stack[len(stack)-1]
            stack = stack[:len(stack)-1]
            res[idx] = i - idx
        }
        stack = append(stack, i)
    }
    return res
}
```

### Key Go Insights
- **Indices Stack**: Store `int` indices.
- **Slice**: Standard Go stack implementation.

## Edge Cases
- All decreasing (results `0`).
- All increasing (results `1` except last).
- Single element.
