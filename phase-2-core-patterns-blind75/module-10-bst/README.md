# Module 10: Binary Search Trees

## Pattern Overview

Binary Search Trees (BST) have a specific property: for every node, all nodes in the left subtree are smaller, and all nodes in the right subtree are larger. This allows O(log n) lookup, insertion, and deletion.

## Core Techniques

### In-order Traversal
In-order traversal of a BST yields elements in sorted order.
```java
void inorder(TreeNode root) {
    if (root == null) return;
    inorder(root.left);
    print(root.val); // Process
    inorder(root.right);
}
```

### Validate BST
Need to track valid ranges (min, max) for every node.
```java
boolean isValid(TreeNode node, long min, long max) {
    if (node == null) return true;
    if (node.val <= min || node.val >= max) return false;
    return isValid(node.left, min, node.val) && isValid(node.right, node.val, max);
}
```

## Problems
1. Validate Binary Search Tree
2. Kth Smallest Element in a BST

**Key Takeaway**: Leverage the sorted property (Left < Root < Right) for efficient searching.
