# Lowest Common Ancestor of a BST

**Difficulty**: Medium
**Pattern**: BST Property

## Problem Statement

Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

## Approach

### BST Property (Optimal)
Use BST property: left < root < right.
1. If both nodes < root, LCA is in left subtree.
2. If both nodes > root, LCA is in right subtree.
3. Otherwise, root is the LCA (split point).

**Time**: O(H)
**Space**: O(1) iterative, O(H) recursive

## Go Solution

```go
func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
    for root != nil {
        if p.Val < root.Val && q.Val < root.Val {
            root = root.Left
        } else if p.Val > root.Val && q.Val > root.Val {
            root = root.Right
        } else {
            return root
        }
    }
    return nil
}
```
