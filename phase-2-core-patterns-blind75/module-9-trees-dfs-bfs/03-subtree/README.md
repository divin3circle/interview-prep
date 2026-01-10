# Subtree of Another Tree

**Difficulty**: Easy  
**Pattern**: Tree (Recursive Checking / DFS)  
**Companies**: Google, Amazon, Microsoft, Facebook

## Problem Statement

Given the roots of two binary trees `root` and `subRoot`, return `true` if there is a subtree of `root` with the same structure and node values of `subRoot` and `false` otherwise.

A subtree of a binary tree `tree` is a tree that consists of a node in `tree` and all of this node's descendants. The tree `tree` could also be considered as a subtree of itself.

## Examples

### Example 1
```
Input: root = [3,4,5,1,2], subRoot = [4,1,2]
Output: true
```

### Example 2
```
Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
Output: false
```

## Constraints

- The number of nodes in the `root` tree is in the range `[1, 2000]`.
- The number of nodes in the `subRoot` tree is in the range `[1, 1000]`.
- `-10^4 <= root.val <= 10^4`
- `-10^4 <= subRoot.val <= 10^4`

## Theoretical Concepts

### Recursive Sub-pattern Matching
This problem is a variation of "Same Tree". Instead of checking if the entire trees are identical, we check if `subRoot` matches any node in the `root` tree.

### Two-Level Recursion
1. **Outer Recursion**: Traverses every node in the `root` tree.
2. **Inner Recursion**: At each node, checks if the tree starting there is identical to `subRoot` (using the `isSameTree` logic).

### Pre-order vs Post-order in Subtree Matching
We usually use pre-order traversal for the outer check: we check the current node first, then the left child, then the right child.

## Approach

### DFS with Identity Check (Optimal)
**Time**: O(N * M) where N is nodes in `root` and M is nodes in `subRoot`, **Space**: O(max(H_n, H_m))

1. If `root == null`, it cannot contain a subRoot (return `false`).
2. If `isSameTree(root, subRoot)` is true, return `true`.
3. Otherwise, return `isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)`.

**Note**: `isSameTree` is exactly the same helper used in the "Same Tree" problem.

**Why it's used**: It's the most straightforward and common solution for this problem. While O(N+M) solutions using Tree Serialization or KMP-like algorithms exist, they are significantly more complex.

## Solution

See [solution.java](solution.java) for implementation.

## Key Insights

1. **Subtree vs Sub-structure**: A subtree must include **all** descendants of the chosen node.
2. **Logical OR**: We only need to find **one** match in the root tree.
3. **Reuse of code**: This problem highlights the importance of mastering the "Same Tree" pattern.

## Edge Cases

- **subRoot is larger than root** (implicitly handled by `isSameTree`).
- **Matching node is a leaf**.
- **Matching node is the root itself**.
- **Multiple nodes in root have the same value as subRoot's root**.
- **subRoot matches a structure but has a dangling extra node below it in the root**.

## Related Problems

- Same Tree (LeetCode 100)
- Symmetric Tree (LeetCode 101)
- Binary Tree Preorder Traversal (LeetCode 144)
