# Module 18: System-Level Thinking

This module bridges the gap between Coding Interviews and System Design.

## 1. Memory Hierarchy
- **Registers**: Immediate
- **L1/L2/L3 Cache**: Very fast. Accessing sequential arrays is faster than linked lists due to **Spatial Locality** (cache hits)
- **RAM**: Fast
- **Disk/Network**: Slow. Avoid I/O in tight loops

### Go-Specific Considerations
- **Slices**: Contiguous memory → better cache locality than linked structures
- **Escape Analysis**: Go compiler determines stack vs heap allocation
- **Garbage Collection**: Minimize allocations in hot paths
- **Sync.Pool**: Reuse objects to reduce GC pressure

## 2. Engineering Trade-offs
There is rarely a "best" solution, only the "right" trade-off for the constraints.

### Time vs Space
- Using a `map[string]int` uses O(n) space to get O(1) time
- Go maps have overhead; for small datasets, linear search might be faster

### Read Heavy vs Write Heavy
- **Read Heavy**: Cache aggressively, use `sync.Map` for concurrent reads
- **Write Heavy**: Append-only logs, batch updates, use channels for coordination

### Go Concurrency Trade-offs
- **Goroutines**: Cheap but not free (~2KB stack)
- **Channels**: Synchronization overhead; use for coordination, not raw speed
- **Mutexes**: Lower overhead than channels for simple critical sections

## 3. Large Scale Data

### Sharding
Splitting data across machines.
```go
func getShardID(key string, numShards int) int {
    h := fnv.New32a()
    h.Write([]byte(key))
    return int(h.Sum32()) % numShards
}
```

### Replication
Copying data for reliability and read scaling.

### Consistency vs Availability (CAP Theorem)
- **CP Systems**: Prioritize consistency (e.g., traditional databases)
- **AP Systems**: Prioritize availability (e.g., Cassandra, DynamoDB)
- Go's `sync` package helps build consistent systems
- For distributed systems, consider etcd (written in Go)

## 4. Go-Specific System Thinking

### When to Use Go
- **Microservices**: Fast startup, small binary size
- **Network services**: Excellent `net/http` stdlib
- **Concurrent processing**: Goroutines and channels
- **CLI tools**: Single binary deployment

### Performance Patterns
- **Buffered I/O**: Use `bufio.Reader/Writer`
- **String Building**: Use `strings.Builder` not `+=`
- **Profiling**: `pprof` for CPU/memory profiling
- **Benchmarking**: `go test -bench` for micro-optimizations
