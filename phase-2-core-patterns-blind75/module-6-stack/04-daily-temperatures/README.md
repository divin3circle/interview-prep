# Daily Temperatures

**Difficulty**: Medium  
**Pattern**: Monotonic Stack  

## Problem Statement

Given an array of integers `temperatures` representing daily temperatures, return an array `answer` such that `answer[i]` is the number of days you have to wait after the `i`th day to get a warmer temperature.

## Approach

Use monotonic decreasing stack. Store indices. When warmer day found, pop and calculate distance.

**Time**: O(n), **Space**: O(n)

## Solution

See [solution.java](solution.java)
