# Contains Duplicate - Variations and Follow-Ups

## Problem Variations

### Variation 1: Contains Duplicate II

**Problem**: Given an integer array and an integer k, return true if there are two distinct indices i and j such that nums[i] == nums[j] and abs(i - j) <= k.

**Difference**: Adds distance constraint between duplicate elements.

**Approach**: Use HashMap to store value → most recent index mapping. Check if current index - previous index <= k.

**Complexity**: Time O(n), Space O(min(n, k))

```java
public boolean containsNearbyDuplicate(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
            return true;
        }
        map.put(nums[i], i);
    }
    return false;
}
```

---

### Variation 2: Contains Duplicate III

**Problem**: Given an integer array, return true if there are two distinct indices i and j such that abs(nums[i] - nums[j]) <= t and abs(i - j) <= k.

**Difference**: Adds both distance and value difference constraints.

**Approach**: Use TreeSet with sliding window to maintain elements within distance k, then check for values within range t.

**Complexity**: Time O(n log k), Space O(k)

```java
public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    TreeSet<Long> set = new TreeSet<>();
    for (int i = 0; i < nums.length; i++) {
        Long floor = set.floor((long) nums[i]);
        Long ceiling = set.ceiling((long) nums[i]);
        
        if ((floor != null && nums[i] - floor <= t) ||
            (ceiling != null && ceiling - nums[i] <= t)) {
            return true;
        }
        
        set.add((long) nums[i]);
        if (i >= k) {
            set.remove((long) nums[i - k]);
        }
    }
    return false;
}
```

---

### Variation 3: Find All Duplicates

**Problem**: Given an array where 1 ≤ nums[i] ≤ n, find all elements that appear twice.

**Approach**: Use the array itself as a hash table by marking visited indices as negative.

**Complexity**: Time O(n), Space O(1) (excluding output)

```java
public List<Integer> findDuplicates(int[] nums) {
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
        int index = Math.abs(nums[i]) - 1;
        if (nums[index] < 0) {
            result.add(index + 1);
        }
        nums[index] = -nums[index];
    }
    return result;
}
```

---

### Variation 4: Find the Duplicate Number

**Problem**: Given an array of n+1 integers where each integer is in range [1, n], find the one duplicate number.

**Constraint**: Cannot modify the array and must use O(1) extra space.

**Approach**: Floyd's cycle detection (treat array as linked list).

**Complexity**: Time O(n), Space O(1)

```java
public int findDuplicate(int[] nums) {
    int slow = nums[0];
    int fast = nums[0];
    
    // Find intersection point
    do {
        slow = nums[slow];
        fast = nums[nums[fast]];
    } while (slow != fast);
    
    // Find entrance to cycle
    slow = nums[0];
    while (slow != fast) {
        slow = nums[slow];
        fast = nums[fast];
    }
    
    return slow;
}
```

---

### Variation 5: Remove Duplicates from Sorted Array

**Problem**: Remove duplicates in-place from a sorted array, return new length.

**Approach**: Two pointers - one for reading, one for writing unique elements.

**Complexity**: Time O(n), Space O(1)

```java
public int removeDuplicates(int[] nums) {
    if (nums.length == 0) return 0;
    
    int writeIndex = 1;
    for (int readIndex = 1; readIndex < nums.length; readIndex++) {
        if (nums[readIndex] != nums[readIndex - 1]) {
            nums[writeIndex++] = nums[readIndex];
        }
    }
    return writeIndex;
}
```

---

## Interview Follow-Up Questions

### Q1: Space Optimization

**Question**: Can you solve this without using extra space?

**Answer**: Yes, by sorting the array first (O(n log n) time, O(1) space), then checking adjacent elements. However, this modifies the input and is slower than the HashSet approach.

```java
public boolean containsDuplicateNoSpace(int[] nums) {
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 1; i++) {
        if (nums[i] == nums[i + 1]) {
            return true;
        }
    }
    return false;
}
```

---

### Q2: Already Sorted Array

**Question**: What if the array is already sorted?

**Answer**: Simply check adjacent elements in O(n) time, O(1) space. No need for HashSet.

```java
public boolean containsDuplicateSorted(int[] nums) {
    for (int i = 0; i < nums.length - 1; i++) {
        if (nums[i] == nums[i + 1]) {
            return true;
        }
    }
    return false;
}
```

---

### Q3: Count Duplicates

**Question**: How would you count the number of duplicate values (not occurrences)?

**Answer**: Use HashMap to count frequencies, then count how many values have frequency > 1.

```java
public int countDuplicateValues(int[] nums) {
    Map<Integer, Integer> freq = new HashMap<>();
    for (int num : nums) {
        freq.put(num, freq.getOrDefault(num, 0) + 1);
    }
    
    int count = 0;
    for (int frequency : freq.values()) {
        if (frequency > 1) {
            count++;
        }
    }
    return count;
}
```

---

### Q4: Find First Duplicate

**Question**: Return the first element that appears twice (in order of first occurrence).

**Answer**: Use HashSet and return immediately when duplicate is found.

```java
public int firstDuplicate(int[] nums) {
    Set<Integer> seen = new HashSet<>();
    for (int num : nums) {
        if (!seen.add(num)) {
            return num; // First duplicate found
        }
    }
    return -1; // No duplicate
}
```

---

### Q5: Streaming Data

**Question**: How would you handle this if numbers arrive one at a time (streaming)?

**Answer**: Maintain a HashSet and check each incoming number against it.

```java
class DuplicateDetector {
    private Set<Integer> seen = new HashSet<>();
    
    public boolean addNumber(int num) {
        return !seen.add(num); // Returns true if duplicate
    }
}
```

---

## Related LeetCode Problems

1. **Contains Duplicate II** (LeetCode 219) - Medium
2. **Contains Duplicate III** (LeetCode 220) - Hard
3. **Find All Duplicates in an Array** (LeetCode 442) - Medium
4. **Find the Duplicate Number** (LeetCode 287) - Medium
5. **Remove Duplicates from Sorted Array** (LeetCode 26) - Easy
6. **Remove Duplicates from Sorted Array II** (LeetCode 80) - Medium
7. **Single Number** (LeetCode 136) - Easy
8. **Single Number II** (LeetCode 137) - Medium

## Key Takeaways

1. **HashSet is optimal for duplicate detection**: O(1) lookups make it ideal
2. **Space-time tradeoff**: Can trade O(n) space for O(n) time improvement
3. **Sorted arrays enable O(1) space solutions**: Check adjacent elements
4. **Early termination**: Return immediately upon finding first duplicate
5. **Variations add constraints**: Distance, value range, or space limitations
6. **Pattern recognition**: Many duplicate problems use similar hash-based approaches

## Practice Recommendations

1. Solve the basic problem first
2. Implement the space-optimized sorting approach
3. Solve Contains Duplicate II to understand distance constraints
4. Attempt Find the Duplicate Number for advanced technique (Floyd's cycle)
5. Practice explaining the space-time tradeoff clearly
