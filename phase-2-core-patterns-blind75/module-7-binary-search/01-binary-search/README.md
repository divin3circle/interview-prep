# Binary Search

**Difficulty**: Easy  
**Pattern**: Binary Search  

## Problem Statement

Given a sorted array of integers `nums` and an integer `target`, return the index of `target` if it exists, otherwise return `-1`.

## Approach

Standard binary search: compare middle element, adjust search space.

**Time**: O(log n), **Space**: O(1)

## Solution

```java
public int search(int[] nums, int target) {
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
