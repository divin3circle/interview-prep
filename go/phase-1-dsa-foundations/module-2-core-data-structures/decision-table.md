# Data Structures Decision Table (Go Edition)

## Quick Reference: Choosing the Right Data Structure

## Decision Matrix

### By Primary Operation

| If You Need... | Use This | Time Complexity | Why |
|----------------|----------|----------------|-----|
| **Fast access by index** | Slice | O(1) | Direct memory calculation |
| **Fast search/lookup** | Map | O(1) average | Hash-based direct access |
| **Fast insertion at beginning** | LinkedList | O(1) | Just update head pointer |
| **Fast insertion at end** | Slice / LinkedList | O(1) amortized | Append operation |
| **Maintain sorted order** | Slice + Sort | O(n log n) | (Go lacks native TreeSet) |
| **Find min/max quickly** | Heap | O(1) peek | Root element is min/max |
| **LIFO (Last-In-First-Out)** | Stack (Slice) | O(1) | Push/pop at one end |
| **FIFO (First-In-First-Out)** | Queue (Slice) | O(1) | Remove from front |
| **Unique elements only** | Map[T]bool | O(1) | Duplicate prevention |
| **Key-value associations** | Map | O(1) | Direct key lookup |

---

## Detailed Comparison

### Slice vs LinkedList

| Operation | Slice | LinkedList | Winner |
|-----------|-------|------------|--------|
| Access by index | O(1) | O(n) | Slice |
| Search | O(n) | O(n) | Tie |
| Insert at beginning | O(n) | O(1) | LinkedList |
| Insert at end | O(1) amortized | O(1) | Tie |
| Memory overhead | Low | High (pointers) | Slice |
| Cache performance | Good | Poor | Slice |

**Use Slice when**: Random access is important, typical case.
**Use LinkedList when**: Frequent insertions/deletions at beginning only.

### Map vs Sorted Slice

In Java, you have `HashMap` vs `TreeMap`. In Go, you usually just use `map`. If order matters, you maintain a separate sorted keys slice or sort on demand.

---

## Common Patterns

### Pattern 1: Need O(1) Lookup → Map

```go
// Problem: Two Sum
m := make(map[int]int)
for i, num := range nums {
    complement := target - num
    if idx, ok := m[complement]; ok {
        return []int{idx, i}
    }
    m[num] = i
}
```

### Pattern 2: Need Sorted Order (Sort Slice)

```go
// Custom Sort
sort.Slice(people, func(i, j int) bool {
    return people[i].Age < people[j].Age
})
```

### Pattern 3: Need Min/Max Efficiently → Heap

```go
// Using container/heap
h := &MinHeap{}
heap.Init(h)
heap.Push(h, 5)
min := heap.Pop(h)
```

### Pattern 4: Need LIFO → Stack (Slice)

```go
// Push
stack = append(stack, val)
// Pop
val := stack[len(stack)-1]
stack = stack[:len(stack)-1]
```

### Pattern 5: Need FIFO → Queue (Slice)

```go
// Enqueue
queue = append(queue, val)
// Dequeue
val := queue[0]
queue = queue[1:]
```

---

## Common Mistakes

### Mistake 1: Not Preallocating Slice

```go
// BAD: May resize many times
nums := []int{}
for i := 0; i < n; i++ {
    nums = append(nums, i)
}

// GOOD: Allocates once
nums := make([]int, 0, n)
for i := 0; i < n; i++ {
    nums = append(nums, i)
}
```

### Mistake 2: Using Slice as Set (Linear Search)

```go
// BAD: O(n) lookup
for _, v := range slice {
    if v == target { return true }
}

// GOOD: O(1) lookup
if myMap[target] { return true }
```

### Mistake 3: String Concatenation in Loop

```go
// BAD: O(n²)
s := ""
for i := 0; i < n; i++ { s += "a" }

// GOOD: O(n)
var sb strings.Builder
for i := 0; i < n; i++ { sb.WriteString("a") }
```
