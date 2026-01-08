package graphs;

import java.util.*;

/**
 * Demonstrating Graph Representation and Traversal.
 * Using Adjacency List (Map<Integer, List<Integer>>).
 */
public class GraphOperations {

    static class Graph {
        // Map Node -> Neighbors
        private Map<Integer, List<Integer>> adjList;

        Graph() {
            adjList = new HashMap<>();
        }

        void addEdge(int src, int dest, boolean bidirectional) {
            adjList.putIfAbsent(src, new ArrayList<>());
            adjList.putIfAbsent(dest, new ArrayList<>());
            adjList.get(src).add(dest);
            if (bidirectional) {
                adjList.get(dest).add(src);
            }
        }

        void dfs(int start) {
            System.out.print("DFS: ");
            Set<Integer> visited = new HashSet<>();
            dfsHelper(start, visited);
            System.out.println();
        }

        private void dfsHelper(int curr, Set<Integer> visited) {
            visited.add(curr);
            System.out.print(curr + " ");
            for (int neighbor : adjList.getOrDefault(curr, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    dfsHelper(neighbor, visited);
                }
            }
        }

        void bfs(int start) {
            System.out.print("BFS: ");
            Set<Integer> visited = new HashSet<>();
            Queue<Integer> queue = new LinkedList<>();

            visited.add(start);
            queue.offer(start);

            while (!queue.isEmpty()) {
                int curr = queue.poll();
                System.out.print(curr + " ");

                for (int neighbor : adjList.getOrDefault(curr, new ArrayList<>())) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        // 0 - 1
        // | |
        // 2 - 3
        g.addEdge(0, 1, true);
        g.addEdge(0, 2, true);
        g.addEdge(1, 3, true);
        g.addEdge(2, 3, true);

        System.out.println("--- Graph Traversals (Start 0) ---");
        g.dfs(0);
        g.bfs(0);
    }
}
