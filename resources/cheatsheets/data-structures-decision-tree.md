# Data Structures Decision Tree

Use this guide to determine which Data Structure to use.

## 1. Do you need to store Key-Value pairs?
- **YES** -> **Map**
  - Need sorted keys? -> **TreeMap**
  - Need insertion order? -> **LinkedHashMap**
  - Just lookup? -> **HashMap** (O(1))
- **NO** -> Go to 2.

## 2. Do you need distinct unique values?
- **YES** -> **Set**
  - Need sorted? -> **TreeSet**
  - Just unique? -> **HashSet** (O(1))
- **NO** -> Go to 3.

## 3. Do you need to process elements in a specific order?
- **LIFO (Last In, First Out)** -> **Stack** (Use `ArrayDeque`)
- **FIFO (First In, First Out)** -> **Queue** (Use `LinkedList` or `ArrayDeque`)
- **Priority (Min/Max)** -> **Heap** (`PriorityQueue`)
- **Double Ended (Both ends)** -> **Deque** (`ArrayDeque`)
- **NO** -> Go to 4.

## 4. How often do you search/access vs insert/delete?
- **Heavy Search/Access** -> **ArrayList** (O(1) access)
- **Heavy Insert/Delete at ends** -> **LinkedList** (O(1))
- **Heavy Search in Ordered Data** -> **Binary Search** on Array

## 5. Relationships
- **Hierarchical/Parent-Child** -> **Tree**
- **Network/Connections** -> **Graph**
- **Prefixes/Strings** -> **Trie**
