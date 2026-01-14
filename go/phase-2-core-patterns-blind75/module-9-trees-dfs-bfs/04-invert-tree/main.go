package main

import "fmt"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func invertTree(root *TreeNode) *TreeNode {
	if root == nil {
		return nil
	}
	// Swap and recursively invert
	root.Left, root.Right = invertTree(root.Right), invertTree(root.Left)
	return root
}

func printInOrder(root *TreeNode) {
	if root == nil {
		return
	}
	printInOrder(root.Left)
	fmt.Printf("%d ", root.Val)
	printInOrder(root.Right)
}

func main() {
	root := &TreeNode{Val: 4}
	root.Left = &TreeNode{Val: 2}
	root.Right = &TreeNode{Val: 7}
	root.Left.Left = &TreeNode{Val: 1}
	root.Left.Right = &TreeNode{Val: 3}
	root.Right.Left = &TreeNode{Val: 6}
	root.Right.Right = &TreeNode{Val: 9}
	
	fmt.Print("Original (In-order): ")
	printInOrder(root)
	fmt.Println()
	
	invertTree(root)
	
	fmt.Print("Inverted (In-order): ")
	printInOrder(root)
	fmt.Println()
}
