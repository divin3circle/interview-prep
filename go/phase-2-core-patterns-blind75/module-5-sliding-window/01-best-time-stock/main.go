package main

import "fmt"

// maxProfit returns maximum profit from single buy/sell.
// Time: O(N)
// Space: O(1)
func maxProfit(prices []int) int {
	if len(prices) == 0 {
		return 0
	}
	
	minPrice := prices[0]
	maxP := 0
	
	for i := 1; i < len(prices); i++ {
		// Update min price if we find a lower buying opportunity
		if prices[i] < minPrice {
			minPrice = prices[i]
		}
		
		// Check profit if we sold today
		currentProfit := prices[i] - minPrice
		if currentProfit > maxP {
			maxP = currentProfit
		}
	}
	
	return maxP
}

func main() {
	tests := [][]int{
		{7, 1, 5, 3, 6, 4},
		{7, 6, 4, 3, 1},
		{1, 2, 3, 4, 5},
	}
	
	for i, prices := range tests {
		result := maxProfit(prices)
		fmt.Printf("Test %d: Input %v -> Max Profit: %d\n", i+1, prices, result)
	}
}
