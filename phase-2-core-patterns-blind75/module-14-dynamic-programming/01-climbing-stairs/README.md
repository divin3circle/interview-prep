# Climbing Stairs

**Difficulty**: Easy  
**Pattern**: Dynamic Programming (Fibonacci)

## Problem Statement
You are climbing a staircase. It takes `n` steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

## Examples

### Example 1
```
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
```

### Example 2
```
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
```

## Constraints
* `1 <= n <= 45`

## Approach

### 1. Intuition (Fibonacci)
The problem can be broken down:
* To reach step `n`, you could have come from step `n-1` (taking 1 step) or step `n-2` (taking 2 steps).
* Therefore, `ways(n) = ways(n-1) + ways(n-2)`.
* This is exactly the Fibonacci sequence: `1, 2, 3, 5, 8...` (shifted slightly as Fib(1)=1, Fib(2)=2 here).

### 2. Implementation Options
* **Recursion**: `O(2^n)` - Too slow, solves same subproblems repeatedly.
* **Memoization (Top-Down)**: `O(n)` - Store results in array.
* **Tabulation (Bottom-Up)**: `O(n)` - Iterative array building.
* **Space-Optimized**: `O(n)` time, `O(1)` space - Keep track of only last two values.

## Solution

See [solution.java](solution.java) for the implementation.
