# Best Time to Buy and Sell Stock

**Difficulty**: Easy  
**Pattern**: Sliding Window (Track Minimum)  
**Companies**: Google, Amazon, Facebook, Microsoft, Apple

## Problem Statement

You are given an array `prices` where `prices[i]` is the price of a given stock on the `i`th day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return `0`.

## Examples

### Example 1
```
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5
```

### Example 2
```
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: No profit possible (prices only decrease)
```

## Constraints

- `1 <= prices.length <= 10^5`
- `0 <= prices[i] <= 10^4`

## Approach

### One Pass with Min Tracking (Optimal)
**Time**: O(n), **Space**: O(1)

Track minimum price seen so far. For each price, calculate profit if sold today and update maximum profit.

**Why it's optimal**: Single pass, constant space.

## Solution

See [solution.java](solution.java) for implementation.

## Key Insights

1. **Buy low, sell high**: Track minimum price, calculate profit at each step
2. **Single pass**: No need to check all pairs
3. **Greedy approach**: Always buy at lowest price seen so far

## Related Problems

- Best Time to Buy and Sell Stock II (LeetCode 122)
- Best Time to Buy and Sell Stock III (LeetCode 123)
- Best Time to Buy and Sell Stock with Cooldown (LeetCode 309)
