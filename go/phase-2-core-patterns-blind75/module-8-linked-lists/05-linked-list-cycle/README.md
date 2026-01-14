# Linked List Cycle

**Difficulty**: Easy
**Pattern**: Linked List (Floyd's Cycle Detection)

## Problem Statement

Given `head`, the head of a linked list, determine if the linked list has a cycle in it. Return `true` if there is a cycle, otherwise return `false`.

## Approach

### Floyd's Cycle Detection (Tortoise and Hare)
Use two pointers moving at different speeds.
1. Initialize `slow` and `fast` both at head.
2. Move `slow` by 1 step, `fast` by 2 steps.
3. If they meet, there's a cycle.
4. If `fast` reaches end (nil), no cycle.

**Time**: O(N)
**Space**: O(1)

## Go Solution

```go
func hasCycle(head *ListNode) bool {
    slow, fast := head, head
    
    for fast != nil && fast.Next != nil {
        slow = slow.Next
        fast = fast.Next.Next
        
        if slow == fast {
            return true
        }
    }
    
    return false
}
```

### Key Go Insights
- **Pointer Comparison**: `slow == fast` compares pointer addresses, not values.
