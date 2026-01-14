package main

import "fmt"

func canFinish(numCourses int, prerequisites [][]int) bool {
	graph := make([][]int, numCourses)
	for _, pre := range prerequisites {
		graph[pre[1]] = append(graph[pre[1]], pre[0])
	}
	
	visit := make([]int, numCourses)
	var hasCycle func(int) bool
	hasCycle = func(course int) bool {
		if visit[course] == 1 {
			return true
		}
		if visit[course] == 2 {
			return false
		}
		visit[course] = 1
		for _, next := range graph[course] {
			if hasCycle(next) {
				return true
			}
		}
		visit[course] = 2
		return false
	}
	
	for i := 0; i < numCourses; i++ {
		if visit[i] == 0 && hasCycle(i) {
			return false
		}
	}
	return true
}

func main() {
	fmt.Printf("Can finish [[1,0]]: %v (Expected: true)\n", canFinish(2, [][]int{{1, 0}}))
	fmt.Printf("Can finish [[1,0],[0,1]]: %v (Expected: false)\n", canFinish(2, [][]int{{1, 0}, {0, 1}}))
}
