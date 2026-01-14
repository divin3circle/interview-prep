# Big-O Complexity Cheatsheet (Go Edition)

## Quick Reference Table

| Complexity | Name | Growth Rate | Example Operations | When n = 100 | When n = 1,000 |
|------------|------|-------------|-------------------|--------------|----------------|
| **O(1)** | Constant | Excellent | Slice access, Map get/put | 1 | 1 |
| **O(log n)** | Logarithmic | Excellent | Binary search, balanced BST | ~7 | ~10 |
| **O(n)** | Linear | Good | Linear search, single loop | 100 | 1,000 |
| **O(n log n)** | Linearithmic | Fair | Merge sort, Quick sort (avg) | ~664 | ~9,966 |
| **O(n²)** | Quadratic | Poor | Nested loops, bubble sort | 10,000 | 1,000,000 |
| **O(2^n)** | Exponential | Very Poor | Recursive Fibonacci | ~1.27×10³⁰ | Infeasible |

---

## Common Data Structure Operations

### Slice (Dynamic Array)

| Operation | Time Complexity | Notes |
|-----------|----------------|-------|
| Access by index | O(1) | Direct memory access |
| Search (unsorted) | O(n) | Must check each element |
| Search (sorted) | O(log n) | If you binary search |
| Append (end) | O(1) amortized | May require resize |
| Prepend/Insert | O(n) | Must shift elements |
| Delete | O(n) | Must shift elements |

**Space**: O(n)

---

### Linked List (Custom Struct)

| Operation | Time Complexity | Notes |
|-----------|----------------|-------|
| Access by index | O(n) | Must traverse from head |
| Search | O(n) | Must traverse list |
| Insert at head | O(1) | Update head pointer |
| Insert at tail | O(1) | If tail pointer maintained |

**Space**: O(n)

---

### Map (HashTable)

| Operation | Time Complexity (Average) | Time Complexity (Worst) | Notes |
|-----------|--------------------------|------------------------|-------|
| Insert | O(1) | O(n) | Worst case: hash collisions |
| Delete | O(1) | O(n) | Worst case: hash collisions |
| Search (Lookup) | O(1) | O(n) | Worst case: hash collisions |

**Space**: O(n)

---

## Pattern Recognition Guide

### When You See... Think...

| Code Pattern | Likely Complexity |
|--------------|------------------|
| Single loop through n elements | O(n) |
| Nested loops (both to n) | O(n²) |
| Loop dividing by 2 each time | O(log n) |
| Loop multiplying by 2 each time | O(log n) |
| Two sequential loops | O(n) |
| Recursive with 2 branches | O(2^n) |
| Sorting (`sort.Ints`) | O(n log n) |

---

## Space Complexity Patterns

| Pattern | Space Complexity |
|---------|-----------------|
| Fixed number of variables | O(1) |
| Slice of size n | O(n) |
| 2D slice of size n×n | O(n²) |
| Recursive call stack of depth n | O(n) |
| Map with n entries | O(n) |

---

## Optimization Strategies

### From O(n²) to O(n)

**Problem**: Finding pairs that sum to target

**Brute Force** (O(n²)):
```go
for i := 0; i < n; i++ {
    for j := i + 1; j < n; j++ {
        if arr[i] + arr[j] == target {
            // Found pair
        }
    }
}
```

**Optimized** (O(n)):
```go
seen := make(map[int]bool)
for _, num := range arr {
    if seen[target - num] {
        // Found pair
    }
    seen[num] = true
}
```

**Strategy**: Use Map to eliminate inner loop.

---

## Interview Quick Tips

### Before Coding

1. **State your approach**: "I'll use a Map for O(1) lookups"
2. **Mention complexity**: "This will be O(n) time and O(n) space"

### While Coding

1. **Explain as you go**: "This loop is O(n), Map operations are O(1)"

### After Coding

1. **Analyze complexity**: "Time: O(n), Space: O(n)"
2. **Discuss optimality**: "This is optimal because we must examine each element"
