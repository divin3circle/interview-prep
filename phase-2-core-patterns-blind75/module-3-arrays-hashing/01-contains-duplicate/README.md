# Contains Duplicate

**Difficulty**: Easy  
**Pattern**: Arrays & Hashing  
**Companies**: Google, Amazon, Apple, Microsoft, Facebook

## Problem Statement

Given an integer array `nums`, return `true` if any value appears at least twice in the array, and return `false` if every element is distinct.

## Examples

### Example 1
```
Input: nums = [1,2,3,1]
Output: true
Explanation: The element 1 appears at indices 0 and 3.
```

### Example 2
```
Input: nums = [1,2,3,4]
Output: false
Explanation: All elements are distinct.
```

### Example 3
```
Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true
Explanation: Multiple elements appear more than once.
```

## Constraints

- `1 <= nums.length <= 10^5`
- `-10^9 <= nums[i] <= 10^9`

## Approach

### Brute Force
**Time**: O(n²), **Space**: O(1)

Check every pair of elements to see if any match.

**Why it's suboptimal**: Nested loops are inefficient for large arrays.

### Sorting
**Time**: O(n log n), **Space**: O(1)

Sort the array, then check adjacent elements for duplicates.

**Why it's suboptimal**: Sorting is slower than necessary and modifies the input.

### HashSet (Optimal)
**Time**: O(n), **Space**: O(n)

Use a HashSet to track seen elements. If we encounter an element already in the set, we've found a duplicate.

**Why it's optimal**: Single pass through the array with O(1) lookups.

## Solution

See [solution.java](solution.java) for the optimal implementation.

## Detailed Explanation

See [solution-explained.md](solution-explained.md) for step-by-step walkthrough using the 10-step framework.

## Test Cases

See [test-cases.java](test-cases.java) for comprehensive test coverage.

## Related Problems

- Contains Duplicate II (with distance constraint)
- Contains Duplicate III (with value constraint)
- Find the Duplicate Number
- Single Number

## Key Insights

1. **HashSet provides O(1) existence checks**: Perfect for duplicate detection
2. **Space-time tradeoff**: Trading O(n) space for O(n) time improvement
3. **Early termination**: Can return immediately upon finding first duplicate
4. **add() return value**: HashSet.add() returns false if element already exists

## Follow-Up Questions

**Q**: What if we cannot use extra space?  
**A**: Sort the array first (O(n log n) time, O(1) space), then check adjacent elements.

**Q**: What if the array is already sorted?  
**A**: Simply check adjacent elements in O(n) time, O(1) space.

**Q**: How would you find all duplicates, not just detect if any exist?  
**A**: Use HashMap to count frequencies, then return elements with count > 1.

**Q**: What if we need to preserve the original array order?  
**A**: HashSet approach doesn't modify the array, so it's already suitable.
