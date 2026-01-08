# Evaluate Reverse Polish Notation

**Difficulty**: Medium  
**Pattern**: Stack  

## Problem Statement

Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are `+`, `-`, `*`, and `/`. Each operand may be an integer or another expression.

## Approach

Use stack. Push numbers, pop two operands when operator encountered, push result.

**Time**: O(n), **Space**: O(n)

## Solution

See [solution.java](solution.java)
