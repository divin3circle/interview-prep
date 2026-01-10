# Pacific Atlantic Water Flow

**Difficulty**: Medium  
**Pattern**: Graph (Multi-Source DFS / BFS)  
**Companies**: Google, Amazon, Microsoft, Facebook

## Problem Statement

There is an `m x n` rectangular island that borders both the Pacific Ocean and the Atlantic Ocean. The **Pacific Ocean** touches the island's left and top edges, and the **Atlantic Ocean** touches the island's right and bottom edges.

The island is partitioned into a grid of square cells of heights `heights[r][c]`. When it rains, water flows to neighbor cells in 4 directions if the neighbor's height is **less than or equal to** the current cell's height. Water can also flow directly into an ocean from any cell adjacent to it.

Return a 2D list of grid coordinates `result` where `result[i] = [ri, ci]` means that rainwater can flow from cell `(ri, ci)` to **both** the Pacific and Atlantic oceans.

## Examples

### Example 1
```
Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
```

### Example 2
```
Input: heights = [[1]]
Output: [[0,0]]
```

## Constraints

- `m == heights.length`
- `n == heights[r].length`
- `1 <= m, n <= 200`
- `0 <= heights[r][c] <= 10^5`

## Theoretical Concepts

### Inverse Flow Strategy
Thinking about water flowing *down* from every cell to the ocean is inefficient (O(M²N²)). Instead, think about water flowing *up* from the ocean.
- A cell can reach the Pacific if it is connected to a Pacific-bordering cell through a path where heights are **non-decreasing**.
- The same applies to the Atlantic.

### Connected Components from Oceans
- **Pacific Reachability**: Start DFS/BFS from all cells on the top and left edges.
- **Atlantic Reachability**: Start DFS/BFS from all cells on the bottom and right edges.
- Use two `boolean[][]` matrices to track reachability from each ocean.

### Intersection of Reachable Sets
The cells that can reach both oceans are those that are marked `true` in both reachability matrices.

## Approach

### Multi-Source DFS (Optimal)
**Time**: O(M * N), **Space**: O(M * N)

1. Create `pacificReachable` and `atlanticReachable` boolean matrices.
2. Perform DFS for Pacific starting from the top row and left column.
3. Perform DFS for Atlantic starting from the bottom row and right column.
4. When doing DFS from `(r, c)` to neighbor `(nr, nc)`, only proceed if `heights[nr][nc] >= heights[r][c]`.
5. After all DFS passes, iterate through the grid once. If a cell is reachable by both, add to the result.

**Why it's optimal**: We visit each cell a constant number of times.

## Solution

See [solution.java](solution.java) for implementation.

## Key Insights

1. **Reverse the problem**: "Can water flow down?" is harder than "Can I climb up?".
2. **Redundancy avoidance**: Marking a cell as reachable once is enough; no need to explore paths from it again for the same ocean.
3. **Boundary conditions**: The four edges are the starting points (mouths of the rivers).

## Edge Cases

- **Island of height 0**.
- **Island with all same heights** (all cells reachable).
- **Steep peaks in middle** (may reach both).
- **Deep valleys in middle** (may reach neither).
- **Single cell island**.

## Related Problems

- Number of Islands (LeetCode 200)
- Surrounded Regions (LeetCode 130)
- Flowing Water (General pattern)
