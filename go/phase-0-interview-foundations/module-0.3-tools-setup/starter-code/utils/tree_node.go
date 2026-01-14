package utils

// TreeNode definition for a binary tree node.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

// NewTreeNode creates a new node with the given value.
func NewTreeNode(val int) *TreeNode {
	return &TreeNode{Val: val}
}
