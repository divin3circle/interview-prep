# Find Minimum in Rotated Sorted Array

**Difficulty**: Medium  
**Pattern**: Binary Search  

## Problem Statement

Find the minimum element in a rotated sorted array.

## Approach

Binary search: if mid > right, minimum is in right half; otherwise in left half.

**Time**: O(log n), **Space**: O(1)

## Solution

```java
public int findMin(int[] nums) {
    int left = 0, right = nums.length - 1;
    
    while (left < right) {
        int mid = left + (right - left) / 2;
        
        if (nums[mid] > nums[right]) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }
    return nums[left];
}
```
