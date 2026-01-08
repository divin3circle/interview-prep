import java.util.*;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pair : prerequisites) {
            graph.get(pair[1]).add(pair[0]);
        }

        int[] visit = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (visit[i] == 0) {
                if (hasCycle(graph, visit, i))
                    return false;
            }
        }

        return true;
    }

    private boolean hasCycle(List<List<Integer>> graph, int[] visit, int curr) {
        if (visit[curr] == 1)
            return true;
        if (visit[curr] == 2)
            return false;

        visit[curr] = 1;

        for (int neighbor : graph.get(curr)) {
            if (hasCycle(graph, visit, neighbor))
                return true;
        }

        visit[curr] = 2;
        return false;
    }
}
