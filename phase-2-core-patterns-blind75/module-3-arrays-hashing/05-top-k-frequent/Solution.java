import java.util.*;

/**
 * Top K Frequent Elements - Optimal Solution
 * 
 * Problem: Find the k most frequent elements in an array.
 * 
 * Approach: Use bucket sort with frequency as index for O(n) time.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * 
 * @author Technical Interview Prep Course
 */
public class Solution {

    /**
     * Finds k most frequent elements using bucket sort.
     * 
     * Algorithm:
     * 1. Count frequency of each element using HashMap
     * 2. Create buckets where index = frequency
     * 3. Place elements in buckets based on their frequency
     * 4. Collect elements from highest frequency buckets until we have k elements
     * 
     * @param nums Array of integers
     * @param k    Number of top frequent elements to return
     * @return Array of k most frequent elements
     */
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequencies
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create buckets (index = frequency)
        // Maximum frequency is nums.length
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int i = 0; i <= nums.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Step 3: Place elements in buckets
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            buckets[freq].add(num);
        }

        // Step 4: Collect k most frequent elements
        int[] result = new int[k];
        int index = 0;

        // Iterate from highest frequency to lowest
        for (int freq = buckets.length - 1; freq >= 0 && index < k; freq--) {
            for (int num : buckets[freq]) {
                result[index++] = num;
                if (index == k) {
                    return result;
                }
            }
        }

        return result;
    }

    /**
     * Alternative: Using min-heap (priority queue).
     * 
     * Time: O(n log k) - better when k is small
     * Space: O(n)
     */
    public int[] topKFrequentHeap(int[] nums, int k) {
        // Count frequencies
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Min-heap of size k (ordered by frequency)
        PriorityQueue<Integer> heap = new PriorityQueue<>(
                (a, b) -> freqMap.get(a) - freqMap.get(b));

        // Maintain heap of size k with k most frequent elements
        for (int num : freqMap.keySet()) {
            heap.offer(num);
            if (heap.size() > k) {
                heap.poll(); // Remove least frequent
            }
        }

        // Extract elements from heap
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll();
        }

        return result;
    }

    /**
     * Alternative: Using max-heap (simpler but O(n log n)).
     * 
     * Time: O(n log n)
     * Space: O(n)
     */
    public int[] topKFrequentMaxHeap(int[] nums, int k) {
        // Count frequencies
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Max-heap ordered by frequency
        PriorityQueue<Integer> heap = new PriorityQueue<>(
                (a, b) -> freqMap.get(b) - freqMap.get(a));

        heap.addAll(freqMap.keySet());

        // Extract top k elements
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll();
        }

        return result;
    }

    /**
     * Demonstration and testing.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Multiple frequencies
        int[] test1 = { 1, 1, 1, 2, 2, 3 };
        System.out.println("Test 1: " + Arrays.toString(test1) + ", k = 2");
        System.out.println("Result: " + Arrays.toString(solution.topKFrequent(test1, 2)));
        System.out.println("Expected: [1, 2] (or [2, 1])\n");

        // Test case 2: Single element
        int[] test2 = { 1 };
        System.out.println("Test 2: " + Arrays.toString(test2) + ", k = 1");
        System.out.println("Result: " + Arrays.toString(solution.topKFrequent(test2, 1)));
        System.out.println("Expected: [1]\n");

        // Test case 3: All same frequency
        int[] test3 = { 1, 2, 3, 4, 5 };
        System.out.println("Test 3: " + Arrays.toString(test3) + ", k = 3");
        System.out.println("Result: " + Arrays.toString(solution.topKFrequent(test3, 3)));
        System.out.println("Expected: any 3 elements\n");

        // Test case 4: Negative numbers
        int[] test4 = { -1, -1, -2, -2, -2, -3 };
        System.out.println("Test 4: " + Arrays.toString(test4) + ", k = 2");
        System.out.println("Result: " + Arrays.toString(solution.topKFrequent(test4, 2)));
        System.out.println("Expected: [-2, -1] (or [-1, -2])\n");
    }
}
