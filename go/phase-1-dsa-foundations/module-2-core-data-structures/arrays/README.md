# Arrays and Slices

## Introduction

In Go, we primarily use **Slices** instead of raw Arrays. While Go has Arrays (fixed size), Slices are dynamic, flexible views into arrays and are the standard for virtually all list-like operations.

## Arrays vs Slices

### Arrays (The Underlying Storage)

**Definition**: Fixed size, value type.
```go
var arr [5]int  // Size 5, initialized to 0s
arr2 := [3]int{1, 2, 3}
```
**Characteristics**:
- Size is part of the type (`[5]int` != `[3]int`)
- Passed by value (copied!)
- Rarely used directly in interviews.

### Slices (The Dynamic Interface)

**Definition**: Window into an array.
```go
var s []int             // nil slice
s := make([]int, 5)     // slice of size 5
s := []int{1, 2, 3}     // slice literal
```
**Characteristics**:
- Dynamic size (via `append`)
- Reference type (cheap to pass)
- O(1) amortized append

### Slice Internals

A slice has 3 components:
1. **Pointer**: To the underlying array
2. **Length**: Number of elements in the slice
3. **Capacity**: Space available in underlying array

## Slice Operations and Complexities

### Access by Index
**Operation**: `s[i]`
**Current Time**: O(1)

### Append (Dynamic Growth)
**Operation**: `s = append(s, val)`
**Time**: O(1) amortized
**Details**: Go doubles capacity when full (up to a point), then grows by ~1.25x.

### Sub-slicing
**Operation**: `s[start:end]`
**Time**: O(1)
**Note**: Shares underlying memory! Modifying the sub-slice affects original.

### Search (Unsorted)
**Time**: O(n)
```go
found := false
for _, v := range s {
    if v == target { found = true; break }
}
```

### Search (Sorted)
**Time**: O(log n)
```go
import "sort"
idx := sort.SearchInts(s, target) // returns index where it should be
if idx < len(s) && s[idx] == target { /* found */ }
```

### Insert at Index (Costly)
**Time**: O(n)
```go
s = append(s[:i+1], s[i:]...) // Expand space
s[i] = element
```
Or more commonly:
```go
s = append(s, 0) // Make space
copy(s[i+1:], s[i:]) // Shift
s[i] = element
```

### Delete at Index
**Time**: O(n)
```go
s = append(s[:i], s[i+1:]...)
```

## Common Mistakes

### Mistake 1: Not Reassigning append
```go
append(s, val) // WRONG! append returns the new slice header
s = append(s, val) // CORRECT
```

### Mistake 2: Memory Leaks with Sub-slices
If you have a huge array and keep a tiny slice of it, the whole array stays in memory.
**Fix**: `copy` to a new smaller slice.

### Mistake 3: Range Loop on Pointer Slice
```go
for i, v := range ptrSlice {
    // v is a COPY of the pointer, usually fine
    // but if you take address &v, it's address of the loop variable
}
```

## Interview Tips

1. **Use Slices**: Almost always.
2. **Preallocate**: `make([]int, 0, n)` if you know size.
3. **Know `copy`**: `copy(dest, src)` is fast.
4. **Sort**: `sort.Ints(s)` or `sort.Slice(s, func...)`.