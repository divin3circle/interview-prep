# Module 11: Heaps / Priority Queue

## Pattern Overview

Heaps (Priority Queues) allow O(1) access to the min or max element and O(log n) - or O(1) depending on implementation - insertion/deletion. Useful for "Top K" problems or finding medians.

## Core Techniques

### Max Heap
Stores largest element at top.
```java
PriorityQueue<Integer> fast = new PriorityQueue<>((a, b) -> b - a);
```

### Min Heap
Stores smallest element at top.
```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
```

## Problems
1. Find Median from Data Stream
2. Kth Largest Element in an Array (Often solved with QuickSelect, but Heap is valid) -> *Note: Problem named "kth-largest" will be treated as the Stream problem or regular Kth Largest? The directory is stream-median usually, but here I have `01-kth-largest` and `02-find-median`.*

**Key Takeaway**: Use heaps when you need continuous access to max/min elements.
