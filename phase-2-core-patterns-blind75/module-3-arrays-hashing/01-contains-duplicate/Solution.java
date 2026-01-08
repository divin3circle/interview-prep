import java.util.*;

/**
 * Contains Duplicate - Optimal Solution
 * 
 * Problem: Given an integer array nums, return true if any value appears
 * at least twice in the array, and return false if every element is distinct.
 * 
 * Approach: Use a HashSet to track elements we've seen. If we encounter
 * an element already in the set, we've found a duplicate.
 * 
 * Time Complexity: O(n) where n = array length
 * - Single pass through the array
 * - HashSet add() and contains() are O(1) average case
 * 
 * Space Complexity: O(n)
 * - HashSet stores up to n elements in worst case (no duplicates)
 * 
 * @author Technical Interview Prep Course
 */
public class Solution {

    /**
     * Determines if array contains any duplicate elements.
     * 
     * Algorithm:
     * 1. Create empty HashSet to track seen elements
     * 2. Iterate through array
     * 3. For each element:
     * - If already in set: return true (found duplicate)
     * - Otherwise: add to set
     * 4. If loop completes: return false (no duplicates)
     * 
     * @param nums Array of integers to check
     * @return true if any duplicates exist, false otherwise
     */
    public boolean containsDuplicate(int[] nums) {
        // HashSet to store elements we've encountered
        Set<Integer> seen = new HashSet<>();

        // Iterate through each element in the array
        for (int num : nums) {
            // Check if we've seen this element before
            // add() returns false if element already exists
            if (!seen.add(num)) {
                return true; // Found duplicate
            }
        }

        // No duplicates found
        return false;
    }

    /**
     * Alternative implementation using contains() for clarity.
     * Functionally identical but more explicit.
     */
    public boolean containsDuplicateAlternative(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            // Explicitly check if element exists
            if (seen.contains(num)) {
                return true; // Found duplicate
            }
            // Add element to set
            seen.add(num);
        }

        return false;
    }

    /**
     * Brute force solution for comparison.
     * 
     * Time: O(n²) - nested loops
     * Space: O(1) - no extra data structures
     * 
     * NOT RECOMMENDED - included only for educational purposes
     */
    public boolean containsDuplicateBruteForce(int[] nums) {
        // Check every pair of elements
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Sorting-based solution.
     * 
     * Time: O(n log n) - dominated by sorting
     * Space: O(1) - in-place sorting (or O(log n) for recursion stack)
     * 
     * Use when space is constrained and modifying input is allowed
     */
    public boolean containsDuplicateSorting(int[] nums) {
        // Sort the array
        Arrays.sort(nums);

        // Check adjacent elements for duplicates
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }

        return false;
    }

    /**
     * Demonstration and testing.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Contains duplicate
        int[] test1 = { 1, 2, 3, 1 };
        System.out.println("Test 1: " + Arrays.toString(test1));
        System.out.println("Contains duplicate: " + solution.containsDuplicate(test1));
        System.out.println("Expected: true\n");

        // Test case 2: All distinct
        int[] test2 = { 1, 2, 3, 4 };
        System.out.println("Test 2: " + Arrays.toString(test2));
        System.out.println("Contains duplicate: " + solution.containsDuplicate(test2));
        System.out.println("Expected: false\n");

        // Test case 3: Multiple duplicates
        int[] test3 = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };
        System.out.println("Test 3: " + Arrays.toString(test3));
        System.out.println("Contains duplicate: " + solution.containsDuplicate(test3));
        System.out.println("Expected: true\n");

        // Test case 4: Single element
        int[] test4 = { 1 };
        System.out.println("Test 4: " + Arrays.toString(test4));
        System.out.println("Contains duplicate: " + solution.containsDuplicate(test4));
        System.out.println("Expected: false\n");

        // Test case 5: Two identical elements
        int[] test5 = { 1, 1 };
        System.out.println("Test 5: " + Arrays.toString(test5));
        System.out.println("Contains duplicate: " + solution.containsDuplicate(test5));
        System.out.println("Expected: true\n");
    }
}
