
/**
 * Array Operations - Comprehensive Implementation
 * 
 * This class demonstrates all fundamental array operations with detailed
 * complexity analysis and best practices for technical interviews.
 */

import java.util.*;

public class ArrayOperations {

    // ========================================================================
    // BASIC OPERATIONS
    // ========================================================================

    /**
     * Access element at specific index.
     * 
     * Time: O(1) - Direct memory address calculation
     * Space: O(1)
     */
    public static int accessElement(int[] arr, int index) {
        // Always validate index bounds
        if (index < 0 || index >= arr.length) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }

        return arr[index];
    }

    /**
     * Update element at specific index.
     * 
     * Time: O(1) - Direct access
     * Space: O(1)
     */
    public static void updateElement(int[] arr, int index, int value) {
        if (index < 0 || index >= arr.length) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }

        arr[index] = value;
    }

    /**
     * Search for element in unsorted array (linear search).
     * 
     * Time: O(n) - Must check each element
     * Space: O(1)
     */
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Return index of first occurrence
            }
        }
        return -1; // Not found
    }

    /**
     * Search for element in sorted array (binary search).
     * 
     * Time: O(log n) - Halves search space each iteration
     * Space: O(1)
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            // Prevent integer overflow
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // Not found
    }

    // ========================================================================
    // INSERTION OPERATIONS
    // ========================================================================

    /**
     * Insert element at end (if space available).
     * 
     * Time: O(1) - Direct assignment
     * Space: O(1)
     * 
     * Note: In practice, you'd use ArrayList for dynamic sizing
     */
    public static int[] insertAtEnd(int[] arr, int size, int value) {
        if (size >= arr.length) {
            throw new IllegalStateException("Array is full");
        }

        arr[size] = value;
        return arr; // Return for chaining, size should be tracked externally
    }

    /**
     * Insert element at specific position.
     * 
     * Time: O(n) - Must shift all elements after insertion point
     * Space: O(n) - Need new array if original is full
     */
    public static int[] insertAtPosition(int[] arr, int size, int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid insertion index");
        }

        // Create new array with space for one more element
        int[] newArr = new int[arr.length + 1];

        // Copy elements before insertion point
        for (int i = 0; i < index; i++) {
            newArr[i] = arr[i];
        }

        // Insert new element
        newArr[index] = value;

        // Copy elements after insertion point
        for (int i = index; i < size; i++) {
            newArr[i + 1] = arr[i];
        }

        return newArr;
    }

    // ========================================================================
    // DELETION OPERATIONS
    // ========================================================================

    /**
     * Delete element at end.
     * 
     * Time: O(1) - Just decrease logical size
     * Space: O(1)
     */
    public static int deleteAtEnd(int[] arr, int size) {
        if (size == 0) {
            throw new IllegalStateException("Array is empty");
        }

        // In practice, just decrease size counter
        // The value remains in memory but is logically removed
        return size - 1; // Return new size
    }

    /**
     * Delete element at specific position.
     * 
     * Time: O(n) - Must shift all subsequent elements
     * Space: O(1) - In-place modification
     */
    public static int deleteAtPosition(int[] arr, int size, int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid deletion index");
        }

        // Shift all elements after index one position left
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }

        return size - 1; // Return new size
    }

    /**
     * Remove all occurrences of a value.
     * 
     * Time: O(n) - Single pass with two pointers
     * Space: O(1) - In-place modification
     */
    public static int removeAllOccurrences(int[] arr, int size, int value) {
        int writeIndex = 0;

        // Read through array, only write non-matching values
        for (int readIndex = 0; readIndex < size; readIndex++) {
            if (arr[readIndex] != value) {
                arr[writeIndex] = arr[readIndex];
                writeIndex++;
            }
        }

        return writeIndex; // New size
    }

    // ========================================================================
    // ARRAY MANIPULATION
    // ========================================================================

    /**
     * Reverse array in-place.
     * 
     * Time: O(n) - Visit each element once
     * Space: O(1) - In-place swapping
     */
    public static void reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            // Swap elements
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

    /**
     * Rotate array right by k positions.
     * 
     * Time: O(n) - Three reversals
     * Space: O(1) - In-place modification
     * 
     * Algorithm: Reverse entire array, then reverse first k, then reverse rest
     */
    public static void rotateRight(int[] arr, int k) {
        if (arr.length == 0)
            return;

        // Handle k larger than array length
        k = k % arr.length;

        // Reverse entire array
        reverse(arr, 0, arr.length - 1);

        // Reverse first k elements
        reverse(arr, 0, k - 1);

        // Reverse remaining elements
        reverse(arr, k, arr.length - 1);
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * Find maximum element.
     * 
     * Time: O(n) - Must check all elements
     * Space: O(1)
     */
    public static int findMax(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }

    /**
     * Find minimum element.
     * 
     * Time: O(n)
     * Space: O(1)
     */
    public static int findMin(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        return min;
    }

    // ========================================================================
    // TWO POINTER TECHNIQUES
    // ========================================================================

    /**
     * Remove duplicates from sorted array (in-place).
     * 
     * Time: O(n) - Single pass
     * Space: O(1) - In-place modification
     * 
     * Returns new length of array without duplicates.
     */
    public static int removeDuplicates(int[] arr) {
        if (arr.length == 0)
            return 0;

        int writeIndex = 1; // Position to write next unique element

        for (int readIndex = 1; readIndex < arr.length; readIndex++) {
            // If current element is different from previous
            if (arr[readIndex] != arr[readIndex - 1]) {
                arr[writeIndex] = arr[readIndex];
                writeIndex++;
            }
        }

        return writeIndex; // New length
    }

    /**
     * Merge two sorted arrays.
     * 
     * Time: O(n + m) where n, m are array lengths
     * Space: O(n + m) for result array
     */
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;

        // Merge while both arrays have elements
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        // Copy remaining elements from arr1
        while (i < arr1.length) {
            result[k++] = arr1[i++];
        }

        // Copy remaining elements from arr2
        while (j < arr2.length) {
            result[k++] = arr2[j++];
        }

        return result;
    }

    /**
     * Find pair with given sum (two pointers on sorted array).
     * 
     * Time: O(n) - Single pass with two pointers
     * Space: O(1)
     */
    public static int[] findPairWithSum(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == target) {
                return new int[] { left, right };
            } else if (sum < target) {
                left++; // Need larger sum
            } else {
                right--; // Need smaller sum
            }
        }

        return new int[] { -1, -1 }; // Not found
    }

    // ========================================================================
    // SLIDING WINDOW TECHNIQUES
    // ========================================================================

    /**
     * Maximum sum of subarray of size k.
     * 
     * Time: O(n) - Single pass with sliding window
     * Space: O(1)
     */
    public static int maxSumSubarray(int[] arr, int k) {
        if (arr.length < k) {
            throw new IllegalArgumentException("Array smaller than window size");
        }

        // Calculate sum of first window
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        int maxSum = windowSum;

        // Slide window and update max
        for (int i = k; i < arr.length; i++) {
            windowSum = windowSum - arr[i - k] + arr[i];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    /**
     * Find smallest subarray with sum >= target.
     * 
     * Time: O(n) - Each element added and removed at most once
     * Space: O(1)
     */
    public static int minSubarrayLength(int[] arr, int target) {
        int minLength = Integer.MAX_VALUE;
        int windowSum = 0;
        int left = 0;

        for (int right = 0; right < arr.length; right++) {
            windowSum += arr[right];

            // Shrink window while sum >= target
            while (windowSum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                windowSum -= arr[left];
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    // ========================================================================
    // PREFIX SUM TECHNIQUES
    // ========================================================================

    /**
     * Build prefix sum array for range queries.
     * 
     * Time: O(n) to build
     * Space: O(n) for prefix array
     */
    public static int[] buildPrefixSum(int[] arr) {
        int[] prefix = new int[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }

        return prefix;
    }

    /**
     * Query range sum using prefix array.
     * 
     * Time: O(1) per query
     * Space: O(1)
     */
    public static int rangeSum(int[] prefix, int left, int right) {
        return prefix[right + 1] - prefix[left];
    }

    // ========================================================================
    // KADANE'S ALGORITHM
    // ========================================================================

    /**
     * Maximum subarray sum (Kadane's algorithm).
     * 
     * Time: O(n) - Single pass
     * Space: O(1)
     */
    public static int maxSubarraySum(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        int maxSoFar = arr[0];
        int maxEndingHere = arr[0];

        for (int i = 1; i < arr.length; i++) {
            // Either extend existing subarray or start new one
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    // ========================================================================
    // DEMONSTRATION
    // ========================================================================

    public static void main(String[] args) {
        System.out.println("=== Array Operations Demo ===\n");

        // Basic operations
        int[] arr = { 5, 2, 8, 1, 9, 3 };
        System.out.println("Original array: " + Arrays.toString(arr));
        System.out.println("Element at index 2: " + accessElement(arr, 2));
        System.out.println("Linear search for 8: " + linearSearch(arr, 8));

        // Sorted array operations
        int[] sorted = { 1, 3, 5, 7, 9, 11 };
        System.out.println("\nSorted array: " + Arrays.toString(sorted));
        System.out.println("Binary search for 7: " + binarySearch(sorted, 7));

        // Two pointers
        int[] pair = findPairWithSum(sorted, 12);
        System.out.println("Pair with sum 12: [" + pair[0] + ", " + pair[1] + "]");

        // Sliding window
        int[] nums = { 1, 4, 2, 10, 23, 3, 1, 0, 20 };
        System.out.println("\nArray: " + Arrays.toString(nums));
        System.out.println("Max sum of subarray size 4: " + maxSumSubarray(nums, 4));

        // Kadane's algorithm
        int[] withNegatives = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println("\nArray with negatives: " + Arrays.toString(withNegatives));
        System.out.println("Maximum subarray sum: " + maxSubarraySum(withNegatives));

        // Reverse
        int[] toReverse = { 1, 2, 3, 4, 5 };
        System.out.println("\nBefore reverse: " + Arrays.toString(toReverse));
        reverseArray(toReverse);
        System.out.println("After reverse: " + Arrays.toString(toReverse));
    }
}
