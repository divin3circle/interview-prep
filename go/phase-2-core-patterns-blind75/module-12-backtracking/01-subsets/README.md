# Subsets

**Difficulty**: Medium
**Pattern**: Backtracking

## Problem Statement

Given an integer array `nums` of unique elements, return all possible subsets (the power set). The solution set must not contain duplicate subsets.

## Approach

### Backtracking
At each position, we have 2 choices: include or exclude the element.
1. Add current path to result (every path is valid).
2. For each remaining element, include it and recurse.
3. Backtrack by removing the element.

**Time**: O(2^N)
**Space**: O(N)

## Go Solution

```go
func subsets(nums []int) [][]int {
    result := [][]int{}
    var backtrack func(int, []int)
    backtrack = func(start int, path []int) {
        result = append(result, append([]int{}, path...))
        for i := start; i < len(nums); i++ {
            backtrack(i+1, append(path, nums[i]))
        }
    }
    backtrack(0, []int{})
    return result
}
```
