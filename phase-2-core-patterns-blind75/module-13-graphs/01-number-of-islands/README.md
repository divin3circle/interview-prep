# Number of Islands

**Difficulty**: Medium  
**Pattern**: Graph (BFS / DFS / Union Find)  
**Companies**: Amazon, Google, Microsoft, Facebook, Apple, Bloomberg, Uber

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

- `m == grid.length`
- `n == grid[i].length`
- `1 <= m, n <= 300`
- `grid[i][j]` is `'0'` or `'1'`.

## Theoretical Concepts

### Connected Components in a Grid
This problem is fundamentally about finding the number of **connected components** in an undirected graph where nodes are land cells and edges exist between adjacent land cells.

### Traversal Algorithms
1. **DFS (Depth-First Search)**: Recursively visit all connected land cells and mark them as visited (sink the island).
2. **BFS (Breadth-First Search)**: Use a queue to visit all connected land cells level by level.
3. **Union Find (Disjoint Set Union)**: Treat each land cell as a set and union adjacent land sets. The number of disjoint sets is the number of islands.

### Marking as Visited
To avoid visiting the same cell twice and getting stuck in a loop:
- **Extra Space**: Use a `boolean[][] visited` array.
- **In-place**: Modify the grid itself (e.g., change `'1'` to `'0'`) to "sink" the island once it has been counted.

## Approach

### DFS / Sink the Island (Optimal)
**Time**: O(M * N), **Space**: O(M * N) worst case for recursion stack.

1. Scan the 2D grid.
2. If a node contains `'1'`, it's the root of a new island. Increment the counter.
3. Start a DFS from that node to find all connected land cells.
4. During DFS, set each visited `'1'` to `'0'`.
5. Repeat until the entire grid is scanned.

**Why it's optimal**: We visit each cell at most twice (once during scan, once during DFS).

## Solution

See [solution.java](solution.java) for implementation.

## Key Insights

1. **Flood fill pattern**: Once you find a piece of land, you "infect" all adjacent pieces to mark them as part of the same island.
2. **In-place modification**: Saves O(MN) auxiliary space if mutating the input is allowed.
3. **Connectivity**: Only horizontal and vertical connections count (4-directional).

## Edge Cases

- **Grid with only water**.
- **Grid with only land** (1 big island).
- **Diagonal lands** (should not be connected).
- **1x1 grid**.
- **Empty grid** (0 islands).

## Related Problems

- Max Area of Island (LeetCode 695)
- Surrounded Regions (LeetCode 130)
- Word Search (LeetCode 79)
- Number of Connected Components in an Undirected Graph (LeetCode 323)
