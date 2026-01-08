# Big-O Complexity Cheatsheet

## Common Mechanics

| Complexity | Name | Description | Example |
|------------|------|-------------|---------|
| **O(1)** | Constant | Direct access, no loops | Access Array Index |
| **O(log n)** | Logarithmic | Cut problem in half each step | Binary Search |
| **O(n)** | Linear | Loop through input once | Liner Search |
| **O(n log n)** | Linearithmic | Divide and conquer | Merge Sort, Heap Sort |
| **O(n²)** | Quadratic | Nested loops | Bubble Sort |
| **O(2^n)** | Exponential | Recursion with 2 branches | Fibonacci (Naive) |
| **O(n!)** | Factorial | Generating all permutations | TSP Brute Force |

## Data Structure Operations

| Structure | Access | Search | Insertion | Deletion |
|-----------|--------|--------|-----------|----------|
| **Array** | O(1) | O(n) | O(n) | O(n) |
| **Stack** | O(n) | O(n) | O(1) | O(1) |
| **Queue** | O(n) | O(n) | O(1) | O(1) |
| **Singly List** | O(n) | O(n) | O(1)* | O(1)* |
| **Doubly List** | O(n) | O(n) | O(1) | O(1) |
| **HashMap** | N/A | O(1) | O(1) | O(1) |
| **BST** | O(log n) | O(log n) | O(log n) | O(log n) |

*\* Assuming reference to node is held.*

## Array Sorting Algorithms

| Algorithm | Best | Average | Worst | Space |
|-----------|------|---------|-------|-------|
| **Quicksort** | O(n log n) | O(n log n) | O(n²) | O(log n) |
| **Mergesort** | O(n log n) | O(n log n) | O(n log n) | O(n) |
| **Heapsort** | O(n log n) | O(n log n) | O(n log n) | O(1) |
| **Bubble Sort** | O(n) | O(n²) | O(n²) | O(1) |
| **Insertion Sort** | O(n) | O(n²) | O(n²) | O(1) |
