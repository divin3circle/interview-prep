# Subsets

**Difficulty**: Medium  
**Pattern**: Backtracking / Power Set  
**Companies**: Google, Amazon, Facebook, Microsoft, Apple, Bloomberg

## Problem Statement

Given an integer array `nums` of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

## Examples

### Example 1
```
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
```

### Example 2
```
Input: nums = [0]
Output: [[],[0]]
```

## Constraints

- `1 <= nums.length <= 10`
- `-10 <= nums[i] <= 10`
- All the numbers of `nums` are unique.

## Theoretical Concepts

### Power Set
The power set of a set is the set of all subsets, including the empty set and the set itself. For a set of size `n`, the power set has `2^n` elements.

### The "Include/Exclude" Strategy
Backtracking for subsets can be modeled as a series of decisions: for each element, do we **include** it in the current subset or **exclude** it?
- This results in a binary decision tree of depth `n`.

### DFS State Space Search
We use recursion to explore the state space:
1. **Choose**: Add an element to the current subset.
2. **Explore**: Recurse forward starting from the next index.
3. **Un-choose**: Remove the element (backtrack) to explore the next branch.

### Bit Manipulation Alternative
Each subset can be represented by a bitmask of length `n`. There are `2^n` such masks (from `00...0` to `11...1`).
1. Iterate from `i = 0` up to `2^n - 1`.
2. For each `i`, if the `j`-th bit is set, include `nums[j]` in the subset.

## Approach

### Backtracking (Optimal for exploration)
**Time**: O(2^n * n), **Space**: O(n) for the recursion stack.

1. Create a `backtrack(start, currentSubset)` function.
2. Add a **copy** of `currentSubset` to the result list.
3. For `i` from `start` to `nums.length - 1`:
   - Add `nums[i]` to `currentSubset`.
   - Call `backtrack(i + 1, currentSubset)`.
   - Pop `nums[i]` from `currentSubset` (backtrack).

**Why it's optimal**: We generate exactly `2^n` subsets, and copying each takes O(n).

## Solution

See [solution.java](solution.java) for implementation.

## Key Insights

1. **Start index**: The `start` parameter prevents us from reusing previous elements, ensuring we only generate unique subsets and don't get stuck in cycles.
2. **Result capture**: Unlike some backtracking problems that only capture results at leaf nodes, for subsets, we capture every state reached.
3. **Immutable results**: Always add a *new* list (copy) to your result, not the reference to the list being modified.

## Edge Cases

- **Empty input array** (not possible per constraints, but returns `[[]]`).
- **Single element array**.
- **Array with max allowed length** (10 nodes -> 1024 subsets).

## Related Problems

- Subsets II (LeetCode 90) - handling duplicates in `nums`.
- Combinations (LeetCode 77)
- Permutations (LeetCode 46)
