# Module 9: Trees (DFS & BFS)

## Pattern Overview

Tree problems usually involve traversing the tree to find properties or modify it.

## Core Techniques

### Depth-First Search (DFS)
Traverse deep into the tree before backtracking. This is typically implemented recursively using the call stack.
- **Pre-order**: Root -> Left -> Right (Useful for cloning, prefix expressions)
- **In-order**: Left -> Root -> Right (Yields sorted order in a BST)
- **Post-order**: Left -> Right -> Root (Useful for bottom-up calculations like tree height)

### Breadth-First Search (BFS)
Traverse level by level using a **Queue** (FIFO). This is used for problems involving the width of a tree, shortest path in unweighted graphs, or level-order traversal.

**Time**: O(n), **Space**: O(w) where w is max width.

## Problems
1. Maximum Depth of Binary Tree
2. Same Tree
3. Subtree of Another Tree
4. Invert Binary Tree
5. Lowest Common Ancestor of a BST
6. Binary Tree Level Order Traversal

**Key Takeaway**: DFS for path/depth problems, BFS for level/shortest path problems.
