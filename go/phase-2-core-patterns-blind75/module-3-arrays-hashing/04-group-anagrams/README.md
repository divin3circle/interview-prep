# Group Anagrams

**Difficulty**: Medium
**Pattern**: Arrays & Hashing

## Problem Statement

Given an array of strings `strs`, group the anagrams together. You can return the answer in any order.

## Examples

### Example 1
```
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
```

### Example 2
```
Input: strs = [""]
Output: [[""]]
```

## Approach

### 1. Sorting Key
- Sort each string (e.g., "eat" -> "aet") and use it as a map key.
- **Time**: O(N * K log K) where K is max string length.
- **Space**: O(N * K)

### 2. Character Count Key (Optimal)
- Anagrams have the same character counts.
- Use an array `[26]int` as the key. 
- In many languages, arrays/lists aren't hashable keys, but **in Go, arrays are comparable and can be map keys**!
- **Time**: O(N * K)
- **Space**: O(N * K)

## Go Solution

```go
func groupAnagrams(strs []string) [][]string {
    groups := make(map[[26]int][]string)
    
    for _, str := range strs {
        var count [26]int
        for i := 0; i < len(str); i++ {
            count[str[i] - 'a']++
        }
        groups[count] = append(groups[count], str)
    }
    
    result := make([][]string, 0, len(groups))
    for _, list := range groups {
        result = append(result, list)
    }
    return result
}
```

### Key Go Insights
- **`map[[26]int][]string`**: Arrays are values in Go. `[26]int` is a distinct type from `[]int` (slice) and is comparable, making it a valid map key.
- This avoids string sorting or manual string key generation ("1#0#...").

## Edge Cases
- Empty strings (work natively with 0-count array).
- No anagrams (each gets its own list).
