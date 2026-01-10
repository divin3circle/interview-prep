# Two Sum

**Difficulty**: Easy  
**Pattern**: Arrays & Hashing  
**Companies**: Google, Amazon, Apple, Microsoft, Facebook, Bloomberg

## Problem Statement

Given an array of integers `nums` and an integer `target`, return the indices of the two numbers that add up to `target`.

You may assume that each input has exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

## Examples

### Example 1
```
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: nums[0] + nums[1] = 2 + 7 = 9
```

### Example 2
```
Input: nums = [3,2,4], target = 6
Output: [1,2]
Explanation: nums[1] + nums[2] = 2 + 4 = 6
```

### Example 3
```
Input: nums = [3,3], target = 6
Output: [0,1]
Explanation: nums[0] + nums[1] = 3 + 3 = 6
```

## Constraints

- `2 <= nums.length <= 10^4`
- `-10^9 <= nums[i] <= 10^9`
- `-10^9 <= target <= 10^9`
- Only one valid answer exists

## Theoretical Concepts

### Hash Maps (Dictionaries)
A HashMap stores key-value pairs and provides:
- **O(1) average insertion**: `put(key, value)`
- **O(1) average lookup**: `get(key)` or `containsKey(key)`
- **O(1) average deletion**: `remove(key)`

In Java, `HashMap<K, V>` implements the Map interface using a hash table with separate chaining for collision resolution.

### The Complement Pattern
For sum-based problems, the complement pattern is crucial:
- Given a target sum and current value `x`
- The complement is `target - x`
- If complement exists in our data structure, we've found a pair

This transforms the problem from "find two numbers that sum to target" to "for each number, check if its complement exists."

### One-Pass vs Two-Pass
- **Two-pass**: Build complete HashMap, then search for complements
- **One-pass (optimal)**: Check for complement before adding current element
  - Avoids using same element twice
  - Reduces iterations from 2n to n

## Edge Cases

- **Duplicate values**: `[3,3], target=6` → Valid, returns `[0,1]`
- **Negative numbers**: `[-1,-2,-3,-4], target=-6` → Works normally
- **Zero in array**: `[0,4,3,0], target=0` → Returns indices of two zeros
- **Large numbers**: Within constraint range, no overflow issues
- **Minimum length**: Array has at least 2 elements per constraints
- **Target equals element**: `[5,10], target=5` → No match (can't use same index twice)

## Approach

### Brute Force
**Time**: O(n²), **Space**: O(1)

Check every pair of elements using nested loops.

**Why it's suboptimal**: Quadratic time complexity is inefficient for large arrays.

### HashMap (Optimal)
**Time**: O(n), **Space**: O(n)

Use a HashMap to store value → index mappings. For each element, check if its complement (target - element) exists in the map.

**Key Insight**: For each number `x`, we need to find if `target - x` exists. HashMap provides O(1) lookup.

**Why it's optimal**: Single pass through array with O(1) lookups.

## Solution

See [solution.java](solution.java) for the optimal implementation.

## Key Insights

1. **Complement pattern**: For pair sum problems, look for `target - current_value`
2. **HashMap for O(1) lookup**: Trades space for time efficiency
3. **Single pass**: Check before adding to avoid using same index twice
4. **Order doesn't matter**: Can return indices in any order

## Follow-Up Questions

**Q**: What if the array is sorted?  
**A**: Use two-pointer technique with O(n) time and O(1) space.

**Q**: What if we need all pairs that sum to target?  
**A**: Continue iterating instead of returning immediately, handle duplicates carefully.

**Q**: What if we can use the same element twice?  
**A**: Check if `target / 2` exists and appears at least twice.

**Q**: How would you handle multiple solutions?  
**A**: Store all valid pairs in a list instead of returning immediately.

## Related Problems

- Two Sum II - Input Array Is Sorted (LeetCode 167)
- 3Sum (LeetCode 15)
- 4Sum (LeetCode 18)
- Two Sum III - Data Structure Design (LeetCode 170)
- Subarray Sum Equals K (LeetCode 560)
