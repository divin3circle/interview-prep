# Module 8: Linked Lists

## Pattern Overview

Linked Lists require pointer manipulation and often use techniques like two pointers (fast/slow), reversal, or dummy nodes.

## Core Techniques

### Reverse Linked List
```java
public ListNode reverse(ListNode head) {
    ListNode prev = null, curr = head;
    while (curr != null) {
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    return prev;
}
```

### Fast/Slow Pointers
```java
public ListNode findMiddle(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
}
```

## Problems
1. Reverse Linked List
2. Merge Two Sorted Lists
3. Reorder List
4. Remove Nth Node From End
5. Linked List Cycle
6. Add Two Numbers

**Key Takeaway**: Master pointer manipulation and two-pointer techniques for linked lists.
