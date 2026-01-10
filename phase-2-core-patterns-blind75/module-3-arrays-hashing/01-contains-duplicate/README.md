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

## Theoretical Concepts

### Hash Tables
A hash table is a data structure that provides average O(1) time complexity for insertion, deletion, and lookup operations. It works by:
- Computing a hash code from the key (in this case, the array element)
- Using the hash code to determine the index in an underlying array
- Handling collisions through chaining or open addressing

### Set Abstract Data Type (ADT)
A Set is a collection that contains no duplicate elements. Key operations:
- `add(element)`: Adds element if not already present, returns boolean indicating if added
- `contains(element)`: Checks if element exists in the set
- `remove(element)`: Removes element from the set

Java's `HashSet` implements the Set interface using a hash table, providing O(1) average-case performance for basic operations.

### Time-Space Tradeoff
This problem demonstrates a classic tradeoff:
- **Less space, more time**: Sorting approach uses O(1) extra space but O(n log n) time
- **More space, less time**: HashSet approach uses O(n) space but O(n) time

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

## Edge Cases

- **Empty array**: Not possible per constraints (length >= 1)
- **Single element**: `[1]` → `false` (need at least 2 elements for duplicate)
- **All unique**: `[1,2,3,4,5]` → `false`
- **All same**: `[5,5,5,5]` → `true` (duplicate found immediately)
- **Duplicate at boundaries**: `[1,2,3,1]` → `true` (first and last elements)
- **Large numbers**: Within range `-10^9` to `10^9`, hash function handles well
- **Negative numbers**: `[-1,-2,-3,-1]` → `true` (works same as positive)

## Related Problems

- Contains Duplicate II (LeetCode 219) - with distance constraint
- Contains Duplicate III (LeetCode 220) - with value constraint
- Find the Duplicate Number (LeetCode 287)
- Single Number (LeetCode 136)

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
