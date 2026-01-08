import java.util.*;

/**
 * Best Time to Buy and Sell Stock - Optimal Solution
 * 
 * Problem: Find maximum profit from one buy and one sell transaction.
 * 
 * Approach: Track minimum price seen so far, calculate profit at each step.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * @author Technical Interview Prep Course
 */
public class Solution {

    /**
     * Finds maximum profit from stock transactions.
     * 
     * Algorithm:
     * 1. Initialize minPrice = infinity, maxProfit = 0
     * 2. For each price:
     * - Update minPrice if current price is lower
     * - Calculate profit if sold today: price - minPrice
     * - Update maxProfit if current profit is higher
     * 3. Return maxProfit
     * 
     * @param prices Array of stock prices
     * @return Maximum profit achievable
     */
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            // Update minimum price seen so far
            if (price < minPrice) {
                minPrice = price;
            }

            // Calculate profit if we sell at current price
            int profit = price - minPrice;

            // Update maximum profit
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        return maxProfit;
    }

    /**
     * Alternative: More concise version.
     */
    public int maxProfitConcise(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }

    /**
     * Demonstration and testing.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Profit possible
        int[] test1 = { 7, 1, 5, 3, 6, 4 };
        System.out.println("Test 1: " + Arrays.toString(test1));
        System.out.println("Result: " + solution.maxProfit(test1));
        System.out.println("Expected: 5 (buy at 1, sell at 6)\n");

        // Test case 2: No profit (decreasing prices)
        int[] test2 = { 7, 6, 4, 3, 1 };
        System.out.println("Test 2: " + Arrays.toString(test2));
        System.out.println("Result: " + solution.maxProfit(test2));
        System.out.println("Expected: 0\n");

        // Test case 3: Single price
        int[] test3 = { 5 };
        System.out.println("Test 3: " + Arrays.toString(test3));
        System.out.println("Result: " + solution.maxProfit(test3));
        System.out.println("Expected: 0\n");

        // Test case 4: Increasing prices
        int[] test4 = { 1, 2, 3, 4, 5 };
        System.out.println("Test 4: " + Arrays.toString(test4));
        System.out.println("Result: " + solution.maxProfit(test4));
        System.out.println("Expected: 4 (buy at 1, sell at 5)\n");
    }
}
