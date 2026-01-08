# Heaps (Priority Queues)

## Overview
A Heap is a special Tree-based structure satisfying the **Heap Property**:
- **Max-Heap**: Parent key >= Children keys. Root is Max.
- **Min-Heap**: Parent key <= Children keys. Root is Min.

It is almost always implemented using a binary tree mapped to an **Array**.

## Core Operations

| Operation | Complexity | Note |
|-----------|------------|------|
| `peek()` | O(1) | Get Min/Max |
| `offer(x)` | O(log n) | Insert and bubble up |
| `poll()` | O(log n) | Remove root and bubble down |
| `remove(x)`| O(n) | Linear scan to find element |

## Implementation in Java
Use `java.util.PriorityQueue`. by default it is a **Min-Heap**.
```java
// Min Heap
PriorityQueue<Integer> minHeap = new PriorityQueue<>();

// Max Heap
PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
```

## Comparisons
- **BST**: O(log n) search, ordered.
- **Heap**: O(1) min/max access, **weakly** ordered.

## Common Use Cases
1. **Top K Elements**: Keep a heap of size K.
2. **Merge K Sorted Lists**: Efficiently pick next smallest.
3. **Median of Stream**: Two heaps pattern.
