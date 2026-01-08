# Module 12: Backtracking

## Pattern Overview

Backtracking algorithm tracks the path to a solution; if a path leads to a dead end, it backtracks and tries another path. Used for combinations, permutations, and search problems.

## Core Techniques

### Template
```java
void backtrack(List<Integer> path, int start) {
    if (goalReached) {
        result.add(new ArrayList<>(path));
        return;
    }
    
    for (int i = start; i < nums.length; i++) {
        path.add(nums[i]); // Choose
        backtrack(path, i + 1); // Explore
        path.remove(path.size() - 1); // Un-choose (Backtrack)
    }
}
```

## Problems
1. Subsets
2. Permutations
3. Combination Sum
4. Word Search
