# Binary Tree Level Order Traversal

**Difficulty**: Medium
**Pattern**: BFS (Queue)

## Problem Statement

Given the `root` of a binary tree, return the level order traversal of its nodes' values (i.e., from left to right, level by level).

## Approach

### BFS with Queue (Optimal)
1. Use a queue to process nodes level by level.
2. For each level, process all nodes at that level.
3. Add children to queue for next level.

**Time**: O(N)
**Space**: O(W) where W is max width

## Go Solution

```go
func levelOrder(root *TreeNode) [][]int {
    result := [][]int{}
    if root == nil {
        return result
    }
    
    queue := []*TreeNode{root}
    
    for len(queue) > 0 {
        levelSize := len(queue)
        currentLevel := []int{}
        
        for i := 0; i < levelSize; i++ {
            node := queue[0]
            queue = queue[1:]
            currentLevel = append(currentLevel, node.Val)
            
            if node.Left != nil {
                queue = append(queue, node.Left)
            }
            if node.Right != nil {
                queue = append(queue, node.Right)
            }
        }
        result = append(result, currentLevel)
    }
    return result
}
```
