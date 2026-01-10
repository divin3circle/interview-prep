# Reverse Linked List

**Difficulty**: Easy  
**Pattern**: Linked List (Pointer Manipulation)  
**Companies**: Google, Amazon, Facebook, Microsoft, Apple, Bloomberg

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
Input: head = [1,2]
Output: [2,1]
```

### Example 3
```
Input: head = []
Output: []
```

## Constraints

- The number of nodes in the list is the range `[0, 5000]`.
- `-5000 <= Node.val <= 5000`

## Theoretical Concepts

### Singly Linked List Structure
A linked list consists of nodes where each node contains:
1. **Data**: The value stored in the node.
2. **Next Pointer**: A reference to the subsequent node in the sequence.

### Pointer Reversal
Reversing a linked list is fundamentally about changing the direction of the `next` pointers. Instead of `A -> B -> C`, we want `A <- B <- C`.

### Iterative vs Recursive Approaches
- **Iterative**: Uses three pointers (`prev`, `curr`, `next`) to track state while traversing the list once.
- **Recursive**: Exploits the call stack to reach the end of the list and then perform the pointer reversal while unwinding.

## Approach

### Iterative Pointer Manipulation (Optimal)
**Time**: O(n), **Space**: O(1)

1. Initialize `prev` as `null` and `curr` as `head`.
2. While `curr` is not `null`:
   - Store `nextTemp = curr.next`.
   - Reverse the pointer: `curr.next = prev`.
   - Move forward: `prev = curr`, `curr = nextTemp`.
3. Return `prev` (new head).

**Why it's optimal**: Linear time with constant extra space.

### Recursive Approach
**Time**: O(n), **Space**: O(n) due to the call stack depth.

**Why it's used**: Demonstrates elegant recursive thinking, though less space-efficient than the iterative approach.

## Solution

See [solution.java](solution.java) for implementation.

## Key Insights

1. **Three-pointer shuffle**: `prev`, `curr`, and a temporary `next` are essential for iterative reversal.
2. **Base cases**: Handle the empty list (`head == null`) and single-node list.
3. **New head**: The `prev` pointer ends up at the last node of the original list, which becomes the new head.

## Edge Cases

- **Empty list** (`head == null`).
- **Single node list**.
- **Two nodes list**.
- **Large number of nodes** (recursive might hit stack overflow).

## Related Problems

- Reverse Linked List II (LeetCode 92)
- Palindrome Linked List (LeetCode 234)
- Swap Nodes in Pairs (LeetCode 24)
