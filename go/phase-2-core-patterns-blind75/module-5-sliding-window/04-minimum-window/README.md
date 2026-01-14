# Minimum Window Substring

**Difficulty**: Hard
**Pattern**: Sliding Window

## Problem Statement

Given two strings `s` and `t` of lengths `m` and `n` respectively, return the minimum window substring of `s` such that every character in `t` (including duplicates) is included in the window. If there is no such substring, return the empty string `""`.

The testcases will be generated such that the answer is unique.

## Examples

### Example 1
```
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
```

### Example 2
```
Input: s = "a", t = "a"
Output: "a"
```

## Approach

### Sliding Window with Two Maps
1. **Target Frequency Map**: Build a map `targetCounts` for string `t` to know exactly what we need.
2. **Current Window**: Expand `right` pointer and maintain `windowCounts`.
3. **Match Logic**: Track `have` (number of unique characters that satisfy the count requirement) and `need` (total unique characters in `t`).
   - If `windowCounts[char] == targetCounts[char]`, increment `have`.
4. **Shrink**: When `have == need`, the current window is valid. Try to shrink from `left` to find the smaller valid window.
   - Update min length and start position.
   - Decrement `windowCounts[s[left]]`.
   - If `windowCounts[s[left]] < targetCounts[s[left]]`, decrement `have` (window becomes invalid).
   - Move `left` forward.

**Time**: O(M + N) where M and N are lengths of `s` and `t`.
**Space**: O(1) (limited charset, e.g., ASCII 128 or 52 letters).

## Go Solution

```go
func minWindow(s string, t string) string {
    if len(t) == 0 { return "" }
    
    // Requirements map
    target := make(map[byte]int)
    for i := 0; i < len(t); i++ {
        target[t[i]]++
    }
    
    window := make(map[byte]int)
    have, need := 0, len(target)
    
    // Result tracking: [len, start_index]
    resLen := len(s) + 1
    resStart := -1
    
    l := 0
    for r := 0; r < len(s); r++ {
        char := s[r]
        window[char]++
        
        if count, ok := target[char]; ok && window[char] == count {
            have++
        }
        
        // While valid window, try shrinking
        for have == need {
            if (r - l + 1) < resLen {
                resLen = r - l + 1
                resStart = l
            }
            
            // Remove from left
            window[s[l]]--
            if count, ok := target[s[l]]; ok && window[s[l]] < count {
                have--
            }
            l++
        }
    }
    
    if resLen > len(s) {
        return ""
    }
    return s[resStart : resStart+resLen]
}
```

### Key Go Insights
- **Slicing**: `s[start:end]` is efficient (O(1) view of underlying array).
- **Map Checks**: `if count, ok := target[char]; ok` ensures we only care about characters relevant to `t`.

## Edge Cases
- `t` longer than `s`.
- No valid window.
- Duplicates in `t` (e.g. `t="AA"`).
