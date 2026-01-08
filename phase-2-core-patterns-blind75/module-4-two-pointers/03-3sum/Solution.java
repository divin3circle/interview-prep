import java.util.*;

/**
 * 3Sum - Optimal Solution
 * 
 * Problem: Find all unique triplets that sum to zero.
 * 
 * Approach: Sort array, fix one element, use two pointers for other two.
 * Skip duplicates to avoid duplicate triplets.
 * 
 * Time Complexity: O(n²)
 * Space Complexity: O(1) excluding output
 * 
 * @author Technical Interview Prep Course
 */
public class Solution {

    /**
     * Finds all unique triplets that sum to zero.
     * 
     * Algorithm:
     * 1. Sort the array
     * 2. For each element i:
     * - Skip if duplicate of previous
     * - Use two pointers (left = i+1, right = end) for remaining elements
     * - If sum == 0: add triplet, skip duplicates, move both pointers
     * - If sum < 0: move left pointer right
     * - If sum > 0: move right pointer left
     * 
     * @param nums Array of integers
     * @return List of unique triplets that sum to zero
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // Sort array to enable two pointers and duplicate skipping
        Arrays.sort(nums);

        // Fix first element
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Early termination: if first element > 0, no solution
            if (nums[i] > 0) {
                break;
            }

            // Two pointers for remaining two elements
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // Found triplet
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for second element
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    // Skip duplicates for third element
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    // Move both pointers
                    left++;
                    right--;

                } else if (sum < 0) {
                    // Sum too small, need larger value
                    left++;
                } else {
                    // Sum too large, need smaller value
                    right--;
                }
            }
        }

        return result;
    }

    /**
     * Demonstration and testing.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Multiple triplets
        int[] test1 = { -1, 0, 1, 2, -1, -4 };
        System.out.println("Test 1: " + Arrays.toString(test1));
        System.out.println("Result: " + solution.threeSum(test1));
        System.out.println("Expected: [[-1, -1, 2], [-1, 0, 1]]\n");

        // Test case 2: No solution
        int[] test2 = { 0, 1, 1 };
        System.out.println("Test 2: " + Arrays.toString(test2));
        System.out.println("Result: " + solution.threeSum(test2));
        System.out.println("Expected: []\n");

        // Test case 3: All zeros
        int[] test3 = { 0, 0, 0 };
        System.out.println("Test 3: " + Arrays.toString(test3));
        System.out.println("Result: " + solution.threeSum(test3));
        System.out.println("Expected: [[0, 0, 0]]\n");

        // Test case 4: Many duplicates
        int[] test4 = { -2, 0, 0, 2, 2 };
        System.out.println("Test 4: " + Arrays.toString(test4));
        System.out.println("Result: " + solution.threeSum(test4));
        System.out.println("Expected: [[-2, 0, 2]]\n");
    }
}
