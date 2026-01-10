# Module 7: Binary Search

## Pattern Overview

Binary Search divides the search space in half repeatedly, achieving O(log n) time complexity for searching sorted data.

## When to Use

1. **Sorted array** → Binary search
2. **"Find minimum/maximum that satisfies..."** → Binary search on answer
3. **Rotated sorted array** → Modified binary search

### Standard Search
Initialize `left` and `right` pointers. Calculate the `mid` point in a way that avoids overflow (`left + (right - left) / 2`). Compare the `mid` value with the target and adjust the range by shifting `left` or `right` to the half that must contain the target.

**Time**: O(log n), **Space**: O(1)

## Problems

1. Binary Search
2. Search in Rotated Sorted Array
3. Find Minimum in Rotated Sorted Array
4. Search a 2D Matrix

**Key Takeaway**: Binary search reduces O(n) to O(log n) for sorted data.
