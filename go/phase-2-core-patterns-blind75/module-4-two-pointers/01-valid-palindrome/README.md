# Valid Palindrome

**Difficulty**: Easy
**Pattern**: Two Pointers

## Problem Statement

A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string `s`, return `true` if it is a palindrome, or `false` otherwise.

## Examples

### Example 1
```
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome
```

### Example 2
```
Input: s = "race a car"
Output: false
```

## Approach

### Two Pointers (Optimal)
- Initialize two pointers: `left` at start, `right` at end.
- Move `left` forward until it hits an alphanumeric char.
- Move `right` backward until it hits an alphanumeric char.
- Compare characters (case-insensitive).
- If mismatch, return `false`.
- Repeat until `left >= right`.
- **Time**: O(n)
- **Space**: O(1) (In-place)

## Go Solution

```go
func isPalindrome(s string) bool {
    // Convert to runes to handle potentially multi-byte chars correctly,
    // though usually these problems are ASCII.
    // Optimal way avoids allocation by indexing string directly if ASCII is guaranteed.
    // Here we use direct string indexing assuming typical constraints (ASCII compatible).
    
    l, r := 0, len(s)-1
    
    for l < r {
        // Move left pointer
        for l < r && !isAlphanumeric(s[l]) {
            l++
        }
        // Move right pointer
        for l < r && !isAlphanumeric(s[r]) {
            r--
        }
        
        // Compare
        if toLower(s[l]) != toLower(s[r]) {
            return false
        }
        l++
        r--
    }
    return true
}

func isAlphanumeric(b byte) bool {
    return (b >= 'a' && b <= 'z') || (b >= 'A' && b <= 'Z') || (b >= '0' && b <= '9')
}

func toLower(b byte) byte {
    if b >= 'A' && b <= 'Z' {
        return b + ('a' - 'A')
    }
    return b
}
```

### Key Go Insights
- **Strings are immutable**: We cannot change `s` in-place (like `s[i] = 'a'`), but we can read it.
- **Custom Helpers**: Frequently faster/cleaner to write simple `isAlphanumeric` for ASCII than importing `unicode` package if you want raw byte performance, but `unicode` package is more correct for full UTF-8.
- **Byte vs Rune**: `s[i]` accesses the byte. If the string contains unicode characters (like `世`), index access might break a character. For simple algorithms problems, ASCII is often assumed. If Unicode is required, cast to `[]rune(s)` first (O(N) memory).

## Edge Cases
- Empty string (True).
- String with only non-alphanumeric (True).
