# 3Sum

**Difficulty**: Medium
**Pattern**: Two Pointers

## Problem Statement

Given an integer array `nums`, return all the triplets `[nums[i], nums[j], nums[k]]` such that `i != j`, `i != k`, and `j != k`, and `nums[i] + nums[j] + nums[k] == 0`.

Notice that the solution set must not contain duplicate triplets.

## Examples

### Example 1
```
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
```

### Example 2
```
Input: nums = [0,1,1]
Output: []
```

### Example 3
```
Input: nums = [0,0,0]
Output: [[0,0,0]]
```

## Approach

### Sorting + Two Pointers (Optimal)
1. **Sort** the array first O(N log N). This allows us to use separation logic and easily skip duplicates.
2. Iterate through the array with index `i`. This is the first element of our triplet.
3. For each `i`, we need to find two numbers that sum to `-nums[i]`. This is exactly the **Two Sum II** problem (sorted input).
4. initialize `left = i + 1` and `right = len(nums) - 1`.
5. **Duplicate Handling**:
   - If `nums[i] == nums[i-1]`, skip this iteration (already processed this start value).
   - When a valid triplet is found (`nums[i] + nums[l] + nums[r] == 0`), move both pointers.
   - Loop `left` and `right` to skip any duplicate values they land on to ensure unique triplets.

**Time**: O(N²) (Outer loop N * Inner loop N)
**Space**: O(1) (excluding output slice memory, dependent on sort implementation)

## Go Solution

```go
func threeSum(nums []int) [][]int {
    sort.Ints(nums)
    var res [][]int
    
    for i := 0; i < len(nums)-2; i++ {
        // Skip duplicates for the first element
        if i > 0 && nums[i] == nums[i-1] {
            continue
        }
        
        // Two Pointers
        l, r := i+1, len(nums)-1
        for l < r {
            sum := nums[i] + nums[l] + nums[r]
            if sum == 0 {
                res = append(res, []int{nums[i], nums[l], nums[r]})
                // Skip duplicates for 2nd and 3rd elements
                for l < r && nums[l] == nums[l+1] { l++ }
                for l < r && nums[r] == nums[r-1] { r-- }
                l++
                r--
            } else if sum < 0 {
                l++
            } else {
                r--
            }
        }
    }
    return res
}
```

### Key Go Insights
- **`sort.Ints(nums)`**: Standard way to sort int slice.
- **Slice Appending**: efficiently building result.

## Edge Cases
- All zeros: `[0,0,0]`.
- No solution.
- Duplicates: `[-1,-1,2]`.
