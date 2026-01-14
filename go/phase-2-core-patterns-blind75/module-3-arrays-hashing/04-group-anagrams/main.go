package main

import "fmt"

// groupAnagrams groups strings that are anagrams.
// Time: O(N * K)
// Space: O(N * K)
func groupAnagrams(strs []string) [][]string {
	// Use [26]int as key. Go arrays are comparable!
	groups := make(map[[26]int][]string)
	
	for _, str := range strs {
		var count [26]int
		for i := 0; i < len(str); i++ {
			// Assuming lowercase English letters
			count[str[i]-'a']++
		}
		groups[count] = append(groups[count], str)
	}
	
	// Convert map values to slice of slices
	result := make([][]string, 0, len(groups))
	for _, list := range groups {
		result = append(result, list)
	}
	return result
}

func main() {
	strs := []string{"eat", "tea", "tan", "ate", "nat", "bat"}
	result := groupAnagrams(strs)
	fmt.Printf("Input: %v\n", strs)
	fmt.Printf("Output: %v\n", result)
	
	// Since order of groups is random (map iteration), exact verification needs logic
	// But simply printing demonstrates correctness for this example.
}
