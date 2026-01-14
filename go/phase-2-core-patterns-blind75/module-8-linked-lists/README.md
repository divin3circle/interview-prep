# Module 8: Linked Lists

## Pattern Overview

Linked Lists require pointer manipulation and often use techniques like two pointers (fast/slow), reversal, or dummy nodes. In Go, we define a `ListNode` struct and work with pointers.

## Core Techniques (Go Style)

### 1. ListNode Definition
```go
type ListNode struct {
    Val  int
    Next *ListNode
}
```

### 2. Dummy Node Pattern
Create a dummy head to simplify edge cases (empty list, single node).
```go
dummy := &ListNode{}
dummy.Next = head
// ... manipulate list
return dummy.Next
```

### 3. Reverse Linked List
```go
var prev *ListNode
curr := head
for curr != nil {
    next := curr.Next
    curr.Next = prev
    prev = curr
    curr = next
}
return prev
```

### 4. Fast/Slow Pointers
```go
slow, fast := head, head
for fast != nil && fast.Next != nil {
    slow = slow.Next
    fast = fast.Next.Next
}
// slow is at middle or cycle detection point
```

## Problems in This Module

### 1. Reverse Linked List
**Difficulty**: Easy
[View Problem](01-reverse-list/README.md)

### 2. Merge Two Sorted Lists
**Difficulty**: Easy
[View Problem](02-merge-two-sorted/README.md)

### 3. Reorder List
**Difficulty**: Medium
[View Problem](03-reorder-list/README.md)

### 4. Remove Nth Node From End
**Difficulty**: Medium
[View Problem](04-remove-nth-node/README.md)

### 5. Linked List Cycle
**Difficulty**: Easy
[View Problem](05-linked-list-cycle/README.md)

### 6. Add Two Numbers
**Difficulty**: Medium
[View Problem](06-add-two-numbers/README.md)

## Common Mistakes in Go
- **Nil Pointer Dereference**: Always check `node != nil` before accessing `node.Next` or `node.Val`.
- **Pointer vs Value**: `*ListNode` is a pointer. Assigning `node = node.Next` moves the pointer, doesn't modify the original list.

## Interview Tips
- **Draw it out**: Visualize pointer movements on paper.
- **Edge cases**: Empty list, single node, two nodes.
