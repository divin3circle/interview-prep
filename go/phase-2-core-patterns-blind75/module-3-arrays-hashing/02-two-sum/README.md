# Two Sum

**Difficulty**: Easy
**Pattern**: Arrays & Hashing

## Problem Statement

Given an array of integers `nums` and an integer `target`, return indices of the two numbers such that they add up to `target`.
You may assume that each input would have **exactly one solution**, and you may not use the same element twice.

## Examples

### Example 1
```
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: nums[0] + nums[1] = 2 + 7 = 9
```

### Example 2
```
Input: nums = [3,2,4], target = 6
Output: [1,2]
```

## Approach

### 1. Brute Force (Bad)
- Check every pair `(i, j)`.
- **Time**: O(n²)
- **Space**: O(1)

### 2. Hash Map (Optimal)
- As we iterate, we need to find if `target - num` exists.
- Use a map to store `val -> index` of elements we've seen so far.
- **Time**: O(n)
- **Space**: O(n)

## Go Solution

```go
func twoSum(nums []int, target int) []int {
    seen := make(map[int]int)
    for i, num := range nums {
        complement := target - num
        if idx, found := seen[complement]; found {
            return []int{idx, i}
        }
        seen[num] = i
    }
    return nil
}
```

### Key Go Insights
- **`map[int]int`**: Perfect for storing `value -> index` mapping.
- **`if v, ok := map[key]; ok`**: Standard Go idiom for checking map existence.
- **Slice Literal**: Return `[]int{idx, i}` directly.

## Edge Cases
- Negative numbers (handled correctly by math).
- No solution (not possible per problem statement).
