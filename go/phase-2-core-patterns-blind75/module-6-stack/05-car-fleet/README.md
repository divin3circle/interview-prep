# Car Fleet

**Difficulty**: Medium
**Pattern**: Stack (Monotonic)

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
- Cars at 10 and 8 form a fleet (meeting at 12).
- Car at 0 is a fleet.
- Cars at 5 and 3 form a fleet (meeting at 6).
```

### Example 2
```
Input: target = 10, position = [3], speed = [3]
Output: 1
```

## Approach

### Inverse Sorting + Monotonic Idea
1. **Calculate Time**: For each car, `time = (target - pos) / speed`.
2. **Sort by Position**: Sort cars by starting position in **descending** order (closest to target first).
3. **Iterate**:
   - Limit `time` of the car ahead determines if the current car catches up.
   - If `currentCarTime <= lastFleetTime`: Current car catches up to the fleet ahead. It merges (becomes part of that fleet).
   - If `currentCarTime > lastFleetTime`: Current car arrives *later* than the fleet ahead. It cannot catch up. It forms a **new fleet**. Update `lastFleetTime`.

**Time**: O(N log N) (Sorting)
**Space**: O(N) (To store coupled position/time data)

## Go Solution

```go
type Car struct {
    pos  int
    time float64
}

func carFleet(target int, position []int, speed []int) int {
    n := len(position)
    cars := make([]Car, n)
    
    for i := 0; i < n; i++ {
        cars[i] = Car{
            pos:  position[i],
            time: float64(target-position[i]) / float64(speed[i]),
        }
    }
    
    // Sort by position descending
    sort.Slice(cars, func(i, j int) bool {
        return cars[i].pos > cars[j].pos
    })
    
    fleets := 0
    var lastTime float64
    
    for i := 0; i < n; i++ {
        // If this car takes longer than the fleet ahead, it starts a new fleet
        if cars[i].time > lastTime {
            fleets++
            lastTime = cars[i].time
        }
        // Else: it catches up (time <= lastTime), so it joins previous fleet.
        // We don't update lastTime because the fleet speed is limited by the slower car ahead.
    }
    
    return fleets
}
```

### Key Go Insights
- **Structs**: Grouping `pos` and `time` makes sorting easier.
- **`sort.Slice`**: Powerful builtin for custom sorting.
- **Float precision**: Division requires float conversion.

## Edge Cases
- All cars catch up (1 fleet).
- No cars catch up (N fleets).
- Single car.
