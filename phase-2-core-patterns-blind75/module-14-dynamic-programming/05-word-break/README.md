# Word Break

**Difficulty**: Medium  
**Pattern**: Dynamic Programming

## Problem Statement
Given a string `s` and a dictionary of strings `wordDict`, return `true` if `s` can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be used multiple times in the segmentation.

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
```

## Constraints
* `1 <= s.length <= 300`
* `1 <= wordDict.length <= 1000`

## Approach

### 1. Dynamic Programming
`dp[i]` = true if the substring `s[0...i]` (or `s[i...end]`) can be segmented.
* We can build this from the back (bottom-up).
* `dp[i]` is true if there exists a word `w` in dictionary such that:
    1. `s` starts with `w` at index `i`
    2. `dp[i + len(w)]` is true.

* Base case: `dp[length] = true` (empty string is valid).

### Complexity
* Time: `O(N^2 * M)` where N is string length and M is max word length (substring check).
* Space: `O(N)`.

## Solution

See [solution.java](solution.java) for the implementation.
