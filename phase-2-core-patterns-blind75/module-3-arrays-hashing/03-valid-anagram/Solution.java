import java.util.*;

/**
 * Valid Anagram - Optimal Solution
 * 
 * Problem: Determine if two strings are anagrams (same characters, same
 * frequencies).
 * 
 * Approach: Use frequency array for lowercase English letters. Increment for
 * characters in s, decrement for characters in t. If all counts are zero,
 * they're anagrams.
 * 
 * Time Complexity: O(n) where n = length of strings
 * Space Complexity: O(1) - fixed array of 26 elements
 * 
 * @author Technical Interview Prep Course
 */
public class Solution {

    /**
     * Determines if two strings are anagrams using frequency array.
     * 
     * Algorithm:
     * 1. Check if lengths differ (early termination)
     * 2. Create frequency array of size 26 (for 'a' to 'z')
     * 3. Increment count for each character in s
     * 4. Decrement count for each character in t
     * 5. If all counts are zero, strings are anagrams
     * 
     * @param s First string
     * @param t Second string
     * @return true if t is an anagram of s, false otherwise
     */
    public boolean isAnagram(String s, String t) {
        // Early termination: different lengths cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Frequency array for 26 lowercase English letters
        int[] charCount = new int[26];

        // Increment for characters in s, decrement for characters in t
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
            charCount[t.charAt(i) - 'a']--;
        }

        // Check if all counts are zero
        for (int count : charCount) {
            if (count != 0) {
                return false; // Frequency mismatch
            }
        }

        return true; // All frequencies match
    }

    /**
     * Alternative: Using HashMap (works for any character set).
     * 
     * Time: O(n)
     * Space: O(k) where k = number of unique characters
     */
    public boolean isAnagramHashMap(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> charCount = new HashMap<>();

        // Count characters in s
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Decrement for characters in t
        for (char c : t.toCharArray()) {
            if (!charCount.containsKey(c)) {
                return false; // Character in t not in s
            }
            charCount.put(c, charCount.get(c) - 1);
            if (charCount.get(c) < 0) {
                return false; // More occurrences in t than s
            }
        }

        // All counts should be zero
        for (int count : charCount.values()) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Sorting approach (simpler but slower).
     * 
     * Time: O(n log n) - dominated by sorting
     * Space: O(n) - for char arrays
     */
    public boolean isAnagramSorting(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        // Convert to char arrays and sort
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        // Compare sorted arrays
        return Arrays.equals(sChars, tChars);
    }

    /**
     * One-pass frequency counting (most efficient).
     * 
     * Time: O(n)
     * Space: O(1)
     */
    public boolean isAnagramOptimized(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];

        // Single pass: increment for s, decrement for t
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        // Check if all counts are zero
        for (int c : count) {
            if (c != 0)
                return false;
        }

        return true;
    }

    /**
     * Demonstration and testing.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Valid anagram
        System.out.println("Test 1: s = \"anagram\", t = \"nagaram\"");
        System.out.println("Result: " + solution.isAnagram("anagram", "nagaram"));
        System.out.println("Expected: true\n");

        // Test case 2: Not an anagram
        System.out.println("Test 2: s = \"rat\", t = \"car\"");
        System.out.println("Result: " + solution.isAnagram("rat", "car"));
        System.out.println("Expected: false\n");

        // Test case 3: Different lengths
        System.out.println("Test 3: s = \"hello\", t = \"world\"");
        System.out.println("Result: " + solution.isAnagram("hello", "world"));
        System.out.println("Expected: false\n");

        // Test case 4: Single character
        System.out.println("Test 4: s = \"a\", t = \"a\"");
        System.out.println("Result: " + solution.isAnagram("a", "a"));
        System.out.println("Expected: true\n");

        // Test case 5: Empty strings
        System.out.println("Test 5: s = \"\", t = \"\"");
        System.out.println("Result: " + solution.isAnagram("", ""));
        System.out.println("Expected: true\n");

        // Test case 6: Repeated characters
        System.out.println("Test 6: s = \"aabbcc\", t = \"abcabc\"");
        System.out.println("Result: " + solution.isAnagram("aabbcc", "abcabc"));
        System.out.println("Expected: true\n");
    }
}
