import java.util.*;

/**
 * Two Sum II - Input Array Is Sorted
 * 
 * Problem: Find two numbers in sorted array that sum to target.
 * Return 1-indexed positions.
 * 
 * Approach: Two pointers from both ends, move based on sum comparison.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * @author Technical Interview Prep Course
 */
public class Solution {

    /**
     * Finds two indices whose values sum to target using two pointers.
     * 
     * Algorithm:
     * 1. Initialize left = 0, right = length - 1
     * 2. While left < right:
     * - Calculate sum = numbers[left] + numbers[right]
     * - If sum == target: return [left+1, right+1] (1-indexed)
     * - If sum < target: left++ (need larger sum)
     * - If sum > target: right-- (need smaller sum)
     * 
     * @param numbers Sorted array of integers (1-indexed in problem)
     * @param target  Target sum
     * @return 1-indexed array [index1, index2]
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                // Found the pair - return 1-indexed positions
                return new int[] { left + 1, right + 1 };
            } else if (sum < target) {
                // Sum too small, need larger value
                left++;
            } else {
                // Sum too large, need smaller value
                right--;
            }
        }

        // Should never reach here given problem constraints
        return new int[] { -1, -1 };
    }

    /**
     * Demonstration and testing.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Example from problem
        int[] test1 = { 2, 7, 11, 15 };
        System.out.println("Test 1: " + Arrays.toString(test1) + ", target = 9");
        System.out.println("Result: " + Arrays.toString(solution.twoSum(test1, 9)));
        System.out.println("Expected: [1, 2]\n");

        // Test case 2: Different positions
        int[] test2 = { 2, 3, 4 };
        System.out.println("Test 2: " + Arrays.toString(test2) + ", target = 6");
        System.out.println("Result: " + Arrays.toString(solution.twoSum(test2, 6)));
        System.out.println("Expected: [1, 3]\n");

        // Test case 3: Negative numbers
        int[] test3 = { -1, 0 };
        System.out.println("Test 3: " + Arrays.toString(test3) + ", target = -1");
        System.out.println("Result: " + Arrays.toString(solution.twoSum(test3, -1)));
        System.out.println("Expected: [1, 2]\n");

        // Test case 4: Large array
        int[] test4 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println("Test 4: [1..10], target = 15");
        System.out.println("Result: " + Arrays.toString(solution.twoSum(test4, 15)));
        System.out.println("Expected: [5, 10] (5 + 10 = 15)\n");
    }
}
