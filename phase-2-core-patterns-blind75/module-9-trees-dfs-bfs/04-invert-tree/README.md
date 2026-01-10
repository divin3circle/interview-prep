# Invert Binary Tree

**Difficulty**: Easy  
**Pattern**: Tree (DFS / BFS / Recursion)  
**Companies**: Google, Amazon, Facebook, Microsoft, Apple, Uber

## Problem Statement

Given the `root` of a binary tree, invert the tree, and return its root.

## Examples

### Example 1
```
Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]
```

### Example 2
```
Input: root = [2,1,3]
Output: [2,3,1]
```

### Example 3
```
Input: root = []
Output: []
```

## Constraints

- The number of nodes in the tree is in the range `[0, 100]`.
- `-100 <= Node.val <= 100`

## Theoretical Concepts

### Tree Inversion
Inverting a binary tree (often jokingly referred to as the problem that got the creator of Homebrew rejected from Google) involves swapping the left and right children for every node in the tree.

### Recursive Pointer Swap
The simplest way to think about this is:
1. Invert the left subtree.
2. Invert the right subtree.
3. Swap the left child and right child.

### BFS Inversion
Alternatively, we can use a queue to traverse the tree level by level. For each node we visit, we swap its children and add them to the queue.

## Approach

### Recursive DFS (Optimal)
**Time**: O(n), **Space**: O(h)

1. If `root == null`, return `null`.
2. Swap `root.left` and `root.right`.
3. Recursively call `invertTree` on the new `root.left` and `root.right`.
4. Return `root`.

**Why it's optimal**: Every node is touched once, and the work at each node is O(1).

## Solution

See [solution.java](solution.java) for implementation.

## Key Insights

1. **Pre-order swap**: Swapping can happen before or after the recursive calls.
2. **Null safety**: Always handle the base case where a node is null.
3. **In-place modification**: We don't need to create new nodes; we just change pointers.

## Edge Cases

- **Empty tree**.
- **Single node tree**.
- **Tree with only left or only right children**.
- **Full/Perfect binary tree**.

## Related Problems

- Symmetric Tree (LeetCode 101)
- Flip Equivalent Binary Trees (LeetCode 951)
- Reverse Binary Tree (Alternative name)
