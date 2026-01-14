# Graphs

## Representation
Adjacency List is standard: `map[int][]int`.

```go
type Graph struct {
    Adj map[int][]int
}
```

## Algorithms
- **DFS**: Recursion + `visited` map.
- **BFS**: Queue slice + `visited` map.
