# Longest Substring Without Repeating Characters

**Difficulty**: Medium  
**Pattern**: Sliding Window  
**Companies**: Google, Amazon, Facebook, Microsoft, Apple, Bloomberg

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
Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
```

## Constraints

- `0 <= s.length <= 5 * 10^4`
- `s` consists of English letters, digits, symbols and spaces.

## Theoretical Concepts

### Sliding Window Pattern
Sliding window is used for problems involving contiguous subarrays or substrings:
1. **Dynamic Window**: The size of the window changes based on a condition.
2. **Two Pointers**: `left` and `right` indices define the current window.
3. **Invariants**: We maintain a property within the window (e.g., all characters are unique).

### Character Frequency Tracking
To detect duplicates efficiently:
- **HashSet**: Store characters in the current window.
- **HashMap**: Store character → last seen index (enables jumping the left pointer).
- **Array**: Fixed-size array (e.g., `int[128]` for ASCII) if the character set is limited.

### Left Pointer Jump Optimization
Instead of moving the `left` pointer one by one until the duplicate is removed, we can store the index of each character in a map. If we find a duplicate at index `i`, we move `left` directly to `map.get(s.charAt(i)) + 1`, provided that index is within the current window range.

## Approach

### Sliding Window with HashSet
**Time**: O(n), **Space**: O(min(m, n)) where m is the size of the character set.

Expand the `right` pointer. If a duplicate is found, shrink the `left` pointer until the duplicate is removed.

### Optimized Sliding Window with HashMap
**Time**: O(n), **Space**: O(min(m, n))

Store the last index of each character. When a duplicate is seen, jump the `left` pointer immediately to `max(left, lastSeenIndex + 1)`.

## Solution

See [solution.java](solution.java) for implementation.

## Key Insights

1. **Window validity**: Maintain a window where all characters are distinct.
2. **O(n) traversal**: Each character is visited at most twice (once by `right`, once by `left`).
3. **Set/Map for uniqueness**: Essential for O(1) duplicate checks.

## Edge Cases

- **Empty string**: `""` → `0`
- **String with all same characters**: `"bbbbb"` → `1`
- **All unique characters**: `"abcdef"` → `6`
- **String with spaces**: `"abc abc"` → `4` (including space)
- **Large character sets**: ASCII vs Unicode handling.

## Related Problems

- Longest Repeating Character Replacement (LeetCode 424)
- Subarrays with K Different Integers (LeetCode 992)
- Minimum Window Substring (LeetCode 76)
