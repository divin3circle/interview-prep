# Add Two Numbers

**Difficulty**: Medium
**Pattern**: Linked List (Digit Addition with Carry)

## Problem Statement

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

## Examples

```
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807
```

## Approach

### Digit-by-Digit Addition with Carry
1. Create dummy node.
2. Track carry (initially 0).
3. While either list has nodes OR carry exists:
   - Sum = carry + val1 + val2.
   - Create new node with `sum % 10`.
   - Update carry = `sum / 10`.
4. Return `dummy.Next`.

**Time**: O(max(N, M))
**Space**: O(max(N, M))

## Go Solution

```go
func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
    dummy := &ListNode{}
    curr := dummy
    carry := 0
    
    for l1 != nil || l2 != nil || carry != 0 {
        sum := carry
        if l1 != nil {
            sum += l1.Val
            l1 = l1.Next
        }
        if l2 != nil {
            sum += l2.Val
            l2 = l2.Next
        }
        
        carry = sum / 10
        curr.Next = &ListNode{Val: sum % 10}
        curr = curr.Next
    }
    
    return dummy.Next
}
```
