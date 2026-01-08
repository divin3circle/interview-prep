import java.util.*;

/**
 * Longest Substring Without Repeating Characters - Optimal Solution
 * 
 * Problem: Find length of longest substring without repeating characters.
 * 
 * Approach: Sliding window with HashSet. Expand window, contract when duplicate
 * found.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(min(n, charset_size))
 * 
 * @author Technical Interview Prep Course
 */
public class Solution {

    /**
     * Finds length of longest substring without repeating characters.
     * 
     * Algorithm:
     * 1. Use HashSet to track characters in current window
     * 2. Expand window by moving right pointer
     * 3. When duplicate found, contract from left until duplicate removed
     * 4. Track maximum window size
     * 
     * @param s Input string
     * @return Length of longest substring without repeating characters
     */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        int left = 0;
        int maxLength = 0;

        // Expand window with right pointer
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // Contract window while duplicate exists
            while (window.contains(currentChar)) {
                window.remove(s.charAt(left));
                left++;
            }

            // Add current character to window
            window.add(currentChar);

            // Update maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    /**
     * Alternative: Using HashMap to store indices (can skip directly).
     * 
     * Time: O(n)
     * Space: O(min(n, charset_size))
     */
    public int lengthOfLongestSubstringHashMap(String s) {
        Map<Character, Integer> charIndex = new HashMap<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If character seen before and in current window
            if (charIndex.containsKey(currentChar) &&
                    charIndex.get(currentChar) >= left) {
                // Move left pointer past the duplicate
                left = charIndex.get(currentChar) + 1;
            }

            // Update character index
            charIndex.put(currentChar, right);

            // Update maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    /**
     * Demonstration and testing.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Repeating pattern
        String test1 = "abcabcbb";
        System.out.println("Test 1: \"" + test1 + "\"");
        System.out.println("Result: " + solution.lengthOfLongestSubstring(test1));
        System.out.println("Expected: 3 (\"abc\")\n");

        // Test case 2: All same character
        String test2 = "bbbbb";
        System.out.println("Test 2: \"" + test2 + "\"");
        System.out.println("Result: " + solution.lengthOfLongestSubstring(test2));
        System.out.println("Expected: 1 (\"b\")\n");

        // Test case 3: Mixed
        String test3 = "pwwkew";
        System.out.println("Test 3: \"" + test3 + "\"");
        System.out.println("Result: " + solution.lengthOfLongestSubstring(test3));
        System.out.println("Expected: 3 (\"wke\")\n");

        // Test case 4: Empty string
        String test4 = "";
        System.out.println("Test 4: \"" + test4 + "\"");
        System.out.println("Result: " + solution.lengthOfLongestSubstring(test4));
        System.out.println("Expected: 0\n");

        // Test case 5: All unique
        String test5 = "abcdef";
        System.out.println("Test 5: \"" + test5 + "\"");
        System.out.println("Result: " + solution.lengthOfLongestSubstring(test5));
        System.out.println("Expected: 6\n");
    }
}
