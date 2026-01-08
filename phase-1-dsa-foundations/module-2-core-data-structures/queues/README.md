# Queues

## Overview
A Queue is a linear data structure that follows the **FIFO** (First In, First Out) principle. The first element added is the first one removed.

## Core Operations

| Operation | Description | Complexity |
|-----------|-------------|------------|
| `offer(x)` / `add(x)` | Enqueue (Add to rear) | O(1) |
| `poll()` / `remove()` | Dequeue (Remove from front) | O(1) |
| `peek()` / `element()` | View front element | O(1) |
| `isEmpty()` | Check if queue empty | O(1) |

> Note: `offer/poll` return special values (false/null) on failure, while `add/remove` throw exceptions. **Prefer `offer/poll`**.

## Implementation in Java
Use `java.util.LinkedList` or `java.util.ArrayDeque` which implement the `Queue` interface.
```java
Queue<String> queue = new LinkedList<>();
queue.offer("First");
queue.poll();
```

## Comparisons
- **Queue**: Standard FIFO.
- **Deque**: Double-Ended Queue (can insert/remove at both ends).
- **PriorityQueue**: Elements ordered by priority/comparator, not insertion order.

## Common Use Cases
1. **BFS (Breadth-First Search)**: Graph/Tree traversal.
2. **Task Scheduling**: Processing jobs in order.
3. **Buffering**: Data streams.

## Interview Tips
- Use Queue for **Level-Order** traversals.
- Use Deque for **Sliding Window** maximums (Monotonic Queue).
