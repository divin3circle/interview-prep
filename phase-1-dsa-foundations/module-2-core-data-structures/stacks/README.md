# Stacks

## Overview
A Stack is a linear data structure that follows the **LIFO** (Last In, First Out) principle. The last element added is the first one removed.

## Core Operations

| Operation | Description | Complexity |
|-----------|-------------|------------|
| `push(x)` | Add item to top | O(1) |
| `pop()` | Remove item from top | O(1) |
| `peek()` | View item at top | O(1) |
| `isEmpty()` | Check if stack empty | O(1) |

## Implementation in Java
Java provides `java.util.Stack`, but it is legacy and synchronized (slower).
**Recommended**: Use `ArrayDeque` as a Stack.
```java
Deque<Integer> stack = new ArrayDeque<>();
stack.push(10);
stack.pop();
```

## Common Use Cases
1. **Function Call Stack**: Recursion.
2. **Undo Mechanisms**: Text editors.
3. **Expression Evaluation**: Parsing math like `(1 + 2) * 3`.
4. **Backtracking**: Maze solving, DFS.

## Interview Tips
- **Stack Overflow**: Be aware of recursion depth limits.
- **Empty Checks**: Always check `!stack.isEmpty()` before popping/peeking to avoid exceptions.
- **Monotonic Stack**: A powerful variation where elements are kept in sorted order (used in problems like Next Greater Element).
