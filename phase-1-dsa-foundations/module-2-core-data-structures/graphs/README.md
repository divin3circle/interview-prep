# Graphs

## Overview
A Graph is a structure consisting of **Vertices** (Nodes) and **Edges** (Connections).

## Types
- **Directed**: Edges have direction (A -> B).
- **Undirected**: Edges are bidirectional (A - B).
- **Weighted**: Edges have weights/costs.
- **Cyclic/Acyclic**: Contains a cycle or not.

## Representations
1. **Adjacency Matrix**: 2D array `grid[i][j]`.
   - Space O(V^2). Good for dense graphs. O(1) edge check.
2. **Adjacency List**: Map `map.get(i) -> List<Neighbors>`.
   - Space O(V + E). Good for sparse graphs. This is the **standard** representation.

## Core Traversals
1. **DFS (Depth-First Search)**: Stack-based (recursion). Used for path finding, cycle detection, topology sort.
2. **BFS (Breadth-First Search)**: Queue-based. Used for **Shortest Path** in unweighted graphs.

## Complexity
- DFS/BFS Time: **O(V + E)** with Adj List.
- Space: **O(V)** to store visited set.

## Interview Tips
- Always keep a `visited` set to avoid cycles.
- Graphs can be disconnected. Loop through all nodes to ensure coverage.
- Grids (2D Arrays) are implicitly graphs (4-way connectivity).
