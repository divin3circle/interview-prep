import java.util.*;

/**
 * Product of Array Except Self - Optimal Solution
 * 
 * Problem: Calculate product of all elements except current element,
 * without using division and in O(n) time.
 * 
 * Approach: Use prefix and suffix products. For each position, multiply
 * product of all left elements by product of all right elements.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1) excluding output array
 * 
 * @author Technical Interview Prep Course
 */
public class Solution {

    /**
     * Calculates product of array except self using prefix/suffix approach.
     * 
     * Algorithm:
     * 1. First pass (left to right): Store prefix products in result
     * result[i] = product of all elements to the left of i
     * 2. Second pass (right to left): Multiply by suffix products
     * result[i] *= product of all elements to the right of i
     * 
     * @param nums Input array
     * @return Array where result[i] = product of all elements except nums[i]
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // First pass: Calculate prefix products
        // result[i] = product of all elements to the left of i
        result[0] = 1; // No elements to the left of index 0
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Second pass: Multiply by suffix products
        // suffix = product of all elements to the right
        int suffix = 1; // No elements to the right of last index
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= suffix;
            suffix *= nums[i];
        }

        return result;
    }

    /**
     * Alternative: Using separate prefix and suffix arrays (more space).
     * 
     * Time: O(n)
     * Space: O(n) - uses extra arrays
     * 
     * Easier to understand but uses more space.
     */
    public int[] productExceptSelfExtraSpace(int[] nums) {
        int n = nums.length;

        // Prefix products: prefix[i] = product of nums[0..i-1]
        int[] prefix = new int[n];
        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        // Suffix products: suffix[i] = product of nums[i+1..n-1]
        int[] suffix = new int[n];
        suffix[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        // Result: prefix[i] * suffix[i]
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = prefix[i] * suffix[i];
        }

        return result;
    }

    /**
     * Division approach (NOT ALLOWED by problem constraints).
     * 
     * Time: O(n)
     * Space: O(1)
     * 
     * Included only for educational purposes.
     * Issues: Division not allowed, must handle zeros specially.
     */
    public int[] productExceptSelfDivision(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Count zeros and calculate product of non-zero elements
        int zeroCount = 0;
        int product = 1;
        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            } else {
                product *= num;
            }
        }

        // Handle different cases
        if (zeroCount > 1) {
            // Multiple zeros: all products are 0
            Arrays.fill(result, 0);
        } else if (zeroCount == 1) {
            // One zero: only that position has non-zero product
            for (int i = 0; i < n; i++) {
                result[i] = (nums[i] == 0) ? product : 0;
            }
        } else {
            // No zeros: divide total product by each element
            for (int i = 0; i < n; i++) {
                result[i] = product / nums[i];
            }
        }

        return result;
    }

    /**
     * Demonstration and testing.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Normal case
        int[] test1 = { 1, 2, 3, 4 };
        System.out.println("Test 1: " + Arrays.toString(test1));
        System.out.println("Result: " + Arrays.toString(solution.productExceptSelf(test1)));
        System.out.println("Expected: [24, 12, 8, 6]\n");

        // Test case 2: With zero
        int[] test2 = { -1, 1, 0, -3, 3 };
        System.out.println("Test 2: " + Arrays.toString(test2));
        System.out.println("Result: " + Arrays.toString(solution.productExceptSelf(test2)));
        System.out.println("Expected: [0, 0, 9, 0, 0]\n");

        // Test case 3: Two elements
        int[] test3 = { 5, 2 };
        System.out.println("Test 3: " + Arrays.toString(test3));
        System.out.println("Result: " + Arrays.toString(solution.productExceptSelf(test3)));
        System.out.println("Expected: [2, 5]\n");

        // Test case 4: With negative numbers
        int[] test4 = { -1, -2, -3, -4 };
        System.out.println("Test 4: " + Arrays.toString(test4));
        System.out.println("Result: " + Arrays.toString(solution.productExceptSelf(test4)));
        System.out.println("Expected: [-24, -12, -8, -6]\n");

        // Test case 5: With ones
        int[] test5 = { 1, 1, 1, 1 };
        System.out.println("Test 5: " + Arrays.toString(test5));
        System.out.println("Result: " + Arrays.toString(solution.productExceptSelf(test5)));
        System.out.println("Expected: [1, 1, 1, 1]\n");
    }
}
