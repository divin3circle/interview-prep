import java.util.*;

/**
 * Trapping Rain Water - Optimal Solution
 * 
 * Problem: Calculate how much rain water can be trapped between bars.
 * 
 * Approach: Two pointers with max height tracking from both ends.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * @author Technical Interview Prep Course
 */
public class Solution {

    /**
     * Calculates trapped rain water using two pointers.
     * 
     * Algorithm:
     * 1. Initialize left = 0, right = length - 1
     * 2. Track leftMax and rightMax heights
     * 3. While left < right:
     * - If height[left] < height[right]:
     * - If height[left] >= leftMax: update leftMax
     * - Else: add (leftMax - height[left]) to water
     * - Move left pointer right
     * - Else:
     * - If height[right] >= rightMax: update rightMax
     * - Else: add (rightMax - height[right]) to water
     * - Move right pointer left
     * 
     * Intuition: Water at position = min(leftMax, rightMax) - height
     * We process from the side with smaller max, ensuring calculation is correct.
     * 
     * @param height Array of bar heights
     * @return Total trapped water
     */
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int water = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                // Process from left side
                if (height[left] >= leftMax) {
                    // Current bar is new max, no water trapped
                    leftMax = height[left];
                } else {
                    // Water trapped = leftMax - current height
                    water += leftMax - height[left];
                }
                left++;
            } else {
                // Process from right side
                if (height[right] >= rightMax) {
                    // Current bar is new max, no water trapped
                    rightMax = height[right];
                } else {
                    // Water trapped = rightMax - current height
                    water += rightMax - height[right];
                }
                right--;
            }
        }

        return water;
    }

    /**
     * Alternative: Using auxiliary arrays (easier to understand).
     * 
     * Time: O(n)
     * Space: O(n)
     */
    public int trapAuxiliaryArrays(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int n = height.length;

        // Calculate max height to the left of each position
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // Calculate max height to the right of each position
        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        // Calculate trapped water
        int water = 0;
        for (int i = 0; i < n; i++) {
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return water;
    }

    /**
     * Demonstration and testing.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Example from problem
        int[] test1 = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println("Test 1: " + Arrays.toString(test1));
        System.out.println("Result: " + solution.trap(test1));
        System.out.println("Expected: 6\n");

        // Test case 2: Another example
        int[] test2 = { 4, 2, 0, 3, 2, 5 };
        System.out.println("Test 2: " + Arrays.toString(test2));
        System.out.println("Result: " + solution.trap(test2));
        System.out.println("Expected: 9\n");

        // Test case 3: No water trapped
        int[] test3 = { 1, 2, 3, 4, 5 };
        System.out.println("Test 3: " + Arrays.toString(test3));
        System.out.println("Result: " + solution.trap(test3));
        System.out.println("Expected: 0\n");

        // Test case 4: Valley shape
        int[] test4 = { 3, 0, 2, 0, 4 };
        System.out.println("Test 4: " + Arrays.toString(test4));
        System.out.println("Result: " + solution.trap(test4));
        System.out.println("Expected: 7\n");
    }
}
