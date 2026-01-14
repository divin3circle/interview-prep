# Reorder List

**Difficulty**: Medium
**Pattern**: Linked List (Fast/Slow + Reverse + Merge)

## Problem Statement

You are given the head of a singly linked-list. The list can be represented as: `L0 → L1 → … → Ln-1 → Ln`

Reorder the list to be on the following form: `L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …`

You may not modify the values in the list's nodes. Only nodes themselves may be changed.

## Approach

### Three Steps (Optimal)
1. **Find Middle**: Use fast/slow pointers.
2. **Reverse Second Half**: Reverse from middle to end.
3. **Merge**: Interleave first half with reversed second half.

**Time**: O(N)
**Space**: O(1)

## Go Solution

```go
func reorderList(head *ListNode) {
    if head == nil || head.Next == nil {
        return
    }
    
    // Step 1: Find middle
    slow, fast := head, head
    for fast.Next != nil && fast.Next.Next != nil {
        slow = slow.Next
        fast = fast.Next.Next
    }
    
    // Step 2: Reverse second half
    second := reverseList(slow.Next)
    slow.Next = nil
    
    // Step 3: Merge
    first := head
    for second != nil {
        tmp1, tmp2 := first.Next, second.Next
        first.Next = second
        second.Next = tmp1
        first, second = tmp1, tmp2
    }
}

func reverseList(head *ListNode) *ListNode {
    var prev *ListNode
    for head != nil {
        next := head.Next
        head.Next = prev
        prev = head
        head = next
    }
    return prev
}
```
