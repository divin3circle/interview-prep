package main

import "fmt"

type Node struct {
	Val       int
	Neighbors []*Node
}

func cloneGraph(node *Node) *Node {
	if node == nil {
		return nil
	}
	cloned := make(map[*Node]*Node)
	var dfs func(*Node) *Node
	dfs = func(n *Node) *Node {
		if clone, exists := cloned[n]; exists {
			return clone
		}
		clone := &Node{Val: n.Val}
		cloned[n] = clone
		for _, neighbor := range n.Neighbors {
			clone.Neighbors = append(clone.Neighbors, dfs(neighbor))
		}
		return clone
	}
	return dfs(node)
}

func main() {
	node1 := &Node{Val: 1}
	node2 := &Node{Val: 2}
	node3 := &Node{Val: 3}
	node4 := &Node{Val: 4}
	
	node1.Neighbors = []*Node{node2, node4}
	node2.Neighbors = []*Node{node1, node3}
	node3.Neighbors = []*Node{node2, node4}
	node4.Neighbors = []*Node{node1, node3}
	
	cloned := cloneGraph(node1)
	fmt.Printf("Original node val: %d, Cloned node val: %d\n", node1.Val, cloned.Val)
	fmt.Printf("Different memory addresses: %v\n", node1 != cloned)
}
