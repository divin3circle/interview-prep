# Strings

## Overview

In Go, strings are **immutable sequences of bytes** (usually UTF-8 encoded). 
Unlike Java, `string` in Go is a value type (a header containing a pointer and length), but since it's immutable, passing it is cheap and safe.

## Key Concepts

### 1. Immutability
You cannot change a character in a string directly.
```go
s := "hello"
s[0] = 'H' // Compile Error!
```
To modify, you convert to `[]byte` or `[]rune`.

### 2. Bytes vs Runes
- `s[i]` accesses the **byte** at index i.
- `for i, r := range s` iterates over **runes** (Unicode Code Points).
- `len(s)` returns number of **bytes**, not characters. `utf8.RuneCountInString(s)` returns characters.

### 3. String Construction
- **concatenation (`+`)**: Costly in loops (O(n²)).
- **`strings.Builder`**: Efficient, O(1) amortized append. Use this!

## Common Operations & Complexity

| Operation | Method | Time Complexity |
|-----------|--------|-----------------|
| Access Byte | `s[i]` | O(1) |
| Length | `len(s)` | O(1) (bytes) |
| Substring | `s[start:end]` | O(1) (shares memory) |
| Search | `strings.Index(s, sub)` | O(n*m) |
| Contains | `strings.Contains(s, sub)` | O(n*m) |
| Concatenation | `+` | O(n) |
| Builder | `sb.WriteString()` | O(1) amortized |

## Interview Tips

- **Use `strings.Builder`** for loops.
- **Comparison**: `==` compares content in Go (unlike Java Ref comparison). `s1 == s2` is safe.
- **Conversions**:
  - `strconv.Atoi("123")` (String to Int)
  - `strconv.Itoa(123)` (Int to String)
  - `[]byte(s)` (Mutable byte slice)

## Related Patterns
- **Two Pointers**: `IsPalindrome`.
- **Sliding Window**: `LongestSubstringWithoutRepeating`.
- **Map**: `Anagram` counting.
