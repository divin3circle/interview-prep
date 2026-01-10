# Module 4: Two Pointers

## Pattern Overview

The Two Pointers pattern uses two pointers to traverse an array or string, typically from opposite ends or at different speeds. This technique reduces time complexity from O(n²) to O(n) for many problems.

## When to Use This Pattern

### Strong Signals

1. **Array is sorted** → Two pointers from both ends
2. **Find pair with target sum** → Two pointers converging
3. **Palindrome checking** → Two pointers from ends
4. **Remove duplicates in-place** → Fast and slow pointers
5. **Container/area problems** → Two pointers to maximize area

### Problem Characteristics

- Sorted array or string
- Need to find pairs or triplets
- In-place modification required
- Comparing elements from different positions

## Core Techniques

### Technique 1: Opposite Direction (Converging)
Used for sorted arrays or character sequences. One pointer starts at the beginning (`left = 0`) and the other at the end (`right = length - 1`). The pointers move toward each other based on a condition (e.g., sum comparison) until they meet.

**Time**: O(n), **Space**: O(1)

### Technique 2: Same Direction (Fast and Slow)
Used for in-place modifications or finding cycles. Both pointers start at the same end; one processes elements (`fast`) while the other tracks the target position (`slow`).

**Time**: O(n), **Space**: O(1)

### Technique 3: Sliding Window Variant
Two pointers that define a flexible range. The `right` pointer expands the window, and the `left` pointer shrinks it to maintain an invariant (e.g., no duplicates).

**Time**: O(n), **Space**: O(min(n, charset_size))

## Problems in This Module

### 1. Valid Palindrome
**Difficulty**: Easy  
**Pattern**: Two pointers from ends

Check if string is palindrome, ignoring non-alphanumeric characters.

[View Problem](01-valid-palindrome/README.md)

---

### 2. Two Sum II - Input Array Is Sorted
**Difficulty**: Medium  
**Pattern**: Two pointers converging

Find two numbers that sum to target in sorted array.

[View Problem](02-two-sum-ii/README.md)

---

### 3. 3Sum
**Difficulty**: Medium  
**Pattern**: Fixed element + two pointers

Find all unique triplets that sum to zero.

[View Problem](03-3sum/README.md)

---

### 4. Container With Most Water
**Difficulty**: Medium  
**Pattern**: Two pointers maximizing area

Find two lines that form container with maximum water.

[View Problem](04-container-water/README.md)

---

### 5. Trapping Rain Water
**Difficulty**: Hard  
**Pattern**: Two pointers with max tracking

Calculate how much rain water can be trapped.

[View Problem](05-trapping-rain-water/README.md)

---

## Complexity Analysis

| Approach | Time | Space | When to Use |
|----------|------|-------|-------------|
| Nested loops | O(n²) | O(1) | Never for these problems |
| Two pointers | O(n) | O(1) | Sorted arrays, palindromes |
| HashMap | O(n) | O(n) | Unsorted arrays |

## Common Mistakes

### Mistake 1: Not Handling Duplicates
In problems like 3Sum, forgotten duplicate checks lead to repeated results. Ensure you use `while` loops to skip adjacent identical elements after processing a valid case.

### Mistake 2: Wrong Pointer Movement
Carefully consider which pointer to move based on the condition. For example, in Two Sum II, if the current sum is less than the target, only moving the `left` pointer forward will increase the sum.

## Interview Tips

### Communication

1. **Identify sorted property**: "Since the array is sorted, we can use two pointers"
2. **Explain pointer movement**: "We move left when sum is too small, right when too large"
3. **Discuss optimization**: "Two pointers reduces from O(n²) to O(n)"

### Edge Cases to Consider

- Empty array or string
- Single element
- All same elements
- Duplicates
- Negative numbers
- Array not sorted (need to sort first)

## Completion Checklist

- [ ] Understand when to use opposite vs same direction pointers
- [ ] Can implement palindrome checking
- [ ] Can solve pair sum problems with two pointers
- [ ] Can extend to triplet problems (3Sum)
- [ ] Solve all 5 problems independently
- [ ] Explain solutions clearly
- [ ] Analyze complexity accurately

## Next Module

After mastering Two Pointers, proceed to [Module 5: Sliding Window](../module-5-sliding-window/README.md) to learn dynamic window techniques.

---

**Key Takeaway**: Two pointers transform O(n²) nested loop problems into O(n) single-pass solutions by exploiting sorted order or using fast/slow pointers.
