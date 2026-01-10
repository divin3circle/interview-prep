# Word Break

**Difficulty**: Medium  
**Pattern**: Dynamic Programming (String Partitioning)  
**Companies**: Google, Amazon, Facebook, Microsoft, Apple, Bloomberg, Uber

## Problem Statement

Given a string `s` and a dictionary of strings `wordDict`, return `true` if `s` can be segmented into a space-separated sequence of one or more dictionary words.

**Note** that the same word in the dictionary may be reused multiple times in the segmentation.

## Examples

### Example 1
```
Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
```

### Example 2
```
Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
```

### Example 3
```
Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false
```

## Constraints

- `1 <= s.length <= 300`
- `1 <= wordDict.length <= 1000`
- `1 <= wordDict[i].length <= 20`
- `s` and `wordDict[i]` consist of only lowercase English letters.
- All the strings of `wordDict` are **unique**.

## Theoretical Concepts

### Recursive Structure
A string `S[0...i]` can be broken if there exists some `j < i` such that:
1. `S[0...j]` can be broken (subproblem).
2. The substring `S[j...i]` is a word in the dictionary.

### Complexity Analysis (Naive vs DP)
- **Naive Recursion**: Exploring all possible split points leads to O(2^n) complexity.
- **Dynamic Programming**: We only solve each prefix subproblem once.

### Set for O(1) Lookups
Converting the `wordDict` list into a `HashSet` is crucial. Checking if a string exists in a list takes O(W), while a HashSet check takes O(1) average time.

## Approach

### Dynamic Programming - Bottom Up (Optimal)
**Time**: O(n³), **Space**: O(n)

*Note: In some implementations, it's O(n² * m) where m is max word length.*

1. Initialize `dp` boolean array of size `s.length() + 1`.
2. Set `dp[0] = true` (empty string is always "breakable").
3. For each `i` from 1 to `s.length()`:
   - For each `j` from 0 to `i-1`:
     - If `dp[j]` is true AND `s.substring(j, i)` is in the dictionary:
       - `dp[i] = true`
       - break (found a valid split for this prefix)
4. Return `dp[s.length()]`.

**Why it's optimal**: It systematically checks all possible segmentations in polynomial time.

## Solution

See [solution.java](solution.java) for implementation.

## Key Insights

1. **Prefix dependency**: The breakability of a string depends entirely on the breakability of its prefixes.
2. **Nested loops**: The outer loop defines the end of the substring, and the inner loop defines the split point.
3. **Substring costs**: Be aware that `s.substring()` takes O(k) time in many modern Java versions, contributing to the O(n³) total complexity.

## Edge Cases

- **Dictionary contains words that are substrings of each other** (e.g., "cat", "cats").
- **String cannot be broken at all**.
- **The entire string is a single word in the dictionary**.
- **Reuse of words**.

## Related Problems

- Word Break II (LeetCode 140) - return all possible segmentations.
- Concatenated Words (LeetCode 472)
- Palindrome Partitioning (LeetCode 131)
