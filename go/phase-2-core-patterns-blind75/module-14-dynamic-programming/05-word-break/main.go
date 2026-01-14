package main

import "fmt"

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

func main() {
	fmt.Printf("WordBreak 'leetcode' ['leet','code']: %v (Expected: true)\n", 
		wordBreak("leetcode", []string{"leet", "code"}))
	fmt.Printf("WordBreak 'applepenapple' ['apple','pen']: %v (Expected: true)\n", 
		wordBreak("applepenapple", []string{"apple", "pen"}))
	fmt.Printf("WordBreak 'catsandog' ['cats','dog','sand','and','cat']: %v (Expected: false)\n", 
		wordBreak("catsandog", []string{"cats", "dog", "sand", "and", "cat"}))
}
