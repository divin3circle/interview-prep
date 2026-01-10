# Search a 2D Matrix

**Difficulty**: Medium  
**Pattern**: Binary Search (2D)  
**Companies**: Google, Amazon, Microsoft, Facebook

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

## Constraints

- `m == matrix.length`
- `n == matrix[i].length`
- `1 <= m, n <= 100`
- `-10^4 <= matrix[i][j], target <= 10^4`

## Theoretical Concepts

### Matrix to Array Linearization
The core trick for this problem is treating the `m x n` matrix as a single sorted array of length `m * n`. 
- An index `i` in the linearized array corresponds to `matrix[i / n][i % n]`.
- Because each row is sorted and the first element of a row is greater than the last of the previous, the entire "stretched out" matrix is strictly non-decreasing.

### Binary Search on Virtual Array
We can perform a standard binary search on the range `[0, m * n - 1]`. 
- `left = 0`, `right = m * n - 1`.
- `mid = (left + right) / 2`.
- Map `mid` back to `(row, col)` coordinates to check the value.

### Alternative: Step-Wise Binary Search
1. Binary search on the first column to find the correct row.
2. Binary search within that row to find the target.
Both yield O(log m + log n), which is equivalent to O(log(m * n)).

## Approach

### Binary Search (Linearized)
**Time**: O(log(m * n)), **Space**: O(1)

Treat the matrix as a sorted list and perform one binary search.

**Why it's optimal**: We exploit the full sorting property in minimal time.

## Solution

See [solution.java](solution.java) for implementation.

## Key Insights

1. **2D structure is a 1D range**: The properties allow us to ignore the row/column boundaries for the purpose of searching.
2. **Coordinate conversion**: `row = index / columns`, `col = index % columns`.
3. **Space efficiency**: Constant extra space.

## Edge Cases

- **Target is smaller than `matrix[0][0]`**.
- **Target is larger than `matrix[m-1][n-1]`**.
- **Single row matrix**.
- **Single column matrix**.
- **Matrix size is 1x1**.

## Related Problems

- Search a 2D Matrix II (LeetCode 240) - where rows and columns are sorted independently.
- Kth Smallest Element in a Sorted Matrix (LeetCode 378).
