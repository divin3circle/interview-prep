# Combination Sum

**Difficulty**: Medium  
**Pattern**: Backtracking  
**Companies**: Google, Amazon, Microsoft, Facebook, Apple, Bloomberg, Airbnb

## Problem Statement

Given an array of **distinct** integers `candidates` and a target integer `target`, return a list of all **unique combinations** of `candidates` where the chosen numbers sum to `target`. You may return the combinations in any order.

The **same** number may be chosen from `candidates` an **unlimited number of times**. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to `target` is less than `150` combinations for the given input.

## Examples

### Example 1
```
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2+2+3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
```

### Example 2
```
Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
```

### Example 3
```
Input: candidates = [2], target = 1
Output: []
```

## Constraints

- `1 <= candidates.length <= 30`
- `2 <= candidates[i] <= 40`
- All elements of `candidates` are distinct.
- `1 <= target <= 40`

## Theoretical Concepts

### Recursive Decision Making
This problem can be viewed as an "Infinite Choice" problem: 
- At each step, we can choose to use the same candidate again, or move to the next candidate.
- To avoid duplicate combinations (e.g., `[2, 3]` and `[3, 2]`), we maintain a `start` index and only choose candidates from `start` onwards.

### Pruning the Search Space
If the candidates are sorted, we can stop the loop early if a candidate exceeds the current remaining target. This is called **pruning**.

### State Representation
- `target`: The remaining sum we need to reach.
- `start`: The index of the candidate we are currently considering.
- `path`: The list of numbers currently selected.

## Approach

### Backtracking (Optimal)
**Time**: O(N^(T/M)) where N is number of candidates, T is target, M is minimum candidate value. (Rough estimate for branching).
**Space**: O(T/M) for the recursion stack.

1. Sort the `candidates` (optional but enables pruning).
2. Create `backtrack(remain, start, path)`:
   - If `remain == 0`, add `path` to results.
   - If `remain < 0`, return (base case for invalid path).
   - For `i` from `start` to `candidates.length - 1`:
     - Add `candidates[i]` to `path`.
     - Recurse with `remain - candidates[i]` and **the same `i`** (since we can reuse).
     - Pop `candidates[i]` (backtrack).

**Why it's optimal**: We explore all valid combinations exactly once.

## Solution

See [solution.java](solution.java) for implementation.

## Key Insights

1. **Reusing the current index**: Calling `backtrack` with `i` instead of `i+1` allows for using the same number multiple times.
2. **Preventing duplicates**: By only looking "forward" (`i` starts at `start`), we ensure that we don't encounter permutations of the same set.
3. **Sorting for efficiency**: Early exit in the loop (`if (candidates[i] > remain) break`) significantly speeds up execution on many test cases.

## Edge Cases

- **Target is smaller than the smallest candidate**.
- **One candidate is equal to the target**.
- **Multiple counts of the same candidate sum to target**.
- **No possible combinations**.

## Related Problems

- Combination Sum II (LeetCode 40) - cannot reuse candidates, handles duplicates in input.
- Combination Sum III (LeetCode 216)
- Target Sum (LeetCode 494)
- Coin Change (LeetCode 322) - finding the *minimum number* of coins (DP).
