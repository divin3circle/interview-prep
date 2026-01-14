# Module 13: Graphs

## Pattern Overview

Graphs represent relationships between entities. Common algorithms include DFS, BFS, and topological sort.

## Core Techniques (Go Style)

### Adjacency List
```go
graph := make(map[int][]int)
graph[1] = []int{2, 3}
graph[2] = []int{4}
```

### DFS (Recursive)
```go
visited := make(map[int]bool)
var dfs func(int)
dfs = func(node int) {
    if visited[node] {
        return
    }
    visited[node] = true
    for _, neighbor := range graph[node] {
        dfs(neighbor)
    }
}
```

### BFS (Queue)
```go
queue := []int{start}
visited := make(map[int]bool)
for len(queue) > 0 {
    node := queue[0]
    queue = queue[1:]
    for _, neighbor := range graph[node] {
        if !visited[neighbor] {
            visited[neighbor] = true
            queue = append(queue, neighbor)
        }
    }
}
```

## Problems in This Module

### 1. Number of Islands
**Difficulty**: Medium
[View Problem](01-number-of-islands/README.md)

### 2. Clone Graph
**Difficulty**: Medium
[View Problem](02-clone-graph/README.md)

### 3. Pacific Atlantic Water Flow
**Difficulty**: Medium
[View Problem](03-pacific-atlantic/README.md)

### 4. Course Schedule
**Difficulty**: Medium
[View Problem](04-course-schedule/README.md)

## Key Takeaway
Master DFS/BFS for graph traversal. Use visited sets to avoid cycles.
