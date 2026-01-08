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

```java
public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
        if (c == '(' || c == '[' || c == '{') {
            stack.push(c);
        } else {
            if (stack.isEmpty()) return false;
            char top = stack.pop();
            if ((c == ')' && top != '(') ||
                (c == ']' && top != '[') ||
                (c == '}' && top != '{')) {
                return false;
            }
        }
    }
    return stack.isEmpty();
}
```

### Technique 2: Monotonic Stack

```java
public int[] nextGreaterElement(int[] nums) {
    int[] result = new int[nums.length];
    Stack<Integer> stack = new Stack<>();
    
    for (int i = nums.length - 1; i >= 0; i--) {
        while (!stack.isEmpty() && stack.peek() <= nums[i]) {
            stack.pop();
        }
        result[i] = stack.isEmpty() ? -1 : stack.peek();
        stack.push(nums[i]);
    }
    return result;
}
```

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
