package queues;

import java.util.*;

/**
 * Demonstrating Queue and Deque operations.
 */
public class QueueOperations {

    public static void main(String[] args) {
        demonstrateStandardQueue();
        demonstrateDeque();
    }

    private static void demonstrateStandardQueue() {
        System.out.println("--- Standard Queue (FIFO) ---");
        // LinkedList implements Queue interface
        Queue<String> queue = new LinkedList<>();

        // 1. Enqueue - O(1)
        queue.offer("First");
        queue.offer("Second");
        queue.offer("Third");
        System.out.println("Queue: " + queue);

        // 2. Peek - O(1)
        System.out.println("Head: " + queue.peek());

        // 3. Dequeue - O(1)
        System.out.println("Polled: " + queue.poll());
        System.out.println("Queue after poll: " + queue);
    }

    private static void demonstrateDeque() {
        System.out.println("\n--- Deque (Double Ended Queue) ---");
        // ArrayDeque is generally faster than LinkedList for Stack/Queue
        Deque<Integer> deque = new ArrayDeque<>();

        // Add to both ends
        deque.offerFirst(1); // HEAD
        deque.offerLast(2); // TAIL
        deque.offerFirst(0); // HEAD -> 0, 1, 2
        System.out.println("Deque: " + deque);

        // Peek both ends
        System.out.println("First: " + deque.peekFirst());
        System.out.println("Last: " + deque.peekLast());

        // Remove from both ends
        deque.pollLast(); // Removes 2
        System.out.println("After pollLast: " + deque);
    }
}
