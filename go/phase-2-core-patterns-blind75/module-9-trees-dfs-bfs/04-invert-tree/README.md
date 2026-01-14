# Invert Binary Tree

**Difficulty**: Easy
**Pattern**: DFS (Recursive)

## Problem Statement

Given the `root` of a binary tree, invert the tree, and return its root.

## Approach

### DFS Recursive (Optimal)
1. If nil, return nil.
2. Swap left and right children.
3. Recursively invert left and right subtrees.

**Time**: O(N)
**Space**: O(H)

## Go Solution

```go
func invertTree(root *TreeNode) *TreeNode {
    if root == nil {
        return nil
    }
    root.Left, root.Right = invertTree(root.Right), invertTree(root.Left)
    return root
}
```

### Key Go Insights
- **Tuple Assignment**: `a, b = b, a` swaps values elegantly.
