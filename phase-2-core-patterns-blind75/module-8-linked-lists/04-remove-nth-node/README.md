# Remove Nth Node From End of List

**Difficulty**: Medium  
**Pattern**: Linked List (Two Pointers / Gap Strategy)  
**Companies**: Google, Amazon, Microsoft, Facebook

## Problem Statement

Given the `head` of a linked list, remove the `n`th node from the end of the list and return its head.

## Examples

### Example 1
```
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
```

### Example 2
```
Input: head = [1], n = 1
Output: []
```

### Example 3
```
Input: head = [1,2], n = 1
Output: [1]
```

## Constraints

- The number of nodes in the list is `sz`.
- `1 <= sz <= 30`
- `0 <= Node.val <= 100`
- `1 <= n <= sz`

## Theoretical Concepts

### Two-Pointer "Gap" Strategy
To find the `n`th node from the end in a single pass:
1. Use two pointers, `fast` and `slow`.
2. Move `fast` ahead by `n` steps.
3. Move both pointers together until `fast` reaches the end.
4. `slow` will now be pointing to the node **at** the `n`th position from the end (or right before it).

### Dummy Node Utility
Removing a node requires a reference to its **predecessor**. If we need to remove the head (the Nth node from the end), having a `dummy` node that points to the head gives us a universal predecessor for all cases.

## Approach

### One-Pass Two-Pointer (Optimal)
**Time**: O(n), **Space**: O(1)

1. Create a `dummy` node pointing to `head`.
2. Initialize `fast` and `slow` at `dummy`.
3. Move `fast` forward `n + 1` steps to create a gap of `n` between them.
4. Move both until `fast` is `null`.
5. Now `slow` is just before the target node. Perform `slow.next = slow.next.next`.
6. Return `dummy.next`.

**Why it's optimal**: We only traverse the list once.

## Solution

See [solution.java](solution.java) for implementation.

## Key Insights

1. **Predecessor identification**: You need the node *before* the one you want to delete.
2. **Gap maintenance**: The distance between pointers is the "memory" of how far from the end we are.
3. **Head removal**: The `dummy` node handles the case where `n` equals the list length.

## Edge Cases

- **Remove the head node** (`n == length`).
- **Remove the last node** (`n == 1`).
- **List with only one node**.
- **List with two nodes**.

## Related Problems

- Remove Linked List Elements (LeetCode 203)
- Delete Node in a Linked List (LeetCode 237)
- Middle of the Linked List (LeetCode 876)
