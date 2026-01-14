# Data Structures Decision Tree (Go Edition)

Use this guide to determine which Data Structure to use.

## 1. Do you need to store Key-Value pairs?
- **YES** -> **Map**
  - Need sorted keys? -> *No built-in (use `github.com/google/btree` or slice of keys).*
  - Need insertion order? -> *No built-in (maintain separate slice of keys).*
  - Just lookup? -> **`map[K]V`** (O(1))
- **NO** -> Go to 2.

## 2. Do you need distinct unique values?
- **YES** -> **Set** (Go doesn't have a built-in Set type)
  - Need sorted? -> *No built-in.*
  - Just unique? -> **`map[T]bool`** or **`map[T]struct{}`** (O(1))
- **NO** -> Go to 3.

## 3. Do you need to process elements in a specific order?
- **LIFO (Last In, First Out)** -> **Stack** (Use Slice `[]T` with append/slice ops)
- **FIFO (First In, First Out)** -> **Queue** (Use Slice `[]T` with append/slice ops, or `container/list`)
- **Priority (Min/Max)** -> **Heap** (Use `container/heap`)
- **Double Ended (Both ends)** -> **Deque** (Use Slice or `container/list`)
- **NO** -> Go to 4.

## 4. How often do you search/access vs insert/delete?
- **Heavy Search/Access** -> **Slice** (`[]T`, O(1) access)
- **Heavy Insert/Delete at ends** -> **Slice** or **Linked List** (`container/list`)
- **Heavy Search in Ordered Data** -> **Slice** + **`sort`** + **Binary Search**

## 5. Relationships
- **Hierarchical/Parent-Child** -> **Tree** (Custom `struct`)
- **Network/Connections** -> **Graph** (Adjacency List `map[Node][]Node`)
- **Prefixes/Strings** -> **Trie** (Custom `struct`)
