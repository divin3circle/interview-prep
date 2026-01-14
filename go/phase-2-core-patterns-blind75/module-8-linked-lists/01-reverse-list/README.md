# Reverse Linked List

**Difficulty**: Easy
**Pattern**: Linked List (Pointer Manipulation)

## Problem Statement

Given the `head` of a singly linked list, reverse the list, and return the reversed list.

## Examples

### Example 1
```
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
```

### Example 2
```
Input: head = []
Output: []
```

## Approach

### Iterative (Optimal)
Use three pointers: `prev`, `curr`, and `next`.
1. Initialize `prev = nil`, `curr = head`.
2. While `curr != nil`:
   - Save `next = curr.Next`.
   - Reverse pointer: `curr.Next = prev`.
   - Move forward: `prev = curr`, `curr = next`.
3. Return `prev` (new head).

**Time**: O(N)
**Space**: O(1)

## Go Solution

```go
func reverseList(head *ListNode) *ListNode {
    var prev *ListNode
    curr := head
    
    for curr != nil {
        next := curr.Next
        curr.Next = prev
        prev = curr
        curr = next
    }
    return prev
}
```

## Edge Cases
- Empty list.
- Single node.
