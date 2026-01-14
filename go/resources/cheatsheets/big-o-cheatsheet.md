# Big-O Complexity Cheatsheet (Go Edition)

## Common Complexities

| Complexity | Name | Description | Go Example |
|------------|------|-------------|------------|
| **O(1)** | Constant | Direct access, no loops | `arr[i]`, `map[key]` |
| **O(log n)** | Logarithmic | Cut problem in half each step | Binary Search |
| **O(n)** | Linear | Loop through input once | `for _, v := range slice` |
| **O(n log n)** | Linearithmic | Divide and conquer | `sort.Slice()`, Merge Sort |
| **O(n²)** | Quadratic | Nested loops | Bubble Sort |
| **O(2^n)** | Exponential | Recursion with 2 branches | Fibonacci (Naive) |
| **O(n!)** | Factorial | Generating all permutations | TSP Brute Force |

## Data Structure Operations (Go)

| Structure | Access | Search | Insertion | Deletion | Go Type |
|-----------|--------|--------|-----------|----------|---------|
| **Slice** | O(1) | O(n) | O(n)* | O(n)* | `[]T` |
| **Stack** | O(n) | O(n) | O(1) | O(1) | `[]T` (append/pop) |
| **Queue** | O(n) | O(n) | O(1) | O(1) | `[]T` (append/shift) |
| **Linked List** | O(n) | O(n) | O(1)** | O(1)** | Custom `*Node` |
| **Map** | N/A | O(1) | O(1) | O(1) | `map[K]V` |
| **Heap** | O(1)*** | O(n) | O(log n) | O(log n) | `container/heap` |

*\* Amortized for append, O(n) for insert/delete in middle*  
*\*\* Assuming reference to node is held*  
*\*\*\* Access to min/max only*

## Go-Specific Notes

### Slice Operations
```go
// Append (amortized O(1))
slice = append(slice, val)

// Insert at index (O(n))
slice = append(slice[:i], append([]int{val}, slice[i:]...)...)

// Delete at index (O(n))
slice = append(slice[:i], slice[i+1:]...)

// Pop last (O(1))
val := slice[len(slice)-1]
slice = slice[:len(slice)-1]
```

### Map Operations
```go
// Insert/Update O(1)
m[key] = value

// Delete O(1)
delete(m, key)

// Check existence O(1)
if val, exists := m[key]; exists {
    // key exists
}
```

## Array Sorting Algorithms

| Algorithm | Best | Average | Worst | Space | Go Function |
|-----------|------|---------|-------|-------|-------------|
| **Quicksort** | O(n log n) | O(n log n) | O(n²) | O(log n) | `sort.Slice()` |
| **Mergesort** | O(n log n) | O(n log n) | O(n log n) | O(n) | - |
| **Heapsort** | O(n log n) | O(n log n) | O(n log n) | O(1) | - |
| **Insertion Sort** | O(n) | O(n²) | O(n²) | O(1) | - |

*Note: Go's `sort.Slice()` uses a hybrid algorithm (introsort: quicksort + heapsort + insertion sort)*

## String Operations (Go)

| Operation | Complexity | Example |
|-----------|------------|---------|
| **Concatenation (+)** | O(n) | `s1 + s2` (creates new string) |
| **strings.Builder** | O(1) amortized | `builder.WriteString(s)` |
| **Substring** | O(n) | `s[i:j]` (copies substring) |
| **Index/Contains** | O(n*m) | `strings.Contains(s, substr)` |
