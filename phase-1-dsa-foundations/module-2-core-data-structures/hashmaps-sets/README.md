# HashMaps & Sets

## Overview
HashMaps store key-value pairs, providing O(1) average time complexity for insertion, deletion, and lookup. HashSets store unique values with similar complexity.

## How it Works
1. **Hashing**: A hash function converts the key into an index.
2. **Buckets**: Arrays where data is stored.
3. **Collisions**: When two keys hash to the same index. Handled via:
   - **Chaining**: Storing a linked list (or Tree in modern Java) at the bucket.
   - **Open Addressing**: Finding the next empty slot.

## Core Operations

| Operation | Complexity (Avg) | Complexity (Worst) |
|-----------|------------------|--------------------|
| `put(k, v)` | O(1) | O(n) |
| `get(k)` | O(1) | O(n) |
| `remove(k)` | O(1) | O(n) |
| `containsKey(k)` | O(1) | O(n) |

> Worst case O(n) happens with poor hash functions (many collisions), but Java 8+ mitigates this to O(log n) using Red-Black Trees for large buckets.

## Choosing the Right Map
- **HashMap**: Unsorted, fast, allows null key.
- **TreeMap**: Sorted by keys (Red-Black Tree), O(log n) ops.
- **LinkedHashMap**: Maintains insertion order.

## Interview Tips
- **Equals & HashCode**: If you use a custom object as a Key, you MUST override both `equals()` and `hashCode()`.
- **Frequency Counting**: Very common pattern (e.g., Anagrams, Top K elements).
- **Two Sum**: Using a Map to trade Space O(n) for Time O(n).
