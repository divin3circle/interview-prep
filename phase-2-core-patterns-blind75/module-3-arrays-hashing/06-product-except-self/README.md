# Product of Array Except Self

**Difficulty**: Medium  
**Pattern**: Arrays & Hashing  
**Companies**: Google, Amazon, Facebook, Microsoft, Apple

## Problem Statement

Given an integer array `nums`, return an array `answer` such that `answer[i]` is equal to the product of all the elements of `nums` except `nums[i]`.

The product of any prefix or suffix of `nums` is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

## Examples

### Example 1
```
Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Explanation:
- answer[0] = 2 × 3 × 4 = 24
- answer[1] = 1 × 3 × 4 = 12
- answer[2] = 1 × 2 × 4 = 8
- answer[3] = 1 × 2 × 3 = 6
```

### Example 2
```
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
```

## Constraints

- `2 <= nums.length <= 10^5`
- `-30 <= nums[i] <= 30`
- Product of any prefix or suffix fits in 32-bit integer

## Approach

### Division (Not Allowed)
**Time**: O(n), **Space**: O(1)

Calculate total product, then divide by each element. **Cannot use** per problem constraints.

### Prefix and Suffix Products (Optimal)
**Time**: O(n), **Space**: O(1) excluding output array

For each position, multiply product of all elements to the left by product of all elements to the right.

**Why it's optimal**: O(n) time without division, O(1) extra space.

## Solution

See [solution.java](solution.java) for implementation.

## Key Insights

1. **Product except self = prefix × suffix**: Split into left and right products
2. **Two passes**: One for prefix, one for suffix
3. **Space optimization**: Use output array to store prefix, calculate suffix on the fly
4. **Handle zeros**: Algorithm naturally handles zeros correctly

## Follow-Up Questions

**Q**: Can you do it with O(1) extra space?  
**A**: Yes, use output array to store prefix products, then multiply by suffix in second pass.

**Q**: What if division was allowed?  
**A**: Calculate total product, divide by each element (handle zeros specially).

**Q**: How do you handle multiple zeros?  
**A**: If 2+ zeros, all products are 0. If 1 zero, only that position is non-zero.

## Related Problems

- Maximum Product Subarray (LeetCode 152)
- Product of the Last K Numbers (LeetCode 1352)
- Minimum Product of Two Elements (LeetCode 1464)
