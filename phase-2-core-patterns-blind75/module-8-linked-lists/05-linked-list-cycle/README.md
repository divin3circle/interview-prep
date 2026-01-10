# Linked List Cycle

**Difficulty**: Easy  
**Pattern**: Linked List (Fast/Slow Pointers / Floyd's Cycle Detection)  
**Companies**: Google, Amazon, Microsoft, Facebook, Bloomberg

## Problem Statement

Given `head`, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the `next` pointer. Internally, `pos` is used to denote the index of the node that tail's `next` pointer is connected to. **Note that `pos` is not passed as a parameter.**

Return `true` if there is a cycle in the linked list. Otherwise, return `false`.

## Examples

### Example 1
```
Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
```

### Example 2
```
Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
```

### Example 3
```
Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.
```

## Constraints

- The number of the nodes in the list is in the range `[0, 10^4]`.
- `-10^5 <= Node.val <= 10^5`
- `pos` is `-1` or a valid index in the linked-list.

## Theoretical Concepts

### Floyd's Cycle-Finding Algorithm (Tortoise and Hare)
This is a pointer algorithm that uses two pointers moving at different speeds:
- **Slow Pointer (`slow`)**: Moves 1 step at a time.
- **Fast Pointer (`fast`)**: Moves 2 steps at a time.
If there is no cycle, `fast` will reach the end (`null`). If there is a cycle, the two pointers will eventually meet (equal) inside the cycle.

### Why they meet
Think of two runners on a circular track. The faster runner will eventually lap the slower runner. In the discrete world of a linked list cycle, the distance between them decreases by 1 in each step, guaranteeing they will eventually land on the same node.

### HashMap/Set Approach
An alternative is tracking visited nodes using a `HashSet`. If we encounter a node already in the set, there is a cycle.
- **Time**: O(n)
- **Space**: O(n)

## Approach

### Fast and Slow Pointers (Optimal)
**Time**: O(n), **Space**: O(1)

1. Initialize `slow` and `fast` pointers at `head`.
2. Move `slow` by 1 and `fast` by 2 while `fast` and `fast.next` are not `null`.
3. If `slow == fast`, return `true`.
4. If loop terminates, return `false`.

**Why it's optimal**: We detect the cycle in linear time without any extra storage for visited nodes.

## Solution

See [solution.java](solution.java) for implementation.

## Key Insights

1. **Distance reduction**: The gap between fast and slow pointers essentially decreases until it reaches zero or the end.
2. **Space efficiency**: Pointer-based detection is superior to set-based detection for memory-sensitive environments.
3. **Safety checks**: Always check `fast != null` and `fast.next != null` to avoid null pointer exceptions.

## Edge Cases

- **Empty list** (`head == null`).
- **Single node with no cycle**.
- **Single node with cycle** (pointing to itself).
- **Two nodes with no cycle**.
- **Two nodes with cycle**.

## Related Problems

- Linked List Cycle II (LeetCode 142) - find the start of the cycle.
- Happy Number (LeetCode 202)
- Find the Duplicate Number (LeetCode 287)
