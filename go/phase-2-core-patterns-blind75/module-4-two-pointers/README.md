# Module 4: Two Pointers

## Pattern Overview

The Two Pointers pattern utilizes two pointers to traverse an array or string, typically from different positions or at different speeds. This often improves time complexity from O(N²) to O(N).

## When to Use This Pattern

### Strong Signals
1. **Array is Sorted** → Pointers from both ends.
2. **Find pair with target sum** → Converging pointers.
3. **Palindrome checking** → Pointers from ends moving inward.
4. **Partition / Remove element** → Fast and slow pointers.

## Core Techniques (Go Style)

### 1. Opposing Pointers (Converging)
Used for sorted arrays or palindromes.
```go
left, right := 0, len(nums)-1
for left < right {
    // Logic
    // left++ or right--
}
```

### 2. Same Direction (Fast & Slow)
Used for in-place modifications or cycle detection.
```go
slow := 0
for fast := 0; fast < len(nums); fast++ {
    if condition(nums[fast]) {
        nums[slow] = nums[fast]
        slow++
    }
}
```

## Problems in This Module

### 1. Valid Palindrome
**Difficulty**: Easy
**Pattern**: Two Pointers from ends
[View Problem](01-valid-palindrome/README.md)

### 2. Two Sum II - Input Array Is Sorted
**Difficulty**: Medium
**Pattern**: Converging Pointers
[View Problem](02-two-sum-ii/README.md)

### 3. 3Sum
**Difficulty**: Medium
**Pattern**: Fixed element + Two Pointers
[View Problem](03-3sum/README.md)

### 4. Container With Most Water
**Difficulty**: Medium
**Pattern**: Converging Pointers (Maximize Area)
[View Problem](04-container-water/README.md)

### 5. Trapping Rain Water
**Difficulty**: Hard
**Pattern**: Two Pointers with Max Tracking
[View Problem](05-trapping-rain-water/README.md)

## Common Mistakes in Go
- **Off-by-one errors**: Be careful with `left < right` vs `left <= right`.
- **Rune vs Byte**: Strings in Go are UTF-8. Iterating by index gives bytes. Use `[]rune(str)` if you need unicode character support, though often for interview problems ASCII is assumed or `unicode` package helps.

## Interview Tips
- **Sorted?**: Always ask if the input is sorted. If so, Two Pointers is highly likely.
