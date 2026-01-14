package main

import "fmt"

func coinChange(coins []int, amount int) int {
	dp := make([]int, amount+1)
	for i := range dp {
		dp[i] = amount + 1
	}
	dp[0] = 0
	
	for a := 1; a <= amount; a++ {
		for _, c := range coins {
			if a-c >= 0 {
				dp[a] = min(dp[a], 1+dp[a-c])
			}
		}
	}
	
	if dp[amount] > amount {
		return -1
	}
	return dp[amount]
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func main() {
	fmt.Printf("Coins [1,2,5], amount 11: %d (Expected: 3)\n", coinChange([]int{1, 2, 5}, 11))
	fmt.Printf("Coins [2], amount 3: %d (Expected: -1)\n", coinChange([]int{2}, 3))
}
