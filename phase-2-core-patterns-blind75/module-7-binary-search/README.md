# Module 7: Binary Search

## Pattern Overview

Binary Search divides the search space in half repeatedly, achieving O(log n) time complexity for searching sorted data.

## When to Use

1. **Sorted array** → Binary search
2. **"Find minimum/maximum that satisfies..."** → Binary search on answer
3. **Rotated sorted array** → Modified binary search

## Core Technique

```java
public int binarySearch(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) return mid;
        else if (nums[mid] < target) left = mid + 1;
        else right = mid - 1;
    }
    return -1;
}
```

## Problems

1. Binary Search
2. Search in Rotated Sorted Array
3. Find Minimum in Rotated Sorted Array
4. Search a 2D Matrix

**Key Takeaway**: Binary search reduces O(n) to O(log n) for sorted data.
