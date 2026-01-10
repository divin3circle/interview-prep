# Module 11: Heaps / Priority Queue

## Pattern Overview

Heaps (Priority Queues) allow O(1) access to the min or max element and O(log n) - or O(1) depending on implementation - insertion/deletion. Useful for "Top K" problems or finding medians.

## Core Techniques

### Max Heap
A binary heap where the parent is always greater than or equal to its children. The largest element is always at the root.
In Java: `new PriorityQueue<>(Collections.reverseOrder())`

### Min Heap
A binary heap where the parent is always less than or equal to its children. The smallest element is always at the root.
In Java: `new PriorityQueue()` (Default)

## Problems
1. Find Median from Data Stream
2. Kth Largest Element in an Array (Often solved with QuickSelect, but Heap is valid) -> *Note: Problem named "kth-largest" will be treated as the Stream problem or regular Kth Largest? The directory is stream-median usually, but here I have `01-kth-largest` and `02-find-median`.*

**Key Takeaway**: Use heaps when you need continuous access to max/min elements.
