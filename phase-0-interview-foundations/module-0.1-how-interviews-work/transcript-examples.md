# Sample Interview Transcripts

This document provides annotated transcripts of technical interviews, illustrating the difference between strong and weak performances. Study these examples to understand how communication, problem-solving approach, and code quality manifest in real interviews.

---

## Transcript 1: Strong Performance - Two Sum Problem

**Problem**: Given an array of integers and a target value, return the indices of two numbers that add up to the target.

### Interview Flow

**Interviewer**: "Let's start with a coding problem. Given an array of integers `nums` and an integer `target`, return the indices of the two numbers such that they add up to `target`. You may assume that each input has exactly one solution, and you may not use the same element twice."

**Candidate**: "Thank you for the problem. Let me make sure I understand correctly. I need to find two distinct indices `i` and `j` where `nums[i] + nums[j] equals target`, and return those indices as an array or list?"

> **Analysis**: Strong start. The candidate immediately clarifies the problem in their own words, demonstrating active listening.

**Interviewer**: "That's correct."

**Candidate**: "Great. I have a few clarifying questions before I proceed. First, can the array contain negative numbers or zeros?"

**Interviewer**: "Yes, it can contain any integers."

**Candidate**: "And is the array sorted in any way?"

**Interviewer**: "No, you should assume it's unsorted."

**Candidate**: "Perfect. And you mentioned there's exactly one solution - does that mean I don't need to handle the case where no solution exists?"

**Interviewer**: "Correct, you can assume a solution always exists."

> **Analysis**: Excellent clarifying questions. The candidate is establishing constraints and edge cases before coding.

**Candidate**: "Understood. Let me work through a couple of examples to make sure I have this right. If `nums = [2, 7, 11, 15]` and `target = 9`, then `nums[0] + nums[1] = 2 + 7 = 9`, so I would return `[0, 1]`. Is that correct?"

**Interviewer**: "Yes, exactly."

**Candidate**: "And if I have `nums = [3, 2, 4]` and `target = 6`, then `nums[1] + nums[2] = 2 + 4 = 6`, so I return `[1, 2]`. One edge case I'm thinking about: what if the array has just two elements like `[1, 2]` with `target = 3`? I would return `[0, 1]`."

> **Analysis**: The candidate is generating examples including an edge case, demonstrating thorough thinking.

**Interviewer**: "All correct. Go ahead and think about your approach."

**Candidate**: "Alright, let me think through different approaches. The brute force solution would be to use nested loops - for each element, check every other element to see if they sum to the target. That would be O(n²) time complexity with O(1) space."

**Interviewer**: "That's a valid approach. Can you do better?"

**Candidate**: "Yes, I can optimize this using a HashMap. The key insight is that for each number `x` in the array, I'm looking for a complement `target - x`. If I store numbers I've seen in a HashMap with their indices, I can check in O(1) time whether the complement exists. This would give me O(n) time complexity with O(n) space complexity."

> **Analysis**: The candidate articulates both brute force and optimal approaches, explaining the tradeoff between time and space.

**Interviewer**: "That sounds good. Go ahead and implement the optimized version."

**Candidate**: "Perfect. I'll walk through my algorithm first. I'll create a HashMap to store numbers as keys and their indices as values. Then I'll iterate through the array once. For each number, I'll calculate its complement by subtracting it from the target. If the complement exists in my HashMap, I've found my answer and return both indices. Otherwise, I add the current number and its index to the HashMap and continue."

> **Analysis**: The candidate explains the algorithm at a high level before coding, allowing the interviewer to catch any logical errors early.

**Interviewer**: "Makes sense. Go ahead."

**Candidate**: *(Begins coding while explaining)*

```java
public int[] twoSum(int[] nums, int target) {
    // HashMap to store number -> index mapping
    Map<Integer, Integer> numMap = new HashMap<>();
    
    // Iterate through array once
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        
        // Check if complement exists in map
        if (numMap.containsKey(complement)) {
            // Found the pair, return indices
            return new int[] {numMap.get(complement), i};
        }
        
        // Add current number to map
        numMap.put(nums[i], i);
    }
    
    // Should never reach here given problem constraints
    return new int[] {};
}
```

**Candidate**: "Let me walk through this with our first example to verify. With `nums = [2, 7, 11, 15]` and `target = 9`:
- i=0: complement = 9-2 = 7, map is empty, add 2->0
- i=1: complement = 9-7 = 2, map contains 2, return [0, 1]

That's correct."

> **Analysis**: The candidate tests their code with an example immediately after writing it, catching potential bugs early.

**Interviewer**: "Good. What about the edge case you mentioned earlier?"

**Candidate**: "With `nums = [1, 2]` and `target = 3`:
- i=0: complement = 3-1 = 2, map is empty, add 1->0
- i=1: complement = 3-2 = 1, map contains 1, return [0, 1]

Works correctly."

**Interviewer**: "What's the time and space complexity of your solution?"

**Candidate**: "Time complexity is O(n) where n is the length of the array, because we iterate through the array once and HashMap operations (get, put, containsKey) are O(1) on average. Space complexity is O(n) in the worst case, where we might store all n elements in the HashMap before finding the solution."

> **Analysis**: Clear, precise complexity analysis with explanation of why.

**Interviewer**: "Excellent. One follow-up: what if the array was sorted? Could you solve it with O(1) space?"

**Candidate**: "Yes, if the array is sorted, I could use the two-pointer technique. I'd place one pointer at the start and one at the end. If the sum is too small, I move the left pointer right. If it's too large, I move the right pointer left. This would still be O(n) time but only O(1) space since I'm just using two pointers."

**Interviewer**: "Perfect. That's all for this problem."

### Key Success Factors in This Interview

1. **Clarifying Questions**: Asked about constraints, edge cases, and assumptions
2. **Example Generation**: Created multiple examples including edge cases
3. **Approach Explanation**: Discussed brute force before optimizing
4. **Algorithm Walkthrough**: Explained approach before coding
5. **Code Quality**: Clean, commented code with meaningful variable names
6. **Testing**: Verified solution with examples
7. **Complexity Analysis**: Accurate analysis with clear explanation
8. **Follow-up Handling**: Quickly adapted to the follow-up question

---

## Transcript 2: Weak Performance - Same Problem

**Interviewer**: "Given an array of integers `nums` and an integer `target`, return the indices of the two numbers such that they add up to `target`."

**Candidate**: "Okay." *(Immediately starts coding)*

> **Analysis**: Red flag. No clarifying questions, no examples, no explanation of approach.

**Interviewer**: "Before you start coding, can you explain your approach?"

**Candidate**: "Oh, um, I'll just check all pairs and see which ones add up."

> **Analysis**: Vague explanation. No mention of complexity or optimization.

**Candidate**: *(Writes code silently)*

```java
public int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
        for (int j = 0; j < nums.length; j++) {
            if (nums[i] + nums[j] == target) {
                return new int[] {i, j};
            }
        }
    }
    return null;
}
```

> **Analysis**: Multiple issues - uses same element twice (i==j case), inefficient O(n²) solution, returns null instead of empty array.

**Interviewer**: "Can you test this with an example?"

**Candidate**: "Um, with [2, 7, 11, 15] and target 9... it should return [0, 1]."

**Interviewer**: "Walk through your code with that example."

**Candidate**: "When i=0 and j=0, we check 2+2=4, not 9. Then i=0, j=1, we check 2+7=9, so we return [0,1]."

**Interviewer**: "What about when i=0 and j=0? Is it correct to use the same element twice?"

**Candidate**: "Oh, I guess not. Um..." *(Stares at code)*

> **Analysis**: Didn't catch the bug proactively. Required interviewer prompting.

**Interviewer**: "How would you fix that?"

**Candidate**: *(Makes changes)*

```java
public int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] + nums[j] == target) {
                return new int[] {i, j};
            }
        }
    }
    return null;
}
```

**Interviewer**: "What's the time complexity?"

**Candidate**: "Um... O(n)?"

> **Analysis**: Incorrect complexity analysis. The nested loops are clearly O(n²).

**Interviewer**: "Are you sure? You have nested loops."

**Candidate**: "Oh right, O(n²)."

**Interviewer**: "Can you optimize this?"

**Candidate**: "Um... I'm not sure how."

> **Analysis**: Unable to optimize without significant hints. Shows lack of pattern knowledge.

**Interviewer**: "What if you stored the numbers you've seen in a data structure?"

**Candidate**: "Like an array?"

**Interviewer**: "What about a HashMap?"

**Candidate**: "Oh, yeah, I could use a HashMap."

> **Analysis**: Required heavy prompting to arrive at the optimal solution.

### Key Failure Points in This Interview

1. **No Clarifying Questions**: Jumped straight to coding
2. **No Examples**: Didn't generate test cases upfront
3. **No Approach Explanation**: Started coding without explaining
4. **Poor Code Quality**: Bugs, inefficient solution
5. **Reactive Testing**: Only tested when prompted
6. **Incorrect Complexity Analysis**: Didn't understand their own code's complexity
7. **Unable to Optimize**: Required significant hints
8. **Poor Communication**: Silent coding, vague explanations

---

## Key Differences Summary

| Aspect | Strong Candidate | Weak Candidate |
|--------|-----------------|----------------|
| **Clarification** | Asked multiple specific questions | No questions asked |
| **Examples** | Generated 2-3 examples including edge cases | Only used when prompted |
| **Approach** | Explained brute force and optimal | Vague, no optimization discussion |
| **Communication** | Constant verbalization | Silent coding |
| **Code Quality** | Clean, commented, correct | Buggy, needed fixes |
| **Testing** | Proactive with multiple cases | Reactive, minimal |
| **Complexity** | Accurate analysis with explanation | Incorrect, needed correction |
| **Optimization** | Independently arrived at optimal | Required heavy hints |

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

These transcripts demonstrate that technical interviews assess far more than coding ability. Communication, systematic thinking, and professional demeanor are equally important signals that distinguish strong candidates.
