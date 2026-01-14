# Stacks

## Introduction

A Stack is a LIFO (Last-In-First-Out) data structure.
Think of a stack of plates: you add to the top and remove from the top.

## Implementation in Go

### Using Slice (Recommended)
Go's slices are perfect for stacks.

```go
var stack []int

// Push
stack = append(stack, 10)

// Pop
val := stack[len(stack)-1]
stack = stack[:len(stack)-1]

// Peek
val := stack[len(stack)-1]
```

### Time Complexity

| Operation | Complexity |
|-----------|------------|
| Push | O(1) |
| Pop | O(1) |
| Peek | O(1) |
| Search | O(n) |

## Use Cases

- Function Call Stack (Recursion)
- Undo/Redo operations
- Balancing Symbols (Parentheses)
- DFS (Depth First Search)
