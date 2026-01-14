# Trees

## Binary Trees
Basic node structure:
```go
type TreeNode struct {
    Val   int
    Left  *TreeNode
    Right *TreeNode
}
```

## Traversals
- **DFS**: Recursive is easiest.
- **BFS**: Use a slice as a queue.

## Balanced Trees
Go doesn't expose Red-Black trees directly in stdlib (except internally in timers/scheduler). 
For interviews, use `map` or standard BST logic if you need to implement one (rare).
