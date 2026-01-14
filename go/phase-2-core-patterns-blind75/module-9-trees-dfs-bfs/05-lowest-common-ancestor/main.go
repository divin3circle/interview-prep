package main

import "fmt"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	for root != nil {
		if p.Val < root.Val && q.Val < root.Val {
			root = root.Left
		} else if p.Val > root.Val && q.Val > root.Val {
			root = root.Right
		} else {
			return root
		}
	}
	return nil
}

func main() {
	root := &TreeNode{Val: 6}
	root.Left = &TreeNode{Val: 2}
	root.Right = &TreeNode{Val: 8}
	root.Left.Left = &TreeNode{Val: 0}
	root.Left.Right = &TreeNode{Val: 4}
	root.Right.Left = &TreeNode{Val: 7}
	root.Right.Right = &TreeNode{Val: 9}
	root.Left.Right.Left = &TreeNode{Val: 3}
	root.Left.Right.Right = &TreeNode{Val: 5}
	
	p := root.Left       // 2
	q := root.Right      // 8
	lca := lowestCommonAncestor(root, p, q)
	fmt.Printf("LCA of %d and %d: %d (Expected: 6)\n", p.Val, q.Val, lca.Val)
	
	p = root.Left              // 2
	q = root.Left.Right        // 4
	lca = lowestCommonAncestor(root, p, q)
	fmt.Printf("LCA of %d and %d: %d (Expected: 2)\n", p.Val, q.Val, lca.Val)
}
