# Largest Rectangle in Histogram

**Difficulty**: Hard  
**Pattern**: Monotonic Stack  

## Problem Statement

Given an array of integers `heights` representing the histogram's bar height where the width of each bar is `1`, return the area of the largest rectangle in the histogram.

## Approach

Use monotonic increasing stack. When smaller bar found, calculate area with popped bars as height.

**Time**: O(n), **Space**: O(n)

## Solution

See [solution.java](solution.java)
