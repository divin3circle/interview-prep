# Linked Lists

## Introduction

A Linked List is a linear data structure where elements are not stored in contiguous memory types. Each element (node) contains a value and a pointer to the next node.

## Types

### Singly Linked List
Each node has a value and a `Next` pointer.
```go
type ListNode struct {
    Val  int
    Next *ListNode
}
```

### Doubly Linked List
Each node has a value, `Next` pointer, and `Prev` pointer.
```go
type DoublyNode struct {
    Val  int
    Prev *DoublyNode
    Next *DoublyNode
}
```

## Comparisons

| Operation | Linked List | Array/Slice |
|-----------|-------------|-------------|
| Access | O(n) | O(1) |
| Insert (Head) | O(1) | O(n) |
| Insert (Middle) | O(n) | O(n) |
| Delete (Head) | O(1) | O(n) |

## When to Use

- **Use Linked List**: When you need constant-time insertions/deletions at the beginning, or when you don't know the size and memory fragmentation is a concern (though modern allocators make slices efficiently).
- **Use Slice**: For almost everything else (better cache locality).

## Common Patterns

1. **Two Pointers**: Fast/Slow runner (Detect cycle, Find middle).
2. **Reversal**: Iterative or recursive.
3. **Dummy Head**: Simplifies edge cases (inserting/deleting at head).
```go
dummy := &ListNode{Next: head}
// ... operations ...
return dummy.Next
```
