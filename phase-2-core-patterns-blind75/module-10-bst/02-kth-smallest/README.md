# Kth Smallest Element in a BST

**Difficulty**: Medium  
**Pattern**: BST Properties / In-order Traversal  
**Companies**: Google, Amazon, Microsoft, Facebook, Apple, Bloomberg

## Problem Statement

Given the `root` of a binary search tree, and an integer `k`, return the `k`th smallest value (1-indexed) of all the values of the nodes in the tree.

## Examples

### Example 1
```
Input: root = [3,1,4,null,2], k = 1
Output: 1
```

### Example 2
```
Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3
```

## Constraints

- The number of nodes in the tree is `n`.
- `1 <= k <= n <= 10^4`
- `0 <= Node.val <= 10^4`

## Theoretical Concepts

### BST In-order Traversal
In a Binary Search Tree, an in-order traversal visits nodes in the following order: Left, Root, Right.
- **Crucial Property**: In-order traversal of a BST visits nodes in non-decreasing (sorted) order.
- To find the **k-th smallest** element, we simply need the k-th node visited during an in-order traversal.

### Iterative In-order Traversal
Using a stack to simulate recursion allows us to implement in-order traversal iteratively. 
- The advantage of the iterative approach is **early termination**: we can stop as soon as we've visited `k` nodes, rather than traversing the entire tree.

### Follow-up: Frequent Modifications
If the BST is modified often and you need to find the k-th smallest element frequently, you can optimize the search to O(height) by:
1. Adding a `subtreeSize` field to each node.
2. Using the size information to decide whether to go left, right, or stay at the current node (similar to Quickselect).

## Approach

### Iterative In-order Traversal (Optimal)
**Time**: O(h + k) where h is tree height, **Space**: O(h)

1. Use a stack to traverse the tree in-order.
2. Push all left nodes onto the stack until a null is reached.
3. Pop a node, decrement `k`.
4. If `k == 0`, we've found our element; return its value.
5. Move to the right child and repeat.

**Why it's optimal**: We only visit the minimal number of nodes required to reach the k-th element.

## Solution

See [solution.java](solution.java) for implementation.

## Key Insights

1. **BST = Sorted Array (conceptually)**: Thinking of the tree as a sorted sequence makes the solution intuitive.
2. **Early exit**: Don't traverse the whole tree if `k` is small.
3. **Space complexity**: The stack stores nodes along one path, which is at most `h` nodes.

## Edge Cases

- **k is 1** (the absolute minimum).
- **k is equal to n** (the absolute maximum).
- **Skewed tree** (all nodes in one branch).
- **Single node tree**.

## Related Problems

- Kth Largest Element in a Stream (LeetCode 703)
- Validate Binary Search Tree (LeetCode 98)
- Binary Search Tree Iterator (LeetCode 173)
