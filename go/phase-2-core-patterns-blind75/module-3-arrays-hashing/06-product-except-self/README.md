# Product of Array Except Self

**Difficulty**: Medium
**Pattern**: Arrays & Hashing

## Problem Statement

Given an integer array `nums`, return an array `answer` such that `answer[i]` is equal to the product of all the elements of `nums` except `nums[i]`.
The algorithm must run in O(n) time and without using the division operation.

## Examples

### Example 1
```
Input: nums = [1,2,3,4]
Output: [24,12,8,6]
```

### Example 2
```
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
```

## Approach

### 1. Division (Not Allowed)
- Calculate total product, divide by `nums[i]`.
- Fails if `nums[i] == 0`.

### 2. Prefix & Suffix Products (Optimal)
- `answer[i] = PrefixProduct[i] * SuffixProduct[i]`
- **Pass 1 (Left -> Right)**: Calculate prefix products and store in `answer`.
  - `answer[i]` stores product of `nums[0]...nums[i-1]`.
- **Pass 2 (Right -> Left)**: Maintain running `suffix` product and multiply `answer[i]` by it.
- **Time**: O(N)
- **Space**: O(1) (output array doesn't count as extra space).

## Go Solution

```go
func productExceptSelf(nums []int) []int {
    n := len(nums)
    res := make([]int, n)
    res[0] = 1
    
    // Pass 1: Prefix products
    for i := 1; i < n; i++ {
        res[i] = res[i-1] * nums[i-1]
    }
    
    // Pass 2: Suffix products
    suffix := 1
    for i := n - 1; i >= 0; i-- {
        res[i] *= suffix
        suffix *= nums[i]
    }
    
    return res
}
```

### Key Go Insights
- **In-place Mutation**: We reuse the `res` slice to store intermediate prefix states, optimizing space.

## Edge Cases
- Zeros (handled naturally).
- Negatives (handled naturally).
