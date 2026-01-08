# Longest Repeating Character Replacement

**Difficulty**: Medium  
**Pattern**: Sliding Window  
**Companies**: Google, Amazon, Microsoft

## Problem Statement

You are given a string `s` and an integer `k`. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most `k` times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

## Examples

### Example 1
```
Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa
```

### Example 2
```
Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace one 'A' in the middle with 'B' and form "AABBBBA"
The substring "BBBB" has the longest repeating letters, which is 4
```

## Constraints

- `1 <= s.length <= 10^5`
- `s` consists of only uppercase English letters
- `0 <= k <= s.length`

## Approach

### Sliding Window with Frequency Count (Optimal)
**Time**: O(n), **Space**: O(1) - at most 26 characters

Maintain window where (window_size - max_frequency) <= k. This ensures we can make all characters the same with at most k replacements.

## Solution

See [solution.java](solution.java) for implementation.

## Key Insights

1. **Valid window condition**: window_length - most_frequent_char_count <= k
2. **Track max frequency**: Don't need to decrease it when shrinking window
3. **Expand when valid, contract when invalid**: Standard sliding window

## Related Problems

- Longest Substring Without Repeating Characters (LeetCode 3)
- Longest Substring with At Most K Distinct Characters (LeetCode 340)
