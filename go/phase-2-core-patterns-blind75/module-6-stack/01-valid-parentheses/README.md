# Valid Parentheses

**Difficulty**: Easy
**Pattern**: Stack

## Problem Statement

Given a string `s` containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input string is valid.

An input string is valid if:
1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.
3. Every close bracket has a corresponding open bracket of the same type.

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

## Approach

### Stack (Optimal)
Use a **Stack** data structure (LIFO).
1. Traverse the string char by char.
2. If it's an **opening bracket** (`(`, `{`, `[`), push it onto the stack.
3. If it's a **closing bracket** (`)`, `}`, `]`):
   - Check if stack is empty (invalid).
   - Pop the top element.
   - If the popped element doesn't match the current closing bracket, return `false`.
4. At the end, return `true` if stack is empty, else `false`.

**Time**: O(N)
**Space**: O(N)

## Go Solution

```go
func isValid(s string) bool {
    // Slice as stack
    stack := []rune{}
    
    // Map for easy lookup
    pairs := map[rune]rune{
        ')': '(',
        ']': '[',
        '}': '{',
    }
    
    for _, char := range s {
        // If it's a closing bracket
        if open, isClose := pairs[char]; isClose {
            // Check if stack empty
            if len(stack) == 0 {
                return false
            }
            // Pop
            top := stack[len(stack)-1]
            stack = stack[:len(stack)-1]
            
            if top != open {
                return false
            }
        } else {
            // It's an opening bracket, push
            stack = append(stack, char)
        }
    }
    
    return len(stack) == 0
}
```

### Key Go Insights
- **Stack Implementation**: Iterate using `range s` gives runes. Use a slice `[]rune` as stack.
- **Append**: Push with `append`.
- **Pop**: Access `stack[len-1]` and reslice `stack[:len-1]`.
- **Map optimized**: Using a map for pairs simplifies logic vs multiple `if/else`.

## Edge Cases
- Empty string (valid?).
- Odd length (invalid).
- Only closing brackets.
