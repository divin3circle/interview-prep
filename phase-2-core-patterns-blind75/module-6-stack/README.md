# Module 6: Stack

## Pattern Overview

The Stack pattern uses Last-In-First-Out (LIFO) data structure to solve problems involving nested structures, matching pairs, or monotonic sequences.

## When to Use This Pattern

### Strong Signals

1. **Matching pairs** (parentheses, brackets) → Stack
2. **Nested structures** → Stack for tracking depth
3. **"Next greater/smaller element"** → Monotonic stack
4. **Reverse Polish Notation** → Stack for evaluation
5. **Undo operations** → Stack for history

## Core Techniques

### Technique 1: Matching Pairs
Push opening symbols onto the stack. When a closing symbol is encountered, pop the top element and verify it matches the current closer. If the stack is empty when needing to pop, or if the symbols don't match, the expression is invalid.

### Technique 2: Monotonic Stack
Used to find the next/previous greater/smaller element. Maintain a stack where elements are strictly increasing or decreasing. When a new element violates the order, pop from the stack until the property can be restored.

## Problems in This Module

1. Valid Parentheses
2. Min Stack
3. Evaluate Reverse Polish Notation
4. Daily Temperatures
5. Car Fleet
6. Largest Rectangle in Histogram

[View problems in subdirectories]

## Key Takeaway

Stacks excel at problems with nested structures or when you need to track "most recent" elements.
