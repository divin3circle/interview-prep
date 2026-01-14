# Two Sum II - Input Array Is Sorted

**Difficulty**: Medium
**Pattern**: Two Pointers

## Problem Statement

Given a **1-indexed** array of integers `numbers` that is already sorted in non-decreasing order, find two numbers such that they add up to a specific `target` number. Return the indices of the two numbers (1-indexed) as an integer array `[index1, index2]` where `1 <= index1 < index2 <= numbers.length`.

You may not use the same element twice. Your solution must use only constant extra space.

## Examples

### Example 1
```
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: 2 + 7 = 9. Indices 1 and 2.
```

### Example 2
```
Input: numbers = [2,3,4], target = 6
Output: [1,3]
```

## Approach

### Two Pointers (Optimal)
Since the array is sorted, we can use two pointers to find the target sum in O(N) time and O(1) space.
1. Initialize `left` at 0 (start) and `right` at `len(numbers)-1` (end).
2. Calculate `sum = numbers[left] + numbers[right]`.
3. If `sum == target`, return `[left+1, right+1]` (adding 1 for 1-based indexing).
4. If `sum < target`, we need a larger sum, so move `left` pointer to the right (`left++`).
5. If `sum > target`, we need a smaller sum, so move `right` pointer to the left (`right--`).

## Go Solution

```go
func twoSum(numbers []int, target int) []int {
    l, r := 0, len(numbers)-1
    
    for l < r {
        sum := numbers[l] + numbers[r]
        
        if sum == target {
            return []int{l + 1, r + 1}
        }
        
        if sum < target {
            l++
        } else {
            r--
        }
    }
    return nil
}
```

### Key Go Insights
- **1-based Indexing**: Remember to return `l+1` and `r+1`.
- **Space Complexity**: O(1) as required (unlike regular Two Sum which typically uses O(N) map).

## Edge Cases
- Minimum length array (2 elements).
- Negative numbers (handled correctly by addition logic on sorted array).
- No solution (problem guarantees one solution).
