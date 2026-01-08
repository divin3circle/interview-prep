# Trees

## Overview
A Tree is a hierarchical structure consisting of nodes. The top node is the **Root**. Each node has zero or more children.

## Key Terminology
- **Leaf**: Node with no children.
- **Height**: Number of edges from root to deepest leaf.
- **Depth**: Number of edges from root to specific node.

## Types
1. **Binary Tree**: Each node has at most 2 children (Left, Right).
2. **Binary Search Tree (BST)**: Left < Root < Right for all nodes.
3. **Balanced Tree**: Height is O(log n) (e.g., AVL, Red-Black).
4. **Trie (Prefix Tree)**: Used for string searches.

## Traversals (Crucial)
1. **In-Order**: Left -> Root -> Right (Sorted in BST).
2. **Pre-Order**: Root -> Left -> Right (Cloning, Prefix notation).
3. **Post-Order**: Left -> Right -> Root (Delete, Postfix notation).
4. **Level-Order (BFS)**: Level by level using Queue.

## Complexity
- Access/Search/Insert/Delete: **O(h)**, where h is height.
- Balanced: h = log n.
- Unbalanced (Skewed): h = n.

## Implementation
```java
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
```
