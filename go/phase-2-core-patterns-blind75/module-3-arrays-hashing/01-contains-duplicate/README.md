# Contains Duplicate

**Difficulty**: Easy
**Pattern**: Arrays & Hashing

## Problem Statement

Given an integer array `nums`, return `true` if any value appears at least twice in the array, and return `false` if every element is distinct.

## Examples

### Example 1
```
Input: nums = [1,2,3,1]
Output: true
Explanation: 1 appears twice.
```

### Example 2
```
Input: nums = [1,2,3,4]
Output: false
```

## Approach

### 1. Brute Force (Bad)
- Nested loops compared every pair.
- **Time**: O(n²)
- **Space**: O(1)

### 2. Sorting (Okay)
- Sort array, check neighbors.
- **Time**: O(n log n)
- **Space**: O(1) (or O(log n) stack space depending on sort impl).

### 3. Hash Set (Optimal)
- Iterate and store seen numbers in a map.
- If number is already in map, return true.
- **Time**: O(n)
- **Space**: O(n)

## Go Solution

```go
func containsDuplicate(nums []int) bool {
    seen := make(map[int]struct{}) // Empty struct uses 0 bytes
    for _, num := range nums {
        if _, exists := seen[num]; exists {
            return true
        }
        seen[num] = struct{}{}
    }
    return false
}
```

### Key Go Insights
- **`map[T]struct{}`**: Uses less memory than `map[T]bool` because `struct{}{}` has 0 size.
- **Short-circuiting**: Return `true` as soon as a duplicate is found.

## Test Cases
- Small arrays
- Large arrays
- Negative numbers
- All duplicates
