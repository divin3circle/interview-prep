# Same Tree

**Difficulty**: Easy  
**Pattern**: Tree (DFS / Recursion)  
**Companies**: Google, Amazon, Microsoft, Facebook

## Problem Statement

Given the roots of two binary trees `p` and `q`, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

## Examples

### Example 1
```
Input: p = [1,2,3], q = [1,2,3]
Output: true
```

### Example 2
```
Input: p = [1,2], q = [1,null,2]
Output: false
```

### Example 3
```
Input: p = [1,2,1], q = [1,1,2]
Output: false
```

## Constraints

- The number of nodes in both trees is in the range `[0, 100]`.
- `-10^4 <= Node.val <= 10^4`

## Theoretical Concepts

### Recursive Equality
Two trees are equal if:
1. The root values are equal.
2. The left subtree of `P` is equal to the left subtree of `Q`.
3. The right subtree of `P` is equal to the right subtree of `Q`.

### Base Cases for Tree Comparison
- Both nodes are `null`: The subtrees are equal (return `true`).
- One node is `null`, but the other is not: The trees are structurally different (return `false`).
- Both nodes exist but have different values: The trees are not equal (return `false`).

### Structural and Value Identity
Comparison must account for both the tree's shape (null pointer positions) and the data stored within each node.

## Approach

### Recursive DFS (Optimal)
**Time**: O(min(N, M)), **Space**: O(min(H1, H2))

1. If both `p` and `q` are `null`, return `true`.
2. If only one is `null` OR `p.val != q.val`, return `false`.
3. Recursively check `isSameTree(p.left, q.left)` AND `isSameTree(p.right, q.right)`.

**Why it's optimal**: We perform a simultaneous traversal and exit as soon as a mismatch is found.

## Solution

See [solution.java](solution.java) for implementation.

## Key Insights

1. **Simultaneous Traversal**: We move through both trees in lock-step.
2. **Logical Short-circuiting**: Using the `&&` operator allows the recursion to stop as soon as any part of the trees differ.
3. **Boolean Return**: This pattern is common for "property checking" problems in trees.

## Edge Cases

- **Both trees are empty**.
- **One tree is empty, the other is not**.
- **Structural difference with same values**.
- **Same structure with different values**.
- **Trees of different sizes**.

## Related Problems

- Symmetric Tree (LeetCode 101)
- Subtree of Another Tree (LeetCode 572)
- Flip Equivalent Binary Trees (LeetCode 951)
