# Framework Practice Problems

These problems are specifically designed to help you internalize the 10-step problem-solving framework. For each problem, consciously follow all 10 steps, even if you know the solution.

**Goal**: Build muscle memory for the framework, not just solve the problems.

---

## Problem 1: Valid Palindrome

**Difficulty**: Easy  
**Pattern Focus**: Two Pointers, String Manipulation

### Problem Statement

A phrase is a palindrome if, after converting all uppercase letters to lowercase and removing all non-alphanumeric characters, it reads the same forward and backward.

Given a string `s`, return `true` if it is a palindrome, or `false` otherwise.

### Examples

```
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Input: s = " "
Output: true
Explanation: Empty string after removing non-alphanumeric is palindrome.
```

### Constraints

- 1 ≤ s.length ≤ 2 × 10⁵
- `s` consists only of printable ASCII characters

### Framework Application Instructions

1. **Understand**: What makes a string a palindrome after preprocessing?
2. **Clarify**: What counts as alphanumeric? How to handle empty strings?
3. **Examples**: Create at least 3 examples including edge cases
4. **Patterns**: Recognize the two-pointer pattern for palindrome checking
5. **Brute Force**: Consider creating a cleaned string first
6. **Optimize**: Can you check in-place without creating new string?
7. **Walkthrough**: Trace through with "A man, a plan..."
8. **Implement**: Write clean code with helper methods if needed
9. **Test**: Test with all examples plus edge cases
10. **Analyze**: Compare in-place vs. preprocessing approaches

---

## Problem 2: Best Time to Buy and Sell Stock

**Difficulty**: Easy  
**Pattern Focus**: Single Pass, Tracking Min/Max

### Problem Statement

You are given an array `prices` where `prices[i]` is the price of a given stock on the `i`th day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

### Examples

```
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: No profit possible, prices only decrease.

Input: prices = [2,4,1]
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 2.
```

### Constraints

- 1 ≤ prices.length ≤ 10⁵
- 0 ≤ prices[i] ≤ 10⁴

### Framework Application Instructions

1. **Understand**: Must buy before selling, maximize profit
2. **Clarify**: Can we not trade at all? What if all prices decrease?
3. **Examples**: Include increasing, decreasing, and mixed sequences
4. **Patterns**: Track minimum price seen so far, calculate profit at each step
5. **Brute Force**: Check all buy-sell pairs
6. **Optimize**: Single pass tracking minimum and maximum profit
7. **Walkthrough**: Trace through [7,1,5,3,6,4] step by step
8. **Implement**: Clean code with meaningful variable names
9. **Test**: Test all examples plus edge case of single price
10. **Analyze**: O(n) time, O(1) space - optimal

---

## Problem 3: Valid Anagram

**Difficulty**: Easy  
**Pattern Focus**: Hash Map, Frequency Counting

### Problem Statement

Given two strings `s` and `t`, return `true` if `t` is an anagram of `s`, and `false` otherwise.

An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, using all the original letters exactly once.

### Examples

```
Input: s = "anagram", t = "nagaram"
Output: true

Input: s = "rat", t = "car"
Output: false

Input: s = "listen", t = "silent"
Output: true
```

### Constraints

- 1 ≤ s.length, t.length ≤ 5 × 10⁴
- `s` and `t` consist of lowercase English letters

### Framework Application Instructions

1. **Understand**: Same letters, same frequency, different order
2. **Clarify**: Case sensitive? Only letters? Different lengths?
3. **Examples**: Include same length different letters, different lengths
4. **Patterns**: Frequency counting with HashMap or array
5. **Brute Force**: Sort both strings and compare
6. **Optimize**: Use HashMap for O(n) solution
7. **Walkthrough**: Trace through "anagram" and "nagaram"
8. **Implement**: Consider both sorting and HashMap approaches
9. **Test**: Test equal strings, different lengths, different letters
10. **Analyze**: Compare O(n log n) sorting vs O(n) HashMap

---

## Problem 4: Merge Two Sorted Lists

**Difficulty**: Easy  
**Pattern Focus**: Linked Lists, Two Pointers

### Problem Statement

You are given the heads of two sorted linked lists `list1` and `list2`.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

### Examples

```
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Input: list1 = [], list2 = []
Output: []

Input: list1 = [], list2 = [0]
Output: [0]
```

### Constraints

- The number of nodes in both lists is in the range [0, 50]
- -100 ≤ Node.val ≤ 100
- Both `list1` and `list2` are sorted in non-decreasing order

### Framework Application Instructions

1. **Understand**: Merge two sorted lists maintaining sorted order
2. **Clarify**: Can lists be empty? In-place or new list?
3. **Examples**: Include both empty, one empty, equal values
4. **Patterns**: Two pointers, dummy node for easier implementation
5. **Brute Force**: Collect all values, sort, create new list
6. **Optimize**: Merge in-place using two pointers
7. **Walkthrough**: Trace through [1,2,4] and [1,3,4]
8. **Implement**: Use dummy node to simplify edge cases
9. **Test**: Test all edge cases including empty lists
10. **Analyze**: O(n + m) time, O(1) space for in-place

---

## Problem 5: Maximum Subarray

**Difficulty**: Medium  
**Pattern Focus**: Dynamic Programming, Kadane's Algorithm

### Problem Statement

Given an integer array `nums`, find the subarray with the largest sum, and return its sum.

A subarray is a contiguous non-empty sequence of elements within an array.

### Examples

```
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
```

### Constraints

- 1 ≤ nums.length ≤ 10⁵
- -10⁴ ≤ nums[i] ≤ 10⁴

### Framework Application Instructions

1. **Understand**: Find contiguous subarray with maximum sum
2. **Clarify**: Must include at least one element? All negative case?
3. **Examples**: Include all negative, all positive, mixed
4. **Patterns**: Dynamic programming, Kadane's algorithm
5. **Brute Force**: Check all possible subarrays O(n²) or O(n³)
6. **Optimize**: Kadane's algorithm for O(n) solution
7. **Walkthrough**: Trace through [-2,1,-3,4,-1,2,1,-5,4]
8. **Implement**: Track current sum and maximum sum
9. **Test**: Test all examples plus all negative array
10. **Analyze**: O(n) time, O(1) space - optimal

---

## How to Use These Problems

### For Each Problem:

1. **Set a Timer**: Allocate 30-45 minutes
2. **Use the Template**: Fill out the [framework-template.md](framework-template.md)
3. **Follow All Steps**: Don't skip steps even if you know the solution
4. **Practice Aloud**: Verbalize your thinking as in an interview
5. **Review**: Compare your approach to the framework

### Progression:

- **Day 1-2**: Problems 1-2 (Easy, fundamental patterns)
- **Day 3-4**: Problems 3-4 (Easy, different data structures)
- **Day 5-6**: Problem 5 (Medium, introduces DP concept)
- **Day 7**: Review all problems, identify patterns

### Success Criteria:

- [ ] Can articulate all 10 steps for each problem
- [ ] Framework application feels natural, not forced
- [ ] Can explain why each step matters
- [ ] Comfortable verbalizing thought process
- [ ] Can identify which patterns apply to new problems

---

## Additional Practice

After completing these 5 problems, apply the framework to:

1. Any problem from the [Arrays & Hashing](../../phase-2-core-patterns-blind75/module-3-arrays-hashing/) module
2. Problems from your target company's interview patterns
3. Daily LeetCode problems

**Remember**: The goal is not speed initially. The goal is to internalize the framework so it becomes automatic. Speed will come with practice.

---

## Reflection Questions

After completing all 5 problems:

1. Which steps do you naturally skip? (Work on those)
2. Which steps feel most valuable? (Emphasize in interviews)
3. Where do you spend most time? (Optimize this)
4. What patterns are you recognizing? (Build your pattern library)
5. How has your problem-solving improved? (Track progress)

**Next Steps**: Proceed to [Module 0.3: Tools Setup](../module-0.3-tools-setup/README.md) to configure your development environment.
