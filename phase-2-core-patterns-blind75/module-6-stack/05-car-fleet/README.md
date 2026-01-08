# Car Fleet

**Difficulty**: Medium  
**Pattern**: Stack  

## Problem Statement

There are `n` cars going to the same destination along a one-lane road. Calculate how many car fleets will arrive at the destination.

## Approach

Sort by position. Calculate time to reach target for each car. Use stack to track fleets.

**Time**: O(n log n), **Space**: O(n)

## Solution

See [solution.java](solution.java)
