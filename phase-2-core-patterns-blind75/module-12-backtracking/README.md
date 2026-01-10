# Module 12: Backtracking

## Pattern Overview

Backtracking algorithm tracks the path to a solution; if a path leads to a dead end, it backtracks and tries another path. Used for combinations, permutations, and search problems.

## Core Techniques

### General Template
Backtracking usually follows a "Choose-Explore-Unchoose" pattern:
1. **Base Case**: If the current path satisfies the goal, add it to the results.
2. **Iteration**: Loop through all available candidates from a given position.
3. **Choose**: Add the candidate to the current path.
4. **Explore**: Recurse forward to find further candidates.
5. **Backtrack**: Remove the candidate from the path to restore the state before trying the next candidate.

## Problems
1. Subsets
2. Permutations
3. Combination Sum
4. Word Search
