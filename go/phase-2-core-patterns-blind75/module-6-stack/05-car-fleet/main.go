package main

import (
	"fmt"
	"sort"
)

type Car struct {
	pos  int
	time float64
}

// carFleet returns the number of car fleets arriving at target.
// Time: O(N log N)
// Space: O(N)
func carFleet(target int, position []int, speed []int) int {
	n := len(position)
	cars := make([]Car, n)
	
	for i := 0; i < n; i++ {
		cars[i] = Car{
			pos:  position[i],
			time: float64(target-position[i]) / float64(speed[i]),
		}
	}
	
	// Sort by position descending (closest to target first)
	sort.Slice(cars, func(i, j int) bool {
		return cars[i].pos > cars[j].pos
	})
	
	fleets := 0
	var lastTime float64
	
	for i := 0; i < n; i++ {
		// If current car arrives later than the fleet ahead, 
		// it cannot catch up, so it forms a new fleet.
		if cars[i].time > lastTime {
			fleets++
			lastTime = cars[i].time
		}
		// If cars[i].time <= lastTime, it catches up and merges.
		// Effectively it slows down to match 'lastTime', so we don't update lastTime.
	}
	
	return fleets
}

func main() {
	target := 12
	position := []int{10, 8, 0, 5, 3}
	speed := []int{2, 4, 1, 1, 3}
	
	fmt.Printf("Input: target=%d, pos=%v, speed=%v\n", target, position, speed)
	result := carFleet(target, position, speed)
	fmt.Printf("Output: %d (Expected 3)\n", result)
	
	target2 := 10
	pos2 := []int{3}
	spd2 := []int{3}
	fmt.Printf("Input: target=%d, pos=%v, speed=%v\n", target2, pos2, spd2)
	fmt.Printf("Output: %d (Expected 1)\n", carFleet(target2, pos2, spd2))
}
