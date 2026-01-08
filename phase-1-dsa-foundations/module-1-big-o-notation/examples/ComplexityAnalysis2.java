/**
 * Complexity Analysis Exercise 2
 * Advanced Scenarios and Tricky Cases
 * 
 * These examples cover more advanced complexity analysis scenarios
 * that commonly appear in technical interviews.
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Deque;

public class ComplexityAnalysis2 {

    // ============================================================================
    // PROBLEM 1: Sorting Algorithms
    // ============================================================================

    /**
     * QuickSort implementation (average case).
     * 
     * QUESTION: What is the time and space complexity?
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * ANSWER:
     * Time Complexity:
     * - Best/Average Case: O(n log n)
     * - Partition divides array roughly in half: log n levels
     * - Each level processes n elements: O(n) per level
     * - Total: O(n log n)
     * 
     * - Worst Case: O(n²)
     * - Occurs when pivot is always smallest/largest element
     * - Creates unbalanced partitions (n-1, 0)
     * - Recursion depth becomes n instead of log n
     * - Total: n + (n-1) + (n-2) + ... + 1 = O(n²)
     * 
     * Space Complexity: O(log n) average, O(n) worst
     * - Recursion stack depth
     * - Average case: log n levels of recursion
     * - Worst case: n levels of recursion
     */

    // ============================================================================
    // PROBLEM 2: Merge Sort
    // ============================================================================

    /**
     * Merge Sort implementation.
     * 
     * QUESTION: What is the time and space complexity?
     */
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rightArr, 0, n2);

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        while (i < n1)
            arr[k++] = leftArr[i++];
        while (j < n2)
            arr[k++] = rightArr[j++];
    }

    /**
     * ANSWER:
     * Time Complexity: O(n log n) - ALL cases (best, average, worst)
     * - Divide phase: Split array in half recursively = log n levels
     * - Conquer phase: Merge n elements at each level = O(n) per level
     * - Total: O(n log n)
     * - Unlike QuickSort, this is guaranteed even in worst case
     * 
     * Space Complexity: O(n)
     * - Temporary arrays in merge function: O(n) total
     * - Recursion stack: O(log n)
     * - Total: O(n) + O(log n) = O(n)
     * 
     * NOTE: Merge sort trades space for guaranteed O(n log n) time
     */

    // ============================================================================
    // PROBLEM 3: Matrix Multiplication
    // ============================================================================

    /**
     * Multiply two n×n matrices.
     * 
     * QUESTION: What is the time and space complexity?
     */
    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int n = A.length;
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return result;
    }

    /**
     * ANSWER:
     * Time Complexity: O(n³)
     * - Three nested loops, each running n times
     * - Total iterations: n × n × n = n³
     * - Each iteration does O(1) work
     * 
     * Space Complexity: O(n²)
     * - Result matrix of size n × n
     * - Input matrices don't count (they're given)
     * - Only counting additional space used
     * 
     * NOTE: Strassen's algorithm can do this in O(n^2.807) but is complex
     */

    // ============================================================================
    // PROBLEM 4: Subset Generation
    // ============================================================================

    /**
     * Generate all subsets of an array.
     * 
     * QUESTION: What is the time and space complexity?
     */
    public static List<List<Integer>> generateSubsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] nums, int start,
            List<Integer> current,
            List<List<Integer>> result) {
        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(nums, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

    /**
     * ANSWER:
     * Time Complexity: O(n × 2^n)
     * - Total number of subsets: 2^n
     * - Each subset takes O(n) time to copy into result
     * - Total: 2^n × O(n) = O(n × 2^n)
     * 
     * Space Complexity: O(n × 2^n)
     * - Storing 2^n subsets
     * - Average subset size is n/2
     * - Total space: 2^n × n/2 = O(n × 2^n)
     * - Recursion depth: O(n)
     * 
     * NOTE: This is exponential! Only feasible for small n (n ≤ 20)
     */

    // ============================================================================
    // PROBLEM 5: Permutations
    // ============================================================================

    /**
     * Generate all permutations of an array.
     * 
     * QUESTION: What is the time and space complexity?
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrackPermute(nums, new ArrayList<>(), new boolean[nums.length], result);
        return result;
    }

    private static void backtrackPermute(int[] nums, List<Integer> current,
            boolean[] used, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;

            current.add(nums[i]);
            used[i] = true;
            backtrackPermute(nums, current, used, result);
            used[i] = false;
            current.remove(current.size() - 1);
        }
    }

    /**
     * ANSWER:
     * Time Complexity: O(n × n!)
     * - Total number of permutations: n!
     * - Each permutation takes O(n) time to create and copy
     * - Total: n! × O(n) = O(n × n!)
     * 
     * Space Complexity: O(n × n!)
     * - Storing n! permutations
     * - Each permutation has length n
     * - Total: n! × n = O(n × n!)
     * - Recursion depth: O(n)
     * 
     * NOTE: Even more expensive than subsets! Only feasible for very small n
     */

    // ============================================================================
    // PROBLEM 6: Tree Traversal
    // ============================================================================

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * Inorder traversal of binary tree.
     * 
     * QUESTION: What is the time and space complexity?
     */
    public static void inorderTraversal(TreeNode root) {
        if (root == null)
            return;

        inorderTraversal(root.left);
        System.out.println(root.val);
        inorderTraversal(root.right);
    }

    /**
     * ANSWER:
     * Time Complexity: O(n) where n = number of nodes
     * - Visit each node exactly once
     * - Each visit does O(1) work
     * 
     * Space Complexity: O(h) where h = height of tree
     * - Recursion stack depth = height of tree
     * - Best case (balanced tree): h = log n, so O(log n)
     * - Worst case (skewed tree): h = n, so O(n)
     * - Average case: O(log n)
     */

    // ============================================================================
    // PROBLEM 7: Level Order Traversal (BFS)
    // ============================================================================

    /**
     * Level order traversal using queue.
     * 
     * QUESTION: What is the time and space complexity?
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);

                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }

            result.add(currentLevel);
        }

        return result;
    }

    /**
     * ANSWER:
     * Time Complexity: O(n) where n = number of nodes
     * - Each node is enqueued and dequeued exactly once
     * - Each operation is O(1)
     * - Total: O(n)
     * 
     * Space Complexity: O(w) where w = maximum width of tree
     * - Queue stores nodes at current level
     * - Maximum width occurs at bottom level
     * - For complete binary tree: w = n/2, so O(n)
     * - For skewed tree: w = 1, so O(1)
     * - Worst case: O(n)
     */

    // ============================================================================
    // PROBLEM 8: Graph DFS
    // ============================================================================

    /**
     * Depth-first search on graph.
     * 
     * QUESTION: What is the time and space complexity?
     */
    public static void dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        System.out.println(node);

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited);
            }
        }
    }

    /**
     * ANSWER:
     * Time Complexity: O(V + E) where V = vertices, E = edges
     * - Visit each vertex once: O(V)
     * - Explore each edge once: O(E)
     * - Total: O(V + E)
     * 
     * Space Complexity: O(V)
     * - Visited array: O(V)
     * - Recursion stack (worst case): O(V)
     * - Total: O(V)
     * 
     * NOTE: This is the standard complexity for graph traversal
     */

    // ============================================================================
    // PROBLEM 9: Dynamic Programming - Longest Common Subsequence
    // ============================================================================

    /**
     * Find length of longest common subsequence.
     * 
     * QUESTION: What is the time and space complexity?
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    /**
     * ANSWER:
     * Time Complexity: O(m × n) where m, n = string lengths
     * - Nested loops: m × n iterations
     * - Each iteration does O(1) work
     * 
     * Space Complexity: O(m × n)
     * - 2D DP table of size (m+1) × (n+1)
     * 
     * OPTIMIZATION: Can reduce space to O(min(m, n)) by using rolling array
     */

    // ============================================================================
    // PROBLEM 10: Sliding Window Maximum
    // ============================================================================

    /**
     * Find maximum in each sliding window of size k.
     * 
     * QUESTION: What is the time and space complexity?
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // Remove elements outside window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove smaller elements (they'll never be max)
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            // Add to result once window is full
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    /**
     * ANSWER:
     * Time Complexity: O(n) where n = array length
     * - Each element is added to deque once: O(n)
     * - Each element is removed from deque at most once: O(n)
     * - Total: O(n) + O(n) = O(n)
     * 
     * This is NOT O(n × k) because of the deque optimization!
     * 
     * Space Complexity: O(k)
     * - Deque stores at most k elements
     * - Result array doesn't count (it's the output)
     * 
     * NOTE: Naive approach would be O(n × k), this is much better!
     */

    // ============================================================================
    // KEY INSIGHTS
    // ============================================================================

    /**
     * ADVANCED COMPLEXITY PATTERNS:
     * 
     * 1. Sorting: O(n log n) for comparison-based sorts
     * 2. Subsets: O(2^n) - exponential
     * 3. Permutations: O(n!) - factorial
     * 4. Tree traversal: O(n) time, O(h) space
     * 5. Graph traversal: O(V + E)
     * 6. Dynamic Programming: Often O(n²) or O(n × m)
     * 7. Sliding window with deque: O(n) despite seeming like O(n × k)
     * 
     * SPACE COMPLEXITY CONSIDERATIONS:
     * 
     * 1. Recursion uses O(depth) stack space
     * 2. Iterative with queue/stack: O(max elements in structure)
     * 3. DP tables: Usually O(n) or O(n²)
     * 4. Output doesn't count toward space complexity
     * 
     * OPTIMIZATION STRATEGIES:
     * 
     * 1. Memoization: Trade space for time
     * 2. Deque: Maintain useful elements only
     * 3. Rolling array: Reduce DP space from O(n²) to O(n)
     * 4. Iteration over recursion: Save stack space
     */
}
