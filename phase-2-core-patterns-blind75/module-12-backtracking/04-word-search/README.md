# Word Search

**Difficulty**: Medium  
**Pattern**: Backtracking (Grid DFS)  
**Companies**: Google, Amazon, Facebook, Microsoft, Apple, Bloomberg, Uber, Snap

## Problem Statement

Given an `m x n` grid of characters `board` and a string `word`, return `true` if `word` exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

## Examples

### Example 1
```
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
```

### Example 2
```
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
```

### Example 3
```
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
```

## Constraints

- `m == board.length`
- `n = board[i].length`
- `1 <= m, n <= 6`
- `1 <= word.length <= 15`
- `board` and `word` consists of only lowercase and uppercase English letters.

## Theoretical Concepts

### Grid Traversal with DFS
Searching in a 2D matrix is often implemented using Depth-First Search. At each cell, you have 4 possible directions (Up, Down, Left, Right).

### Avoiding Infinite Loops (Visited Cells)
Since we cannot use the same cell twice in a single word, we must mark cells as "visited".
- **Strategy 1**: Use a separate `boolean[][] visited` array (O(m*n) space).
- **Strategy 2**: Temporarily modify the `board` (e.g., replace char with `#`) and restore it after the recursive call (O(1) extra space).

### Backtracking on a Grid
1. **Match**: Does the current cell match `word[index]`?
2. **Mark**: Mark current cell as visited.
3. **Explore**: Try all 4 neighbors for `word[index + 1]`.
4. **Restore**: If no path found, unmark the cell (backtrack) to allow other starting paths to use it.

## Approach

### Backtracking with In-place Marking (Optimal)
**Time**: O(N * 3^L) where N is number of cells and L is word length (each step has 3 directions, excluding where we came from).
**Space**: O(L) for recursion stack depth.

1. Loop through every cell in the grid.
2. If `board[r][c] == word.charAt(0)`, start DFS.
3. In `dfs(r, c, index)`:
   - Base case: `index == word.length()`, return `true`.
   - Bounds/Match check: If out of bounds or `board[r][c] != word.charAt(index)`, return `false`.
   - Mark cell: `temp = board[r][c]; board[r][c] = '#';`.
   - Recurse: `found = dfs(up) || dfs(down) || dfs(left) || dfs(right)`.
   - Restore: `board[r][c] = temp;`.
   - Return `found`.

**Why it's optimal**: We prune invalid paths early and use constant extra space for marking.

## Solution

See [solution.java](solution.java) for implementation.

## Key Insights

1. **Start from every cell**: A word can start anywhere.
2. **Short-circuiting**: Using `||` between recursive calls means we stop as soon as we find a match.
3. **Memory management**: In-place modification is a powerful way to reduce space complexity from O(MN) to O(1).

## Edge Cases

- **Word is longer than total cells**.
- **Word starts and ends at the same cell** (not allowed).
- **Grid is 1x1**.
- **The same letter appears multiple times in the word**.
- **Path is a zigzag or snake-like**.

## Related Problems

- Word Search II (LeetCode 212) - multiple words using a Trie.
- Number of Islands (LeetCode 200)
- Flood Fill (LeetCode 733)
