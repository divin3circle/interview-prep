# Merge Two Sorted Lists

**Difficulty**: Easy
**Pattern**: Linked List (Dummy Node)

## Problem Statement

You are given the heads of two sorted linked lists `list1` and `list2`. Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists. Return the head of the merged linked list.

## Approach

### Dummy Node (Optimal)
Use a dummy node to simplify edge cases.
1. Create `dummy` node.
2. Use `curr` pointer starting at `dummy`.
3. While both lists have nodes:
   - Compare values, attach smaller node to `curr`.
   - Move pointer in the list we took from.
   - Move `curr` forward.
4. Attach remaining nodes from non-empty list.
5. Return `dummy.Next`.

**Time**: O(N + M)
**Space**: O(1)

## Go Solution

```go
func mergeTwoLists(list1 *ListNode, list2 *ListNode) *ListNode {
    dummy := &ListNode{}
    curr := dummy
    
    for list1 != nil && list2 != nil {
        if list1.Val <= list2.Val {
            curr.Next = list1
            list1 = list1.Next
        } else {
            curr.Next = list2
            list2 = list2.Next
        }
        curr = curr.Next
    }
    
    if list1 != nil {
        curr.Next = list1
    } else {
        curr.Next = list2
    }
    
    return dummy.Next
}
```
