package main

import "fmt"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func kthSmallest(root *TreeNode, k int) int {
	count := 0
	var result int
	
	var inorder func(*TreeNode)
	inorder = func(node *TreeNode) {
		if node == nil || count >= k {
			return
		}
		inorder(node.Left)
		count++
		if count == k {
			result = node.Val
			return
		}
		inorder(node.Right)
	}
	
	inorder(root)
	return result
}

func main() {
	root := &TreeNode{Val: 3}
	root.Left = &TreeNode{Val: 1}
	root.Right = &TreeNode{Val: 4}
	root.Left.Right = &TreeNode{Val: 2}
	
	fmt.Printf("1st smallest: %d (Expected: 1)\n", kthSmallest(root, 1))
	fmt.Printf("2nd smallest: %d (Expected: 2)\n", kthSmallest(root, 2))
	fmt.Printf("3rd smallest: %d (Expected: 3)\n", kthSmallest(root, 3))
}
