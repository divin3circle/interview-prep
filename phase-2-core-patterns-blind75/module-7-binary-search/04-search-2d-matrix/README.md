# Search a 2D Matrix

**Difficulty**: Medium  
**Pattern**: Binary Search  

## Problem Statement

Search for a value in an m x n matrix. Integers in each row are sorted left to right. First integer of each row is greater than the last integer of the previous row.

## Approach

Treat 2D matrix as 1D sorted array. Use binary search with index conversion.

**Time**: O(log(m×n)), **Space**: O(1)

## Solution

```java
public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length, n = matrix[0].length;
    int left = 0, right = m * n - 1;
    
    while (left <= right) {
        int mid = left + (right - left) / 2;
        int midValue = matrix[mid / n][mid % n];
        
        if (midValue == target) return true;
        else if (midValue < target) left = mid + 1;
        else right = mid - 1;
    }
    return false;
}
```
