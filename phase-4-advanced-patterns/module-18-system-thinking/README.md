# Module 18: System-Level Thinking

This module bridges the gap between Coding Interviews and System Design.

## 1. Memory Hierarchy
- **Registers**: Immediate.
- **L1/L2/L3 Cache**: Very fast. Accessing sequential array is faster than LinkedList because of **Spatial Locality** (Cache hits).
- **RAM**: Fast.
- **Disk/Network**: Slow. Avoid I/O in tight loops.

## 2. Engineering Trade-offs
There is rarely a "best" solution, only the "right" trade-off for the constraints.
- **Time vs Space**: Using a HashMap uses O(n) space to get O(1) time.
- **Read Heavy vs Write Heavy**: 
  - Read Heavy: Cache aggressively, index everything.
  - Write Heavy: Append-only logs, batch updates.

## 3. Large Scale Data
- **Sharding**: Splitting data across machines.
- **Replication**: Copying data for reliability.
- **Consistency vs Availability (CAP Theorem)**.
