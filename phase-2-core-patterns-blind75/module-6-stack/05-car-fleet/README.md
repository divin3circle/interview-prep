# Car Fleet

**Difficulty**: Medium  
**Pattern**: Stack  
**Companies**: Google, Amazon, Microsoft

## Problem Statement

There are `n` cars at given miles away from the starting milestone `0`, traveling to a target mile `target`.

You are given two integer arrays `position` and `speed`, both of length `n`, where `position[i]` is the position of the `i`th car and `speed[i]` is the speed of the `i`th car (in miles per hour).

A car can never pass another car ahead of it, but it can catch up to it and drive bumper to bumper at the same speed. The faster car will slow down to match the slower car's speed. The distance between these two cars is ignored (they are assumed to have the same position).

A car fleet is some non-empty set of cars driving at the same position and same speed. Note that a single car is also a car fleet.

If a car catches up to a car fleet right at the destination point, it will still be considered as one car fleet.

Return the number of car fleets that will arrive at the destination.

## Examples

### Example 1
```
Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
Output: 3
Explanation:
- The cars starting at 10 and 8 become a fleet, meeting each other at 12.
- The car starting at 0 doesn't catch up to any other car, so it is a fleet by itself.
- The cars starting at 5 and 3 become a fleet, meeting each other at 6. The fleet moves at speed 1 until it reaches target.
```

### Example 2
```
Input: target = 10, position = [3], speed = [3]
Output: 1
```

## Constraints

- `n == position.length == speed.length`
- `1 <= n <= 10^5`
- `0 < target <= 10^6`
- `0 <= position[i] < target`
- `All the values in position are unique.`
- `0 < speed[i] <= 10^6`

## Theoretical Concepts

### Time to Destination
The crucial metric is the time each car *would* take to reach the target if it were alone:
`time = (target - position) / speed`

### Sorting by Position
Cars must be processed from those closest to the target to those furthest away. This is because a car can only be slowed down by a car ahead of it. By sorting cars by starting position in descending order, we can check if a car "catches up" to the fleet already formed ahead of it.

### Fleet Formation Logic
If car `A` is behind car `B` and `time(A) <= time(B)`, car `A` will catch up to `B` and they will form a fleet. The speed of the fleet is determined by the slower (ahead) car, so the time for the entire fleet remains `time(B)`.

### Monotonic Stack Application
We can use a stack to store the arrival times of the fleets. 
- Process cars from front to back (sorted by position).
- If the current car takes more time than the fleet in front, it becomes a new fleet (push time to stack).
- If it takes less or equal time, it merges into the fleet ahead (do nothing/don't push).

## Approach

### Positional Sorting + Arrival Time Analysis (Optimal)
**Time**: O(n log n) due to sorting, **Space**: O(n)

1. Combine position and speed into car objects.
2. Sort cars by position descending.
3. Calculate arrival time for each car.
4. Use a stack (or a simple variable tracking last fleet time) to count fleets.

**Why it's optimal**: Sorting is the bottleneck; the actual counting is O(n).

## Solution

See [solution.java](solution.java) for implementation.

## Key Insights

1. **Relative speeds matter**: Fast cars behind slow cars merge; fast cars in front stay in front.
2. **Bottleneck principle**: The fleet is restricted by the slowest car at the front.
3. **Floating point precision**: Be careful when calculating time (use `double`).

## Edge Cases

- **One car**: Always 1 fleet.
- **Cars catch up at target**: Explicitly mentioned as a single fleet.
- **Cars start very far apart**.
- **All cars have same speed**.
- **All cars have same arrival time**.

## Related Problems

- Car Fleet II (LeetCode 1776)
- Asteroid Collision (LeetCode 735)
