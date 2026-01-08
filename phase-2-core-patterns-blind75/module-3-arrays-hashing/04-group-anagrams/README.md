# Group Anagrams

**Difficulty**: Medium  
**Pattern**: Arrays & Hashing  
**Companies**: Google, Amazon, Facebook, Microsoft, Uber

## Problem Statement

Given an array of strings `strs`, group the anagrams together. You can return the answer in any order.

An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, using all the original letters exactly once.

## Examples

### Example 1
```
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Explanation: 
- "eat", "tea", "ate" are anagrams
- "tan", "nat" are anagrams
- "bat" stands alone
```

### Example 2
```
Input: strs = [""]
Output: [[""]]
```

### Example 3
```
Input: strs = ["a"]
Output: [["a"]]
```

## Constraints

- `1 <= strs.length <= 10^4`
- `0 <= strs[i].length <= 100`
- `strs[i]` consists of lowercase English letters

## Approach

### Sorting as Key
**Time**: O(n × k log k) where n = number of strings, k = max string length  
**Space**: O(n × k)

Sort each string and use sorted version as HashMap key. Anagrams will have identical sorted forms.

**Why it works**: Anagrams produce the same sorted string.

### Character Count as Key (Optimal)
**Time**: O(n × k) where n = number of strings, k = max string length  
**Space**: O(n × k)

Use character frequency as key (e.g., "#1#2#0#0..." for counts of a, b, c, d...).

**Why it's better**: Avoids O(k log k) sorting, achieves O(k) per string.

## Solution

See [solution.java](solution.java) for implementations.

## Key Insights

1. **Anagrams share a common signature**: Either sorted form or character frequency
2. **HashMap for grouping**: Key = signature, Value = list of anagrams
3. **Sorting is simpler**: Character count is faster but more complex
4. **putIfAbsent pattern**: Ensures list exists before adding

## Follow-Up Questions

**Q**: What if we need to handle Unicode characters?  
**A**: Sorting approach works universally; character count needs HashMap instead of array.

**Q**: How would you optimize for very long strings?  
**A**: Character count approach is better (O(k) vs O(k log k) per string).

**Q**: What if memory is constrained?  
**A**: Process in batches, write groups to disk.

## Related Problems

- Valid Anagram (LeetCode 242)
- Find All Anagrams in a String (LeetCode 438)
- Group Shifted Strings (LeetCode 249)
