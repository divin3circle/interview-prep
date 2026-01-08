import java.util.*;

/**
 * Comprehensive Test Cases for Contains Duplicate
 * 
 * This class provides thorough test coverage including:
 * - Normal cases
 * - Edge cases
 * - Boundary conditions
 * - Performance scenarios
 */
public class TestCases {

    private static int testsPassed = 0;
    private static int totalTests = 0;

    public static void main(String[] args) {
        System.out.println("=== Contains Duplicate - Test Suite ===\n");

        Solution solution = new Solution();

        // Normal test cases
        testNormalCases(solution);

        // Edge cases
        testEdgeCases(solution);

        // Boundary conditions
        testBoundaryConditions(solution);

        // Performance tests
        testPerformance(solution);

        // Summary
        System.out.println("\n=== Test Summary ===");
        System.out.println("Tests passed: " + testsPassed + "/" + totalTests);
        System.out.println("Success rate: " + (100.0 * testsPassed / totalTests) + "%");
    }

    private static void testNormalCases(Solution solution) {
        System.out.println("--- Normal Test Cases ---\n");

        // Test 1: Simple duplicate at different positions
        test(solution, new int[] { 1, 2, 3, 1 }, true,
                "Simple duplicate (1 appears twice)");

        // Test 2: All distinct elements
        test(solution, new int[] { 1, 2, 3, 4 }, false,
                "All distinct elements");

        // Test 3: Multiple duplicates
        test(solution, new int[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 }, true,
                "Multiple duplicates");

        // Test 4: Duplicate at end
        test(solution, new int[] { 1, 2, 3, 4, 5, 1 }, true,
                "Duplicate at beginning and end");

        // Test 5: Adjacent duplicates
        test(solution, new int[] { 1, 1, 2, 3, 4 }, true,
                "Adjacent duplicates");

        System.out.println();
    }

    private static void testEdgeCases(Solution solution) {
        System.out.println("--- Edge Cases ---\n");

        // Test 6: Single element (no duplicates possible)
        test(solution, new int[] { 1 }, false,
                "Single element");

        // Test 7: Two identical elements (minimum duplicate case)
        test(solution, new int[] { 1, 1 }, true,
                "Two identical elements");

        // Test 8: Two different elements
        test(solution, new int[] { 1, 2 }, false,
                "Two different elements");

        // Test 9: All same elements
        test(solution, new int[] { 5, 5, 5, 5, 5 }, true,
                "All same elements");

        // Test 10: Empty array (edge case - though constraints say length >= 1)
        // Uncomment if your implementation handles empty arrays
        // test(solution, new int[]{}, false, "Empty array");

        System.out.println();
    }

    private static void testBoundaryConditions(Solution solution) {
        System.out.println("--- Boundary Conditions ---\n");

        // Test 11: Negative numbers
        test(solution, new int[] { -1, -2, -3, -1 }, true,
                "Negative numbers with duplicate");

        // Test 12: Mix of positive and negative
        test(solution, new int[] { -1, 0, 1, 2, -1 }, true,
                "Mix of positive and negative");

        // Test 13: Zero values
        test(solution, new int[] { 0, 0 }, true,
                "Zero values");

        // Test 14: Large numbers
        test(solution, new int[] { 1000000000, -1000000000, 1000000000 }, true,
                "Large numbers");

        // Test 15: Maximum constraint values
        test(solution, new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE }, true,
                "Maximum constraint values");

        System.out.println();
    }

    private static void testPerformance(Solution solution) {
        System.out.println("--- Performance Tests ---\n");

        // Test 16: Large array with no duplicates
        int[] noDuplicates = new int[10000];
        for (int i = 0; i < noDuplicates.length; i++) {
            noDuplicates[i] = i;
        }
        long start = System.nanoTime();
        boolean result = solution.containsDuplicate(noDuplicates);
        long end = System.nanoTime();
        test(result, false, "Large array (10,000 elements) with no duplicates");
        System.out.println("  Time: " + (end - start) / 1000000.0 + " ms");

        // Test 17: Large array with duplicate at end
        int[] duplicateAtEnd = new int[10000];
        for (int i = 0; i < duplicateAtEnd.length - 1; i++) {
            duplicateAtEnd[i] = i;
        }
        duplicateAtEnd[duplicateAtEnd.length - 1] = 0; // Duplicate of first element
        start = System.nanoTime();
        result = solution.containsDuplicate(duplicateAtEnd);
        end = System.nanoTime();
        test(result, true, "Large array with duplicate at end");
        System.out.println("  Time: " + (end - start) / 1000000.0 + " ms");

        // Test 18: Large array with early duplicate
        int[] earlyDuplicate = new int[10000];
        earlyDuplicate[0] = 1;
        earlyDuplicate[1] = 1; // Duplicate at position 1
        for (int i = 2; i < earlyDuplicate.length; i++) {
            earlyDuplicate[i] = i;
        }
        start = System.nanoTime();
        result = solution.containsDuplicate(earlyDuplicate);
        end = System.nanoTime();
        test(result, true, "Large array with early duplicate (should return quickly)");
        System.out.println("  Time: " + (end - start) / 1000000.0 + " ms");

        System.out.println();
    }

    /**
     * Helper method to run a single test case.
     */
    private static void test(Solution solution, int[] nums, boolean expected, String description) {
        totalTests++;
        boolean result = solution.containsDuplicate(nums);
        boolean passed = result == expected;

        if (passed) {
            testsPassed++;
            System.out.println("✓ PASS: " + description);
        } else {
            System.out.println("✗ FAIL: " + description);
            System.out.println("  Input: " + Arrays.toString(nums));
            System.out.println("  Expected: " + expected);
            System.out.println("  Got: " + result);
        }
    }

    /**
     * Overloaded helper for direct result testing.
     */
    private static void test(boolean result, boolean expected, String description) {
        totalTests++;
        boolean passed = result == expected;

        if (passed) {
            testsPassed++;
            System.out.println("✓ PASS: " + description);
        } else {
            System.out.println("✗ FAIL: " + description);
            System.out.println("  Expected: " + expected);
            System.out.println("  Got: " + result);
        }
    }
}
