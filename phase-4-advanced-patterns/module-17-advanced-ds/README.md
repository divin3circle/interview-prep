# Module 17: Advanced Data Structures

## Tries (Prefix Trees)
Used for autocomplete and spell checkers.
- **Insert**: O(L) where L is word length.
- **Search**: O(L).
- **Space**: O(ALPHABET_SIZE * L * N).

## Union-Find (Disjoint Set)
Used for network connectivity, Kruskal's Algorithm, cycle detection in undirected graphs.
- **Find**: Determine which set an element belongs to.
- **Union**: Merge two sets.
- **Optimization**: Path Compression + Union by Rank -> O(α(N)) (Inverse Ackermann, effectively O(1)).

## Segment Trees
Used for range queries (Sum, Min, Max) on an array with updates.
- **Build**: O(n).
- **Query**: O(log n).
- **Update**: O(log n).
