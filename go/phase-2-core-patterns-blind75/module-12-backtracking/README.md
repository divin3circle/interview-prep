# Module 12: Backtracking

## Pattern Overview

Backtracking explores all possible solutions by building candidates incrementally and abandoning ("backtracking") when a candidate cannot lead to a valid solution.

## Core Techniques (Go Style)

### Choose-Explore-Unchoose Pattern
```go
func backtrack(path []int, choices []int) {
    if isGoal(path) {
        result = append(result, append([]int{}, path...)) // Copy!
        return
    }
    for i, choice := range choices {
        // Choose
        path = append(path, choice)
        // Explore
        backtrack(path, choices[i+1:])
        // Unchoose
        path = path[:len(path)-1]
    }
}
```

### Key Points
- **Copy slices** when adding to result: `append([]int{}, path...)`
- **Slice manipulation** for backtracking: `path[:len(path)-1]`

## Problems in This Module

### 1. Subsets
**Difficulty**: Medium
[View Problem](01-subsets/README.md)

### 2. Permutations
**Difficulty**: Medium
[View Problem](02-permutations/README.md)

### 3. Combination Sum
**Difficulty**: Medium
[View Problem](03-combination-sum/README.md)

### 4. Word Search
**Difficulty**: Medium
[View Problem](04-word-search/README.md)

## Key Takeaway
Backtracking = DFS + pruning. Build incrementally, backtrack when stuck.
