# Permutations

**Difficulty**: Medium  
**Pattern**: Backtracking

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

## Constraints
* `1 <= nums.length <= 6`
* All integers are unique.

## Approach

### 1. Backtracking
Ideally, we want to try putting every number at every position.
* Maintain a current list `tempList`.
* Loop through `nums`.
* If `nums[i]` is already in `tempList`, skip it (or use a `used` boolean array for O(1) check).
* Else, add it and recurse.
* Base case: If `tempList.size() == nums.length`, add to result.

### Complexity
* **Time**: `O(N * N!)` - There are N! permutations.
* **Space**: `O(N)` - Recursion depth.

## Solution

See [solution.java](solution.java) for the implementation.
