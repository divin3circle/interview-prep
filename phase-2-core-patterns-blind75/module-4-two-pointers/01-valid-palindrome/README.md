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

## Theoretical Concepts

### Two Pointer Pattern
The two pointer technique uses two indices to traverse data structure:
- **Opposite Direction**: Start from both ends, move toward center
  - Used when: Checking symmetry, finding pairs in sorted array
  - Example: Palindrome checking, Two Sum II
- **Same Direction**: Both pointers move forward (fast/slow)
  - Used when: Cycle detection, removing duplicates
  - Example: Linked list cycle, remove duplicates

### String Processing Techniques
For this problem, we need to:
1. **Filter characters**: Only consider alphanumeric
2. **Normalize case**: Convert to lowercase for comparison
3. **Compare symmetrically**: Check if string reads same forward/backward

### In-Place vs String Building
Two approaches to handle non-alphanumeric characters:
1. **String Building**: Create filtered string, then check palindrome
   - Time: O(n), Space: O(n)
2. **In-Place (Optimal)**: Skip non-alphanumeric during comparison
   - Time: O(n), Space: O(1)
   - More efficient, no extra string allocation

### Character Classification in Java
- `Character.isLetterOrDigit(c)`: Returns true for a-z, A-Z, 0-9
- `Character.toLowerCase(c)`: Converts to lowercase
- Alternative: Manual check with `(c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')`

## Edge Cases

- **Empty after filtering**: `" "` or `".,,"` → `true` (empty string is palindrome)
- **Single character**: `"a"` → `true`
- **All non-alphanumeric**: `"!!!"` → `true` (becomes empty)
- **Numbers only**: `"12321"` → `true`
- **Mixed alphanumeric**: `"A1b2B1a"` → `true` (becomes "a1b2b1a")
- **Case sensitivity**: `"Aa"` → `true` (both become 'a')
- **Spaces in middle**: `"race a car"` → `false` (becomes "raceacar")

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
