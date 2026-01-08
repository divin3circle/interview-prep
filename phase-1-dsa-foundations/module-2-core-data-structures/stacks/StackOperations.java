package stacks;

import java.util.*;

/**
 * Demonstrating Stack operations using both implementations.
 */
public class StackOperations {

    public static void main(String[] args) {
        demonstrateArrayDequeStack();
        demonstrateCustomStack();
    }

    // Recommended way in Modern Java
    private static void demonstrateArrayDequeStack() {
        System.out.println("--- Stack using ArrayDeque (Recommended) ---");
        Deque<String> stack = new ArrayDeque<>();

        // 1. Push - O(1)
        stack.push("Bottom");
        stack.push("Middle");
        stack.push("Top");
        System.out.println("Stack: " + stack);

        // 2. Peek - O(1)
        System.out.println("Peek: " + stack.peek());

        // 3. Pop - O(1)
        String popped = stack.pop();
        System.out.println("Popped: " + popped);
        System.out.println("Stack after pop: " + stack);

        // 4. Check Empty
        System.out.println("Is Empty? " + stack.isEmpty());
    }

    // Simple Custom Stack using Array
    private static void demonstrateCustomStack() {
        System.out.println("\n--- Custom Array-based Stack ---");
        MyStack s = new MyStack(5);
        s.push(10);
        s.push(20);
        System.out.println("Peek: " + s.peek());
        System.out.println("Pop: " + s.pop());
        System.out.println("Pop: " + s.pop());
        // System.out.println("Pop: " + s.pop()); // Would throw Exception/Error
    }

    static class MyStack {
        private int[] arr;
        private int top;
        private int capacity;

        MyStack(int size) {
            arr = new int[size];
            capacity = size;
            top = -1;
        }

        public void push(int x) {
            if (isFull()) {
                System.out.println("Stack Overflow");
                return;
            }
            arr[++top] = x;
        }

        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack Underflow");
                return -1;
            }
            return arr[top--];
        }

        public int peek() {
            if (isEmpty())
                return -1;
            return arr[top];
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public boolean isFull() {
            return top == capacity - 1;
        }
    }
}
