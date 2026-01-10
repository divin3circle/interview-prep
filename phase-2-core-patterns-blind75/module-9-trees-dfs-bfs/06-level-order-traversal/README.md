# Binary Tree Level Order Traversal

**Difficulty**: Medium  
**Pattern**: Tree (BFS / Queue)  
**Companies**: Google, Amazon, Microsoft, Facebook, Apple, Bloomberg, Uber

## Problem Statement

Given the `root` of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

## Examples

### Example 1
```
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
```

### Example 2
```
Input: root = [1]
Output: [[1]]
```

### Example 3
```
Input: root = []
Output: []
```

## Constraints

- The number of nodes in the tree is in the range `[0, 2000]`.
- `-1000 <= Node.val <= 1000`

## Theoretical Concepts

### Breadth-First Search (BFS)
BFS explores a tree level by level. It uses a **Queue** (First-In-First-Out) to store nodes that need to be visited.

### Level Isolation
In a standard BFS, you visit all nodes in order. To produce the output as a `List<List<Integer>>`, you must isolate each level:
1. Before processing a level, record the current size of the queue (`levelSize`).
2. Process exactly `levelSize` nodes. These are all nodes at the current depth.
3. Any children added to the queue during this process belong to the *next* level.

### Iterative vs Recursive BFS
While BFS is almost always implemented iteratively with a queue, it can be simulated with recursion (DFS) by passing the current depth as an argument and adding the node value to the list corresponding to that depth.

## Approach

### Iterative BFS with Queue (Optimal)
**Time**: O(n), **Space**: O(w) where w is the maximum width of the tree.

1. If `root == null`, return an empty list.
2. Create a `queue` and add `root`.
3. While `queue` is not empty:
   - Determine `levelSize`.
   - Create a `currentLevel` list.
   - For `i` from 0 to `levelSize - 1`:
     - Pop `node` from `queue`.
     - Add `node.val` to `currentLevel`.
     - Add non-null children to `queue`.
   - Add `currentLevel` to the final result.

**Why it's optimal**: Every node is visited and queued exactly once.

## Solution

See [solution.java](solution.java) for implementation.

## Key Insights

1. **Queue size snapshot**: Capturing the size before the loop is critical for level separation.
2. **Left-to-right**: Adding the `left` child before the `right` child ensures the required order.
3. **Space complexity**: In a perfect binary tree, the last level contains `n/2` nodes, so `w = O(n)`.

## Edge Cases

- **Empty tree**.
- **Single node tree**.
- **Skewed tree** (BFS still works fine, width is 1).
- **Tree with missing children**.

## Related Problems

- Binary Tree Level Order Traversal II (LeetCode 107) - bottom-up.
- Binary Tree Zigzag Level Order Traversal (LeetCode 103)
- Binary Tree Right Side View (LeetCode 199)
- Populating Next Right Pointers in Each Node (LeetCode 116)
