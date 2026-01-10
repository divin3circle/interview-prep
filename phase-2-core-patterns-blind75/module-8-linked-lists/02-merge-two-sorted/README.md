# Merge Two Sorted Lists

**Difficulty**: Easy  
**Pattern**: Linked List (Two Pointers / Merge Sort component)  
**Companies**: Google, Amazon, Microsoft, Facebook, Apple

## Problem Statement

You are given the heads of two sorted linked lists `list1` and `list2`.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

## Examples

### Example 1
```
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
```

### Example 2
```
Input: list1 = [], list2 = []
Output: []
```

### Example 3
```
Input: list1 = [], list2 = [0]
Output: [0]
```

## Constraints

- The number of nodes in both lists is in the range `[0, 50]`.
- `-100 <= Node.val <= 100`
- Both `list1` and `list2` are sorted in non-decreasing order.

## Theoretical Concepts

### Dummy Node Pattern
A "dummy" or "sentinel" node is a common technique used to simplify linked list code. It acts as a permanent placeholder at the start of the list, so we don't need to write special logic for the "first" node insertion. At the end, we simply return `dummy.next`.

### Two-Pointer Linear Merge
Since both lists are already sorted, we can use two pointers (one for each list) to compare values and build the new list in a single pass. This is identical to the "merge" step in Merge Sort.

### Tail Appending
After one of the lists is exhausted, the remaining part of the other list (which is already sorted) can be simply "appended" to the result list in O(1) time.

## Approach

### Iterative with Dummy Node (Optimal)
**Time**: O(n + m), **Space**: O(1)

1. Create a `dummy` node and a `tail` pointer.
2. While both lists are non-empty:
   - Attach the node with the smaller value to `tail.next`.
   - Move the pointer of the chosen list.
   - Move `tail`.
3. Attach any remaining nodes from the non-empty list.
4. Return `dummy.next`.

**Why it's optimal**: Linear time with no extra memory allocation for existing nodes.

## Solution

See [solution.java](solution.java) for implementation.

## Key Insights

1. **Dummy node simplifies edge cases**: Avoids `null` checks when starting the merged list.
2. **Sorted property maintenance**: We only compare the current heads because they represent the smallest remaining values.
3. **Efficiency**: We don't create new nodes; we just rewire existing ones.

## Edge Cases

- **One list is empty**.
- **Both lists are empty**.
- **Lists have different lengths**.
- **Lists contain duplicate values**.
- **Nodes have same values across lists**.

## Related Problems

- Merge k Sorted Lists (LeetCode 23)
- Sort List (LeetCode 148)
- Merge Sorted Array (LeetCode 88)
