# Module 3: Arrays & Hashing

## Pattern Overview

Arrays & Hashing problems leverage **Hash Maps** (`map[K]V`) and **Sets** (`map[T]bool`) to improve time complexity.
Often, these data structures allow us to transform O(n²) nested loop solutions into O(n) single-pass solutions by trading space for time.

## When to Use This Pattern

### Strong Signals
1. **"Find duplicates"** → Use `map[T]bool` (Set).
2. **"Find pair summing to X"** → Use Map to store complement.
3. **"Count frequency"** → Use Map (`map[Key]int`).
4. **"Group similar items"** → Use Map with slice values (`map[Key][]string`).
5. **"Check if related"** → Map for mapping relationships.

## Core Techniques (Go Style)

### Technique 1: Set for Existence
Go doesn't have a built-in `Set` type. We use `map[T]bool` or `map[T]struct{}`.
```go
seen := make(map[int]bool)
if seen[val] { return true }
seen[val] = true
```
**Time**: O(n), **Space**: O(n)

### Technique 2: Lookups
Store value -> index/info mapping.
```go
lookup := make(map[int]int)
if idx, ok := lookup[target-val]; ok { ... }
```

### Technique 3: Frequency Counting
```go
counts := make(map[string]int)
counts[str]++
```

### Technique 4: Grouping
```go
groups := make(map[string][]string)
groups[key] = append(groups[key], val)
```

## Problems in This Module

### 1. Contains Duplicate
**Difficulty**: Easy
**Pattern**: Set
[View Problem](01-contains-duplicate/README.md)

### 2. Two Sum
**Difficulty**: Easy
**Pattern**: Complement Map
[View Problem](02-two-sum/README.md)

### 3. Valid Anagram
**Difficulty**: Easy
**Pattern**: Frequency Counter
[View Problem](03-valid-anagram/README.md)

### 4. Group Anagrams
**Difficulty**: Medium
**Pattern**: Map Grouping
[View Problem](04-group-anagrams/README.md)

### 5. Top K Frequent Elements
**Difficulty**: Medium
**Pattern**: Frequency Map + Bucket Sort / Heap
[View Problem](05-top-k-frequent/README.md)

### 6. Product of Array Except Self
**Difficulty**: Medium
**Pattern**: Prefix/Suffix Arrays
[View Problem](06-product-except-self/README.md)

## Common Mistakes in Go

1. **Ordering**: Maps are unordered. Don't rely on iteration order.
2. **Nil Maps**: You can read from a nil map, but writing panics! `m["key"] = val` on nil map crashes. Always `make()`.
3. **Reference Types**: Maps are reference types. Passing them to functions shares underlying data.

## Interview Tips

- **Mention the Space Tradeoff**: "I can make this faster (O(n)) by using a map, but it will cost O(n) memory. Is that acceptable?"
- **Preallocate**: If you know size, `make(map[int]int, len(nums))` avoids resizing overhead.
