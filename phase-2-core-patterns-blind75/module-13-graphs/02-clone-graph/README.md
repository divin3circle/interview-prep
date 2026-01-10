# Clone Graph

**Difficulty**: Medium  
**Pattern**: Graph (DFS / BFS with HashMap)  
**Companies**: Google, Amazon, Facebook, Microsoft

## Problem Statement

Given a reference of a node in a connected undirected graph. Return a deep copy (clone) of the graph.

Each node in the graph contains a value (`int`) and a list (`List[Node]`) of its neighbors.

```java
class Node {
    public int val;
    public List<Node> neighbors;
}
```

## Examples

### Example 1
```
Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
Output: [[2,4],[1,3],[2,4],[1,3]]
Explanation: 
Node 1's neighbors are 2 and 4.
Node 2's neighbors are 1 and 3.
Node 3's neighbors are 2 and 4.
Node 4's neighbors are 1 and 3.
```

## Constraints

- The number of nodes in the graph is between `0` and `100`.
- `1 <= Node.val <= 100`
- `Node.val` is unique for each node.
- There are no repeated edges and no self-loops in the graph.
- The Graph is connected and all nodes can be visited starting from the given node.

## Theoretical Concepts

### Deep Copy vs Shallow Copy
- **Shallow Copy**: Copying the object references. Modifications to the copy affect the original.
- **Deep Copy**: Creating entirely new objects and recreating the relationships (edges) between them.

### Cycle Handling with HashMap
The primary challenge in cloning a graph with cycles is avoiding infinite recursion and ensuring a node is cloned only once. We use a **HashMap** (original node → cloned node) to:
1. Track which nodes have already been cloned.
2. Retrieve the clone of an existing node when building neighbor lists.

### Traversal for Cloning
- **DFS (Recursive)**: Clean and intuitive. For each neighbor of a node, either clone it (if new) or get its clone (if seen) and add it to the current clone's neighbors.
- **BFS (Iterative)**: Uses a queue. Useful if we want to process nodes level by level or avoid deep recursion.

## Approach

### DFS with HashMap (Optimal)
**Time**: O(V + E) where V is nodes and E is edges, **Space**: O(V) for the map and recursion stack.

1. Maintain a `visited` map: `Node -> Node` (Old -> New).
2. If the input node is `null`, return `null`.
3. If node is already in `visited`, return its clone from the map.
4. Create a new clone node with the same value.
5. Add it to the map: `visited.put(node, clone)`.
6. For each neighbor in `node.neighbors`:
   - Recursively call `cloneGraph` and add the result to `clone.neighbors`.
7. Return `clone`.

**Why it's optimal**: We visit each node and each edge exactly once.

## Solution

See [solution.java](solution.java) for implementation.

## Key Insights

1. **HashMap as a "Source of Truth"**: The map ensures we don't recreate nodes, maintaining the graph's topology correctly.
2. **Infinite Recursion Prevention**: Adding the clone to the map **before** recursing into its neighbors is critical for handling cycles.
3. **Graph Topology**: Cloning is as much about the edges as it is about the node values.

## Edge Cases

- **Empty graph** (input is `null`).
- **Graph with a single node**.
- **Graph with a self-loop** (though constrained against it, the logic handles it).
- **Fully connected graph**.
- **Linear graph** (linked list structure).

## Related Problems

- Copy List with Random Pointer (LeetCode 138)
- Clone Binary Tree with Random Pointer (LeetCode 1485)
- All Paths From Source to Target (LeetCode 797)
