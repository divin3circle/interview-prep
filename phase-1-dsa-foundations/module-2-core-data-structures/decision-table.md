# Data Structures Decision Table

## Quick Reference: Choosing the Right Data Structure

This table helps you quickly identify which data structure to use based on your requirements.

---

## Decision Matrix

### By Primary Operation

| If You Need... | Use This | Time Complexity | Why |
|----------------|----------|----------------|-----|
| **Fast access by index** | Array / ArrayList | O(1) | Direct memory calculation |
| **Fast search/lookup** | HashMap / HashSet | O(1) average | Hash-based direct access |
| **Fast insertion at beginning** | LinkedList | O(1) | Just update head pointer |
| **Fast insertion at end** | ArrayList / LinkedList | O(1) amortized | Append operation |
| **Maintain sorted order** | TreeSet / TreeMap | O(log n) | Self-balancing tree |
| **Find min/max quickly** | Heap / PriorityQueue | O(1) peek, O(log n) remove | Root element is min/max |
| **LIFO (Last-In-First-Out)** | Stack | O(1) | Push/pop at one end |
| **FIFO (First-In-First-Out)** | Queue | O(1) | Add at rear, remove from front |
| **Unique elements only** | HashSet / TreeSet | O(1) / O(log n) | Automatic duplicate prevention |
| **Key-value associations** | HashMap / TreeMap | O(1) / O(log n) | Direct key lookup |

---

## By Problem Type

| Problem Type | Recommended Structure | Example Problems |
|--------------|---------------------|------------------|
| **Counting frequency** | HashMap | Character frequency, word count |
| **Detecting duplicates** | HashSet | Contains duplicate, unique elements |
| **Finding pairs/complements** | HashMap | Two sum, pair with target sum |
| **Tracking seen elements** | HashSet | First unique character |
| **Nested structures** | Stack | Valid parentheses, nested brackets |
| **Undo operations** | Stack | Text editor undo, browser history |
| **Level-order processing** | Queue | Binary tree level-order, BFS |
| **Task scheduling** | Queue | Process scheduling, printer queue |
| **Top K elements** | Heap | K largest elements, K closest points |
| **Streaming median** | Two Heaps | Running median, sliding window median |
| **Range queries** | Segment Tree / Fenwick Tree | Sum of range, min in range |
| **Hierarchical data** | Tree | File system, organization chart |
| **Network/relationships** | Graph | Social network, road map |

---

## By Constraint

| Constraint | Best Choice | Alternative | Notes |
|------------|-------------|-------------|-------|
| **Memory is limited** | Array (fixed size) | LinkedList | Arrays more memory-efficient |
| **Frequent insertions/deletions** | LinkedList | ArrayList | Avoid shifting elements |
| **Need random access** | Array / ArrayList | - | O(1) vs O(n) for LinkedList |
| **Data must be sorted** | TreeSet / TreeMap | Sorted ArrayList | Maintain order automatically |
| **Need fast lookups** | HashMap / HashSet | - | O(1) vs O(n) for arrays |
| **Data size unknown** | ArrayList / LinkedList | Array | Dynamic resizing |
| **Need to iterate in order** | ArrayList / LinkedList | HashMap | Predictable iteration |

---

## Detailed Comparison

### Arrays vs LinkedLists

| Operation | Array | LinkedList | Winner |
|-----------|-------|------------|--------|
| Access by index | O(1) | O(n) | Array |
| Search | O(n) | O(n) | Tie |
| Insert at beginning | O(n) | O(1) | LinkedList |
| Insert at end | O(1) amortized | O(1) | Tie |
| Insert in middle | O(n) | O(n) | Tie (but LinkedList better if position known) |
| Delete at beginning | O(n) | O(1) | LinkedList |
| Delete at end | O(1) | O(n) | Array |
| Memory overhead | Low | High (pointers) | Array |
| Cache performance | Good | Poor | Array |

**Use Array when**: Random access is important, memory is limited, data size is known
**Use LinkedList when**: Frequent insertions/deletions at beginning, data size varies greatly

---

### HashMap vs TreeMap

| Feature | HashMap | TreeMap | Winner |
|---------|---------|---------|--------|
| Get/Put | O(1) average | O(log n) | HashMap |
| Ordered keys | No | Yes | TreeMap |
| Null keys | Allowed (1) | Not allowed | HashMap |
| Memory | Less | More | HashMap |
| Iteration order | Unpredictable | Sorted | TreeMap |

**Use HashMap when**: Need fastest possible lookups, don't care about order
**Use TreeMap when**: Need sorted keys, need range operations (floor, ceiling)

---

### HashSet vs TreeSet

| Feature | HashSet | TreeSet | Winner |
|---------|---------|---------|--------|
| Add/Remove/Contains | O(1) average | O(log n) | HashSet |
| Ordered elements | No | Yes | TreeSet |
| Null elements | Allowed (1) | Not allowed | HashSet |
| Memory | Less | More | HashSet |
| Iteration order | Unpredictable | Sorted | TreeSet |

**Use HashSet when**: Need fastest possible operations, don't care about order
**Use TreeSet when**: Need sorted elements, need range operations

---

### Stack vs Queue

| Use Case | Stack (LIFO) | Queue (FIFO) |
|----------|--------------|--------------|
| Function calls | ✓ | |
| Undo operations | ✓ | |
| Backtracking | ✓ | |
| DFS | ✓ | |
| Expression evaluation | ✓ | |
| Task scheduling | | ✓ |
| BFS | | ✓ |
| Print queue | | ✓ |
| Request handling | | ✓ |

---

## Common Patterns

### Pattern 1: Need O(1) Lookup → HashMap/HashSet

```java
// Problem: Two Sum
Map<Integer, Integer> map = new HashMap<>();
for (int i = 0; i < nums.length; i++) {
    int complement = target - nums[i];
    if (map.containsKey(complement)) {
        return new int[] {map.get(complement), i};
    }
    map.put(nums[i], i);
}
```

### Pattern 2: Need Sorted Order → TreeSet/TreeMap

```java
// Problem: K Closest Points
TreeMap<Double, Point> map = new TreeMap<>();
for (Point p : points) {
    double dist = distance(p);
    map.put(dist, p);
}
// First K entries are closest
```

### Pattern 3: Need Min/Max Efficiently → Heap

```java
// Problem: K Largest Elements
PriorityQueue<Integer> minHeap = new PriorityQueue<>();
for (int num : nums) {
    minHeap.offer(num);
    if (minHeap.size() > k) {
        minHeap.poll();
    }
}
// Heap contains K largest elements
```

### Pattern 4: Need LIFO → Stack

```java
// Problem: Valid Parentheses
Stack<Character> stack = new Stack<>();
for (char c : s.toCharArray()) {
    if (isOpening(c)) {
        stack.push(c);
    } else {
        if (stack.isEmpty() || !matches(stack.pop(), c)) {
            return false;
        }
    }
}
return stack.isEmpty();
```

### Pattern 5: Need FIFO → Queue

```java
// Problem: Binary Tree Level Order
Queue<TreeNode> queue = new LinkedList<>();
queue.offer(root);
while (!queue.isEmpty()) {
    TreeNode node = queue.poll();
    process(node);
    if (node.left != null) queue.offer(node.left);
    if (node.right != null) queue.offer(node.right);
}
```

---

## Interview Decision Flowchart

```
START
  ↓
Do you need to store key-value pairs?
  ├─ YES → Do you need sorted keys?
  │         ├─ YES → TreeMap
  │         └─ NO → HashMap
  │
  └─ NO → Do you need unique elements only?
            ├─ YES → Do you need sorted elements?
            │         ├─ YES → TreeSet
            │         └─ NO → HashSet
            │
            └─ NO → Do you need fast access by index?
                      ├─ YES → ArrayList
                      │
                      └─ NO → Do you need LIFO?
                                ├─ YES → Stack
                                │
                                └─ NO → Do you need FIFO?
                                          ├─ YES → Queue
                                          │
                                          └─ NO → Do you need min/max?
                                                    ├─ YES → Heap
                                                    │
                                                    └─ NO → Do you need hierarchy?
                                                              ├─ YES → Tree
                                                              └─ NO → Graph
```

---

## Space-Time Tradeoffs

### Example: Finding Duplicates

| Approach | Time | Space | Trade-off |
|----------|------|-------|-----------|
| Nested loops | O(n²) | O(1) | Slow but no extra space |
| Sorting first | O(n log n) | O(1)* | Faster but modifies input |
| HashSet | O(n) | O(n) | Fastest but uses extra space |

*Depends on sorting algorithm

**General Rule**: You can often trade space for time, but not always vice versa.

---

## Common Mistakes

### Mistake 1: Using ArrayList for Frequent Insertions at Beginning

```java
// BAD: O(n) per insertion
List<Integer> list = new ArrayList<>();
for (int i = 0; i < n; i++) {
    list.add(0, i);  // Shifts all elements!
}

// GOOD: O(1) per insertion
LinkedList<Integer> list = new LinkedList<>();
for (int i = 0; i < n; i++) {
    list.addFirst(i);
}
```

### Mistake 2: Using Array When Need Fast Lookups

```java
// BAD: O(n) lookup
int[] arr = new int[n];
for (int num : arr) {
    if (num == target) return true;  // Linear search
}

// GOOD: O(1) lookup
Set<Integer> set = new HashSet<>();
return set.contains(target);
```

### Mistake 3: Not Considering Memory

```java
// BAD: Unnecessary space for simple counting
Map<Character, Integer> freq = new HashMap<>();

// GOOD: Array is sufficient for limited character set
int[] freq = new int[26];  // For lowercase letters
```

---

## Quick Tips for Interviews

1. **Ask about constraints**: "How large is the input?" "Are there duplicates?"
2. **Start simple**: Begin with array, optimize to HashMap if needed
3. **Know your complexities**: Memorize the operation costs
4. **Consider space**: Discuss space-time tradeoffs
5. **Think about edge cases**: Empty input, single element, all same values

---

**Use this table as a quick reference during problem-solving. With practice, choosing the right data structure becomes intuitive.**
