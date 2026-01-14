# Module 10: Binary Search Trees

## Pattern Overview

Binary Search Trees (BST) have the property: for every node, left subtree values < node value < right subtree values. This enables O(log n) operations.

## Core Techniques (Go Style)

### 1. In-Order Traversal
In-order traversal of a BST yields sorted values.
```go
func inorder(node *TreeNode, result *[]int) {
    if node == nil {
        return
    }
    inorder(node.Left, result)
    *result = append(*result, node.Val)
    inorder(node.Right, result)
}
```

### 2. Range Validation
Validate BST by ensuring each node is within valid range `(min, max)`.

## Problems in This Module

### 1. Validate Binary Search Tree
**Difficulty**: Medium
[View Problem](01-validate-bst/README.md)

### 2. Kth Smallest Element in a BST
**Difficulty**: Medium
[View Problem](02-kth-smallest/README.md)

## Key Takeaway
Leverage the sorted property (Left < Root < Right) for efficient operations.
