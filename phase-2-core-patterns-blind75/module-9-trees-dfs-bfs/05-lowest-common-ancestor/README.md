# Lowest Common Ancestor of a Binary Search Tree

**Difficulty**: Easy  
**Pattern**: BST Properties / Tree Traversal  
**Companies**: Google, Amazon, Facebook, Microsoft, Apple, LinkedIn

## Problem Statement

Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes `p` and `q` as the lowest node in `T` that has both `p` and `q` as descendants (where we allow a node to be a descendant of itself).”

## Examples

### Example 1
```
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.
```

### Example 2
```
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
```

### Example 3
```
Input: root = [2,1], p = 2, q = 1
Output: 2
```

## Constraints

- The number of nodes in the tree is in the range `[2, 10^5]`.
- `-10^9 <= Node.val <= 10^9`
- All `Node.val` are unique.
- `p` and `q` will exist in the BST.
- `p != q`

## Theoretical Concepts

### Binary Search Tree (BST) Property
In a BST:
- All nodes in a node's **left** subtree have values **less** than the node's value.
- All nodes in a node's **right** subtree have values **greater** than the node's value.

### LCA in a BST
Because a BST is ordered, the LCA of two nodes `p` and `q` is the first node (starting from the root) whose value lies **between** `p.val` and `q.val` (inclusive).
- If `p` and `q` are both smaller than `root`, the LCA must be in the left subtree.
- If `p` and `q` are both larger than `root`, the LCA must be in the right subtree.
- If one is larger and one is smaller (or one equals the root), the current `root` **is** the LCA.

### Comparison with Binary Tree LCA
In a general Binary Tree (non-BST), we would need to search both subtrees and backtrack, which is O(n). In a BST, we can simply "follow the path" in O(h) time.

## Approach

### Iterative BST Traversal (Optimal)
**Time**: O(h) where h is tree height, **Space**: O(1)

1. Start at the `root`.
2. If `p.val` and `q.val` are both smaller than `curr.val`, move to `curr.left`.
3. If `p.val` and `q.val` are both larger than `curr.val`, move to `curr.right`.
4. Otherwise (the "split" point), `curr` is the LCA.

**Why it's optimal**: We only visit nodes on a single path from the root to the LCA.

## Solution

See [solution.java](solution.java) for implementation.

## Key Insights

1. **BST ordering is the key**: We don't need to visit most nodes in the tree.
2. **Inclusive Range**: If `root.val == p.val`, `root` is the LCA.
3. **No backtracking needed**: We only move deeper into the tree.

## Edge Cases

- **One node is an ancestor of the other**.
- **Nodes are in different subtrees**.
- **Nodes are leaf nodes**.
- **Large tree height** (Iterative approach avoids StackOverflow).

## Related Problems

- Lowest Common Ancestor of a Binary Tree (LeetCode 236) - the general version.
- Smallest Common Region (LeetCode 1257)
- Path Sum (LeetCode 112)
