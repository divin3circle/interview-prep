# Phase 5: Final Projects

Apply your skills to build system components. These are common "Object-Oriented Design" (OOD) interview questions.

## Project 1: LRU Cache
Implement a Least Recently Used Cache.

### Requirements
- `Get` and `Put` in O(1)

### Go Implementation Strategy
```go
type LRUCache struct {
    capacity int
    cache    map[int]*Node
    head     *Node
    tail     *Node
}

type Node struct {
    key   int
    value int
    prev  *Node
    next  *Node
}
```

**Structure**: `map[int]*Node` + Doubly Linked List

## Project 2: Design a Rate Limiter
Limit requests per second for a user.

### Go Implementation Techniques
- **Sliding Window Log**: Use `time.Time` slice
- **Token Bucket**: Use `time.Ticker` and channel
- **Concurrent Safety**: Use `sync.Mutex` or `sync.Map`

```go
type RateLimiter struct {
    mu       sync.Mutex
    requests map[string][]time.Time
    limit    int
    window   time.Duration
}
```

## Project 3: In-Memory File System
Implement `ls`, `mkdir`, `addContentToFile`, `readContentFromFile`.

### Go Implementation
```go
type FileSystem struct {
    root *FileNode
}

type FileNode struct {
    isFile   bool
    content  string
    children map[string]*FileNode
}
```

**Structure**: Trie or N-ary Tree with `map[string]*FileNode`

## Project 4: Trie Autocomplete
Given a prefix, return top 3 hottest search terms.

### Go Implementation
```go
type AutocompleteNode struct {
    children map[rune]*AutocompleteNode
    isEnd    bool
    freq     int
    word     string
}
```

**Structure**: Trie with Frequency tracking

### Go-Specific Tips
- Use `container/heap` for maintaining top K results
- Use `sort.Slice` for simple sorting
- Consider `sync.RWMutex` for concurrent access patterns
