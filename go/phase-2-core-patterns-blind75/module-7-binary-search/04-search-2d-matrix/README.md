# Search a 2D Matrix

**Difficulty**: Medium
**Pattern**: Binary Search (2D)

## Problem Statement

You are given an `m x n` integer matrix `matrix` with the following two properties:
- Each row is sorted in non-decreasing order.
- The first integer of each row is greater than the last integer of the previous row.

Given an integer `target`, return `true` if `target` is in `matrix` or `false` otherwise.

You must write a solution in `O(log(m * n))` time complexity.

## Examples

### Example 1
```
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
```

### Example 2
```
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
```

## Approach

### Virtual Array (Optimal)
The matrix properties effectively allow us to treat the `m x n` matrix as a sorted 1D array of size `m * n`.
1. Range `[0, m*n - 1]`.
2. Map index `idx` to matrix coordinates:
   - `row = idx / cols`
   - `col = idx % cols`
3. Perform standard binary search.

**Time**: O(log(M * N))
**Space**: O(1)

## Go Solution

```go
func searchMatrix(matrix [][]int, target int) bool {
    rows := len(matrix)
    if rows == 0 { return false }
    cols := len(matrix[0])
    
    left, right := 0, rows*cols - 1
    
    for left <= right {
        mid := left + (right-left)/2
        midVal := matrix[mid/cols][mid%cols]
        
        if midVal == target {
            return true
        }
        
        if midVal < target {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    return false
}
```

### Key Go Insights
- **Coordinate Mapping**: `mid / cols` gives the row index, `mid % cols` gives the column index.
- **Empty Matrix Check**: Always check `len(matrix) == 0` before accessing `matrix[0]`.

## Edge Cases
- Empty matrix.
- Target out of bounds (smaller/larger than all).
- Single element matrix.
