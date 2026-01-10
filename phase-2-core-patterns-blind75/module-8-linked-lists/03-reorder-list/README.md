# Reorder List

**Difficulty**: Medium  
**Pattern**: Linked List (Fast/Slow Pointers, Reversal, Merging)  
**Companies**: Google, Amazon, Facebook, Microsoft

## Problem Statement

You are given the head of a singly linked-list. The list can be represented as:
`L0 → L1 → … → Ln-1 → Ln`

Reorder the list to be on the following form:
`L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …`

You may not modify the values in the list's nodes. Only nodes themselves may be changed.

## Examples

### Example 1
```
Input: head = [1,2,3,4]
Output: [1,4,2,3]
```

### Example 2
```
Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]
```

## Constraints

- The number of nodes in the list is in the range `[1, 5 * 10^4]`.
- `1 <= Node.val <= 1000`

## Theoretical Concepts

### Multi-Step Linked List Manipulation
Complex linked list problems often require combining several primitives:
1. **Finding the Middle**: Using Fast and Slow pointers.
2. **Reversing a Sub-list**: Standard pointer reversal.
3. **Merging Lists**: Alternating nodes from two lists.

### Fast and Slow Pointers (Tortoise and Hare)
To find the middle of a list without knowing its length:
- `slow` moves 1 step, `fast` moves 2 steps.
- When `fast` reaches the end, `slow` is at the middle.

### Alternating Merge
Merging two lists by alternating their nodes requires careful pointer management to avoid losing references while rewiring.

## Approach

### Three-Phase Strategy (Optimal)
**Time**: O(n), **Space**: O(1)

1. **Find Middle**: Use fast/slow pointers to split the list into two halves.
2. **Reverse Second Half**: Reverse the second half of the list starting from the middle's next node.
3. **Merge Halves**: Interleave nodes from the first half and the reversed second half.

**Why it's optimal**: We achieve the reordering in linear time with constant extra space (in-place).

## Solution

See [solution.java](solution.java) for implementation.

## Key Insights

1. **Space optimization**: By reversing the second half in-place, we avoid using extra space (O(1)) compared to using an array (O(n)).
2. **Pointer isolation**: Remember to set the end of the first half to `null` to avoid cycles.
3. **Symmetry in merging**: The first half might be longer by one node in lists with odd lengths.

## Edge Cases

- **Single node list**.
- **Two nodes list**.
- **Even length list**.
- **Odd length list**.

## Related Problems

- Reverse Linked List (LeetCode 206)
- Merge Two Sorted Lists (LeetCode 21)
- Palindrome Linked List (LeetCode 234)
