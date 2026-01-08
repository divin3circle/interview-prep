import java.util.*;

/**
 * Group Anagrams - Optimal Solution
 * 
 * Problem: Group strings that are anagrams of each other.
 * 
 * Approach: Use sorted string as HashMap key to group anagrams together.
 * 
 * Time Complexity: O(n × k log k) where n = number of strings, k = max length
 * Space Complexity: O(n × k) for storing all strings
 * 
 * @author Technical Interview Prep Course
 */
public class Solution {

    /**
     * Groups anagrams using sorted string as key.
     * 
     * Algorithm:
     * 1. Create HashMap: sorted_string → list_of_anagrams
     * 2. For each string:
     * - Sort the string to get key
     * - Add original string to list for that key
     * 3. Return all values (groups) from HashMap
     * 
     * @param strs Array of strings to group
     * @return List of grouped anagrams
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        // HashMap: sorted_string → list of anagrams
        Map<String, List<String>> groups = new HashMap<>();

        for (String str : strs) {
            // Sort string to create key
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            // Add string to appropriate group
            groups.putIfAbsent(key, new ArrayList<>());
            groups.get(key).add(str);
        }

        // Return all groups
        return new ArrayList<>(groups.values());
    }

    /**
     * Alternative: Using character count as key (faster for long strings).
     * 
     * Time: O(n × k) - no sorting needed
     * Space: O(n × k)
     */
    public List<List<String>> groupAnagramsCharCount(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();

        for (String str : strs) {
            // Create character count key
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }

            // Convert count array to string key
            StringBuilder keyBuilder = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (count[i] > 0) {
                    keyBuilder.append((char) ('a' + i));
                    keyBuilder.append(count[i]);
                }
            }
            String key = keyBuilder.toString();

            // Add to group
            groups.putIfAbsent(key, new ArrayList<>());
            groups.get(key).add(str);
        }

        return new ArrayList<>(groups.values());
    }

    /**
     * Alternative: Using delimiter-separated count as key.
     * 
     * Time: O(n × k)
     * Space: O(n × k)
     */
    public List<List<String>> groupAnagramsDelimiter(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();

        for (String str : strs) {
            // Count character frequencies
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }

            // Create key with delimiter (e.g., "1#0#2#..." for "aac")
            StringBuilder key = new StringBuilder();
            for (int c : count) {
                key.append('#');
                key.append(c);
            }

            // Group anagrams
            String keyStr = key.toString();
            groups.putIfAbsent(keyStr, new ArrayList<>());
            groups.get(keyStr).add(str);
        }

        return new ArrayList<>(groups.values());
    }

    /**
     * Demonstration and testing.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Multiple anagram groups
        String[] test1 = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println("Test 1: " + Arrays.toString(test1));
        System.out.println("Result: " + solution.groupAnagrams(test1));
        System.out.println("Expected: [[eat, tea, ate], [tan, nat], [bat]]\n");

        // Test case 2: Empty string
        String[] test2 = { "" };
        System.out.println("Test 2: " + Arrays.toString(test2));
        System.out.println("Result: " + solution.groupAnagrams(test2));
        System.out.println("Expected: [[\"\"]]\n");

        // Test case 3: Single string
        String[] test3 = { "a" };
        System.out.println("Test 3: " + Arrays.toString(test3));
        System.out.println("Result: " + solution.groupAnagrams(test3));
        System.out.println("Expected: [[a]]\n");

        // Test case 4: No anagrams
        String[] test4 = { "abc", "def", "ghi" };
        System.out.println("Test 4: " + Arrays.toString(test4));
        System.out.println("Result: " + solution.groupAnagrams(test4));
        System.out.println("Expected: [[abc], [def], [ghi]]\n");
    }
}
