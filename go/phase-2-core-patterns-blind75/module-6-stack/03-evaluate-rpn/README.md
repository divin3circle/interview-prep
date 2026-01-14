# Evaluate Reverse Polish Notation

**Difficulty**: Medium
**Pattern**: Stack

## Problem Statement

You are given an array of strings `tokens` that represents an arithmetic expression in Reverse Polish Notation (RPN).

Evaluate the expression. Return an integer that represents the value of the expression.

Note that:
- The valid operators are `+`, `-`, `*`, and `/`.
- Each operand may be an integer or another expression.
- The division between two integers always truncates toward zero.
- There will not be any division by zero.
- The input represents a valid arithmetic expression in reverse polish notation.
- The answer and all the intermediate calculations can be represented in a 32-bit integer.

## Examples

### Example 1
```
Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
```

### Example 2
```
Input: tokens = ["4","13","5","/","+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
```

## Approach

### Stack (Optimal)
Use a stack to numbers.
1. Iterate through tokens.
2. If token is a number, push to stack.
3. If token is an operator:
   - Pop two numbers. **Note**: The first popped is the *second* operand (`b`), the second popped is the *first* operand (`a`).
   - Perform `a op b`.
   - Push result back to stack.
4. The final result is the only element left in the stack.

**Time**: O(N)
**Space**: O(N)

## Go Solution

```go
func evalRPN(tokens []string) int {
    stack := []int{}
    
    for _, token := range tokens {
        switch token {
        case "+":
            b := stack[len(stack)-1]; stack = stack[:len(stack)-1]
            a := stack[len(stack)-1]; stack = stack[:len(stack)-1]
            stack = append(stack, a+b)
        case "-":
            b := stack[len(stack)-1]; stack = stack[:len(stack)-1]
            a := stack[len(stack)-1]; stack = stack[:len(stack)-1]
            stack = append(stack, a-b)
        case "*":
            b := stack[len(stack)-1]; stack = stack[:len(stack)-1]
            a := stack[len(stack)-1]; stack = stack[:len(stack)-1]
            stack = append(stack, a*b)
        case "/":
            b := stack[len(stack)-1]; stack = stack[:len(stack)-1]
            a := stack[len(stack)-1]; stack = stack[:len(stack)-1]
            stack = append(stack, a/b)
        default:
            val, _ := strconv.Atoi(token)
            stack = append(stack, val)
        }
    }
    return stack[0]
}
```

### Key Go Insights
- **`strconv.Atoi`**: Converts string to int.
- **Switch**: Clean way to handle operators.
- **Slice as Stack**: Standard pattern.

## Edge Cases
- Negative results.
- Division truncation (handled by Go's integer division).
- Single number input.
