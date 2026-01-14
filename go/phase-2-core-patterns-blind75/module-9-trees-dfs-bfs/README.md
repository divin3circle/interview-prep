# Module 9: Trees (DFS & BFS)

## Pattern Overview

Tree problems involve traversing the tree using DFS (Depth-First Search) or BFS (Breadth-First Search) to find properties or modify the structure.

## Core Techniques (Go Style)

### 1. TreeNode Definition
```go
type TreeNode struct {
    Val   int
    Left  *TreeNode
    Right *TreeNode
}
```

### 2. DFS (Recursive)
```go
func dfs(node *TreeNode) {
    if node == nil {
        return
    }
    // Pre-order: process node here
    dfs(node.Left)
    // In-order: process node here
    dfs(node.Right)
    // Post-order: process node here
}
```

### 3. BFS (Iterative with Queue)
```go
func bfs(root *TreeNode) {
    if root == nil {
        return
    }
    queue := []*TreeNode{root}
    for len(queue) > 0 {
        node := queue[0]
        queue = queue[1:]
        // Process node
        if node.Left != nil {
            queue = append(queue, node.Left)
        }
        if node.Right != nil {
            queue = append(queue, node.Right)
        }
    }
}
```

## Problems in This Module

### 1. Maximum Depth of Binary Tree
**Difficulty**: Easy
[View Problem](01-maximum-depth/README.md)

### 2. Same Tree
**Difficulty**: Easy
[View Problem](02-same-tree/README.md)

### 3. Subtree of Another Tree
**Difficulty**: Easy
[View Problem](03-subtree/README.md)

### 4. Invert Binary Tree
**Difficulty**: Easy
[View Problem](04-invert-tree/README.md)

### 5. Lowest Common Ancestor of a BST
**Difficulty**: Medium
[View Problem](05-lowest-common-ancestor/README.md)

### 6. Binary Tree Level Order Traversal
**Difficulty**: Medium
[View Problem](06-level-order-traversal/README.md)

## Common Mistakes in Go
- **Nil Check**: Always check `node != nil` before accessing `node.Left`, `node.Right`, or `node.Val`.
- **Queue Implementation**: Use slice append/slice for simple queue operations.

## Interview Tips
- **DFS**: Use for depth, path, or recursive structure problems.
- **BFS**: Use for level-order, shortest path, or width problems.
