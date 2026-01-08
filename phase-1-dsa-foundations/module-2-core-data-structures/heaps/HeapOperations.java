package heaps;

import java.util.*;

/**
 * Demonstrating Min-Heap and Max-Heap using PriorityQueue.
 */
public class HeapOperations {

    public static void main(String[] args) {
        demonstrateMinHeap();
        demonstrateMaxHeap();
        demonstrateTopKPattern();
    }

    private static void demonstrateMinHeap() {
        System.out.println("--- Min Heap (Default) ---");
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add Elements - O(log n)
        pq.offer(5);
        pq.offer(1);
        pq.offer(10);

        // Peek Min - O(1)
        System.out.println("Min: " + pq.peek()); // 1

        // Poll Min - O(log n)
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " "); // 1 5 10
        }
        System.out.println();
    }

    private static void demonstrateMaxHeap() {
        System.out.println("\n--- Max Heap (Custom Comparator) ---");
        // Use Collections.reverseOrder() or lambda (a,b) -> b-a
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        pq.offer(5);
        pq.offer(1);
        pq.offer(10);

        System.out.println("Max: " + pq.peek()); // 10

        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " "); // 10 5 1
        }
        System.out.println();
    }

    private static void demonstrateTopKPattern() {
        System.out.println("\n--- Top K Largest Pattern ---");
        // Find top 3 largest elements
        int[] nums = { 3, 2, 1, 5, 6, 4 };
        int k = 3;

        // Keep Min Heap of size K
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove smallest of the heap
            }
        }
        // Heap contains [4, 5, 6] (Top 3)
        System.out.println("Top " + k + " elements: " + minHeap);
    }
}
