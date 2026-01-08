# Course Schedule

**Difficulty**: Medium  
**Pattern**: Graphs (Topological Sort / Cycle Detection)

## Problem Statement
There are a total of `numCourses` courses you have to take, labeled from `0` to `numCourses - 1`. You are given an array `prerequisites` where `prerequisites[i] = [ai, bi]` indicates that you must take course `bi` first if you want to take course `ai`.

* For example, the pair `[0, 1]`, indicates that to take course `0` you have to first take course `1`.

Return `true` if you can finish all courses. Otherwise, return `false`.

## Examples

### Example 1
```
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: To take course 1 you should have finished course 0. So it is possible.
```

### Example 2
```
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: Cycle detected (0->1->0). Impossible.
```

## Constraints
* `1 <= numCourses <= 2000`
* `0 <= prerequisites.length <= 5000`

## Approach

### 1. Cycle Detection (DFS)
The problem asks if the Directed Graph has a cycle.
* Build an Adjacency List.
* Use a `visit` array with 3 states:
    * `0`: Unvisited
    * `1`: Visiting (Currently in recursion stack)
    * `2`: Visited (Fully processed)
* Iterate through all nodes. If we encounter a node with state `1` (Visiting), a cycle exists -> Return False.

### 2. Topological Sort (Kahn's Algorithm - BFS)
* Calculate in-degrees for all nodes.
* Add nodes with 0 in-degree to Queue.
* Process queue: remove node, decrease neighbors' in-degrees. If neighbor becomes 0, add to queue.
* Count processed nodes. If `count == numCourses`, return True.

## Solution

See [solution.java](solution.java) for the implementation.
