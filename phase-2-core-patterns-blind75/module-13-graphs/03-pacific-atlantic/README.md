# Pacific Atlantic Water Flow

**Difficulty**: Medium  
**Pattern**: Graphs (DFS/BFS)

## Problem Statement
There is an `m x n` rectangular island that borders both the **Pacific Ocean** and **Atlantic Ocean**. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.

The island is partitioned into a grid of square cells. You are given an `m x n` integer matrix `heights` where `heights[r][c]` represents the height above sea level of the cell at coordinate `(r, c)`.

Rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is **less than or equal to** the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.

Return a 2D list of grid coordinates `result` where `result[i] = [ri, ci]` denotes that rain water can flow from cell `(ri, ci)` to **both** the Pacific and Atlantic oceans.

## Examples

### Example
```
Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
```

## Constraints
* `1 <= m, n <= 200`
* `0 <= heights[r][c] <= 10^5`

## Approach

### 1. Reverse DFS
Instead of checking where water flows *from* each cell (which repeats work), check where water can flow *from the ocean* (uphill).
* Start DFS/BFS from the **Pacific border** (Top Row, Left Col). Mark all reachable cells as `pacificReachable`.
* Start DFS/BFS from the **Atlantic border** (Bottom Row, Right Col). Mark all reachable cells as `atlanticReachable`.
* Intersection: Find cells that are marked `true` in both sets.

### Complexity
* **Time**: `O(m * n)` - Two searches over the grid.
* **Space**: `O(m * n)` - Visited arrays.

## Solution

See [solution.java](solution.java) for the implementation.
