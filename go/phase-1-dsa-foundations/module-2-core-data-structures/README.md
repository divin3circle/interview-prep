# Module 2: Core Data Structures (Go Edition)

## Introduction

Data structures are the fundamental building blocks of all software. Understanding how they work internally, their operation complexities, and when to use each one is essential for solving algorithmic problems efficiently.

Think of data structures as different types of containers, each optimized for specific operations.

## Why Data Structures Matter

### In Technical Interviews

The right data structure choice can transform an O(n²) solution into O(n):
- **Problem**: Find if two numbers sum to target
- **Wrong choice**: Nested loops with slice → O(n²)
- **Right choice**: Map for lookups → O(n)

## Overview of Core Data Structures

### Linear Data Structures

**Slices (Arrays)**: Dynamic size (conceptually), contiguous memory, fast index access.
**Linked Lists**: Nodes with pointers, dynamic size, fast insertion/deletion.
**Stacks**: Last-In-First-Out (LIFO), function calls, undo operations.
**Queues**: First-In-First-Out (FIFO), task scheduling, breadth-first search.

### Hash-Based Structures

**Map**: Key-value pairs, O(1) average lookup, counting, caching.
**Set (Map[T]bool)**: Unique elements, O(1) average lookup, duplicate detection.

### Hierarchical Structures

**Trees**: Hierarchical relationships, file systems.
**Binary Search Trees**: Sorted data, O(log n) operations when balanced.
**Heaps**: Priority queues, finding min/max efficiently.

### Graph Structures

**Graphs**: Networks, relationships, social connections, maps.

---

## Data Structure Decision Guide

![Data Structure Decision Tree](data_structure_decision_tree.png)

### Quick Decision Table

| Need | Use | Why |
|------|-----|-----|
| Access by index | Slice | O(1) index access |
| Fast search/lookup | Map | O(1) average lookup |
| Maintain insertion order | Slice | Sequential access |
| LIFO (Last-In-First-Out) | Slice (as Stack) | Simple push/pop |
| FIFO (First-In-First-Out) | Slice (as Queue) | Simple enqueue/dequeue |
| Prioritized access | Heap (container/heap) | O(log n) insert/delete |
| Hierarchical relationships | Tree | Parent-child structure |
| Network relationships | Graph | Vertices and edges |

---

## Module Structure

This module covers each data structure in depth:

### [Arrays & Slices](arrays/README.md)
- Internal mechanics and memory layout
- Go Slices vs Java ArrayLists
- Common patterns and techniques

### [Strings](strings/README.md)
- String immutability in Go
- `strings.Builder` for efficient concatenation
- Rune manipulation (Unicode awareness)

### [Linked Lists](linked-lists/README.md)
- Singly vs doubly linked lists
- Node structure (`type ListNode struct`)
- Insertion, deletion, and traversal

### [Stacks](stacks/README.md)
- LIFO principle
- Implementation using Slices

### [Queues](queues/README.md)
- FIFO principle
- Implementation using Slices

### [Maps & Sets](hashmaps-sets/README.md)
- Hash function mechanics
- Go `map` internals
- Implementing Sets using `map[T]bool`

### [Heaps](heaps/README.md)
- Examples using `container/heap`

### [Trees](trees/README.md)
- Binary trees vs BSTs
- Tree traversals

### [Graphs](graphs/README.md)
- Adjacency lists using Slices of pointers

---

## Learning Approach

### Study Sequence

**Recommended Order**:
1. Arrays/Slices (Foundation)
2. Strings (Special case of slices of bytes)
3. Maps (Critical for interviews)
4. Linked Lists
5. Stacks and Queues
6. Trees
7. Heaps
8. Graphs

**Time Investment**: 30-45 minutes per data structure

---

## Complexity Comparison

### Access/Search Operations

| Data Structure | Access | Search | Notes |
|---------------|--------|--------|-------|
| Slice | O(1) | O(n) | O(log n) if sorted |
| LinkedList | O(n) | O(n) | Must traverse |
| Stack | O(n) | O(n) | Only top is O(1) |
| Queue | O(n) | O(n) | Only front is O(1) |
| Map | N/A | O(1) avg | O(n) worst case |
| BST (balanced) | O(log n) | O(log n) | O(n) if unbalanced |
| Heap | O(n) | O(n) | Only min/max is O(1) |

### Insertion/Deletion Operations

| Data Structure | Insert | Delete | Notes |
|---------------|--------|--------|-------|
| Slice (end) | O(1) amortized | O(1) | May require resize |
| Slice (beginning) | O(n) | O(n) | Must shift elements |
| LinkedList (head) | O(1) | O(1) | Pointers |
| Map | O(1) avg | O(1) avg | Rehash |
| Heap | O(log n) | O(log n) | Bubble up/down |

---

## Common Interview Patterns

### Pattern 1: Fast Lookup → Map
**Problems**: Two Sum, Contains Duplicate
**Why**: O(1) lookup

### Pattern 2: Maintain Order → Slice/Queue
**Problems**: Valid Parentheses
**Why**: LIFO/FIFO

### Pattern 3: Sorted Data → Heap
**Problems**: K-th Largest Element
**Why**: Efficient min/max

---

## Space-Time Tradeoffs

### Example: Finding Duplicates

**Approach 1: Nested Loops (O(n²))**
```go
for i := 0; i < len(arr); i++ {
    for j := i+1; j < len(arr); j++ {
        if arr[i] == arr[j] { return true }
    }
}
```

**Approach 2: Sorting (O(n log n))**
```go
sort.Ints(arr)
for i := 0; i < len(arr)-1; i++ {
    if arr[i] == arr[i+1] { return true }
}
```

**Approach 3: Map (O(n))**
```go
seen := make(map[int]bool)
for _, num := range arr {
    if seen[num] { return true }
    seen[num] = true
}
```

**Lesson**: Map uses O(n) space but achieves O(n) time.

---

## Practical Tips for Interviews

1. **Ask About Constraints**: "How large is the input?"
2. **Start with Brute Force**, Then Optimize.
3. **Know Your Complexities**.
4. **Implement Common Structures**: Know how to write `ListNode`.
5. **Recognize When to Use Each**:
   - Fast lookup? -> Map
   - Sorted? -> Sort it or use Heap.
   - LIFO? -> Stack (Slice).

---

## Next Steps

Work through each data structure in order:

1. [Arrays](arrays/README.md)
2. [Strings](strings/README.md)
3. [Linked Lists](linked-lists/README.md)
4. [Stacks](stacks/README.md)
5. [Queues](queues/README.md)
6. [Maps](hashmaps-sets/README.md)
7. [Heaps](heaps/README.md)
8. [Trees](trees/README.md)
9. [Graphs](graphs/README.md)