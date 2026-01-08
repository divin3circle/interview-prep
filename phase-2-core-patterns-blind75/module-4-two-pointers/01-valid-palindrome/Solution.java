import java.util.*;

/**
 * Valid Palindrome - Optimal Solution
 * 
 * Problem: Check if string is palindrome after removing non-alphanumeric
 * characters and converting to lowercase.
 * 
 * Approach: Two pointers from both ends, skip non-alphanumeric, compare.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * @author Technical Interview Prep Course
 */
public class Solution {

    /**
     * Checks if string is valid palindrome using two pointers.
     * 
     * Algorithm:
     * 1. Initialize left and right pointers at both ends
     * 2. While left < right:
     * - Skip non-alphanumeric from left
     * - Skip non-alphanumeric from right
     * - Compare characters (case-insensitive)
     * - If mismatch: return false
     * - Move pointers inward
     * 3. Return true if all comparisons match
     * 
     * @param s Input string
     * @return true if palindrome, false otherwise
     */
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // Skip non-alphanumeric from left
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            // Skip non-alphanumeric from right
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare characters (case-insensitive)
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            // Move pointers inward
            left++;
            right--;
        }

        return true; // All comparisons matched
    }

    /**
     * Alternative: Using StringBuilder to filter first (less optimal).
     * 
     * Time: O(n)
     * Space: O(n) - creates filtered string
     */
    public boolean isPalindromeFiltered(String s) {
        // Filter and convert to lowercase
        StringBuilder filtered = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                filtered.append(Character.toLowerCase(c));
            }
        }

        // Check if filtered string is palindrome
        String str = filtered.toString();
        int left = 0, right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    /**
     * Alternative: Using reverse and compare (simplest but uses more space).
     * 
     * Time: O(n)
     * Space: O(n)
     */
    public boolean isPalindromeReverse(String s) {
        // Filter and convert to lowercase
        StringBuilder filtered = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                filtered.append(Character.toLowerCase(c));
            }
        }

        // Compare with reverse
        String str = filtered.toString();
        String reversed = filtered.reverse().toString();

        return str.equals(reversed);
    }

    /**
     * Demonstration and testing.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Valid palindrome with punctuation
        String test1 = "A man, a plan, a canal: Panama";
        System.out.println("Test 1: \"" + test1 + "\"");
        System.out.println("Result: " + solution.isPalindrome(test1));
        System.out.println("Expected: true\n");

        // Test case 2: Not a palindrome
        String test2 = "race a car";
        System.out.println("Test 2: \"" + test2 + "\"");
        System.out.println("Result: " + solution.isPalindrome(test2));
        System.out.println("Expected: false\n");

        // Test case 3: Empty after filtering
        String test3 = " ";
        System.out.println("Test 3: \"" + test3 + "\"");
        System.out.println("Result: " + solution.isPalindrome(test3));
        System.out.println("Expected: true\n");

        // Test case 4: Single character
        String test4 = "a";
        System.out.println("Test 4: \"" + test4 + "\"");
        System.out.println("Result: " + solution.isPalindrome(test4));
        System.out.println("Expected: true\n");

        // Test case 5: Numbers and letters
        String test5 = "0P";
        System.out.println("Test 5: \"" + test5 + "\"");
        System.out.println("Result: " + solution.isPalindrome(test5));
        System.out.println("Expected: false\n");
    }
}
