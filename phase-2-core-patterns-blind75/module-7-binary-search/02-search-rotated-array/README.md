# Search in Rotated Sorted Array

**Difficulty**: Medium  
**Pattern**: Binary Search  

## Problem Statement

Search for a target value in a rotated sorted array. Return its index or -1 if not found.

## Approach

Modified binary search: determine which half is sorted, then decide which half to search.

**Time**: O(log n), **Space**: O(1)

## Solution

```java
public int search(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) return mid;
        
        if (nums[left] <= nums[mid]) {
            if (target >= nums[left] && target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        } else {
            if (target > nums[mid] && target <= nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }
    return -1;
}
```
