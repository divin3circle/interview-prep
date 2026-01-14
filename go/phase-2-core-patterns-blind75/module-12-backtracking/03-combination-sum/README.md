# Combination Sum

**Difficulty**: Medium
**Pattern**: Backtracking

## Problem Statement

Given an array of distinct integers `candidates` and a target integer `target`, return a list of all unique combinations of `candidates` where the chosen numbers sum to `target`. You may return the combinations in any order. The same number may be chosen from `candidates` an unlimited number of times.

## Approach

### Backtracking with Remaining Target
1. If remaining < 0, prune.
2. If remaining == 0, add to result.
3. For each candidate from start index, include it and recurse with same index (allow reuse).

**Time**: O(N^(T/M)) where T is target, M is min candidate
**Space**: O(T/M)

## Go Solution

```go
func combinationSum(candidates []int, target int) [][]int {
    result := [][]int{}
    var backtrack func(int, int, []int)
    backtrack = func(start, remain int, path []int) {
        if remain < 0 {
            return
        }
        if remain == 0 {
            result = append(result, append([]int{}, path...))
            return
        }
        for i := start; i < len(candidates); i++ {
            backtrack(i, remain-candidates[i], append(path, candidates[i]))
        }
    }
    backtrack(0, target, []int{})
    return result
}
```
