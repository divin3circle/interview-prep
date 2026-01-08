# Module 13: Graphs

## Pattern Overview

Graphs model relationships. Common algorithms: DFS, BFS, Topological Sort, Union-Find.

## Core Techniques

### DFS on Graph (Matrix)
```java
void dfs(int[][] grid, int r, int c) {
    if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0') return;
    grid[r][c] = '0'; // visited
    dfs(grid, r+1, c);
    dfs(grid, r-1, c);
    dfs(grid, r, c+1);
    dfs(grid, r, c-1);
}
```

## Problems
1. Number of Islands
2. Clone Graph
3. Pacific Atlantic Water Flow
4. Course Schedule

