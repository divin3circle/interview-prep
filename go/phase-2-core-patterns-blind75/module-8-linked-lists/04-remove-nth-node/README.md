# Remove Nth Node From End of List

**Difficulty**: Medium
**Pattern**: Linked List (Two Pointers)

## Problem Statement

Given the `head` of a linked list, remove the `nth` node from the end of the list and return its head.

## Approach

### Two Pointers with Gap (Optimal)
Use two pointers with a gap of `n` nodes.
1. Create dummy node pointing to head.
2. Initialize `first` and `second` both at dummy.
3. Move `first` ahead by `n+1` steps.
4. Move both pointers until `first` reaches end.
5. Now `second` is just before the node to remove.
6. Skip the node: `second.Next = second.Next.Next`.

**Time**: O(N)
**Space**: O(1)

## Go Solution

```go
func removeNthFromEnd(head *ListNode, n int) *ListNode {
    dummy := &ListNode{Next: head}
    first, second := dummy, dummy
    
    // Move first n+1 steps ahead
    for i := 0; i <= n; i++ {
        first = first.Next
    }
    
    // Move both until first reaches end
    for first != nil {
        first = first.Next
        second = second.Next
    }
    
    // Remove nth node
    second.Next = second.Next.Next
    return dummy.Next
}
```
