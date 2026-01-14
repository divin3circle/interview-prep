# Longest Substring Without Repeating Characters

**Difficulty**: Medium
**Pattern**: Sliding Window

## Problem Statement

Given a string `s`, find the length of the longest substring without repeating characters.

## Examples

### Example 1
```
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
```

### Example 2
```
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
```

### Example 3
```
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
```

## Approach

### Sliding Window with Map (Optimal)
We use a sliding window `[left, right]`.
1. Expand `right` pointer.
2. If `s[right]` is already in our window (check via map or set), shrink from `left` until the duplicate is removed.
3. Update `maxLength`.

**Optimization**: instead of shrinking one by one, store the *last index* of each character in a map. If we encounter a duplicate at `right`, we can jump `left` directly to `last_index + 1`.

**Time**: O(N)
**Space**: O(min(N, M)) where M is charset size.

## Go Solution

```go
func lengthOfLongestSubstring(s string) int {
    if len(s) == 0 { return 0 }
    
    // Map stores the last seen index of each character
    // rune -> int map handles full Unicode
    seen := make(map[byte]int) 
    maxLength := 0
    left := 0
    
    for right := 0; right < len(s); right++ {
        char := s[right]
        
        // If char seen before and is inside current window
        if idx, found := seen[char]; found && idx >= left {
            left = idx + 1
        }
        
        seen[char] = right
        currentLen := right - left + 1
        if currentLen > maxLength {
            maxLength = currentLen
        }
    }
    return maxLength
}
```

### Key Go Insights
- **Byte vs Rune**: Standard LeetCode inputs for this are usually ASCII, so `byte` processing allows simple indexing. Ideally, use `rune` for full unicode support `for i, char := range s`.
- **Map access**: `val, ok := map[key]` check is idiomatic.

## Edge Cases
- Empty string.
- Single char.
- All duplicates.
