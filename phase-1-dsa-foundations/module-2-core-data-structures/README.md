# Module 2: Core Data Structures

## Introduction

Data structures are the fundamental building blocks of all software. Understanding how they work internally, their operation complexities, and when to use each one is essential for solving algorithmic problems efficiently.

Think of data structures as different types of containers, each optimized for specific operations. Just as you wouldn't use a filing cabinet to store liquids, you shouldn't use an array when you need fast insertions and deletions.

## Why Data Structures Matter

### In Technical Interviews

The right data structure choice can transform an O(n²) solution into O(n):
- **Problem**: Find if two numbers sum to target
- **Wrong choice**: Nested loops with array → O(n²)
- **Right choice**: HashMap for lookups → O(n)

### In Real-World Engineering

Data structures determine:
- Application performance and scalability
- Memory efficiency
- Code maintainability
- System architecture

## Overview of Core Data Structures

### Linear Data Structures

**Arrays**: Fixed or dynamic size, contiguous memory, fast index access
**Linked Lists**: Nodes with pointers, dynamic size, fast insertion/deletion
**Stacks**: Last-In-First-Out (LIFO), function calls, undo operations
**Queues**: First-In-First-Out (FIFO), task scheduling, breadth-first search

### Hash-Based Structures

**HashMap**: Key-value pairs, O(1) average lookup, counting, caching
**HashSet**: Unique elements, O(1) average lookup, duplicate detection

### Hierarchical Structures

**Trees**: Hierarchical relationships, file systems, decision trees
**Binary Search Trees**: Sorted data, O(log n) operations when balanced
**Heaps**: Priority queues, finding min/max efficiently

### Graph Structures

**Graphs**: Networks, relationships, social connections, maps

---

## Data Structure Decision Guide

![Data Structure Decision Tree](data_structure_decision_tree.png)

### Quick Decision Table

| Need | Use | Why |
|------|-----|-----|
| Access by index | Array/ArrayList | O(1) index access |
| Fast search/lookup | HashMap/HashSet | O(1) average lookup |
| Maintain insertion order | LinkedList/ArrayList | Sequential access |
| LIFO (Last-In-First-Out) | Stack | Function calls, undo |
| FIFO (First-In-First-Out) | Queue | Task scheduling, BFS |
| Sorted data with fast ops | TreeSet/TreeMap | O(log n) operations |
| Priority-based access | Heap/PriorityQueue | O(log n) insert/delete |
| Hierarchical relationships | Tree | Parent-child structure |
| Network relationships | Graph | Vertices and edges |

---

## Module Structure

This module covers each data structure in depth:

### [Arrays](arrays/README.md)
- Internal mechanics and memory layout
- Static vs dynamic arrays (ArrayList)
- Common operations and their complexities
- When to use arrays
- Common patterns and techniques

### [Strings](strings/README.md)
- String immutability and implications
- StringBuilder vs String concatenation
- Common string manipulation techniques
- Pattern matching and searching

### [Linked Lists](linked-lists/README.md)
- Singly vs doubly linked lists
- Node structure and pointer manipulation
- Insertion, deletion, and traversal
- Common linked list patterns
- When to use vs arrays

### [Stacks](stacks/README.md)
- LIFO principle
- Implementation (array-based vs linked-list-based)
- Common applications
- Stack-based problem patterns

### [Queues](queues/README.md)
- FIFO principle
- Implementation variations (circular, deque)
- Common applications
- Queue-based problem patterns

### [HashMaps and HashSets](hashmaps-sets/README.md)
- Hash function mechanics
- Collision resolution
- Load factor and resizing
- When to use HashMap vs HashSet
- Common hashing patterns

### [Heaps](heaps/README.md)
- Min-heap vs max-heap
- Binary heap implementation
- Heapify operations
- Priority queue applications
- K-th largest/smallest problems

### [Trees](trees/README.md)
- Binary trees vs binary search trees
- Tree traversals (inorder, preorder, postorder, level-order)
- Balanced trees (AVL, Red-Black)
- Common tree patterns

### [Graphs](graphs/README.md)
- Graph representations (adjacency list vs matrix)
- Directed vs undirected graphs
- Weighted vs unweighted graphs
- Basic graph algorithms (DFS, BFS)

---

## Learning Approach

### For Each Data Structure

1. **Understand the Concept**: What problem does it solve?
2. **Learn the Mechanics**: How does it work internally?
3. **Memorize Complexities**: What are the operation costs?
4. **Recognize Patterns**: When should you use it?
5. **Practice Implementation**: Can you code it from scratch?

### Study Sequence

**Recommended Order**:
1. Arrays (foundation for many others)
2. Strings (special case of arrays)
3. Linked Lists (introduces pointers)
4. Stacks and Queues (simple but powerful)
5. HashMaps/HashSets (most useful for interviews)
6. Trees (hierarchical thinking)
7. Heaps (specialized tree)
8. Graphs (most complex)

**Time Investment**: 30-45 minutes per data structure

---

## Complexity Comparison

### Access/Search Operations

| Data Structure | Access | Search | Notes |
|---------------|--------|--------|-------|
| Array | O(1) | O(n) | O(log n) if sorted |
| LinkedList | O(n) | O(n) | Must traverse |
| Stack | O(n) | O(n) | Only top is O(1) |
| Queue | O(n) | O(n) | Only front is O(1) |
| HashMap | N/A | O(1) avg | O(n) worst case |
| HashSet | N/A | O(1) avg | O(n) worst case |
| BST (balanced) | O(log n) | O(log n) | O(n) if unbalanced |
| Heap | O(n) | O(n) | Only min/max is O(1) |

### Insertion/Deletion Operations

| Data Structure | Insert | Delete | Notes |
|---------------|--------|--------|-------|
| Array (end) | O(1) amortized | O(1) | May require resize |
| Array (beginning) | O(n) | O(n) | Must shift elements |
| LinkedList (beginning) | O(1) | O(1) | Update head pointer |
| LinkedList (end) | O(1) | O(n) | If tail pointer / else traverse |
| Stack | O(1) | O(1) | Push/pop at top |
| Queue | O(1) | O(1) | Enqueue/dequeue |
| HashMap | O(1) avg | O(1) avg | May require rehash |
| HashSet | O(1) avg | O(1) avg | May require rehash |
| BST (balanced) | O(log n) | O(log n) | O(n) if unbalanced |
| Heap | O(log n) | O(log n) | Bubble up/down |

---

## Common Interview Patterns

### Pattern 1: Fast Lookup → HashMap/HashSet

**Problems**: Two Sum, Contains Duplicate, Group Anagrams

**Why**: Need O(1) lookup to avoid nested loops

### Pattern 2: Maintain Order → Queue/Stack

**Problems**: Valid Parentheses, Sliding Window Maximum

**Why**: FIFO or LIFO behavior required

### Pattern 3: Sorted Data → TreeSet/Heap

**Problems**: K-th Largest Element, Meeting Rooms

**Why**: Need to maintain sorted order efficiently

### Pattern 4: Hierarchical Data → Tree

**Problems**: Binary Tree Traversal, Lowest Common Ancestor

**Why**: Data has parent-child relationships

### Pattern 5: Relationships → Graph

**Problems**: Number of Islands, Course Schedule

**Why**: Data has network-like connections

---

## Space-Time Tradeoffs

### Example: Finding Duplicates

**Approach 1: Nested Loops**
```java
// Time: O(n²), Space: O(1)
for (int i = 0; i < arr.length; i++) {
    for (int j = i + 1; j < arr.length; j++) {
        if (arr[i] == arr[j]) return true;
    }
}
```

**Approach 2: Sorting**
```java
// Time: O(n log n), Space: O(1) or O(n) depending on sort
Arrays.sort(arr);
for (int i = 0; i < arr.length - 1; i++) {
    if (arr[i] == arr[i + 1]) return true;
}
```

**Approach 3: HashSet**
```java
// Time: O(n), Space: O(n)
Set<Integer> seen = new HashSet<>();
for (int num : arr) {
    if (seen.contains(num)) return true;
    seen.add(num);
}
```

**Lesson**: Often we trade space for time. HashSet uses O(n) space but achieves O(n) time.

---

## Implementation vs Interface

### In Java

**Interfaces** (abstract types):
- `List`: Ordered collection
- `Set`: Unique elements
- `Map`: Key-value pairs
- `Queue`: FIFO collection

**Implementations** (concrete types):
- `ArrayList`: Resizable array
- `LinkedList`: Doubly-linked list
- `HashSet`: Hash table
- `HashMap`: Hash table
- `TreeSet`: Red-black tree
- `TreeMap`: Red-black tree
- `PriorityQueue`: Binary heap

**Interview Tip**: Declare with interface, instantiate with implementation:
```java
List<Integer> list = new ArrayList<>();  // Good
ArrayList<Integer> list = new ArrayList<>();  // Less flexible
```

---

## Memory Considerations

### Array Memory Layout

```
Contiguous memory:
[1][2][3][4][5]
 ↑  ↑  ↑  ↑  ↑
Each element at base_address + (index × element_size)
```

**Advantage**: Cache-friendly, fast access
**Disadvantage**: Requires contiguous space, expensive to resize

### Linked List Memory Layout

```
Non-contiguous memory:
[1|•]→[2|•]→[3|•]→[4|•]→[5|•]→null
```

**Advantage**: Dynamic size, cheap insertion/deletion
**Disadvantage**: Extra memory for pointers, poor cache locality

---

## Practical Tips for Interviews

### 1. Ask About Constraints

- "How large is the input?" → Affects data structure choice
- "Are there duplicates?" → Might need Set vs List
- "Is the data sorted?" → Can use binary search
- "What operations are most common?" → Optimize for those

### 2. Start with Brute Force, Then Optimize

- Brute force often uses simple arrays
- Optimization often involves HashMap, Heap, or Tree

### 3. Know Your Complexities

Memorize the complexity table. It's non-negotiable for interviews.

### 4. Implement Common Structures

Be able to implement from scratch:
- LinkedList (insert, delete, reverse)
- Stack (using array or linked list)
- Queue (using array or linked list)
- Binary tree traversals

### 5. Recognize When to Use Each

- Need fast lookup? → HashMap
- Need sorted order? → TreeSet or Heap
- Need LIFO? → Stack
- Need FIFO? → Queue
- Need hierarchy? → Tree
- Need relationships? → Graph

---

## Next Steps

### Study Each Data Structure

Work through each data structure in order:

1. [Arrays](arrays/README.md) - Start here
2. [Strings](strings/README.md)
3. [Linked Lists](linked-lists/README.md)
4. [Stacks](stacks/README.md)
5. [Queues](queues/README.md)
6. [HashMaps and HashSets](hashmaps-sets/README.md)
7. [Heaps](heaps/README.md)
8. [Trees](trees/README.md)
9. [Graphs](graphs/README.md)

### Practice Implementation

After studying each structure:
- Implement it from scratch
- Solve 2-3 problems using it
- Explain when and why to use it

### Move to Phase 2

Once comfortable with all data structures, proceed to [Phase 2: Core Patterns + Blind 75](../../phase-2-core-patterns-blind75/README.md) to apply this knowledge to real interview problems.

---

**Data structures are the vocabulary of algorithmic problem-solving. Master them, and you'll be able to express solutions to any problem efficiently and elegantly.**
