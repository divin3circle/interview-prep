# Kth Smallest Element in a BST

**Difficulty**: Medium
**Pattern**: BST (In-Order Traversal)

## Problem Statement

Given the `root` of a binary search tree, and an integer `k`, return the `kth` smallest value (1-indexed) of all the values of the nodes in the tree.

## Approach

### In-Order Traversal (Optimal)
In-order traversal of BST gives sorted order.
1. Traverse left subtree.
2. Process current node (increment counter).
3. If counter == k, we found the answer.
4. Traverse right subtree.

**Time**: O(H + k) where H is height
**Space**: O(H)

## Go Solution

```go
func kthSmallest(root *TreeNode, k int) int {
    count := 0
    var result int
    
    var inorder func(*TreeNode)
    inorder = func(node *TreeNode) {
        if node == nil || count >= k {
            return
        }
        inorder(node.Left)
        count++
        if count == k {
            result = node.Val
            return
        }
        inorder(node.Right)
    }
    
    inorder(root)
    return result
}
```
