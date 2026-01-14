# Permutations

**Difficulty**: Medium
**Pattern**: Backtracking

## Problem Statement

Given an array `nums` of distinct integers, return all the possible permutations.

## Approach

### Backtracking with Used Tracking
1. If path length == nums length, add to result.
2. For each number, if not used, add to path and recurse.
3. Backtrack by removing from path.

**Time**: O(N!)
**Space**: O(N)

## Go Solution

```go
func permute(nums []int) [][]int {
    result := [][]int{}
    used := make([]bool, len(nums))
    var backtrack func([]int)
    backtrack = func(path []int) {
        if len(path) == len(nums) {
            result = append(result, append([]int{}, path...))
            return
        }
        for i := 0; i < len(nums); i++ {
            if used[i] {
                continue
            }
            used[i] = true
            backtrack(append(path, nums[i]))
            used[i] = false
        }
    }
    backtrack([]int{})
    return result
}
```
