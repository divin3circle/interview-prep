# Maps & Sets

## Maps
Go maps (`map[KeyType]ValueType`) are hash tables.

- **Lookups/Inserts/Deletes**: O(1) average.
- **Keys**: Must be comparable (bool, number, string, pointer, channel, interface, arrays). Not slices/maps/funcs.
- **Iteration**: Random order!

## Sets
Go has no built-in Set. Use `map[T]bool` or `map[T]struct{}`.
- `map[T]bool`: Easier to write (`if set[val]`).
- `map[T]struct{}`: Uses slightly less memory (`struct{}` is 0 bytes).

```go
set := make(map[string]struct{})
set["a"] = struct{}{}
if _, exists := set["a"]; exists { ... }
```
