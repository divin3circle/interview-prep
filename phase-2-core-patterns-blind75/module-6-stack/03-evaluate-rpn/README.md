# Evaluate Reverse Polish Notation

**Difficulty**: Medium  
**Pattern**: Stack  
**Companies**: Google, Amazon, Microsoft, LinkedIn

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

### Example 3
```
Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
Output: 22
Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5 = 22
```

## Constraints

- `1 <= tokens.length <= 10^4`
- `tokens[i]` is either an operator (`+`, `-`, `*`, or `/`) or an integer in the range `[-200, 200]`.

## Theoretical Concepts

### Postfix (RPN) vs Infix Notation
- **Infix**: `(a + b) * c`. Requires parentheses to define precedence.
- **Postfix (RPN)**: `a b + c *`. Operands come before operators. No parentheses needed; the order of operations is unambiguous.

### Stack-Based Evaluation
The stack is the natural data structure for evaluating RPN because it allows us to store operands and apply operators to the most recently encountered values:
- When an **operand** is seen: Push to stack.
- When an **operator** is seen: Pop two operands, apply the operator, and push the result back.

### Operator Commutativity and Stack Order
For non-commutative operations like subtraction and division, the order of popping matters:
- `tokens = ["a", "b", "-"]` means `a - b`.
- When popping, `b` (the second operand) comes off first, then `a` (the first operand).
- Calculation: `result = secondPopped - firstPopped`? **No**, it's `result = firstOperand - secondOperand`.
- Consistent logic: `int b = stack.pop(); int a = stack.pop(); return a - b;`

## Approach

### Stack Evaluation (Optimal)
**Time**: O(n), **Space**: O(n)

Iterate through the `tokens`. Use a stack to hold numbers. Switch on operators to perform arithmetic.

**Why it's optimal**: We parse the input tokens exactly once.

## Solution

See [solution.java](solution.java) for implementation.

## Key Insights

1. **No precedence handling needed**: RPN inherently handles order of operations.
2. **Order of operands in non-commutative ops**: Pop `b` then `a`, compute `a op b`.
3. **Integer conversion**: Use `Integer.parseInt()` for operands.

## Edge Cases

- **Negative numbers**: `["2", "-1", "+"]` → `1`.
- **Division truncation**: `["13", "5", "/"]` → `2`.
- **Long expressions**: Large intermediate values (though constrained to 32-bit).
- **Single operand expressions**: `["10"]` → `10`.

## Related Problems

- Basic Calculator (LeetCode 224)
- Basic Calculator II (LeetCode 227)
- Expression Add Operators (LeetCode 282)
