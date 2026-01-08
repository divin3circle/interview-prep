import java.util.*;

/**
 * Container With Most Water - Optimal Solution
 * 
 * Problem: Find two lines that form container with maximum water.
 * 
 * Approach: Two pointers from both ends, move pointer with smaller height.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * @author Technical Interview Prep Course
 */
public class Solution {

    /**
     * Finds maximum water container area using two pointers.
     * 
     * Algorithm:
     * 1. Initialize left = 0, right = length - 1
     * 2. Initialize maxArea = 0
     * 3. While left < right:
     * - Calculate area = min(height[left], height[right]) * (right - left)
     * - Update maxArea if current area is larger
     * - Move pointer with smaller height inward
     * 4. Return maxArea
     * 
     * Intuition: Moving the shorter line might find a taller line,
     * potentially increasing area. Moving the taller line cannot help.
     * 
     * @param height Array of line heights
     * @return Maximum water area
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            // Calculate current area
            // Area = width × min_height
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            int area = width * minHeight;

            // Update maximum area
            maxArea = Math.max(maxArea, area);

            // Move pointer with smaller height
            // This is the only way to potentially increase area
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    /**
     * Brute force solution for comparison (NOT RECOMMENDED).
     * 
     * Time: O(n²)
     * Space: O(1)
     */
    public int maxAreaBruteForce(int[] height) {
        int maxArea = 0;

        // Try all pairs
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int width = j - i;
                int minHeight = Math.min(height[i], height[j]);
                int area = width * minHeight;
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }

    /**
     * Demonstration and testing.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Example from problem
        int[] test1 = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println("Test 1: " + Arrays.toString(test1));
        System.out.println("Result: " + solution.maxArea(test1));
        System.out.println("Expected: 49 (indices 1 and 8: min(8,7) * 7 = 49)\n");

        // Test case 2: Minimum case
        int[] test2 = { 1, 1 };
        System.out.println("Test 2: " + Arrays.toString(test2));
        System.out.println("Result: " + solution.maxArea(test2));
        System.out.println("Expected: 1\n");

        // Test case 3: Increasing heights
        int[] test3 = { 1, 2, 3, 4, 5 };
        System.out.println("Test 3: " + Arrays.toString(test3));
        System.out.println("Result: " + solution.maxArea(test3));
        System.out.println("Expected: 6 (indices 0 and 4: min(1,5) * 4 = 4)\n");

        // Test case 4: Same heights
        int[] test4 = { 5, 5, 5, 5 };
        System.out.println("Test 4: " + Arrays.toString(test4));
        System.out.println("Result: " + solution.maxArea(test4));
        System.out.println("Expected: 15 (indices 0 and 3: 5 * 3 = 15)\n");
    }
}
