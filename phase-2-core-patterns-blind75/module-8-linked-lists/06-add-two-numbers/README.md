# Add Two Numbers

**Difficulty**: Medium  
**Pattern**: Linked List (Linear Traversal / Math Simulation)  
**Companies**: Amazon, Google, Microsoft, Facebook, Apple, Bloomberg

## Problem Statement

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in **reverse order**, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

## Examples

### Example 1
```
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
```

### Example 2
```
Input: l1 = [0], l2 = [0]
Output: [0]
```

### Example 3
```
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
```

## Constraints

- The number of nodes in each linked list is in the range `[1, 100]`.
- `0 <= Node.val <= 9`
- It is guaranteed that the list represents a number that does not have leading zeros.

## Theoretical Concepts

### Elementary Math Simulation
When adding two numbers by hand, we process digits from right to left (least significant to most significant), adding them and managing a "carry" value. Since the linked lists are in reverse order, we can process them from head to tail exactly as we would perform manual addition.

### Carry Logic
- `sum = val1 + val2 + carry`
- `digit to store = sum % 10`
- `new carry = sum / 10`

### Dummy Node Pattern
Using a dummy node allows us to easily build the result list without special-casing the head node creation.

## Approach

### Sum Simulation with Linked List (Optimal)
**Time**: O(max(n, m)), **Space**: O(max(n, m)) for the result list.

1. Create a `dummy` node and set `curr` to it. Initialize `carry = 0`.
2. While `l1 != null`, `l2 != null`, or `carry != 0`:
   - Get values from `l1` and `l2` (if available), otherwise use 0.
   - Calculate `sum = val1 + val2 + carry`.
   - Update `carry = sum / 10`.
   - Create a new node with `sum % 10` and attach to `curr.next`.
   - Advance `l1`, `l2`, and `curr`.
3. Return `dummy.next`.

**Why it's optimal**: We visit each node exactly once and only allocate memory required for the answer.

## Solution

See [solution.java](solution.java) for implementation.

## Key Insights

1. **Reverse order is a gift**: If the lists were in forward order, we would need to reverse them first (or use a stack).
2. **Carry handling at the end**: Don't forget to add a final node if a carry exists after both lists are exhausted.
3. **Uneven lengths**: The `while` loop condition should handle lists of different lengths gracefully.

## Edge Cases

- **Numbers have different lengths**.
- **Sum results in a new most significant digit** (e.g., `99 + 1 = 100`).
- **One or both numbers are 0**.
- **Very large numbers** (that exceed standard `long` limits—the linked list handles this naturally).

## Related Problems

- Add Two Numbers II (LeetCode 445) - digits are in forward order.
- Multiply Strings (LeetCode 43)
- Sum of Two Integers (LeetCode 371)
