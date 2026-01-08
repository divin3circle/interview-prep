# Combination Sum

**Difficulty**: Medium  
**Pattern**: Backtracking

## Problem Statement
Given an array of distinct integers `candidates` and a target integer `target`, return a list of all unique combinations of `candidates` where the chosen numbers sum to `target`. You may return the combinations in any order.
The same number may be chosen from `candidates` an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

## Examples

### Example 1
```
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
```

## Constraints
* `1 <= candidates.length <= 30`
* `1 <= target <= 500`

## Approach

### 1. Backtracking (Unbounded Knapsack style)
Similar to Subsets, but we can reuse elements.
* When sorting candidates, we can break early if `sum > target`.
* Recursive Function `backtrack(remain, start)`:
    * If `remain < 0`: Invalid path, return.
    * If `remain == 0`: Valid path, add to result.
    * Loop from `start` to end:
        * Add `candidates[i]`.
        * Recurse with `backtrack(remain - candidates[i], i)`. **Note**: passing `i`, not `i+1`, allows reuse.
        * Backtrack (remove element).

## Solution

See [solution.java](solution.java) for the implementation.
