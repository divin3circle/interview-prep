# Clone Graph

**Difficulty**: Medium
**Pattern**: DFS with HashMap

## Problem Statement

Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph.

## Approach

### DFS with HashMap
Use map to track cloned nodes to avoid infinite loops.

**Time**: O(N + E)
**Space**: O(N)

## Go Solution

```go
type Node struct {
    Val int
    Neighbors []*Node
}

func cloneGraph(node *Node) *Node {
    if node == nil {
        return nil
    }
    cloned := make(map[*Node]*Node)
    var dfs func(*Node) *Node
    dfs = func(n *Node) *Node {
        if clone, exists := cloned[n]; exists {
            return clone
        }
        clone := &Node{Val: n.Val}
        cloned[n] = clone
        for _, neighbor := range n.Neighbors {
            clone.Neighbors = append(clone.Neighbors, dfs(neighbor))
        }
        return clone
    }
    return dfs(node)
}
```
