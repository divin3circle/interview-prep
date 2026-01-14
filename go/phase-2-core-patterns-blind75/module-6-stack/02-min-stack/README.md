# Min Stack

**Difficulty**: Medium
**Pattern**: Stack

## Problem Statement

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the `MinStack` struct:
- `Constructor()` initializes the stack object.
- `Push(val int)` pushes the element `val` onto the stack.
- `Pop()` removes the element on the top of the stack.
- `Top() int` gets the top element of the stack.
- `GetMin() int` retrieves the minimum element in the stack.

You must implement a solution with O(1) time complexity for each function.

## Examples

### Example 1
```
Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]
```

## Approach

### Two Stacks (Optimal)
Maintain two stacks:
1. `stack`: Stores all values.
2. `minStack`: Stores the minimum values.
   - When pushing `val`: if `val <= minStack.top()`, push `val` to `minStack` as well.
   - When popping `val`: if `val == minStack.top()`, pop from `minStack` as well.
   - `GetMin()`: valid `minStack.top()`.

Alternatively, use a single stack of pairs `{val, currentMin}`. The two-stack approach saves space if the minimum doesn't change often.

**Time**: O(1) for all ops.
**Space**: O(N).

## Go Solution

```go
type MinStack struct {
    stack    []int
    minStack []int
}

func Constructor() MinStack {
    return MinStack{}
}

func (this *MinStack) Push(val int) {
    this.stack = append(this.stack, val)
    // If minStack is empty or val is new minimum (or equal)
    if len(this.minStack) == 0 || val <= this.minStack[len(this.minStack)-1] {
        this.minStack = append(this.minStack, val)
    }
}

func (this *MinStack) Pop() {
    if len(this.stack) == 0 { return }
    val := this.stack[len(this.stack)-1]
    this.stack = this.stack[:len(this.stack)-1]
    
    // If popped value was the current minimum
    if val == this.minStack[len(this.minStack)-1] {
        this.minStack = this.minStack[:len(this.minStack)-1]
    }
}

func (this *MinStack) Top() int {
    if len(this.stack) == 0 { return 0 }
    return this.stack[len(this.stack)-1]
}

func (this *MinStack) GetMin() int {
    if len(this.minStack) == 0 { return 0 }
    return this.minStack[len(this.minStack)-1]
}
```

### Key Go Insights
- **Struct Methods**: Use pointer receivers `(this *MinStack)` to mutate the stack.
- **Slice**: Standard Go dynamic arrays.

## Edge Cases
- Operations on empty stack (usually constraints say it won't happen).
- Duplicate minimums (`push(-2), push(-2)`).
