package main

import "fmt"

type Graph struct {
	// AdjList: Node -> Neighbors
	AdjList map[int][]int
}

func NewGraph() *Graph {
	return &Graph{
		AdjList: make(map[int][]int),
	}
}

func (g *Graph) AddEdge(src, dest int, bidirectional bool) {
	g.AdjList[src] = append(g.AdjList[src], dest)
	
	// Ensure dest exists in map even if no outgoing edges
	if _, exists := g.AdjList[dest]; !exists {
		g.AdjList[dest] = []int{}
	}
	
	if bidirectional {
		g.AdjList[dest] = append(g.AdjList[dest], src)
	}
}

func (g *Graph) DFS(start int) {
	fmt.Print("DFS: ")
	visited := make(map[int]bool)
	g.dfsHelper(start, visited)
	fmt.Println()
}

func (g *Graph) dfsHelper(curr int, visited map[int]bool) {
	visited[curr] = true
	fmt.Printf("%d ", curr)
	
	for _, neighbor := range g.AdjList[curr] {
		if !visited[neighbor] {
			g.dfsHelper(neighbor, visited)
		}
	}
}

func (g *Graph) BFS(start int) {
	fmt.Print("BFS: ")
	visited := make(map[int]bool)
	queue := []int{start}
	visited[start] = true
	
	for len(queue) > 0 {
		curr := queue[0]
		queue = queue[1:] // Dequeue
		
		fmt.Printf("%d ", curr)
		
		for _, neighbor := range g.AdjList[curr] {
			if !visited[neighbor] {
				visited[neighbor] = true
				queue = append(queue, neighbor)
			}
		}
	}
	fmt.Println()
}

func main() {
	g := NewGraph()
	// 0 - 1
	// |   |
	// 2 - 3
	g.AddEdge(0, 1, true)
	g.AddEdge(0, 2, true)
	g.AddEdge(1, 3, true)
	g.AddEdge(2, 3, true)
	
	fmt.Println("--- Graph Traversals (Start 0) ---")
	g.DFS(0)
	g.BFS(0)
}
