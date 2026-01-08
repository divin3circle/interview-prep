# Valid Anagram

**Difficulty**: Easy  
**Pattern**: Arrays & Hashing  
**Companies**: Google, Amazon, Microsoft, Facebook, Bloomberg

## Problem Statement

Given two strings `s` and `t`, return `true` if `t` is an anagram of `s`, and `false` otherwise.

An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, using all the original letters exactly once.

## Examples

### Example 1
```
Input: s = "anagram", t = "nagaram"
Output: true
Explanation: Both strings contain the same characters with the same frequencies
```

### Example 2
```
Input: s = "rat", t = "car"
Output: false
Explanation: Different characters
```

### Example 3
```
Input: s = "listen", t = "silent"
Output: true
Explanation: Same characters, different order
```

## Constraints

- `1 <= s.length, t.length <= 5 * 10^4`
- `s` and `t` consist of lowercase English letters

## Approach

### Sorting
**Time**: O(n log n), **Space**: O(n) for char arrays

Sort both strings and compare. If they're anagrams, sorted versions will be identical.

**Why it works**: Anagrams have the same characters in the same frequencies.

### Frequency Counting with HashMap
**Time**: O(n), **Space**: O(1) - at most 26 characters

Count character frequencies in both strings and compare.

**Why it's better**: Linear time complexity.

### Frequency Array (Optimal for lowercase letters)
**Time**: O(n), **Space**: O(1) - fixed size array of 26

Use array of size 26 for lowercase English letters. Increment for `s`, decrement for `t`.

**Why it's optimal**: O(1) space (constant 26 elements) and simple implementation.

## Solution

See [solution.java](solution.java) for the optimal implementation.

## Key Insights

1. **Anagrams have identical character frequencies**: Core property to exploit
2. **Early termination**: Different lengths → not anagrams
3. **Array vs HashMap**: Array is faster for limited character set
4. **Sorting is simple but slower**: O(n log n) vs O(n)

## Follow-Up Questions

**Q**: What if inputs contain Unicode characters?  
**A**: Use HashMap instead of array to handle arbitrary character sets.

**Q**: What if we need to ignore case?  
**A**: Convert both strings to lowercase first.

**Q**: What if we need to ignore spaces and punctuation?  
**A**: Filter out non-alphabetic characters before comparison.

**Q**: How would you find all anagrams of a string in a list?  
**A**: Use sorted string as key in HashMap, group anagrams together.

## Related Problems

- Group Anagrams (LeetCode 49)
- Find All Anagrams in a String (LeetCode 438)
- Permutation in String (LeetCode 567)
- Valid Palindrome (LeetCode 125)
