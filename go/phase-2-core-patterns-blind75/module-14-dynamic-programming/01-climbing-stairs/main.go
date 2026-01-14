package main

import "fmt"

func climbStairs(n int) int {
	if n <= 1 {
		return 1
	}
	prev, curr := 1, 1
	for i := 2; i <= n; i++ {
		prev, curr = curr, prev+curr
	}
	return curr
}

func main() {
	fmt.Printf("Stairs 2: %d (Expected: 2)\n", climbStairs(2))
	fmt.Printf("Stairs 3: %d (Expected: 3)\n", climbStairs(3))
	fmt.Printf("Stairs 5: %d (Expected: 8)\n", climbStairs(5))
}
