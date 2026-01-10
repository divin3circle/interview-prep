# Module 3: Arrays & Hashing

## Pattern Overview

The Arrays & Hashing pattern leverages hash-based data structures (HashMap and HashSet) to achieve O(1) lookup time, transforming problems that would otherwise require O(n²) nested loops into O(n) single-pass solutions.

## When to Use This Pattern

### Strong Signals

1. **"Find duplicates"** → Use HashSet for O(1) existence checks
2. **"Find pair/elements that sum to X"** → Use HashMap to store complements
3. **"Count frequency of elements"** → Use HashMap for counting
4. **"Group similar items"** → Use HashMap with custom keys
5. **"Check if two things are related"** → Use HashMap for mapping

### Problem Characteristics

- Need to check if element exists: O(1) with HashSet
- Need to find complement or pair: O(1) lookup with HashMap
- Need to count occurrences: HashMap with frequency counting
- Need to group elements: HashMap with list values

## Core Techniques

### Technique 1: HashSet for Existence Checks
Use a `HashSet` to store elements as you iterate through the collection. For each element, check if it already exists in the set in O(1) time. This is the primary way to detect duplicates or previously seen values without nested loops.

**Time**: O(n), **Space**: O(n)

### Technique 2: HashMap for Pair Finding
Use a `HashMap` to store each element and its index (or the element itself) as you traverse the array. For each element `x`, check if the required complement (e.g., `target - x`) exists in the map. This transforms a search problem into a lookup problem.

**Time**: O(n), **Space**: O(n)

### Technique 3: Frequency Counting
Maintain a `HashMap<Element, Integer>` to store the count of each element. This is essential for problems involving anagrams, finding top-K frequent elements, or any problem requiring the "distribution" of values.

**Time**: O(n), **Space**: O(n)

### Technique 4: Grouping with HashMap
Use a `HashMap` where the value is a list (e.g., `Map<String, List<String>>`). Generate a "canonical form" (like a sorted string or a frequency key) and use it as the map key to group related items together.

**Time**: O(n × k log k) where k = average string length, **Space**: O(n × k)

## Problems in This Module

### 1. Contains Duplicate
**Difficulty**: Easy  
**Pattern**: HashSet for existence check

Given an integer array, return true if any value appears at least twice.

[View Problem](01-contains-duplicate/README.md)

---

### 2. Two Sum
**Difficulty**: Easy  
**Pattern**: HashMap for complement lookup

Find two indices that sum to target value.

[View Problem](02-two-sum/README.md)

---

### 3. Valid Anagram
**Difficulty**: Easy  
**Pattern**: Frequency counting

Determine if two strings are anagrams.

[View Problem](03-valid-anagram/README.md)

---

### 4. Group Anagrams
**Difficulty**: Medium  
**Pattern**: HashMap grouping

Group strings that are anagrams of each other.

[View Problem](04-group-anagrams/README.md)

---

### 5. Top K Frequent Elements
**Difficulty**: Medium  
**Pattern**: Frequency counting + bucket sort

Find the k most frequent elements.

[View Problem](05-top-k-frequent/README.md)

---

### 6. Product of Array Except Self
**Difficulty**: Medium  
**Pattern**: Prefix/suffix products

Calculate product of all elements except current.

[View Problem](06-product-except-self/README.md)

---

## Complexity Analysis

| Approach | Time | Space | When to Use |
|----------|------|-------|-------------|
| Nested loops | O(n²) | O(1) | Never for these problems |
| Sorting | O(n log n) | O(1) | When order matters |
| HashMap | O(n) | O(n) | Default choice for most problems |
| HashSet | O(n) | O(n) | Existence checks only |

## Common Mistakes

### Mistake 1: Using Nested Loops
Avoid using O(n²) double loops to check for existence or pairs. Instead, use a `HashSet` or `HashMap` to achieve O(n) time.

### Mistake 2: Not Using getOrDefault
When counting frequencies in Java, use `map.getOrDefault(key, 0) + 1` to write cleaner, more efficient code and avoid verbose `null` checks.

### Mistake 3: Forgetting containsKey Check
Before retrieving a value that must exist, ensure you check `containsKey()` or handle potential `null` returns from `get()` to prevent `NullPointerException`.

## Interview Tips

### Communication

1. **Identify the pattern early**: "This looks like a hash map problem because we need O(1) lookups"
2. **Discuss space tradeoff**: "We're trading O(n) space for O(n) time instead of O(n²)"
3. **Mention alternatives**: "We could sort first, but that would be O(n log n)"

### Edge Cases to Consider

- Empty array
- Single element
- All duplicates
- No duplicates
- Negative numbers
- Zero values
- Very large numbers

## Completion Checklist

- [ ] Understand when to use HashMap vs HashSet
- [ ] Can implement frequency counting pattern
- [ ] Can use HashMap for pair finding
- [ ] Can group elements with HashMap
- [ ] Solve all 6 problems independently
- [ ] Explain solutions clearly
- [ ] Analyze complexity accurately

## Next Module

After mastering Arrays & Hashing, proceed to [Module 4: Two Pointers](../module-4-two-pointers/README.md) to learn efficient array traversal techniques.

---

**Key Takeaway**: Hash-based data structures transform O(n²) problems into O(n) solutions by trading space for time.
