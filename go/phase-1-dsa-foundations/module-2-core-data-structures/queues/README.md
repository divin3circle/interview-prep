# Queues

## Introduction

A Queue is a FIFO (First-In-First-Out) data structure.
Think of a line at a store: first person in line is the first one served.

## Implementation in Go

### Using Slice
Simple but can have memory leak if not handled (underlying array grows but beginning is sliced off).

```go
var queue []int

// Enqueue
queue = append(queue, 10)

// Dequeue
val := queue[0]
queue = queue[1:]
```

### Time Complexity

| Operation | Complexity |
|-----------|------------|
| Enqueue | O(1) |
| Dequeue | O(1) |
| Peek | O(1) |

## Use Cases

- BFS (Breadth First Search)
- Task Scheduling
- Printer Queue
- Handling Requests

## Deque (Double-Ended Queue)
Supports insertion/deletion at both ends.
Go doesn't have a built-in `Deque` class, but you can use `container/list` (Doubly Linked List) or a slice with careful index management.
