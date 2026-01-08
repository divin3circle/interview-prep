# Module 9: Trees (DFS & BFS)

## Pattern Overview

Tree problems usually involve traversing the tree to find properties or modify it.

## Core Techniques

### Depth-First Search (DFS)
Traverse deep into the tree before backtracking.
- **Pre-order**: Root -> Left -> Right
- **In-order**: Left -> Root -> Right (Sorted for BST)
- **Post-order**: Left -> Right -> Root

```java
public int dfs(TreeNode root) {
    if (root == null) return 0;
    // Process root
    int left = dfs(root.left);
    int right = dfs(root.right);
    return Math.max(left, right) + 1;
}
```

### Breadth-First Search (BFS)
Traverse level by level using a Queue.
```java
public void bfs(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
        TreeNode node = queue.poll();
        // Process node
        if (node.left != null) queue.offer(node.left);
        if (node.right != null) queue.offer(node.right);
    }
}
```

## Problems
1. Maximum Depth of Binary Tree
2. Same Tree
3. Subtree of Another Tree
4. Invert Binary Tree
5. Lowest Common Ancestor of a BST
6. Binary Tree Level Order Traversal

**Key Takeaway**: DFS for path/depth problems, BFS for level/shortest path problems.
