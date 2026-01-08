# Number of Islands

**Difficulty**: Medium  
**Pattern**: Graphs (DFS/BFS)

## Problem Statement
Given an `m x n` 2D binary grid `grid` which represents a map of `'1'`s (land) and `'0'`s (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

## Examples

### Example 1
```
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
```

### Example 2
```
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
```

## Constraints
* `m == grid.length`
* `n == grid[i].length`
* `1 <= m, n <= 300`

## Approach

### 1. Depth First Search (DFS)
Iterate through every cell in the grid.
* If a cell is `'1'` (Land), it means we found a new island. Increment count.
* Start a DFS from that cell to find all connected parts of this island.
* **Mark visited**: Change `'1'` to `'0'` (or a special character like `'#'`) to mark it as visited so we don't count it again.

### Complexity
* **Time**: `O(m * n)` - We visit each cell once.
* **Space**: `O(m * n)` - Worst case stack depth if the entire grid is land.

## Solution

See [solution.java](solution.java) for the implementation.
