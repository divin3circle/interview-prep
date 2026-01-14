# Module 15: Explaining Solutions Clearly

## The REACT Framework
In an interview, **Communication > Code**. Use REACT:

1. **R**epeat: Repeat the question to ensure understanding.
2. **E**xamples: Walk through examples/edge cases.
3. **A**pproach: Describe your high-level strategy (Brute force → Optimized).
4. **C**ode: Write clean code.
5. **T**est: Dry run with an example.

## Go-Specific Communication Tips

### Discussing Go Idioms
- **Slices vs Arrays**: "I'm using a slice here because we need dynamic sizing."
- **Maps**: "I'll use a `map[string]int` for O(1) lookups."
- **Pointers**: "This function takes a pointer receiver to modify the struct in place."
- **Error Handling**: "In production Go, I'd return an error here, but for this problem I'll assume valid input."

### Whiteboarding / Text Editor Tips
- **Space Management**: Don't write in the center. Start top-left.
- **Variable Names**: Use `maxHeight` not `h`.
- **Modularize**: "I'll assume I have a helper function `isValid(node)` and implement it later."

## Common Mistakes
- **Jumping to Code**: Never write code until the interviewer buys into your plan.
- **Silent Coding**: Always narrate your thought process. "I'm using a map here to store frequencies for O(1) lookup."
- **Forgetting Go Conventions**: Mention exported vs unexported names, error handling patterns, etc.

## Example Walkthrough

**Problem**: Two Sum

**Good Communication**:
1. "Let me repeat: given an array and target, find two indices that sum to target."
2. "For example, `[2,7,11,15]` with target 9 returns `[0,1]`."
3. "Brute force is O(n²) with nested loops. Optimized: use a map to store complements, O(n) time."
4. "I'll use `map[int]int` where key is the number, value is its index."
5. [Write code]
6. "Let me test with `[2,7,11,15]`, target 9: i=0, map empty, add 2→0. i=1, check 9-7=2, found at index 0, return [0,1]."
