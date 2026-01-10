# Module 10: Binary Search Trees

## Pattern Overview

Binary Search Trees (BST) have a specific property: for every node, all nodes in the left subtree are smaller, and all nodes in the right subtree are larger. This allows O(log n) lookup, insertion, and deletion.

## Core Techniques

### In-order Traversal
In-order traversal (Left -> Root -> Right) of a BST yields elements in strictly increasing order. This property is used for validation and finding specific elements in sorted order.

### Validate BST
To validate a BST, ensure that every node falls within a specific range `(min, max)`. The range is refined as you move down the tree: the current node's value becomes the `max` for the left subtree and the `min` for the right subtree.

## Problems
1. Validate Binary Search Tree
2. Kth Smallest Element in a BST

**Key Takeaway**: Leverage the sorted property (Left < Root < Right) for efficient searching.
