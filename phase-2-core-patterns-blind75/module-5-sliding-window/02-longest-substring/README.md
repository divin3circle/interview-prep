# Longest Substring Without Repeating Characters

**Difficulty**: Medium  
**Pattern**: Sliding Window  
**Companies**: Google, Amazon, Facebook, Microsoft, Apple

## Problem Statement

Given a string `s`, find the length of the longest substring without repeating characters.

## Examples

### Example 1
```
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with length 3
```

### Example 2
```
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with length 1
```

### Example 3
```
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with length 3
```

## Constraints

- `0 <= s.length <= 5 * 10^4`
- `s` consists of English letters, digits, symbols and spaces

## Approach

### Sliding Window with HashSet (Optimal)
**Time**: O(n), **Space**: O(min(n, charset_size))

Use sliding window with HashSet. Expand window by adding characters. When duplicate found, contract from left until duplicate removed.

**Why it's optimal**: Each character visited at most twice (once by right, once by left pointer).

## Solution

See [solution.java](solution.java) for implementation.

## Key Insights

1. **Dynamic window**: Expands and contracts based on duplicates
2. **HashSet for O(1) lookup**: Check if character already in window
3. **Contract when duplicate**: Remove from left until duplicate gone

## Related Problems

- Longest Substring with At Most K Distinct Characters (LeetCode 340)
- Longest Repeating Character Replacement (LeetCode 424)
