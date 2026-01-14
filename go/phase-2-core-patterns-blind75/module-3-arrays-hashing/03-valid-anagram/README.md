# Valid Anagram

**Difficulty**: Easy
**Pattern**: Arrays & Hashing

## Problem Statement

Given two strings `s` and `t`, return `true` if `t` is an anagram of `s`, and `false` otherwise.
An anagram is formed by rearranging letters. Character counts must match exactly.

## Examples

### Example 1
```
Input: s = "anagram", t = "nagaram"
Output: true
```

### Example 2
```
Input: s = "rat", t = "car"
Output: false
```

## Approach

### 1. Sorting (Okay)
- Sort both strings and compare.
- **Time**: O(n log n)
- **Space**: O(n) (to convert string to []byte/[]rune for sorting)

### 2. Frequency Array (Optimal)
- Since inputs are lowercase English letters, use `[26]int`.
- Increment count for `s`, decrement for `t`.
- **Time**: O(n)
- **Space**: O(1) (fixed size 26)

## Go Solution

```go
func isAnagram(s string, t string) bool {
    if len(s) != len(t) { return false }
    
    var count [26]int
    for i := 0; i < len(s); i++ {
        count[s[i] - 'a']++
        count[t[i] - 'a']--
    }
    
    for _, v := range count {
        if v != 0 { return false }
    }
    return true
}
```

### Key Go Insights
- **Byte Chars**: `s[i]` gives a `byte` (uint8). `s[i] - 'a'` is a valid index op.
- **Strings are Immutable**: But efficient to access by index O(1).
- **Arrays vs Slices**: Used `[26]int` (Array) not `[]int` (Slice) for slight optimization since size is fixed.

## Edge Cases
- Different lengths (impossible to be anagrams).
- Unicode? (Would need `map[rune]int` instead of array).
