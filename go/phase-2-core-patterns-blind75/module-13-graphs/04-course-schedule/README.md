# Course Schedule

**Difficulty**: Medium
**Pattern**: Cycle Detection (DFS)

## Problem Statement

There are a total of `numCourses` courses you have to take, labeled from `0` to `numCourses - 1`. You are given an array `prerequisites` where `prerequisites[i] = [ai, bi]` indicates that you must take course `bi` first if you want to take course `ai`. Return `true` if you can finish all courses.

## Approach

### Cycle Detection with DFS
Use 3 states: unvisited (0), visiting (1), visited (2).
If we encounter a visiting node, there's a cycle.

**Time**: O(V + E)
**Space**: O(V + E)

## Go Solution

```go
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
```
