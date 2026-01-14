# Sample Interview Transcripts (Go Edition)

This document provides annotated transcripts of technical interviews, illustrating the difference between strong and weak performances. Study these examples to understand how communication, problem-solving approach, and code quality manifest in real interviews.

---

## Transcript 1: Strong Performance - Two Sum Problem

**Problem**: Given a slice of integers and a target value, return the indices of two numbers that add up to the target.

### Interview Flow

**Interviewer**: "Let's start with a coding problem. Given a slice of integers `nums` and an integer `target`, return the indices of the two numbers such that they add up to `target`. You may assume that each input has exactly one solution, and you may not use the same element twice."

**Candidate**: "Thank you for the problem. Let me make sure I understand correctly. I need to find two distinct indices `i` and `j` where `nums[i] + nums[j] equals target`, and return those indices as a slice?"

> **Analysis**: Strong start. The candidate immediately clarifies the problem in their own words, demonstrating active listening.

**Interviewer**: "That's correct."

**Candidate**: "Great. I have a few clarifying questions before I proceed. First, can the slice contain negative numbers or zeros?"

**Interviewer**: "Yes, it can contain any integers."

**Candidate**: "And is the slice sorted in any way?"

**Interviewer**: "No, you should assume it's unsorted."

**Candidate**: "Perfect. And you mentioned there's exactly one solution - does that mean I don't need to handle the case where no solution exists?"

**Interviewer**: "Correct, you can assume a solution always exists."

> **Analysis**: Excellent clarifying questions. The candidate is establishing constraints and edge cases before coding.

**Candidate**: "Understood. Let me work through a couple of examples. If `nums = [2, 7, 11, 15]` and `target = 9`, then `nums[0] + nums[1] = 2 + 7 = 9`, so I would return `[0, 1]`. Is that correct?"

**Interviewer**: "Yes, exactly."

**Candidate**: "And if I have `nums = [3, 2, 4]` and `target = 6`, then `nums[1] + nums[2] = 2 + 4 = 6`, so I return `[1, 2]`. An edge case: what if the slice has just two elements like `[1, 2]` with `target = 3`? I would return `[0, 1]`."

> **Analysis**: The candidate is generating examples including an edge case, demonstrating thorough thinking.

**Interviewer**: "All correct. Go ahead and think about your approach."

**Candidate**: "Alright, let me think through different approaches. The brute force solution would be to use nested loops - for each element, check every other element. That would be O(n²) time complexity with O(1) space."

**Interviewer**: "That's a valid approach. Can you do better?"

**Candidate**: "Yes, I can optimize this using a Map. The key insight is that for each number `x`, I'm looking for a complement `target - x`. If I store numbers I've seen in a Map with their indices, I can check in O(1) time whether the complement exists. This would give me O(n) time complexity with O(n) space complexity."

> **Analysis**: The candidate articulates both brute force and optimal approaches, explaining the tradeoff between time and space.

**Interviewer**: "That sounds good. Go ahead and implement the optimized version."

**Candidate**: "Perfect. I'll walk through my algorithm first. I'll create a Map `map[int]int` to store numbers as keys and indices as values. Then I'll iterate through the slice. For each number, I'll calculate its complement. If the complement exists in my Map, I've found my answer and return both indices. Otherwise, I add the number and its index to the Map."

> **Analysis**: The candidate explains the algorithm at a high level before coding.

**Interviewer**: "Makes sense. Go ahead."

**Candidate**: *(Begins coding while explaining)*

```go
func twoSum(nums []int, target int) []int {
    // Map to store number -> index mapping
    numMap := make(map[int]int)
    
    // Iterate through slice once
    for i, num := range nums {
        complement := target - num
        
        // Check if complement exists in map
        if idx, found := numMap[complement]; found {
            // Found the pair, return indices
            return []int{idx, i}
        }
        
        // Add current number to map
        numMap[num] = i
    }
    
    // Should never reach here given problem constraints
    return []int{}
}
```

**Candidate**: "Let me walk through this with our first example. With `nums = [2, 7, 11, 15]` and `target = 9`:
- i=0: complement = 9-2 = 7, map empty, add 2->0
- i=1: complement = 9-7 = 2, map has 2, return [0, 1]

That's correct."

> **Analysis**: The candidate tests their code with an example immediately after writing it.

**Interviewer**: "Good. What about the edge case you mentioned earlier?"

**Candidate**: "With `nums = [1, 2]` and `target = 3`:
- i=0: complement = 3-1 = 2, map empty, add 1->0
- i=1: complement = 3-2 = 1, map has 1, return [0, 1]

Works correctly."

**Interviewer**: "What's the time and space complexity?"

**Candidate**: "Time complexity is O(n), because we iterate through the slice once and Map lookups are O(1) on average. Space complexity is O(n) in the worst case to store the elements in the Map."

> **Analysis**: Clear, precise complexity analysis.

**Interviewer**: "Excellent. One follow-up: what if the slice was sorted? Could you solve it with O(1) space?"

**Candidate**: "Yes, if the slice is sorted, I could use the two-pointer technique. I'd place one pointer at the start and one at the end. If the sum is too small, I move the left pointer right. If it's too large, I move the right pointer left. This would still be O(n) time but only O(1) space."

**Interviewer**: "Perfect. That's all for this problem."

### Key Success Factors in This Interview

1. **Clarifying Questions**: Asked about constraints and edge cases
2. **Example Generation**: Created multiple examples
3. **Approach Explanation**: Discussed brute force before optimizing
4. **Code Quality**: Idiomatic Go code (using `range`, `make`, map check syntax)
5. **Testing**: Verified solution with examples
6. **Complexity Analysis**: Accurate analysis
7. **Follow-up Handling**: Quickly adapted to the follow-up question

---

## Transcript 2: Weak Performance - Same Problem

**Interviewer**: "Given a slice of integers `nums` and an integer `target`, return the indices of the two numbers such that they add up to `target`."

**Candidate**: "Okay." *(Immediately starts coding)*

> **Analysis**: Red flag. No clarifying questions, no examples.

**Interviewer**: "Before you start coding, can you explain your approach?"

**Candidate**: "Oh, um, I'll just check all pairs."

> **Analysis**: Vague explanation. No mention of complexity.

**Candidate**: *(Writes code silently)*

```go
func twoSum(nums []int, target int) []int {
    for i := 0; i < len(nums); i++ {
        for j := 0; j < len(nums); j++ {
            if nums[i] + nums[j] == target {
                return []int{i, j}
            }
        }
    }
    return nil
}
```

> **Analysis**: Multiple issues - uses same element twice (i==j case), inefficient O(n²) solution, returns nil instead of empty slice (which might be okay in Go but inconsistent).

**Interviewer**: "Can you test this with an example?"

**Candidate**: "Um, with [2, 7, 11, 15] and target 9... it should return [0, 1]."

**Interviewer**: "Walk through your code with that example."

**Candidate**: "When i=0 and j=0, we check 2+2=4... oh wait. i=0, j=1, we check 2+7=9, so we return [0,1]."

**Interviewer**: "What about when i=0 and j=0? Is it correct to use the same element twice?"

**Candidate**: "Oh, I guess not. Um..." *(Stares at code)*

> **Analysis**: Didn't catch the bug proactively.

**Interviewer**: "How would you fix that?"

**Candidate**: *(Makes changes)*

```go
func twoSum(nums []int, target int) []int {
    for i := 0; i < len(nums); i++ {
        for j := i + 1; j < len(nums); j++ {
            if nums[i] + nums[j] == target {
                return []int{i, j}
            }
        }
    }
    return nil
}
```

**Interviewer**: "What's the time complexity?"

**Candidate**: "Um... O(n)?"

> **Analysis**: Incorrect complexity analysis.

**Interviewer**: "Are you sure? You have nested loops."

**Candidate**: "Oh right, O(n²)."

**Interviewer**: "Can you optimize this?"

**Candidate**: "Um... I'm not sure how."

> **Analysis**: Unable to optimize without hints.

**Interviewer**: "What if you stored the numbers you've seen in a Map?"

**Candidate**: "Oh, yeah, I could use a Map."

> **Analysis**: Required heavy prompting.

### Key Failure Points in This Interview

1. **No Clarifying Questions**: Jumped straight to coding
2. **No Examples**: Didn't generate test cases upfront
3. **Poor Code Quality**: Bugs, inefficient solution
4. **Incorrect Complexity Analysis**: Didn't understand their own code's complexity
5. **Unable to Optimize**: Required significant hints
6. **Poor Communication**: Silent coding, vague explanations

---

## Lessons to Apply

1. **Always ask clarifying questions** before coding
2. **Generate examples** including edge cases upfront
3. **Explain your approach** at a high level before implementing
4. **Think aloud** throughout the entire process
5. **Test proactively** with multiple cases
6. **Know your complexity** and be able to explain it
7. **Start with brute force**, then optimize
8. **Handle feedback gracefully** and incorporate it quickly
