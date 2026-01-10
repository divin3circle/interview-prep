# Module 8: Linked Lists

## Pattern Overview

Linked Lists require pointer manipulation and often use techniques like two pointers (fast/slow), reversal, or dummy nodes.

## Core Techniques

### Reverse Linked List
Iteratively flip the `next` pointer of each node to point to the `previous` node. Requires maintaining a `prev` reference and a `temporary` reference to the next node before overwriting it.

### Fast/Slow Pointers
Use two pointers that move at different speeds (usually 1 node vs 2 nodes per step). This is used for cycle detection (Floyd's Cycle-Finding Algorithm) or finding the middle/kth element of a list.

## Problems
1. Reverse Linked List
2. Merge Two Sorted Lists
3. Reorder List
4. Remove Nth Node From End
5. Linked List Cycle
6. Add Two Numbers

**Key Takeaway**: Master pointer manipulation and two-pointer techniques for linked lists.
