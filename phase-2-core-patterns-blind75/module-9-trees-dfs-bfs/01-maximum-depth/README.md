# Maximum Depth of Binary Tree

**Difficulty**: Easy  
**Pattern**: Tree (DFS / Recursion)  
**Companies**: Google, Amazon, Facebook, Microsoft, Apple, LinkedIn

## Problem Statement

Given the `root` of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

## Examples

### Example 1
```
Input: root = [3,9,20,null,null,15,7]
Output: 3
```

### Example 2
```
Input: root = [1,null,2]
Output: 2
```

## Constraints

- The number of nodes in the tree is in the range `[0, 10^4]`.
- `-100 <= Node.val <= 100`

## Theoretical Concepts

### Depth vs Height
- **Depth of a Node**: Number of edges from the root to that node.
- **Height of a Node**: Number of edges from that node to the deepest leaf in its subtree.
- **Max Depth of Tree**: Equal to the height of the root node.

### Depth-First Search (DFS)
DFS is the most common way to find the depth of a tree. It explores a branch as deeply as possible before backtracking.
- **Recursive DFS**: Naturally uses the call stack. The depth of a node is `1 + max(depth of left, depth of right)`.
- **Iterative DFS**: Uses a stack to keep track of nodes and their current depths.

### Breadth-First Search (BFS)
BFS explores the tree level by level using a queue. The number of levels explored equals the maximum depth.

## Approach

### Recursive DFS (Optimal)
**Time**: O(n), **Space**: O(h) where h is the height of the tree.

1. If `root == null`, return 0.
2. Recursively find the height of left and right subtrees.
3. Return `1 + Math.max(leftHeight, rightHeight)`.

**Why it's optimal**: We visit each node exactly once.

## Solution

See [solution.java](solution.java) for implementation.

## Key Insights

1. **Recursive Definition**: The height of a tree is 1 (the current node) plus the height of its taller child.
2. **Post-order traversal**: We calculate the height of children before calculating the height of the parent.
3. **Space complexity**: In the worst case (skewed tree), the space is O(n). In a balanced tree, it is O(log n).

## Edge Cases

- **Empty tree** (`root == null`).
- **Single node tree**.
- **Skewed tree** (all nodes only have left or only have right children).
- **Perfectly balanced tree**.

## Related Problems

- Minimum Depth of Binary Tree (LeetCode 111)
- Balanced Binary Tree (LeetCode 110)
- Diameter of Binary Tree (LeetCode 543)
