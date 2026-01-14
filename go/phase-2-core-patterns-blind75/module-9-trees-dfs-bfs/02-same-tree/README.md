# Same Tree

**Difficulty**: Easy
**Pattern**: DFS (Recursive)

## Problem Statement

Given the roots of two binary trees `p` and `q`, write a function to check if they are the same or not. Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

## Approach

### DFS Recursive (Optimal)
1. If both nil, return true.
2. If one nil, return false.
3. If values differ, return false.
4. Recursively check left and right subtrees.

**Time**: O(N)
**Space**: O(H)

## Go Solution

```go
func isSameTree(p *TreeNode, q *TreeNode) bool {
    if p == nil && q == nil {
        return true
    }
    if p == nil || q == nil {
        return false
    }
    if p.Val != q.Val {
        return false
    }
    return isSameTree(p.Left, q.Left) && isSameTree(p.Right, q.Right)
}
```
