# Word Break

**Difficulty**: Medium
**Pattern**: DP

## Problem Statement

Given a string `s` and a dictionary of strings `wordDict`, return `true` if `s` can be segmented into a space-separated sequence of one or more dictionary words.

## Approach

### DP
`dp[i]` = true if s[0:i] can be segmented.

**Time**: O(N² * M) where M is avg word length
**Space**: O(N)

## Go Solution

```go
func wordBreak(s string, wordDict []string) bool {
    dp := make([]bool, len(s)+1)
    dp[len(s)] = true
    
    for i := len(s) - 1; i >= 0; i-- {
        for _, word := range wordDict {
            if i+len(word) <= len(s) && s[i:i+len(word)] == word {
                dp[i] = dp[i+len(word)]
            }
            if dp[i] {
                break
            }
        }
    }
    return dp[0]
}
```
