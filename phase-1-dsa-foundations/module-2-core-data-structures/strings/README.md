# Strings

## Overview
Strings are immutable sequences of characters in Java. Understanding how they work in memory (String Pool) and efficient manipulation (StringBuilder) is crucial for performance.

## Key Concepts

### 1. Immutability
Once a String object is created, its data cannot be changed. Modification creates a new object.
```java
String s = "hello";
s = s + " world"; // Creates a new String object
```

### 2. String Constant Pool
A special memory area in the Heap. String literals share references if they have the same content.
```java
String s1 = "Java";
String s2 = "Java"; // s1 == s2 is true
String s3 = new String("Java"); // s1 == s3 is false
```

### 3. StringBuilder vs StringBuffer
- **StringBuilder**: Mutable, not thread-safe, fast. Use this for string manipulation.
- **StringBuffer**: Mutable, thread-safe, slower. Legacy.

## Common Operations & Complexity

| Operation | Method | Time Complexity |
|-----------|--------|-----------------|
| Access | `charAt(i)` | O(1) |
| Length | `length()` | O(1) |
| Substring | `substring(begin, end)` | O(n) |
| Search | `indexOf(str)` | O(n*m) |
| Concatenation | `+` or `concat()` | O(n) |
| Builder Append | `sb.append()` | O(1) amortized |

## Interview Tips
- **Always use StringBuilder** for loops or repeated modifications.
- be aware of `substring` creating new strings (copying char array).
- Comparisons: Use `.equals()` for content, `==` for reference.

## Related Patterns
- Two Pointers (Palindromes)
- Sliding Window (Substring problems)
- Hashing (Anagrams)
