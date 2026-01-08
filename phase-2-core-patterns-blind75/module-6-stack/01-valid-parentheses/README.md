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

```
Input: s = "()"
Output: true

Input: s = "()[]{}"
Output: true

Input: s = "(]"
Output: false
```

## Approach

Use stack to track opening brackets. When closing bracket found, check if it matches top of stack.

**Time**: O(n), **Space**: O(n)

## Solution

See [solution.java](solution.java)
