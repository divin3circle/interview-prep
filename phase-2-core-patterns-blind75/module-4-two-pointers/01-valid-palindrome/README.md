# Valid Palindrome

**Difficulty**: Easy  
**Pattern**: Two Pointers  
**Companies**: Google, Amazon, Facebook, Microsoft, Apple

## Problem Statement

A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string `s`, return `true` if it is a palindrome, or `false` otherwise.

## Examples

### Example 1
```
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome
```

### Example 2
```
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome
```

### Example 3
```
Input: s = " "
Output: true
Explanation: Empty string after removing non-alphanumeric is palindrome
```

## Constraints

- `1 <= s.length <= 2 * 10^5`
- `s` consists only of printable ASCII characters

## Approach

### Two Pointers (Optimal)
**Time**: O(n), **Space**: O(1)

Use two pointers from both ends, skip non-alphanumeric characters, compare characters.

**Why it's optimal**: Single pass, constant space, no string manipulation needed.

## Solution

See [solution.java](solution.java) for implementation.

## Key Insights

1. **Two pointers from ends**: Compare characters moving inward
2. **Skip non-alphanumeric**: Use Character.isLetterOrDigit()
3. **Case-insensitive**: Convert to lowercase for comparison
4. **No extra string needed**: Process in-place

## Related Problems

- Valid Palindrome II (LeetCode 680)
- Palindrome Linked List (LeetCode 234)
- Longest Palindromic Substring (LeetCode 5)
