# Valid Parentheses

**Difficulty**: Easy  
**Pattern**: Stack  
**Companies**: Google, Amazon, Facebook, Microsoft, Apple

## Problem Statement

Given a string `s` containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input string is valid.

An input string is valid if:
1. Open brackets must be closed by the same type of brackets
2. Open brackets must be closed in the correct order
3. Every close bracket has a corresponding open bracket of the same type

## Examples

### Example 1
```
Input: s = "()"
Output: true
```

### Example 2
```
Input: s = "()[]{}"
Output: true
```

### Example 3
```
Input: s = "(]"
Output: false
```

## Constraints

- `1 <= s.length <= 10^4`
- `s` consists of parentheses only `'()[]{}'`.

## Theoretical Concepts

### Stack LIFO Principle
A stack is a Last-In, First-Out (LIFO) data structure. It is ideal for problems involving nested structures or "matching" because:
- The last opening bracket we see must be the first one to be closed.
- We push opening brackets onto the stack and pop them when we find a corresponding closing bracket.

### Mapping for Clean Code
Using a HashMap to store the relationships between opening and closing brackets (e.g., `')' -> '('`) makes the code cleaner and more extensible. This allows us to handle new types of brackets by simply adding them to the map.

### Correct Closure Invariants
At any point while processing a closing bracket:
1. The stack must not be empty (otherwise, we have a "dangling" closing bracket).
2. The top of the stack must match the current closing bracket's opening pair.
3. At the end of the process, the stack must be empty (otherwise, we have "unclosed" opening brackets).

## Approach

### Stack-Based Matching (Optimal)
**Time**: O(n), **Space**: O(n)

Iterate through the string. Push opening brackets. For closing brackets, pop from the stack and verify the match.

**Why it's optimal**: We visit each character exactly once and use minimal auxiliary space required for the nesting depth.

## Solution

See [solution.java](solution.java) for implementation.

## Key Insights

1. **Stack for nested matching**: The core technique for balanced expressions.
2. **HashMap/Switch for pairs**: Decouples logic from specific characters.
3. **Empty stack check at end**: Crucial for strings like `"("`.
4. **Early exit**: If we see a mismatch, we can return `false` immediately.

## Edge Cases

- **Single character**: `"("` or `")"` → `false`
- **Only opening brackets**: `"((("` → `false`
- **Only closing brackets**: `")))"` → `false`
- **Correct type, wrong order**: `"([)]"` → `false`
- **Interleaved correct pairs**: `"([])"` → `true`
- **Empty string**: Constraint says length >= 1, but technically `true` for general cases.

## Related Problems

- Generate Parentheses (LeetCode 22)
- Longest Valid Parentheses (LeetCode 32)
- Score of Parentheses (LeetCode 856)
