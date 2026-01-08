# Arrays

## Introduction

Arrays are the most fundamental data structure in computer science. They store elements of the same type in contiguous memory locations, allowing for extremely fast access by index. Understanding arrays deeply is essential because many other data structures are built on top of them.

## What is an Array?

An array is a collection of elements stored in consecutive memory locations. Each element can be accessed directly using its index (position) in constant time.

### Memory Layout

```
Memory Address:  1000   1004   1008   1012   1016
Array:           [  5  |  2  |  8  |  1  |  9  ]
Index:              0      1      2      3      4
```

**Key Insight**: Because elements are stored consecutively, the address of any element can be calculated:
```
address = base_address + (index × element_size)
```

This mathematical calculation is why array access is O(1) - it's just arithmetic, not a search.

## Static Arrays vs Dynamic Arrays

### Static Arrays

**Definition**: Fixed size determined at creation time.

**In Java**:
```java
int[] arr = new int[5];  // Size is 5, cannot change
```

**Characteristics**:
- Size cannot change after creation
- Memory allocated once
- No overhead for resizing
- Wastes memory if not fully used

### Dynamic Arrays (ArrayList in Java)

**Definition**: Automatically resizes when capacity is exceeded.

**In Java**:
```java
List<Integer> list = new ArrayList<>();  // Starts with default capacity
```

**How Resizing Works**:
1. When array is full and you add an element
2. Create new array (typically 1.5x or 2x the size)
3. Copy all elements to new array
4. Add the new element
5. Update reference to point to new array

**Example**:
```java
// Internal state progression
Initial: capacity=10, size=0  []
After 10 adds: capacity=10, size=10  [1,2,3,4,5,6,7,8,9,10]
Add 11th element:
  - Create new array: capacity=15 (1.5x growth)
  - Copy 10 elements: O(n)
  - Add element 11: O(1)
  - Result: capacity=15, size=11
```

**Amortized Analysis**:
- Most insertions: O(1) - just add to end
- Occasional resize: O(n) - copy all elements
- Over n insertions: Total cost = n + (1 + 2 + 4 + 8 + ... + n/2) < 2n
- Amortized cost per insertion: 2n/n = O(1)

## Array Operations and Complexities

### Access by Index

**Operation**: `arr[i]`

**Time Complexity**: O(1)

**How it works**:
```java
int value = arr[3];  // Direct memory calculation
// address = base + (3 × 4 bytes) = base + 12
```

**Why O(1)**: Simple arithmetic, no iteration needed.

### Search (Unsorted Array)

**Operation**: Find if element exists

**Time Complexity**: O(n)

**Implementation**:
```java
public boolean contains(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target) {
            return true;
        }
    }
    return false;
}
```

**Why O(n)**: Must potentially check every element.

### Search (Sorted Array)

**Operation**: Binary search

**Time Complexity**: O(log n)

**Implementation**:
```java
public int binarySearch(int[] arr, int target) {
    int left = 0, right = arr.length - 1;
    
    while (left <= right) {
        int mid = left + (right - left) / 2;
        
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    
    return -1;  // Not found
}
```

**Why O(log n)**: Cuts search space in half each iteration.

### Insert at End (ArrayList)

**Operation**: `list.add(element)`

**Time Complexity**: O(1) amortized

**Implementation**:
```java
public void add(int element) {
    if (size == capacity) {
        resize();  // O(n) occasionally
    }
    arr[size] = element;
    size++;
}
```

**Why O(1) amortized**: Resizing happens rarely, cost is spread across many insertions.

### Insert at Beginning

**Operation**: Insert at index 0

**Time Complexity**: O(n)

**Implementation**:
```java
public void insertAtBeginning(int[] arr, int element) {
    // Must shift all elements right
    for (int i = arr.length - 1; i > 0; i--) {
        arr[i] = arr[i - 1];
    }
    arr[0] = element;
}
```

**Visual**:
```
Before: [1, 2, 3, 4, 5]
Insert 0 at beginning:
Step 1: [1, 2, 3, 4, 4]  // Shift 5
Step 2: [1, 2, 3, 3, 4]  // Shift 4
Step 3: [1, 2, 2, 3, 4]  // Shift 3
Step 4: [1, 1, 2, 3, 4]  // Shift 2
Step 5: [0, 1, 2, 3, 4]  // Insert 0
```

**Why O(n)**: Must shift n elements.

### Insert at Middle

**Operation**: Insert at arbitrary index

**Time Complexity**: O(n)

**Implementation**:
```java
public void insertAt(int[] arr, int index, int element) {
    // Shift elements from index onwards
    for (int i = arr.length - 1; i > index; i--) {
        arr[i] = arr[i - 1];
    }
    arr[index] = element;
}
```

**Why O(n)**: On average, must shift n/2 elements, which is O(n).

### Delete at End

**Operation**: Remove last element

**Time Complexity**: O(1)

**Implementation**:
```java
public void removeLast() {
    if (size > 0) {
        size--;  // Just decrease size, no shifting needed
    }
}
```

**Why O(1)**: No elements need to be moved.

### Delete at Beginning

**Operation**: Remove first element

**Time Complexity**: O(n)

**Implementation**:
```java
public void removeFirst(int[] arr) {
    // Shift all elements left
    for (int i = 0; i < arr.length - 1; i++) {
        arr[i] = arr[i + 1];
    }
}
```

**Why O(n)**: Must shift all remaining elements.

### Delete at Middle

**Operation**: Remove element at arbitrary index

**Time Complexity**: O(n)

**Implementation**:
```java
public void removeAt(int[] arr, int index) {
    // Shift elements after index to the left
    for (int i = index; i < arr.length - 1; i++) {
        arr[i] = arr[i + 1];
    }
}
```

**Why O(n)**: On average, must shift n/2 elements.

## Common Array Patterns

### Pattern 1: Two Pointers

**Use Case**: Problems involving pairs, palindromes, or sorted arrays.

**Example**: Check if array is palindrome
```java
public boolean isPalindrome(int[] arr) {
    int left = 0;
    int right = arr.length - 1;
    
    while (left < right) {
        if (arr[left] != arr[right]) {
            return false;
        }
        left++;
        right--;
    }
    
    return true;
}
```

**Time**: O(n), **Space**: O(1)

### Pattern 2: Sliding Window

**Use Case**: Subarray problems with fixed or variable window size.

**Example**: Maximum sum of k consecutive elements
```java
public int maxSumSubarray(int[] arr, int k) {
    int maxSum = 0;
    int windowSum = 0;
    
    // Calculate sum of first window
    for (int i = 0; i < k; i++) {
        windowSum += arr[i];
    }
    maxSum = windowSum;
    
    // Slide window
    for (int i = k; i < arr.length; i++) {
        windowSum += arr[i] - arr[i - k];  // Add new, remove old
        maxSum = Math.max(maxSum, windowSum);
    }
    
    return maxSum;
}
```

**Time**: O(n), **Space**: O(1)

### Pattern 3: Prefix Sum

**Use Case**: Range sum queries, subarray sum problems.

**Example**: Range sum queries
```java
public class RangeSumQuery {
    private int[] prefixSum;
    
    public RangeSumQuery(int[] arr) {
        prefixSum = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }
    }
    
    public int rangeSum(int left, int right) {
        return prefixSum[right + 1] - prefixSum[left];
    }
}
```

**Preprocessing**: O(n), **Query**: O(1), **Space**: O(n)

### Pattern 4: In-Place Modification

**Use Case**: Modify array without extra space.

**Example**: Move zeros to end
```java
public void moveZeros(int[] arr) {
    int writeIndex = 0;
    
    // Move all non-zero elements to front
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] != 0) {
            arr[writeIndex] = arr[i];
            writeIndex++;
        }
    }
    
    // Fill remaining with zeros
    while (writeIndex < arr.length) {
        arr[writeIndex] = 0;
        writeIndex++;
    }
}
```

**Time**: O(n), **Space**: O(1)

### Pattern 5: Sorting-Based Solutions

**Use Case**: Problems that become easier when array is sorted.

**Example**: Find pair with target sum (sorted array)
```java
public int[] twoSum(int[] arr, int target) {
    Arrays.sort(arr);  // O(n log n)
    
    int left = 0, right = arr.length - 1;
    
    while (left < right) {
        int sum = arr[left] + arr[right];
        
        if (sum == target) {
            return new int[] {left, right};
        } else if (sum < target) {
            left++;
        } else {
            right--;
        }
    }
    
    return new int[] {-1, -1};
}
```

**Time**: O(n log n), **Space**: O(1)

## When to Use Arrays

### Use Arrays When:

1. **You need fast random access** - O(1) access by index
2. **You know the size in advance** - No wasted memory
3. **Memory efficiency is important** - No pointer overhead
4. **Cache performance matters** - Contiguous memory is cache-friendly
5. **You're implementing other data structures** - Stacks, queues, heaps often use arrays

### Don't Use Arrays When:

1. **Frequent insertions/deletions at beginning** - Use LinkedList instead
2. **Size changes frequently** - Use ArrayList for automatic resizing
3. **Need to maintain sorted order with insertions** - Use TreeSet
4. **Need fast lookups by value** - Use HashMap

## Common Mistakes

### Mistake 1: Off-by-One Errors

```java
// WRONG: Index out of bounds
for (int i = 0; i <= arr.length; i++) {  // Should be <, not <=
    System.out.println(arr[i]);
}

// CORRECT
for (int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}
```

### Mistake 2: Modifying Array While Iterating

```java
// WRONG: Can cause issues
for (int i = 0; i < list.size(); i++) {
    if (list.get(i) == 0) {
        list.remove(i);  // Changes size during iteration
    }
}

// CORRECT: Iterate backwards
for (int i = list.size() - 1; i >= 0; i--) {
    if (list.get(i) == 0) {
        list.remove(i);
    }
}
```

### Mistake 3: Not Checking Bounds

```java
// WRONG: No bounds checking
int value = arr[index];  // What if index is negative or >= length?

// CORRECT
if (index >= 0 && index < arr.length) {
    int value = arr[index];
}
```

### Mistake 4: Unnecessary Copying

```java
// WRONG: O(n) for each insertion at beginning
List<Integer> list = new ArrayList<>();
for (int i = 0; i < n; i++) {
    list.add(0, i);  // Shifts all elements each time
}

// CORRECT: Add at end, then reverse if needed
List<Integer> list = new ArrayList<>();
for (int i = 0; i < n; i++) {
    list.add(i);  // O(1) amortized
}
Collections.reverse(list);  // O(n) once
```

## Interview Tips

### 1. Clarify Array Properties

Ask:
- "Is the array sorted?"
- "Can it contain duplicates?"
- "What's the range of values?"
- "Can I modify the array in-place?"

### 2. Consider Space-Time Tradeoffs

- In-place: O(1) space but may be O(n²) time
- Extra array: O(n) space but can achieve O(n) time

### 3. Think About Edge Cases

- Empty array: `arr.length == 0`
- Single element: `arr.length == 1`
- All same values
- Already sorted/reverse sorted

### 4. Know Common Techniques

- Two pointers for sorted arrays
- Sliding window for subarrays
- Prefix sum for range queries
- Sorting to simplify problem

## Practice Problems

1. **Two Sum** - Use HashMap for O(n) solution
2. **Best Time to Buy and Sell Stock** - Track minimum, calculate profit
3. **Contains Duplicate** - Use HashSet or sort
4. **Product of Array Except Self** - Use prefix and suffix products
5. **Maximum Subarray** - Kadane's algorithm
6. **Merge Sorted Arrays** - Two pointers
7. **Rotate Array** - Reverse technique
8. **Move Zeros** - Two pointers in-place

## Summary

### Key Takeaways

1. Arrays provide **O(1) random access** via index
2. **Insertions/deletions are expensive** (O(n)) except at end
3. **ArrayList provides dynamic resizing** with O(1) amortized append
4. **Contiguous memory** makes arrays cache-friendly
5. **Many patterns** (two pointers, sliding window, prefix sum) work on arrays

### Complexity Reference

| Operation | Time | Notes |
|-----------|------|-------|
| Access | O(1) | Direct index calculation |
| Search (unsorted) | O(n) | Must check each element |
| Search (sorted) | O(log n) | Binary search |
| Insert at end | O(1) amortized | May require resize |
| Insert at beginning | O(n) | Must shift all elements |
| Delete at end | O(1) | No shifting needed |
| Delete at beginning | O(n) | Must shift all elements |

---

**Arrays are the foundation of many algorithms and data structures. Master them first, and other structures will be easier to understand.**
