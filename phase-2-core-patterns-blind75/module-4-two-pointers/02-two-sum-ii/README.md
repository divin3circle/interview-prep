# Two Sum II - Input Array Is Sorted

**Difficulty**: Medium  
**Pattern**: Two Pointers  
**Companies**: Google, Amazon, Microsoft, Facebook

## Problem Statement

Given a 1-indexed array of integers `numbers` that is already sorted in non-decreasing order, find two numbers such that they add up to a specific `target` number. Return the indices of the two numbers (1-indexed) as an integer array `[index1, index2]` where `1 <= index1 < index2 <= numbers.length`.

You may not use the same element twice. Your solution must use only constant extra space.

## Examples

### Example 1
```
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: 2 + 7 = 9, indices are 1 and 2 (1-indexed)
```

### Example 2
```
Input: numbers = [2,3,4], target = 6
Output: [1,3]
```

### Example 3
```
Input: numbers = [-1,0], target = -1
Output: [1,2]
```

## Constraints

- `2 <= numbers.length <= 3 * 10^4`
- `-1000 <= numbers[i] <= 1000`
- `numbers` is sorted in non-decreasing order
- `-1000 <= target <= 1000`
- Exactly one solution exists

## Theoretical Concepts

### Sorted Array Properties
When array is sorted, we gain powerful properties:
- **Binary Search**: Can find element in O(log n)
- **Two Pointers**: Can find pairs in O(n) with O(1) space
- **Monotonicity**: If sum is too small, moving left pointer right increases sum
- **Monotonicity**: If sum is too large, moving right pointer left decreases sum

### Two Sum I vs Two Sum II

| Aspect | Two Sum I | Two Sum II |
|--------|-----------|------------|
| Array | Unsorted | Sorted |
| Optimal Approach | HashMap | Two Pointers |
| Time | O(n) | O(n) |
| Space | O(n) | O(1) |
| Indexing | 0-indexed | 1-indexed |

### Two Pointer Decision Logic
```
sum = numbers[left] + numbers[right]
if (sum < target)  → left++   // Need larger sum
if (sum > target)  → right--  // Need smaller sum
if (sum == target) → return   // Found solution
```

**Why this works**:
- If `sum < target`: All pairs with `right` and `left` or smaller are too small
- If `sum > target`: All pairs with `left` and `right` or larger are too large
- Each iteration eliminates one index from consideration

### Space Complexity Constraint
Problem requires O(1) space, which rules out:
- HashMap approach (O(n) space)
- Storing all pairs (O(n²) space)
- Binary search for each element (O(1) space but O(n log n) time)

Two pointers is the only approach meeting both time and space requirements.

## Edge Cases

- **Minimum length**: `[1,2], target=3` → `[1,2]`
- **Negative numbers**: `[-1,0], target=-1` → `[1,2]`
- **Duplicates**: `[1,2,2,3], target=4` → `[2,3]` or `[1,4]`
- **Large gap**: `[1,100], target=101` → `[1,2]`
- **Adjacent elements**: `[1,2,3], target=3` → `[1,2]`
- **Same value repeated**: `[2,2,2], target=4` → `[1,2]` (first two)

## Approach

### Two Pointers (Optimal)
**Time**: O(n), **Space**: O(1)

Use two pointers from both ends. If sum is too small, move left pointer right. If sum is too large, move right pointer left.

**Why it's optimal**: Exploits sorted property for O(n) time with O(1) space.

## Solution

See [solution.java](solution.java) for implementation.

## Key Insights

1. **Sorted array enables two pointers**: Can determine which pointer to move
2. **1-indexed output**: Remember to add 1 to indices
3. **Constant space required**: Cannot use HashMap like Two Sum I
4. **Guaranteed solution**: Can return immediately when found

## Related Problems

- Two Sum (LeetCode 1)
- 3Sum (LeetCode 15)
- 4Sum (LeetCode 18)
