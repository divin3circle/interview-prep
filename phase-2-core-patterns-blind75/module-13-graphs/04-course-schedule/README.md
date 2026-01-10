# Course Schedule

**Difficulty**: Medium  
**Pattern**: Graph (Topological Sort / Cycle Detection)  
**Companies**: Google, Amazon, Microsoft, Facebook, Apple, Bloomberg, Uber

## Problem Statement

There are a total of `numCourses` courses you have to take, labeled from `0` to `numCourses - 1`. You are given an array `prerequisites` where `prerequisites[i] = [ai, bi]` indicates that you must take course `bi` first if you want to take course `ai`.

- For example, the pair `[0, 1]` indicates that to take course `0` you have to first take course `1`.

Return `true` if you can finish all courses. Otherwise, return `false`.

## Examples

### Example 1
```
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
```

### Example 2
```
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: To take course 1 you should have finished course 0, and to take course 0 you should have finished course 1. So it is impossible.
```

## Constraints

- `1 <= numCourses <= 2000`
- `0 <= prerequisites.length <= 5000`
- `prerequisites[i].length == 2`
- `0 <= ai, bi < numCourses`
- All the pairs `prerequisites[i]` are unique.

## Theoretical Concepts

### Directed Acyclic Graph (DAG)
This problem is equivalent to asking: **Is the directed graph formed by course prerequisites a DAG?**
- If there is a cycle, we cannot finish the courses because of a circular dependency.
- If there is no cycle, a topological ordering exists, and we can finish the courses.

### Kahn's Algorithm (BFS)
Kahn's algorithm uses the concept of **In-degree** (number of incoming edges to a node):
1. Compute in-degree for all nodes.
2. Add nodes with in-degree 0 to a queue (these have no prerequisites).
3. While queue is not empty:
   - Pop a node, increment the count of "finished" courses.
   - For each neighbor, decrement its in-degree.
   - If a neighbor's in-degree becomes 0, add it to the queue.
4. If `count == numCourses`, return `true`.

### DFS Cycle Detection
Using recursion and a "recursion stack" state:
- **State 0**: Unvisited.
- **State 1**: Visiting (currently in recursion stack).
- **State 2**: Visited (fully processed).
If we encounter a node in State 1 during DFS, a cycle is detected.

## Approach

### Kahn's Algorithm (Optimal & Practical)
**Time**: O(V + E), **Space**: O(V + E)

1. Build an adjacency list and an in-degree array.
2. Put all nodes with `in-degree == 0` into a queue.
3. Process nodes and release dependencies.
4. Check if we processed all courses.

**Why it's optimal**: Linear time complexity, and it intuitively models the process of taking courses as prerequisites are cleared.

## Solution

See [solution.java](solution.java) for implementation.

## Key Insights

1. **Cycle = Deadlock**: Dependencies must be linear or branching, never circular.
2. **In-degree logic**: A course with in-degree 0 is "unlocked".
3. **Graph building**: Converting the edge list into an adjacency list is the first step for efficient traversal.

## Edge Cases

- **No prerequisites**.
- **Self-dependency** (`[0, 0]`).
- **Disconnected components**.
- **Large number of courses with few dependencies**.
- **Courses with multiple prerequisites**.

## Related Problems

- Course Schedule II (LeetCode 210) - return the ordering.
- Course Schedule IV (LeetCode 1462)
- Alien Dictionary (LeetCode 269)
- Parallel Courses (LeetCode 1136)
