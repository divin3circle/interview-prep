# Word Search

**Difficulty**: Medium  
**Pattern**: Backtracking (DFS on Grid)

## Problem Statement
Given an `m x n` grid of characters `board` and a string `word`, return `true` if `word` exists in the grid.
The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

## Examples

### Example 1
```
Input: board = [
  ["A","B","C","E"],
  ["S","F","C","S"],
  ["A","D","E","E"]
], word = "ABCCED"
Output: true
```

## Constraints
* `1 <= m, n <= 6`

## Approach

### 1. DFS Backtracking
We need to search for the word starting from *every* cell.
* If `board[i][j]` matches the first char of `word`, trigger DFS.
* **DFS(i, j, index)**:
    * Base case: If `index == word.length`, we found the word. Return true.
    * Boundary check / Mismatch check: Return false.
    * **Mark Visited**: Temporarily change board char to `#` to avoid cycles.
    * Recurse on 4 neighbors.
    * **Backtrack**: Restore board char.

### Complexity
* **Time**: `O(N * 3^L)` where N is number of cells and L is word length. (Branching factor 3 because we don't go back to parent).
* **Space**: `O(L)` recursion depth.

## Solution

See [solution.java](solution.java) for the implementation.
