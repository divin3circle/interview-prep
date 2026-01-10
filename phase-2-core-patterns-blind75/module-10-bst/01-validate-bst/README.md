# Validate Binary Search Tree

**Difficulty**: Medium  
**Pattern**: BST Properties / DFS (Recursion)  
**Companies**: Google, Amazon, Microsoft, Facebook, Apple, Bloomberg, Uber

## Problem Statement

Given the `root` of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:
- The left subtree of a node contains only nodes with keys **less than** the node's key.
- The right subtree of a node contains only nodes with keys **greater than** the node's key.
- Both the left and right subtrees must also be binary search trees.

## Examples

### Example 1
```
Input: root = [2,1,3]
Output: true
```

### Example 2
```
Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
```

## Constraints

- The number of nodes in the tree is in the range `[1, 10^4]`.
- `-2^31 <= Node.val <= 2^31 - 1`

## Theoretical Concepts

### Local vs Global Constraints
A common mistake is checking only if `left.val < current.val < right.val`. This is insufficient.
- All nodes in the total left subtree must be less than the root.
- All nodes in the total right subtree must be greater than the root.
To enforce this, we must pass down a range `(min, max)` within which each node's value must fall.

### In-order Traversal Property
An essential property of a valid BST is that its **in-order traversal** produces values in **strictly increasing** order.
- This provides an alternative validation method: Perform in-order traversal and verify that each node is larger than the previous one.

### Handling Integer Overflow
Since node values can be `Integer.MIN_VALUE` or `Integer.MAX_VALUE`, we should use `Long.MIN_VALUE` and `Long.MAX_VALUE` for the initial boundaries to avoid edge case failures.

## Approach

### DFS with Range Constraints (Optimal)
**Time**: O(n), **Space**: O(h)

1. Use a helper function `validate(node, min, max)`.
2. For the root, range is `(Long.MIN_VALUE, Long.MAX_VALUE)`.
3. For each node:
   - If `node == null`, return `true`.
   - If `node.val <= min` OR `node.val >= max`, return `false`.
   - Recurse left: `validate(node.left, min, node.val)`.
   - Recurse right: `validate(node.right, node.val, max)`.
4. Result is `leftValid && rightValid`.

**Why it's optimal**: We visit each node once and perform constant-time checks.

## Solution

See [solution.java](solution.java) for implementation.

## Key Insights

1. **Top-down constraint passing**: The parent tells the children what their "window" of validity is.
2. **Strict inequality**: BST rules typically specify "less than" and "greater than", meaning duplicates are usually not allowed.
3. **Integer limits**: Be careful with boundary checks when values can reach `2^31 - 1`.

## Edge Cases

- **Single node tree**.
- **Tree with values at integer limits**.
- **Tree that satisfies local but not global BST properties**.
- **Duplicates in the tree** (should return `false`).

## Related Problems

- Insert into a Binary Search Tree (LeetCode 701)
- Delete Node in a BST (LeetCode 450)
- Convert Sorted Array to Binary Search Tree (LeetCode 108)
