# Module 6: Stack

## Pattern Overview

The Stack pattern uses Last-In-First-Out (LIFO) data structure to solve problems involving nested structures, matching pairs, or monotonic sequences. In Go, slices are commonly used as stacks.

## Core Techniques (Go Style)

### 1. Slice as Stack
Go does not have a built-in `Stack` class found in Java. We use slices:
```go
stack := []int{}
// Push
stack = append(stack, val)
// Pop
val := stack[len(stack)-1]
stack = stack[:len(stack)-1]
// Peek
top := stack[len(stack)-1]
// Empty check
if len(stack) == 0 { ... }
```

### 2. Matching Pairs
Common for parentheses validation.
Push openers, pop on closers if they match top.

### 3. Monotonic Stack
Keep stack sorted (increasing or decreasing) by popping elements that violate the order.
Used for "next greater/smaller element" problems.
```go
// Decreasing stack (for Next Greater Element)
for len(stack) > 0 && stack[len(stack)-1] < currentVal {
    // Process popped element
    stack = stack[:len(stack)-1]
}
stack = append(stack, currentVal)
```

## Problems in This Module

### 1. Valid Parentheses
**Difficulty**: Easy
**Pattern**: Matching Stack
[View Problem](01-valid-parentheses/README.md)

### 2. Min Stack
**Difficulty**: Medium
**Pattern**: Two Stacks / Pair Stack
[View Problem](02-min-stack/README.md)

### 3. Evaluate Reverse Polish Notation
**Difficulty**: Medium
**Pattern**: Evaluation Stack
[View Problem](03-evaluate-rpn/README.md)

### 4. Daily Temperatures
**Difficulty**: Medium
**Pattern**: Monotonic Stack
[View Problem](04-daily-temperatures/README.md)

### 5. Car Fleet
**Difficulty**: Medium
**Pattern**: Monotonic Stack (Position/Speed)
[View Problem](05-car-fleet/README.md)

### 6. Largest Rectangle in Histogram
**Difficulty**: Hard
**Pattern**: Monotonic Stack (Area Max)
[View Problem](06-largest-rectangle/README.md)

## Common Mistakes in Go
- **Empty Stack Panic**: Always check `len(stack) > 0` before accessing `stack[len(stack)-1]`.
- **Reference vs Value**: When storing structs in stack, consider pointers if structs are large or need mutation, though commonly values are fine for simple problems.

## Interview Tips
- **LIFO**: Identify LIFO nature (processing most recent item first).
- **Stack Overflow**: Be mindful of recursion depth if implementing recursive DFS (implicit stack).
