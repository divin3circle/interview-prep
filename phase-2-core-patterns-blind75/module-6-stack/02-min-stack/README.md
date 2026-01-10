# Min Stack

**Difficulty**: Medium  
**Pattern**: Stack  
**Companies**: Google, Amazon, Facebook, Microsoft, Bloomberg

## Problem Statement

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the `MinStack` class:
- `MinStack()` initializes the stack object.
- `void push(int val)` pushes the element `val` onto the stack.
- `void pop()` removes the element on the top of the stack.
- `int top()` gets the top element of the stack.
- `int getMin()` retrieves the minimum element in the stack.

You must implement a solution with O(1) time complexity for each function.

## Examples

### Example 1
```
Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
```

## Constraints

- `-2^31 <= val <= 2^31 - 1`
- Methods `pop`, `top` and `getMin` operations will always be called on non-empty stacks.
- At most `3 * 10^4` calls will be made to `push`, `pop`, `top`, and `getMin`.

## Theoretical Concepts

### Augmented Data Structures
To achieve O(1) for `getMin`, we must augment the standard stack behavior. We need to store extra information about the state of the stack at every step.

### Incremental State Maintenance
When pushing an element, the minimum value in the stack *as it exists at that moment* is fixed. Even if we pop later elements, that minimum value remains valid for that specific prefix of the stack.

### Implementation Strategies
1. **Two Stacks**: Maintain a main stack for values and a parallel `minStack` where `minStack.peek()` is the minimum of all values currently in the main stack.
2. **Stack of Pairs**: Store `(value, currentMin)` pairs in a single stack.
3. **Difference Strategy**: Store the difference between the val and the actual min (advanced, avoids extra space but risks overflow if not careful).

## Approach

### Two-Stack Approach (Optimal)
**Time**: O(1) for all operations, **Space**: O(n)

Keep a secondary stack `minStack`. When pushing `x`, push `min(x, minStack.peek())` to `minStack`. This ensures the minimum for the current stack height is always available at the top of the `minStack`.

**Why it's optimal**: Meets all O(1) requirements with clean, understandable logic.

## Solution

See [solution.java](solution.java) for implementation.

## Key Insights

1. **Space-Time Tradeoff**: Use O(n) auxiliary space to achieve O(1) time for `getMin`.
2. **Invariant**: `minStack.peek()` always represents the minimum value in `mainStack`.
3. **Synchronized Operations**: Always push and pop from both stacks simultaneously to keep them in sync.

## Edge Cases

- **Duplicate minimums**: Pushing `[-2, 0, -2]` and then popping.
- **Empty stack operations**: Per constraints, we assume pop/top/getMin are only called on non-empty stacks.
- **Integer limits**: Using `-2^31` or `2^31 - 1`.
- **Single element stack**.

## Related Problems

- Max Stack (LeetCode 716)
- Sliding Window Maximum (LeetCode 239)
- Largest Rectangle in Histogram (LeetCode 84)
