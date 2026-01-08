import java.util.*;

/**
 * Two Sum - Optimal Solution
 * 
 * Problem: Given an array of integers and a target, return indices of
 * two numbers that add up to the target.
 * 
 * Approach: Use HashMap to store value → index mappings. For each element,
 * check if its complement (target - element) exists in the map.
 * 
 * Time Complexity: O(n) - single pass through array
 * Space Complexity: O(n) - HashMap storage
 * 
 * @author Technical Interview Prep Course
 */
public class Solution {

    /**
     * Finds two indices whose values sum to target.
     * 
     * Algorithm:
     * 1. Create HashMap to store value → index
     * 2. For each element:
     * - Calculate complement = target - current value
     * - If complement exists in map: return [complement_index, current_index]
     * - Otherwise: add current value and index to map
     * 3. Return empty array (should never reach given constraints)
     * 
     * @param nums   Array of integers
     * @param target Target sum value
     * @return Array of two indices whose values sum to target
     */
    public int[] twoSum(int[] nums, int target) {
        // HashMap: value → index
        Map<Integer, Integer> valueToIndex = new HashMap<>();

        // Single pass through array
        for (int i = 0; i < nums.length; i++) {
            int currentValue = nums[i];
            int complement = target - currentValue;

            // Check if complement exists in our map
            if (valueToIndex.containsKey(complement)) {
                // Found the pair - return indices
                return new int[] { valueToIndex.get(complement), i };
            }

            // Store current value and its index for future lookups
            valueToIndex.put(currentValue, i);
        }

        // No solution found (should never reach given problem constraints)
        return new int[] {};
    }

    /**
     * Brute force solution for comparison.
     * 
     * Time: O(n²) - nested loops
     * Space: O(1) - no extra data structures
     * 
     * NOT RECOMMENDED - included only for educational purposes
     */
    public int[] twoSumBruteForce(int[] nums, int target) {
        // Check every pair of elements
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] {};
    }

    /**
     * Two-pointer solution (only works if array is sorted).
     * 
     * Time: O(n log n) if we need to sort, O(n) if already sorted
     * Space: O(n) to store original indices
     * 
     * Note: This approach loses original indices when sorting,
     * so we need to track them separately.
     */
    public int[] twoSumTwoPointer(int[] nums, int target) {
        // Create array of [value, original_index] pairs
        int[][] pairs = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            pairs[i] = new int[] { nums[i], i };
        }

        // Sort by value
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));

        // Two pointers
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = pairs[left][0] + pairs[right][0];

            if (sum == target) {
                return new int[] { pairs[left][1], pairs[right][1] };
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[] {};
    }

    /**
     * Demonstration and testing.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Example from problem
        int[] test1 = { 2, 7, 11, 15 };
        int[] result1 = solution.twoSum(test1, 9);
        System.out.println("Test 1: " + Arrays.toString(test1) + ", target = 9");
        System.out.println("Result: " + Arrays.toString(result1));
        System.out.println("Expected: [0, 1]\n");

        // Test case 2: Different positions
        int[] test2 = { 3, 2, 4 };
        int[] result2 = solution.twoSum(test2, 6);
        System.out.println("Test 2: " + Arrays.toString(test2) + ", target = 6");
        System.out.println("Result: " + Arrays.toString(result2));
        System.out.println("Expected: [1, 2]\n");

        // Test case 3: Duplicate values
        int[] test3 = { 3, 3 };
        int[] result3 = solution.twoSum(test3, 6);
        System.out.println("Test 3: " + Arrays.toString(test3) + ", target = 6");
        System.out.println("Result: " + Arrays.toString(result3));
        System.out.println("Expected: [0, 1]\n");

        // Test case 4: Negative numbers
        int[] test4 = { -1, -2, -3, -4, -5 };
        int[] result4 = solution.twoSum(test4, -8);
        System.out.println("Test 4: " + Arrays.toString(test4) + ", target = -8");
        System.out.println("Result: " + Arrays.toString(result4));
        System.out.println("Expected: [2, 4] (or [4, 2])\n");

        // Test case 5: Zero target
        int[] test5 = { -3, 3, 4, 90 };
        int[] result5 = solution.twoSum(test5, 0);
        System.out.println("Test 5: " + Arrays.toString(test5) + ", target = 0");
        System.out.println("Result: " + Arrays.toString(result5));
        System.out.println("Expected: [0, 1]\n");
    }
}
