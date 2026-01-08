# Module 5: Sliding Window

## Pattern Overview

The Sliding Window pattern maintains a window of elements that satisfies certain conditions. The window expands and contracts dynamically as we traverse the array or string, enabling efficient solutions to subarray/substring problems.

## When to Use This Pattern

### Strong Signals

1. **Contiguous subarray/substring** → Sliding window
2. **"Longest/shortest substring with..."** → Dynamic window
3. **"Maximum/minimum sum of subarray size k"** → Fixed window
4. **"Find all subarrays that..."** → Sliding window with conditions

### Problem Characteristics

- Contiguous elements (subarray or substring)
- Optimization problem (max/min length, sum, etc.)
- Conditions on window contents
- Need O(n) instead of O(n²)

## Core Techniques

### Technique 1: Fixed-Size Window

```java
// Maximum sum of subarray of size k
public int maxSumFixedWindow(int[] arr, int k) {
    int windowSum = 0;
    
    // Initial window
    for (int i = 0; i < k; i++) {
        windowSum += arr[i];
    }
    
    int maxSum = windowSum;
    
    // Slide window
    for (int i = k; i < arr.length; i++) {
        windowSum = windowSum - arr[i - k] + arr[i];
        maxSum = Math.max(maxSum, windowSum);
    }
    
    return maxSum;
}
```

**Time**: O(n), **Space**: O(1)

### Technique 2: Dynamic Window (Expand/Contract)

```java
// Longest substring without repeating characters
public int lengthOfLongestSubstring(String s) {
    Set<Character> window = new HashSet<>();
    int left = 0, maxLen = 0;
    
    for (int right = 0; right < s.length(); right++) {
        // Contract window while duplicate exists
        while (window.contains(s.charAt(right))) {
            window.remove(s.charAt(left++));
        }
        window.add(s.charAt(right));
        maxLen = Math.max(maxLen, right - left + 1);
    }
    
    return maxLen;
}
```

**Time**: O(n), **Space**: O(min(n, charset_size))

## Problems in This Module

### 1. Best Time to Buy and Sell Stock
**Difficulty**: Easy  
**Pattern**: Sliding window variant (track minimum)

Find maximum profit from one buy and one sell.

[View Problem](01-best-time-stock/README.md)

---

### 2. Longest Substring Without Repeating Characters
**Difficulty**: Medium  
**Pattern**: Dynamic sliding window with HashSet

Find length of longest substring without repeating characters.

[View Problem](02-longest-substring/README.md)

---

### 3. Longest Repeating Character Replacement
**Difficulty**: Medium  
**Pattern**: Sliding window with frequency counting

Find longest substring with same letter after k replacements.

[View Problem](03-character-replacement/README.md)

---

### 4. Minimum Window Substring
**Difficulty**: Hard  
**Pattern**: Sliding window with character matching

Find minimum window containing all characters of target string.

[View Problem](04-minimum-window/README.md)

---

## Complexity Analysis

| Approach | Time | Space | When to Use |
|----------|------|-------|-------------|
| Nested loops | O(n²) or O(n³) | O(1) | Never for these problems |
| Sliding window | O(n) | O(k) | Contiguous subarrays/substrings |

## Common Mistakes

### Mistake 1: Not Contracting Window Properly

```java
// WRONG: Doesn't contract window when condition violated
while (right < s.length()) {
    window.add(s.charAt(right));
    right++;
}

// CORRECT: Contract when needed
for (int right = 0; right < s.length(); right++) {
    while (violatesCondition()) {
        window.remove(s.charAt(left++));
    }
    window.add(s.charAt(right));
}
```

### Mistake 2: Wrong Window Size Calculation

```java
// WRONG: Off-by-one error
int size = right - left;

// CORRECT: Inclusive range
int size = right - left + 1;
```

## Interview Tips

### Communication

1. **Identify window type**: "This needs a dynamic window that expands and contracts"
2. **Explain condition**: "We contract when we have duplicates"
3. **Discuss optimization**: "Sliding window reduces from O(n²) to O(n)"

### Edge Cases

- Empty string/array
- Single element
- All same elements
- No valid window exists
- Entire array is the answer

## Completion Checklist

- [ ] Understand fixed vs dynamic windows
- [ ] Can implement window expansion and contraction
- [ ] Can track window state (HashSet, HashMap, counters)
- [ ] Solve all 4 problems independently
- [ ] Explain solutions clearly

## Next Module

After mastering Sliding Window, proceed to [Module 6: Stack](../module-6-stack/README.md).

---

**Key Takeaway**: Sliding window transforms O(n²) nested loop problems into O(n) solutions by maintaining window state and avoiding redundant work.
