# Longest Repeating Character Replacement

**Difficulty**: Medium
**Pattern**: Sliding Window

## Problem Statement

You are given a string `s` and an integer `k`. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most `k` times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

## Examples

### Example 1
```
Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
```

### Example 2
```
Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
```

## Approach

### Sliding Window with Count Array (Optimal)
We maintain a window `[left, right]` and a count of characters inside it.
The condition for a valid window is:
`Window Length - Count of Most Frequent Char <= k`

If this holds, it means we can replace all other characters (which are `WindowLen - MaxFreq` in count) with the most frequent character using at most `k` operations.

1. Expand `right`.
2. Update frequency map/array and track `maxFreq` seen in the current window.
3. If `(right - left + 1) - maxFreq > k`, the window is invalid. Shrink from `left`.
4. Update result.

**Time**: O(N)
**Space**: O(1) (Array of size 26)

## Go Solution

```go
func characterReplacement(s string, k int) int {
    counts := make([]int, 26)
    maxFreq := 0
    maxLength := 0
    left := 0
    
    for right := 0; right < len(s); right++ {
        charIdx := s[right] - 'A'
        counts[charIdx]++
        
        // Update global max frequency in current window
        if counts[charIdx] > maxFreq {
            maxFreq = counts[charIdx]
        }
        
        // If window is invalid, shrink it
        // Current window size is (right - left + 1)
        // Replacements needed = Window Size - MaxFreq
        if (right - left + 1) - maxFreq > k {
            counts[s[left]-'A']--
            left++
        }
        
        // Window is now valid (or was kept size by moving left)
        if (right - left + 1) > maxLength {
            maxLength = right - left + 1
        }
    }
    return maxLength
}
```

### Key Go Insights
- **`s[i] - 'A'`**: Convert char 'A'-'Z' to index 0-25. `s` inputs are usually uppercase English letters per constraints.

## Edge Cases
- `k = 0`.
- All same characters.
- `k >= len(s)`.
