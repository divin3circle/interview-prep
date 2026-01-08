# Big-O Complexity Cheatsheet

## Quick Reference Table

| Complexity | Name | Growth Rate | Example Operations | When n = 100 | When n = 1,000 |
|------------|------|-------------|-------------------|--------------|----------------|
| **O(1)** | Constant | Excellent | Array access, HashMap get/put | 1 | 1 |
| **O(log n)** | Logarithmic | Excellent | Binary search, balanced BST operations | ~7 | ~10 |
| **O(n)** | Linear | Good | Linear search, single loop | 100 | 1,000 |
| **O(n log n)** | Linearithmic | Fair | Merge sort, heap sort, quick sort (avg) | ~664 | ~9,966 |
| **O(n²)** | Quadratic | Poor | Nested loops, bubble sort | 10,000 | 1,000,000 |
| **O(2^n)** | Exponential | Very Poor | Recursive Fibonacci, subset generation | ~1.27×10³⁰ | Infeasible |
| **O(n!)** | Factorial | Extremely Poor | Permutation generation | ~9.3×10¹⁵⁷ | Infeasible |

---

## Common Data Structure Operations

### Array / ArrayList

| Operation | Time Complexity | Notes |
|-----------|----------------|-------|
| Access by index | O(1) | Direct memory access |
| Search (unsorted) | O(n) | Must check each element |
| Search (sorted) | O(log n) | Binary search |
| Insert at end | O(1) amortized | May require resize |
| Insert at beginning | O(n) | Must shift all elements |
| Insert at middle | O(n) | Must shift elements |
| Delete at end | O(1) | Simple removal |
| Delete at beginning | O(n) | Must shift all elements |
| Delete at middle | O(n) | Must shift elements |

**Space**: O(n)

---

### LinkedList

| Operation | Time Complexity | Notes |
|-----------|----------------|-------|
| Access by index | O(n) | Must traverse from head |
| Search | O(n) | Must traverse list |
| Insert at beginning | O(1) | Update head pointer |
| Insert at end | O(1) | If tail pointer maintained |
| Insert at middle | O(n) | Must find position first |
| Delete at beginning | O(1) | Update head pointer |
| Delete at end | O(n) | Must find second-to-last |
| Delete at middle | O(n) | Must find position first |

**Space**: O(n)

---

### Stack

| Operation | Time Complexity | Notes |
|-----------|----------------|-------|
| Push | O(1) | Add to top |
| Pop | O(1) | Remove from top |
| Peek | O(1) | View top element |
| Search | O(n) | Must check each element |

**Space**: O(n)

---

### Queue

| Operation | Time Complexity | Notes |
|-----------|----------------|-------|
| Enqueue | O(1) | Add to rear |
| Dequeue | O(1) | Remove from front |
| Peek | O(1) | View front element |
| Search | O(n) | Must check each element |

**Space**: O(n)

---

### HashMap / HashSet

| Operation | Time Complexity (Average) | Time Complexity (Worst) | Notes |
|-----------|--------------------------|------------------------|-------|
| Insert | O(1) | O(n) | Worst case: hash collisions |
| Delete | O(1) | O(n) | Worst case: hash collisions |
| Search | O(1) | O(n) | Worst case: hash collisions |
| Contains | O(1) | O(n) | Worst case: hash collisions |

**Space**: O(n)

**Note**: Worst case O(n) occurs with poor hash function or many collisions. Good hash functions make this extremely rare.

---

### Binary Search Tree (Balanced)

| Operation | Time Complexity (Average) | Time Complexity (Worst) | Notes |
|-----------|--------------------------|------------------------|-------|
| Search | O(log n) | O(n) | Worst: skewed tree |
| Insert | O(log n) | O(n) | Worst: skewed tree |
| Delete | O(log n) | O(n) | Worst: skewed tree |
| Find min/max | O(log n) | O(n) | Leftmost/rightmost node |

**Space**: O(n)

**Note**: Self-balancing trees (AVL, Red-Black) guarantee O(log n) for all operations.

---

### Heap / Priority Queue

| Operation | Time Complexity | Notes |
|-----------|----------------|-------|
| Insert | O(log n) | Bubble up |
| Delete min/max | O(log n) | Bubble down |
| Peek min/max | O(1) | Root element |
| Build heap | O(n) | Heapify algorithm |
| Search | O(n) | No efficient search |

**Space**: O(n)

---

### Graph (Adjacency List)

| Operation | Time Complexity | Notes |
|-----------|----------------|-------|
| Add vertex | O(1) | Add to list |
| Add edge | O(1) | Add to adjacency list |
| Remove vertex | O(V + E) | Remove from all lists |
| Remove edge | O(E) | Search adjacency list |
| Check if edge exists | O(V) | Search adjacency list |
| DFS/BFS | O(V + E) | Visit all vertices and edges |

**Space**: O(V + E) where V = vertices, E = edges

---

## Common Sorting Algorithms

| Algorithm | Best Case | Average Case | Worst Case | Space | Stable |
|-----------|-----------|--------------|------------|-------|--------|
| **Bubble Sort** | O(n) | O(n²) | O(n²) | O(1) | Yes |
| **Selection Sort** | O(n²) | O(n²) | O(n²) | O(1) | No |
| **Insertion Sort** | O(n) | O(n²) | O(n²) | O(1) | Yes |
| **Merge Sort** | O(n log n) | O(n log n) | O(n log n) | O(n) | Yes |
| **Quick Sort** | O(n log n) | O(n log n) | O(n²) | O(log n) | No |
| **Heap Sort** | O(n log n) | O(n log n) | O(n log n) | O(1) | No |
| **Counting Sort** | O(n + k) | O(n + k) | O(n + k) | O(k) | Yes |
| **Radix Sort** | O(d(n + k)) | O(d(n + k)) | O(d(n + k)) | O(n + k) | Yes |

**Notes**:
- k = range of input values
- d = number of digits
- Stable = maintains relative order of equal elements

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
| Loop with HashMap operations | O(n) |
| Recursive with 2 branches | O(2^n) |
| Divide and conquer (merge sort) | O(n log n) |
| Generating all permutations | O(n!) |
| Generating all subsets | O(2^n) |

---

## Space Complexity Patterns

| Pattern | Space Complexity |
|---------|-----------------|
| Fixed number of variables | O(1) |
| Array/list of size n | O(n) |
| 2D array of size n×n | O(n²) |
| Recursive call stack of depth n | O(n) |
| Recursive call stack of depth log n | O(log n) |
| HashMap with n entries | O(n) |

---

## Optimization Strategies

### From O(n²) to O(n)

**Problem**: Finding pairs that sum to target

**Brute Force** (O(n²)):
```java
for (int i = 0; i < n; i++) {
    for (int j = i + 1; j < n; j++) {
        if (arr[i] + arr[j] == target) {
            // Found pair
        }
    }
}
```

**Optimized** (O(n)):
```java
Set<Integer> seen = new HashSet<>();
for (int num : arr) {
    if (seen.contains(target - num)) {
        // Found pair
    }
    seen.add(num);
}
```

**Strategy**: Use HashMap/HashSet to eliminate inner loop.

---

### From O(n) to O(log n)

**Problem**: Searching in sorted array

**Linear Search** (O(n)):
```java
for (int i = 0; i < arr.length; i++) {
    if (arr[i] == target) return i;
}
```

**Binary Search** (O(log n)):
```java
int left = 0, right = arr.length - 1;
while (left <= right) {
    int mid = left + (right - left) / 2;
    if (arr[mid] == target) return mid;
    if (arr[mid] < target) left = mid + 1;
    else right = mid - 1;
}
```

**Strategy**: Exploit sorted property with binary search.

---

### From O(2^n) to O(n)

**Problem**: Fibonacci sequence

**Recursive** (O(2^n)):
```java
int fib(int n) {
    if (n <= 1) return n;
    return fib(n - 1) + fib(n - 2);
}
```

**Dynamic Programming** (O(n)):
```java
int fib(int n) {
    if (n <= 1) return n;
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
}
```

**Strategy**: Cache results to avoid recomputation (memoization/DP).

---

## Interview Quick Tips

### Before Coding

1. **State your approach**: "I'll use a HashMap for O(1) lookups"
2. **Mention complexity**: "This will be O(n) time and O(n) space"
3. **Discuss tradeoffs**: "I could do O(1) space but it would be O(n²) time"

### While Coding

1. **Explain as you go**: "This loop is O(n), HashMap operations are O(1)"
2. **Point out optimizations**: "I'm using a HashSet here to avoid the O(n) search"

### After Coding

1. **Analyze complexity**: "Time: O(n), Space: O(n)"
2. **Explain why**: "Single pass through array with constant-time HashMap operations"
3. **Discuss optimality**: "This is optimal because we must examine each element"

---

## Common Interview Questions

### "What's the time complexity?"

**Answer format**: "The time complexity is O(n) because [explain why]."

### "Can you optimize this?"

**Think about**:
- Can I use a better data structure?
- Can I eliminate nested loops?
- Can I use sorting to my advantage?
- Can I cache repeated calculations?

### "What's the space complexity?"

**Remember to count**:
- Extra arrays/lists created
- HashMap/HashSet storage
- Recursive call stack depth
- Don't count input or output

---

## Practice Checklist

- [ ] Can identify O(1), O(log n), O(n), O(n log n), O(n²) in code
- [ ] Can explain why each complexity class occurs
- [ ] Can analyze nested loops correctly
- [ ] Can determine recursive complexity
- [ ] Can calculate space complexity
- [ ] Can discuss time-space tradeoffs
- [ ] Can recognize optimization opportunities
- [ ] Can explain complexity in interviews

---

**Keep this cheatsheet handy during practice. With repetition, complexity analysis becomes automatic.**
