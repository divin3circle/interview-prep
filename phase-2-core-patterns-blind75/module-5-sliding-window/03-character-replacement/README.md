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
Explanation: Replace the two 'A's with two 'B's or vice versa.
```

### Example 2
```
Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating character, which is 4.
```

## Constraints

- `1 <= s.length <= 10^5`
- `s` consists of only uppercase English letters.
- `0 <= k <= s.length`

## Theoretical Concepts

### Sliding Window Validity
A sliding window is valid if:
`Window Length - Frequency of Max Character <= k`

This means the number of characters we need to replace to make the entire window contain the same character is within our budget `k`.

### Global Max Frequency Strategy
We track the frequency of all characters in the current window.
`maxFreq` is the frequency of the most frequent character encountered *in any valid window so far*.
A neat optimization: We don't need to re-scan for the current max frequency when a window shrinks because a smaller `maxFreq` will never yield a longer valid window than what we've already found.

### Window Expansion and Contraction
1. **Expand**: Increment the count of the character at `right`. Update `maxFreq`.
2. **Check**: If `(right - left + 1) - maxFreq > k`, the window is invalid.
3. **Contract**: If invalid, decrement the count of the character at `left` and increment `left`.

## Approach

### Sliding Window with Frequency Array
**Time**: O(n), **Space**: O(1) - fixed size array of 26.

Use an integer array of size 26 to store counts of 'A'-'Z'.

**Why it's optimal**: We only iterate through the string once and use constant extra space.

## Solution

See [solution.java](solution.java) for implementation.

## Key Insights

1. **Max character frequency determines replacements**: We always replace the "minority" characters.
2. **No need for window shrink logic to update maxFreq**: A smaller window will not improve the overall maximum result.
3. **Window length - maxFreq**: The number of changes needed.

## Edge Cases

- **All characters same**: `"AAAA", k=2` → `4`
- **k = 0**: `"AABC", k=0` → `2`
- **k >= string length**: `"ABC", k=5` → `3`
- **Alternating characters**: `"ABABAB", k=1` → `3`

## Related Problems

- Longest Substring Without Repeating Characters (LeetCode 3)
- Max Consecutive Ones III (LeetCode 1004)
