# Module 5: Sliding Window

## Pattern Overview

The Sliding Window pattern maintains a window of elements that satisfy certain conditions. Expands and contracts dynamically to find optimal subarrays/substrings in O(N).

## Core Techniques (Go Style)

### 1. Fixed Window
Maintain state for `k` elements. Slide by adding `nums[i]` and removing `nums[i-k]`.
```go
// Sum of size k subarray
sum := 0
for i := 0; i < k; i++ { sum += nums[i] }
maxSum := sum
for i := k; i < len(nums); i++ {
    sum += nums[i] - nums[i-k]
    maxSum = max(maxSum, sum)
}
```

### 2. Dynamic Window (Expand/Contract)
`right` pointer expands window. `left` pointer contracts when condition is violated.
```go
l, r := 0, 0
for r < len(s) {
    // Add s[r] to window state
    
    // While condition invalid, shrink window from left
    for !valid() {
        // Remove s[l] state
        l++
    }
    // Update max/min result
    r++
}
```

## Problems in This Module

### 1. Best Time to Buy and Sell Stock
**Difficulty**: Easy
**Pattern**: Basic Window (Track Min)
[View Problem](01-best-time-stock/README.md)

### 2. Longest Substring Without Repeating Characters
**Difficulty**: Medium
**Pattern**: Dynamic Window + Set/Map
[View Problem](02-longest-substring/README.md)

### 3. Longest Repeating Character Replacement
**Difficulty**: Medium
**Pattern**: Dynamic Window + Frequency Count
[View Problem](03-character-replacement/README.md)

### 4. Minimum Window Substring
**Difficulty**: Hard
**Pattern**: Dynamic Window + Match Count
[View Problem](04-minimum-window/README.md)

## Common Mistakes in Go
- **Map access**: `count[char]++` works even if key is missing (zero value).
- **Window Size**: `r - l + 1` (inclusive) vs `r - l` (exclusive). Be consistent.

## Interview Tips
- **Contiguous?**: If problem asks for contiguous subarray/substring, think Sliding Window.
