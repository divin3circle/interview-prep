# Permutations

**Difficulty**: Medium  
**Pattern**: Backtracking  
**Companies**: Google, Amazon, Facebook, Microsoft, Apple, LinkedIn

## Problem Statement

Given an array `nums` of distinct integers, return all the possible permutations. You can return the answer in any order.

## Examples

### Example 1
```
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
```

### Example 2
```
Input: nums = [0,1]
Output: [[0,1],[1,0]]
```

### Example 3
```
Input: nums = [1]
Output: [[1]]
```

## Constraints

- `1 <= nums.length <= 6`
- `-10 <= nums[i] <= 10`
- All the integers of `nums` are unique.

## Theoretical Concepts

### Permutations vs Subsets
- **Subsets**: Selection of elements where order does not matter (e.g., `{1, 2}` is same as `{2, 1}`).
- **Permutations**: Arrangement of elements where order **does** matter (e.g., `(1, 2)` is different from `(2, 1)`).
- For `n` distinct elements, there are `n!` (factorial) permutations.

### The "Used" Set
When generating permutations, we need to ensure each element is used exactly once in each arrangement. We use a `boolean[] used` array (or a `Set`) to keep track of which elements are currently in the partial permutation.

### Backtracking Framework
1. **Base Case**: If `currentPermutation.size() == nums.length`, we found a complete permutation.
2. **Recursive Step**: Iterate through all potential candidates.
3. **Pruning**: If the candidate is already `used`, skip it.

## Approach

### Backtracking with Used Array (Optimal)
**Time**: O(n! * n), **Space**: O(n)

1. Create a `backtrack(currentList)` function.
2. If `currentList.size() == nums.length`, add a copy of it to results.
3. For each `num` in `nums`:
   - If `num` is already in `currentList`, continue.
   - Add `num` to `currentList`.
   - Call `backtrack`.
   - Pop `num` (backtrack).

**Why it's optimal**: We generate exactly `n!` permutations.

## Solution

See [solution.java](solution.java) for implementation.

## Key Insights

1. **Ordering matters**: Unlike subsets, we always loop from the beginning of the array, only skipping elements that are already part of the current path.
2. **Boolean array vs ArrayList.contains()**: Checking a boolean array is O(1), while `list.contains()` is O(n). For larger `n`, the boolean array is significantly faster.
3. **Complexity growth**: Factorial growth is extremely fast (10! = 3.6 million).

## Edge Cases

- **Single element array**.
- **Array of maximum constraint length** (6! = 720 permutations).
- **All elements were used in a previous branch**.

## Related Problems

- Permutations II (LeetCode 47) - handling duplicates.
- Next Permutation (LeetCode 31)
- Permutation Sequence (LeetCode 60)
