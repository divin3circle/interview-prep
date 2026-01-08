# Linked Lists

## Overview
A Linked List is a linear data structure where elements are stored in nodes. Each node contains data and a reference (link) to the next node. Unlike arrays, elements are not stored in contiguous memory locations.

## Types

### 1. Singly Linked List
Each node points only to the next node.
- **Pros**: Simple, less memory per node.
- **Cons**: Cannot traverse backward.

### 2. Doubly Linked List
Each node points to both next and previous nodes.
- **Pros**: Bidirectional traversal, O(1) deletion if node is known.
- **Cons**: More memory (2 pointers), more complex pointer manipulation.

### 3. Circular Linked List
Last node points back to first.

## Key Concepts

### Node Structure
```java
// Singly
class Node {
    int val;
    Node next;
}

// Doubly
class Node {
    int val;
    Node next;
    Node prev;
}
```

## Operations Complexity

| Operation | Singly LL | Doubly LL | Array |
|-----------|-----------|-----------|-------|
| Access (Get i-th) | O(n) | O(n) | O(1) |
| Insert Head | O(1) | O(1) | O(n) |
| Insert Tail | O(n)* | O(1)* | O(1)** |
| Delete Head | O(1) | O(1) | O(n) |
| Search | O(n) | O(n) | O(n) |

*\* O(1) if tail pointer is maintained.*
*\*\* Amortized O(1) for dynamic array.*

## Interview Tips
- **Dummy Heads**: Use a dummy node to simplify edge cases (inserting at head, merging).
- **Two Pointers**: "Runner" technique (Fast & Slow) is key for finding cycles and midpoints.
- **Pointer Hygiene**: Always verify `node != null` before accessing `node.next`.

## Implementations
- [SinglyLinkedList.java](singly/SinglyLinkedList.java) - Standard implementation.
- [DoublyLinkedList.java](doubly/DoublyLinkedList.java) - Bidirectional implementation.
