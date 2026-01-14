# Validate Binary Search Tree

**Difficulty**: Medium
**Pattern**: BST (Range Validation)

## Problem Statement

Given the `root` of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:
- The left subtree of a node contains only nodes with keys less than the node's key.
- The right subtree of a node contains only nodes with keys greater than the node's key.
- Both the left and right subtrees must also be binary search trees.

## Approach

### Range Validation (Optimal)
Track valid range `(min, max)` for each node.
1. Root can be any value: `(-∞, +∞)`.
2. Left child must be in `(min, node.Val)`.
3. Right child must be in `(node.Val, max)`.

**Time**: O(N)
**Space**: O(H)

## Go Solution

```go
func isValidBST(root *TreeNode) bool {
    return validate(root, math.MinInt64, math.MaxInt64)
}

func validate(node *TreeNode, min, max int) bool {
    if node == nil {
        return true
    }
    if node.Val <= min || node.Val >= max {
        return false
    }
    return validate(node.Left, min, node.Val) && validate(node.Right, node.Val, max)
}
```
