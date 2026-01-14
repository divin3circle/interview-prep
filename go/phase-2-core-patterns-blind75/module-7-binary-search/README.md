# Module 7: Binary Search

## Pattern Overview

Binary Search divides the search space in half repeatedly, achieving O(log n) time complexity for searching sorted data. It's not just for finding elements in an array; it's a general technique for optimization problems ("Binary Search on Answer").

## Core Techniques (Go Style)

### 1. Standard Binary Search
Initialize `left` and `right`. Loop while `left <= right`.
```go
func binarySearch(nums []int, target int) int {
    left, right := 0, len(nums)-1
    for left <= right {
        mid := left + (right-left)/2 // Avoid overflow
        if nums[mid] == target {
            return mid
        } else if nums[mid] < target {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    return -1
}
```

### 2. Finding Minimum/Maximum (Boundaries)
Sometimes we need `left` and `right` to converge to a boundary, e.g., finding the first bad version or minimum in a rotated array.
- Loop condition often `left < right`.
- Update logic: `right = mid` (keep mid) or `left = mid + 1`.

## Problems in This Module

### 1. Binary Search
**Difficulty**: Easy
**Pattern**: Standard
[View Problem](01-binary-search/README.md)

### 2. Search in Rotated Sorted Array
**Difficulty**: Medium
**Pattern**: Modified Binary Search (Pivot Logic)
[View Problem](02-search-rotated-array/README.md)

### 3. Find Minimum in Rotated Sorted Array
**Difficulty**: Medium
**Pattern**: Boundary convergence
[View Problem](03-find-minimum-rotated/README.md)

### 4. Search a 2D Matrix
**Difficulty**: Medium
**Pattern**: 2D indexing or Double Binary Search
[View Problem](04-search-2d-matrix/README.md)

## Common Mistakes in Go
- **Overflow**: Always use `mid := left + (right-left)/2` instead of `(left+right)/2` (though less likely to hit 64-bit int limits, it's good practice).
- **Infinite Loop**: Be careful with `left < right` vs `left <= right` and how you update bounds (`mid` vs `mid+1`).

## Interview Tips
- **Sorted?**: If the input is sorted (or partially sorted like a rotated array), think Binary Search immediately.
- **Log N Time**: If the constraint allows O(log N) but not O(N), it's likely Binary Search.
