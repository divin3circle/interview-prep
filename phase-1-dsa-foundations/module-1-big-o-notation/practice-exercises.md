# Big-O Complexity Analysis - Practice Exercises

## Instructions

For each code snippet below:
1. Determine the time complexity
2. Determine the space complexity
3. Explain your reasoning
4. Check your answer against the solution

Practice analyzing code without running it. This skill is essential for technical interviews.

---

## Exercise 1: Simple Loop

```java
public void printArray(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
        System.out.println(arr[i]);
    }
}
```

**Your Analysis**:
- Time Complexity: _______________
- Space Complexity: _______________
- Reasoning: _______________

<details>
<summary>Click to reveal solution</summary>

**Time Complexity**: O(n) where n = arr.length

**Space Complexity**: O(1)

**Explanation**:
- The loop runs exactly n times (once for each element)
- Each iteration performs O(1) work (printing)
- Total: n × O(1) = O(n)
- Space: Only using variable `i`, which is constant space

</details>

---

## Exercise 2: Nested Loops

```java
public void printPairs(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < arr.length; j++) {
            System.out.println(arr[i] + "," + arr[j]);
        }
    }
}
```

**Your Analysis**:
- Time Complexity: _______________
- Space Complexity: _______________
- Reasoning: _______________

<details>
<summary>Click to reveal solution</summary>

**Time Complexity**: O(n²) where n = arr.length

**Space Complexity**: O(1)

**Explanation**:
- Outer loop runs n times
- For each outer iteration, inner loop runs n times
- Total iterations: n × n = n²
- Each iteration does O(1) work
- Total: O(n²)
- Space: Only using variables `i` and `j`

</details>

---

## Exercise 3: Nested Loops with Different Ranges

```java
public void printPairs(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
        for (int j = i + 1; j < arr.length; j++) {
            System.out.println(arr[i] + "," + arr[j]);
        }
    }
}
```

**Your Analysis**:
- Time Complexity: _______________
- Space Complexity: _______________
- Reasoning: _______________

<details>
<summary>Click to reveal solution</summary>

**Time Complexity**: O(n²) where n = arr.length

**Space Complexity**: O(1)

**Explanation**:
- First iteration: inner loop runs (n-1) times
- Second iteration: inner loop runs (n-2) times
- ...
- Last iteration: inner loop runs 0 times
- Total: (n-1) + (n-2) + ... + 1 + 0 = n(n-1)/2 = (n² - n)/2
- Drop constants and lower-order terms: O(n²)
- Even though we do half the work, it's still quadratic growth

</details>

---

## Exercise 4: Binary Search

```java
public int binarySearch(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;
    
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
    
    return -1;
}
```

**Your Analysis**:
- Time Complexity: _______________
- Space Complexity: _______________
- Reasoning: _______________

<details>
<summary>Click to reveal solution</summary>

**Time Complexity**: O(log n) where n = arr.length

**Space Complexity**: O(1)

**Explanation**:
- Each iteration cuts the search space in half
- Start with n elements
- After 1 iteration: n/2 elements
- After 2 iterations: n/4 elements
- After k iterations: n/2^k elements
- When n/2^k = 1, we're done: k = log₂(n)
- Space: Only using a few variables (left, right, mid)

</details>

---

## Exercise 5: Sequential Loops

```java
public void process(int[] arr) {
    // First loop
    for (int i = 0; i < arr.length; i++) {
        System.out.println(arr[i]);
    }
    
    // Second loop
    for (int i = 0; i < arr.length; i++) {
        System.out.println(arr[i] * 2);
    }
}
```

**Your Analysis**:
- Time Complexity: _______________
- Space Complexity: _______________
- Reasoning: _______________

<details>
<summary>Click to reveal solution</summary>

**Time Complexity**: O(n) where n = arr.length

**Space Complexity**: O(1)

**Explanation**:
- First loop: O(n)
- Second loop: O(n)
- Total: O(n) + O(n) = O(2n) = O(n)
- We drop the constant 2
- Space: Only using variable `i`

</details>

---

## Exercise 6: Loop with Doubling

```java
public void printPowersOfTwo(int n) {
    for (int i = 1; i < n; i = i * 2) {
        System.out.println(i);
    }
}
```

**Your Analysis**:
- Time Complexity: _______________
- Space Complexity: _______________
- Reasoning: _______________

<details>
<summary>Click to reveal solution</summary>

**Time Complexity**: O(log n)

**Space Complexity**: O(1)

**Explanation**:
- i starts at 1 and doubles each iteration: 1, 2, 4, 8, 16, ...
- Sequence: 2^0, 2^1, 2^2, 2^3, ..., 2^k
- Loop stops when 2^k ≥ n
- Therefore k = log₂(n)
- Space: Only using variable `i`

</details>

---

## Exercise 7: Creating New Array

```java
public int[] doubleArray(int[] arr) {
    int[] result = new int[arr.length];
    
    for (int i = 0; i < arr.length; i++) {
        result[i] = arr[i] * 2;
    }
    
    return result;
}
```

**Your Analysis**:
- Time Complexity: _______________
- Space Complexity: _______________
- Reasoning: _______________

<details>
<summary>Click to reveal solution</summary>

**Time Complexity**: O(n) where n = arr.length

**Space Complexity**: O(n)

**Explanation**:
- Loop runs n times, each iteration does O(1) work
- Time: O(n)
- We create a new array of size n
- Space: O(n) for the result array
- Note: We don't count input array in space complexity

</details>

---

## Exercise 8: Recursive Factorial

```java
public int factorial(int n) {
    if (n <= 1) {
        return 1;
    }
    return n * factorial(n - 1);
}
```

**Your Analysis**:
- Time Complexity: _______________
- Space Complexity: _______________
- Reasoning: _______________

<details>
<summary>Click to reveal solution</summary>

**Time Complexity**: O(n)

**Space Complexity**: O(n)

**Explanation**:
- Function calls itself n times (n, n-1, n-2, ..., 1)
- Each call does O(1) work (multiplication)
- Time: O(n)
- Call stack depth is n (each call waits for the next to complete)
- Space: O(n) for the call stack

</details>

---

## Exercise 9: Fibonacci (Naive Recursive)

```java
public int fibonacci(int n) {
    if (n <= 1) {
        return n;
    }
    return fibonacci(n - 1) + fibonacci(n - 2);
}
```

**Your Analysis**:
- Time Complexity: _______________
- Space Complexity: _______________
- Reasoning: _______________

<details>
<summary>Click to reveal solution</summary>

**Time Complexity**: O(2^n)

**Space Complexity**: O(n)

**Explanation**:
- Each call makes 2 recursive calls
- Forms a binary tree of calls
- Tree has height n
- Number of nodes in tree: 2^0 + 2^1 + 2^2 + ... + 2^n ≈ 2^(n+1) - 1
- Time: O(2^n)
- Maximum call stack depth is n (longest path in tree)
- Space: O(n) for call stack

</details>

---

## Exercise 10: String Concatenation in Loop

```java
public String concatenate(String[] words) {
    String result = "";
    
    for (int i = 0; i < words.length; i++) {
        result += words[i];  // String concatenation
    }
    
    return result;
}
```

**Your Analysis**:
- Time Complexity: _______________
- Space Complexity: _______________
- Reasoning: _______________

<details>
<summary>Click to reveal solution</summary>

**Time Complexity**: O(n²) where n = total characters

**Space Complexity**: O(n)

**Explanation**:
- String concatenation creates a new string each time
- If each word has average length m and there are k words:
  - Iteration 1: copy m characters
  - Iteration 2: copy 2m characters
  - Iteration 3: copy 3m characters
  - ...
  - Total: m + 2m + 3m + ... + km = m(1 + 2 + 3 + ... + k) = m × k(k+1)/2
- This is O(k²) in terms of number of words
- Or O(n²) where n is total characters
- Space: O(n) for the final result string
- **Better approach**: Use StringBuilder for O(n) time

</details>

---

## Exercise 11: HashMap Operations

```java
public boolean hasDuplicate(int[] arr) {
    Set<Integer> seen = new HashSet<>();
    
    for (int num : arr) {
        if (seen.contains(num)) {
            return true;
        }
        seen.add(num);
    }
    
    return false;
}
```

**Your Analysis**:
- Time Complexity: _______________
- Space Complexity: _______________
- Reasoning: _______________

<details>
<summary>Click to reveal solution</summary>

**Time Complexity**: O(n) where n = arr.length

**Space Complexity**: O(n)

**Explanation**:
- Loop runs n times
- HashSet contains() is O(1) average case
- HashSet add() is O(1) average case
- Total: n × O(1) = O(n)
- In worst case (all unique elements), HashSet stores n elements
- Space: O(n)

</details>

---

## Exercise 12: Merge Sort

```java
public void mergeSort(int[] arr, int left, int right) {
    if (left < right) {
        int mid = left + (right - left) / 2;
        
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);  // O(n) operation
    }
}
```

**Your Analysis**:
- Time Complexity: _______________
- Space Complexity: _______________
- Reasoning: _______________

<details>
<summary>Click to reveal solution</summary>

**Time Complexity**: O(n log n) where n = arr.length

**Space Complexity**: O(n)

**Explanation**:
- Recursion tree has log n levels (dividing by 2 each time)
- Each level processes all n elements (in merge operations)
- Total: n × log n = O(n log n)
- Space: O(n) for temporary arrays in merge operations
- Also O(log n) for call stack, but O(n) dominates

</details>

---

## Exercise 13: Nested Loop with HashMap

```java
public void process(int[] arr) {
    Map<Integer, Integer> map = new HashMap<>();
    
    for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < arr.length; j++) {
            map.put(arr[i] + arr[j], i);
        }
    }
}
```

**Your Analysis**:
- Time Complexity: _______________
- Space Complexity: _______________
- Reasoning: _______________

<details>
<summary>Click to reveal solution</summary>

**Time Complexity**: O(n²) where n = arr.length

**Space Complexity**: O(n²)

**Explanation**:
- Nested loops: n × n = n² iterations
- HashMap put() is O(1) average case
- Time: O(n²)
- In worst case, all sums are unique
- Maximum entries in map: n² (all pairs)
- Space: O(n²)

</details>

---

## Exercise 14: Two Different Arrays

```java
public void printCombinations(int[] arr1, int[] arr2) {
    for (int i = 0; i < arr1.length; i++) {
        for (int j = 0; j < arr2.length; j++) {
            System.out.println(arr1[i] + "," + arr2[j]);
        }
    }
}
```

**Your Analysis**:
- Time Complexity: _______________
- Space Complexity: _______________
- Reasoning: _______________

<details>
<summary>Click to reveal solution</summary>

**Time Complexity**: O(a × b) where a = arr1.length, b = arr2.length

**Space Complexity**: O(1)

**Explanation**:
- Outer loop runs a times
- Inner loop runs b times for each outer iteration
- Total: a × b iterations
- Cannot simplify to O(n²) because arrays may have different sizes
- Must use two variables: O(a × b)
- Space: Only using variables i and j

</details>

---

## Exercise 15: Complex Example

```java
public void complexFunction(int n) {
    // Part 1
    for (int i = 0; i < n; i++) {
        System.out.println(i);
    }
    
    // Part 2
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            System.out.println(i + "," + j);
        }
    }
    
    // Part 3
    for (int i = 1; i < n; i = i * 2) {
        System.out.println(i);
    }
}
```

**Your Analysis**:
- Time Complexity: _______________
- Space Complexity: _______________
- Reasoning: _______________

<details>
<summary>Click to reveal solution</summary>

**Time Complexity**: O(n²)

**Space Complexity**: O(1)

**Explanation**:
- Part 1: O(n)
- Part 2: O(n²)
- Part 3: O(log n)
- Total: O(n) + O(n²) + O(log n)
- Drop lower-order terms: O(n²)
- The nested loop dominates
- Space: Only using loop variables

</details>

---

## Self-Assessment

After completing these exercises, you should be able to:

- [ ] Identify O(1), O(log n), O(n), O(n log n), and O(n²) in code
- [ ] Analyze nested loops correctly
- [ ] Understand the impact of string concatenation
- [ ] Calculate space complexity including data structures
- [ ] Determine recursive complexity
- [ ] Recognize when to use different variables for different inputs
- [ ] Identify the dominant term in combined operations

## Next Steps

1. Review any exercises you got wrong
2. Practice analyzing your own code
3. Try analyzing code from [LeetCode](https://leetcode.com) problems
4. Proceed to [Module 2: Core Data Structures](../module-2-core-data-structures/README.md)

---

**Complexity analysis is a skill that improves with practice. The more code you analyze, the faster and more accurate you'll become.**
