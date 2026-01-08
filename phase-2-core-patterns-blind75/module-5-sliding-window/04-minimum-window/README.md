# Minimum Window Substring

**Difficulty**: Hard  
**Pattern**: Sliding Window  
**Companies**: Google, Amazon, Facebook, Microsoft

## Problem Statement

Given two strings `s` and `t` of lengths `m` and `n` respectively, return the minimum window substring of `s` such that every character in `t` (including duplicates) is included in the window. If there is no such substring, return the empty string `""`.

## Examples

### Example 1
```
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t
```

### Example 2
```
Input: s = "a", t = "a"
Output: "a"
```

### Example 3
```
Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window
```

## Constraints

- `m == s.length`
- `n == t.length`
- `1 <= m, n <= 10^5`
- `s` and `t` consist of uppercase and lowercase English letters

## Approach

### Sliding Window with Character Matching (Optimal)
**Time**: O(m + n), **Space**: O(1) - at most 52 characters

Use two HashMaps: one for target characters, one for window. Expand window until all characters matched, then contract to find minimum.

## Solution

See [solution.java](solution.java) for implementation.

## Key Insights

1. **Track required and formed characters**: Know when window is valid
2. **Expand to find valid window, contract to minimize**: Standard pattern
3. **HashMap for character counts**: Handle duplicates correctly

## Related Problems

- Substring with Concatenation of All Words (LeetCode 30)
- Minimum Size Subarray Sum (LeetCode 209)
