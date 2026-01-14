# Maximum Depth of Binary Tree

**Difficulty**: Easy
**Pattern**: DFS (Recursive)

## Problem Statement

Given the `root` of a binary tree, return its maximum depth. A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

## Approach

### DFS Recursive (Optimal)
Recursively find the max depth of left and right subtrees, then return `max(left, right) + 1`.

**Time**: O(N)
**Space**: O(H) where H is height (call stack)

## Go Solution

```go
func maxDepth(root *TreeNode) int {
    if root == nil {
        return 0
    }
    return max(maxDepth(root.Left), maxDepth(root.Right)) + 1
}

func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}
```
