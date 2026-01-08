# Clone Graph

**Difficulty**: Medium  
**Pattern**: Graphs (DFS/BFS)

## Problem Statement
Given a reference of a node in a connected undirected graph. Return a deep copy (clone) of the graph.

Each node in the graph contains a value (`int`) and a list (`List[Node]`) of its neighbors.

## Examples

### Example 1
```
Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
Output: [[2,4],[1,3],[2,4],[1,3]]
Explanation: There are 4 nodes in the graph.
1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
...
```

## Constraints
* The number of nodes in the graph is between `[0, 100]`.
* `1 <= Node.val <= 100`

## Approach

### 1. DFS with HashMap
To deep copy a graph, we need to ensure we copy each node exactly once and preserve valid connections.
* Use a **HashMap** (`Map<Node, Node>`) to map original nodes to their clones.
* **Algorithm**:
    1. If node is `null`, return `null`.
    2. If node is already in map, return its clone (handle cycles).
    3. Create a clone for the specific node and put in map.
    4. Iterate through neighbors, recursively calling `cloneGraph` and adding the results to the clone's neighbors list.

### Complexity
* **Time**: `O(V + E)` - Visit every vertex and edge.
* **Space**: `O(V)` - HashMap stores all vertices.

## Solution

See [solution.java](solution.java) for the implementation.
