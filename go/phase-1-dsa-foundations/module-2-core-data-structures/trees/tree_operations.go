package main

import "fmt"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

// DFS: Pre-Order (Root -> Left -> Right)
func PreOrder(node *TreeNode) {
	if node == nil {
		return
	}
	fmt.Printf("%d ", node.Val)
	PreOrder(node.Left)
	PreOrder(node.Right)
}

// DFS: In-Order (Left -> Root -> Right)
func InOrder(node *TreeNode) {
	if node == nil {
		return
	}
	InOrder(node.Left)
	fmt.Printf("%d ", node.Val)
	InOrder(node.Right)
}

// DFS: Post-Order (Left -> Right -> Root)
func PostOrder(node *TreeNode) {
	if node == nil {
		return
	}
	PostOrder(node.Left)
	PostOrder(node.Right)
	fmt.Printf("%d ", node.Val)
}

// BFS: Level Order
func LevelOrder(root *TreeNode) {
	if root == nil {
		return
	}
	
	queue := []*TreeNode{root}
	
	for len(queue) > 0 {
		curr := queue[0]
		queue = queue[1:] // Dequeue
		
		fmt.Printf("%d ", curr.Val)
		
		if curr.Left != nil {
			queue = append(queue, curr.Left)
		}
		if curr.Right != nil {
			queue = append(queue, curr.Right)
		}
	}
}

func main() {
	fmt.Println("--- Tree Operations ---")
	
	// Create Tree
	//      1
	//     / \
	//    2   3
	//   / \
	//  4   5
	root := &TreeNode{Val: 1}
	root.Left = &TreeNode{Val: 2}
	root.Right = &TreeNode{Val: 3}
	root.Left.Left = &TreeNode{Val: 4}
	root.Left.Right = &TreeNode{Val: 5}
	
	fmt.Print("Pre-Order:  ")
	PreOrder(root)
	fmt.Println()
	
	fmt.Print("In-Order:   ")
	InOrder(root)
	fmt.Println()
	
	fmt.Print("Post-Order: ")
	PostOrder(root)
	fmt.Println()
	
	fmt.Print("Level-Order:")
	LevelOrder(root)
	fmt.Println()
}
