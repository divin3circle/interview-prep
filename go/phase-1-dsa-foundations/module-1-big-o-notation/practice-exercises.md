# Big-O Complexity Analysis - Practice Exercises (Go Edition)

## Instructions

For each code snippet below:
1. Determine the time complexity
2. Determine the space complexity
3. Explain your reasoning
4. Check your answer against the solution

Practice analyzing code without running it. This skill is essential for technical interviews.

---

## Exercise 1: Simple Loop

```go
func printSlice(arr []int) {
    for i := 0; i < len(arr); i++ {
        fmt.Println(arr[i])
    }
}
```

**Your Analysis**:
- Time Complexity: _______________
- Space Complexity: _______________
- Reasoning: _______________

<details>
<summary>Click to reveal solution</summary>

**Time Complexity**: O(n) where n = len(arr)

**Space Complexity**: O(1)

**Explanation**:
- The loop runs exactly n times
- Each iteration performs O(1) work (printing)
- Space: Only using variable `i`

</details>

---

## Exercise 2: Nested Loops

```go
func printPairs(arr []int) {
    for i := 0; i < len(arr); i++ {
        for j := 0; j < len(arr); j++ {
            fmt.Printf("%d,%d\n", arr[i], arr[j])
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

**Time Complexity**: O(n²) where n = len(arr)

**Space Complexity**: O(1)

**Explanation**:
- Outer loop runs n times
- Inner loop runs n times for each outer iteration
- Total: n × n = n²
- Space: Only loop variables

</details>

---

## Exercise 3: Binary Search

```go
func binarySearch(arr []int, target int) int {
    left, right := 0, len(arr)-1
    
    for left <= right {
        mid := left + (right-left)/2
        
        if arr[mid] == target {
            return mid
        } else if arr[mid] < target {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    return -1
}
```

**Your Analysis**:
- Time Complexity: _______________
- Space Complexity: _______________
- Reasoning: _______________

<details>
<summary>Click to reveal solution</summary>

**Time Complexity**: O(log n) where n = len(arr)

**Space Complexity**: O(1)

**Explanation**:
- Each iteration cuts the search space in half
- Space: Only using `left`, `right`, `mid`

</details>

---

## Exercise 4: Creating New Slice

```go
func doubleSlice(arr []int) []int {
    result := make([]int, len(arr))
    
    for i := 0; i < len(arr); i++ {
        result[i] = arr[i] * 2
    }
    
    return result
}
```

**Your Analysis**:
- Time Complexity: _______________
- Space Complexity: _______________
- Reasoning: _______________

<details>
<summary>Click to reveal solution</summary>

**Time Complexity**: O(n) where n = len(arr)

**Space Complexity**: O(n)

**Explanation**:
- Loop runs n times: O(n) time
- We create a new slice of size n: O(n) space

</details>

---

## Exercise 5: String Concatenation in Loop

```go
func concatenate(words []string) string {
    result := ""
    
    for i := 0; i < len(words); i++ {
        result += words[i]  // String concatenation
    }
    
    return result
}
```

**Your Analysis**:
- Time Complexity: _______________
- Space Complexity: _______________
- Reasoning: _______________

<details>
<summary>Click to reveal solution</summary>

**Time Complexity**: O(n²) where n = total characters (approx)

**Space Complexity**: O(n)

**Explanation**:
- String concatenation creates a new string each time in Go (strings are immutable)
- Similar to Java, this is inefficient.
- **Better approach**: Use `strings.Builder` for O(n) time.

</details>

---

## Exercise 6: Map Operations

```go
func hasDuplicate(arr []int) bool {
    seen := make(map[int]bool)
    
    for _, num := range arr {
        if seen[num] {
            return true
        }
        seen[num] = true
    }
    
    return false
}
```

**Your Analysis**:
- Time Complexity: _______________
- Space Complexity: _______________
- Reasoning: _______________

<details>
<summary>Click to reveal solution</summary>

**Time Complexity**: O(n) where n = len(arr)

**Space Complexity**: O(n)

**Explanation**:
- Loop runs n times
- Map lookup and insert are O(1) average
- Space: Map stores up to n elements

</details>

---

## Self-Assessment

After completing these exercises, you should be able to:

- [ ] Identify O(1), O(log n), O(n), O(n log n), and O(n²) in Go code
- [ ] Analyze nested loops correctly
- [ ] Understand the impact of `result += str`
- [ ] Calculate space complexity including data structures
- [ ] Determine recursive complexity
