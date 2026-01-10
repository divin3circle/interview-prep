# Minimum Window Substring

**Difficulty**: Hard  
**Pattern**: Sliding Window  
**Companies**: Google, Amazon, Facebook, Microsoft, Airbnb, Uber

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
Explanation: The entire string s is the minimum window.
```

### Example 3
```
Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since s only has one 'a', return empty string.
```

## Constraints

- `m == s.length`
- `n == t.length`
- `1 <= m, n <= 10^5`
- `s` and `t` consist of uppercase and lowercase English letters.

## Theoretical Concepts

### Sliding Window for Template Matching
We use a two-pointer sliding window to find the smallest range `[left, right]` that satisfies the "template" `t`.

### Frequency Map and "Requirement" Counter
To handle duplicates in `t` (e.g., `t = "aa"`):
1. **Target Map**: Store the required counts of each character in `t`.
2. **Window Map**: Store the counts of characters in the current window.
3. **Match Counter**: Increment when a character in the window reaches the required count in `t`. Decrement when shrinking.

### Optimization
- If a character in `s` is not in `t`, we can ignore it in our match logic (though it still contributes to window length).
- Track the minimum length and start index to extract the result string at the end rather than slicing strings repeatedly.

## Approach

### Sliding Window with Two Maps
**Time**: O(m + n), **Space**: O(k) where k is the character set size.

1. Build frequency map for `t`.
2. Expand `right` until all characters are matched.
3. Once valid, shrink `left` as much as possible while maintaining validity.
4. Record minimum window found.

**Why it's optimal**: Each pointer moves at most `m` times.

## Solution

See [solution.java](solution.java) for implementation.

## Key Insights

1. **Two-pointer contraction**: The window must be compressed as much as possible once it becomes valid.
2. **Frequency comparison**: A character is "fully matched" when its count in the window >= its count in `t`.
3. **Handle uppercase/lowercase**: They are distinct characters.

## Edge Cases

- **s shorter than t**: `s = "a", t = "ab"` → `""`
- **t has duplicate characters**: `t = "aa"`
- **Answer is the whole string**: `s = "abcdef", t = "af"`
- **No possible window**: `s = "abc", t = "d"`

## Related Problems

- Longest Substring Without Repeating Characters (LeetCode 3)
- Find All Anagrams in a String (LeetCode 438)
- Permutation in String (LeetCode 567)
