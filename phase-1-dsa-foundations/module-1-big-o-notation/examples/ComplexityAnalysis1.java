/**
 * Complexity Analysis Exercise 1
 * 
 * Analyze the time and space complexity of the following code snippets.
 * For each function, determine:
 * 1. Time complexity (best, average, worst case if applicable)
 * 2. Space complexity
 * 3. Explanation of your reasoning
 */

public class ComplexityAnalysis1 {
    
    // ============================================================================
    // PROBLEM 1: Simple Loop
    // ============================================================================
    
    /**
     * Calculate the sum of all elements in an array.
     * 
     * QUESTION: What is the time and space complexity?
     */
    public static int sumArray(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
    
    /**
     * ANSWER:
     * Time Complexity: O(n) where n = arr.length
     * - Single loop iterates through all n elements exactly once
     * - Each iteration performs constant time operations (addition, assignment)
     * 
     * Space Complexity: O(1)
     * - Only using two variables (sum and i) regardless of input size
     * - No additional data structures created
     */
    
    
    // ============================================================================
    // PROBLEM 2: Nested Loops
    // ============================================================================
    
    /**
     * Print all pairs of elements from an array.
     * 
     * QUESTION: What is the time and space complexity?
     */
    public static void printAllPairs(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.println("(" + arr[i] + ", " + arr[j] + ")");
            }
        }
    }
    
    /**
     * ANSWER:
     * Time Complexity: O(n²) where n = arr.length
     * - Outer loop runs n times
     * - For each outer iteration, inner loop runs n times
     * - Total iterations: n × n = n²
     * - Print operation is O(1)
     * 
     * Space Complexity: O(1)
     * - Only using loop variables i and j
     * - Printing doesn't count toward space complexity
     */
    
    
    // ============================================================================
    // PROBLEM 3: Nested Loops with Optimization
    // ============================================================================
    
    /**
     * Print all unique pairs (i, j) where i < j.
     * 
     * QUESTION: What is the time and space complexity?
     */
    public static void printUniquePairs(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                System.out.println("(" + arr[i] + ", " + arr[j] + ")");
            }
        }
    }
    
    /**
     * ANSWER:
     * Time Complexity: O(n²) where n = arr.length
     * - Outer loop runs n times
     * - Inner loop runs (n-1), (n-2), ..., 1, 0 times
     * - Total iterations: (n-1) + (n-2) + ... + 1 = n(n-1)/2 = O(n²)
     * - Although it's half the iterations of Problem 2, it's still O(n²)
     * 
     * Space Complexity: O(1)
     * - Only using loop variables
     */
    
    
    // ============================================================================
    // PROBLEM 4: Binary Search
    // ============================================================================
    
    /**
     * Binary search on a sorted array.
     * 
     * QUESTION: What is the time and space complexity?
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
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
    
    /**
     * ANSWER:
     * Time Complexity: O(log n) where n = arr.length
     * - Each iteration cuts the search space in half
     * - After k iterations, search space is n / 2^k
     * - When search space = 1: n / 2^k = 1, so k = log₂(n)
     * - Therefore, maximum iterations = log₂(n)
     * 
     * Space Complexity: O(1)
     * - Only using a constant number of variables (left, right, mid)
     * - No recursion, so no call stack space
     */
    
    
    // ============================================================================
    // PROBLEM 5: Recursive Binary Search
    // ============================================================================
    
    /**
     * Binary search implemented recursively.
     * 
     * QUESTION: What is the time and space complexity?
     */
    public static int binarySearchRecursive(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1; // Base case: not found
        }
        
        int mid = left + (right - left) / 2;
        
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return binarySearchRecursive(arr, target, mid + 1, right);
        } else {
            return binarySearchRecursive(arr, target, left, mid - 1);
        }
    }
    
    /**
     * ANSWER:
     * Time Complexity: O(log n) where n = arr.length
     * - Same logic as iterative binary search
     * - Each recursive call cuts search space in half
     * - Maximum depth of recursion = log₂(n)
     * 
     * Space Complexity: O(log n)
     * - Recursive calls use call stack space
     * - Maximum recursion depth = log₂(n)
     * - Each call frame uses O(1) space
     * - Total: O(log n) stack space
     * 
     * NOTE: This is worse space complexity than iterative version!
     */
    
    
    // ============================================================================
    // PROBLEM 6: Creating a New Array
    // ============================================================================
    
    /**
     * Create a new array with doubled values.
     * 
     * QUESTION: What is the time and space complexity?
     */
    public static int[] doubleArray(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i] * 2;
        }
        return result;
    }
    
    /**
     * ANSWER:
     * Time Complexity: O(n) where n = arr.length
     * - Single loop through all n elements
     * - Each operation (multiplication, assignment) is O(1)
     * 
     * Space Complexity: O(n)
     * - Creating a new array of size n
     * - This counts as additional space beyond the input
     */
    
    
    // ============================================================================
    // PROBLEM 7: String Concatenation in Loop
    // ============================================================================
    
    /**
     * Concatenate all strings in an array.
     * 
     * QUESTION: What is the time and space complexity?
     */
    public static String concatenateStrings(String[] strings) {
        String result = "";
        for (String s : strings) {
            result += s; // String concatenation
        }
        return result;
    }
    
    /**
     * ANSWER:
     * Time Complexity: O(n × m) where n = number of strings, m = average string length
     * - Loop runs n times
     * - String concatenation creates a new string each time
     * - Each concatenation copies all previous characters
     * - Iteration 1: copy 0 chars, add m chars
     * - Iteration 2: copy m chars, add m chars
     * - Iteration 3: copy 2m chars, add m chars
     * - Total: 0 + m + 2m + 3m + ... + (n-1)m = m × n(n-1)/2 = O(n²m)
     * 
     * Actually O(n²m) in worst case!
     * 
     * Space Complexity: O(n × m)
     * - Final string contains all characters from all strings
     * - Total length = n × m
     * 
     * NOTE: This is why StringBuilder is preferred for string concatenation!
     */
    
    
    // ============================================================================
    // PROBLEM 8: StringBuilder Concatenation
    // ============================================================================
    
    /**
     * Concatenate strings using StringBuilder.
     * 
     * QUESTION: What is the time and space complexity?
     */
    public static String concatenateStringsOptimized(String[] strings) {
        StringBuilder sb = new StringBuilder();
        for (String s : strings) {
            sb.append(s);
        }
        return sb.toString();
    }
    
    /**
     * ANSWER:
     * Time Complexity: O(n × m) where n = number of strings, m = average string length
     * - Loop runs n times
     * - StringBuilder.append() is amortized O(m) for string of length m
     * - Total: n × m = O(nm)
     * 
     * This is MUCH better than O(n²m) from Problem 7!
     * 
     * Space Complexity: O(n × m)
     * - StringBuilder internally stores all characters
     * - Final string contains n × m characters
     */
    
    
    // ============================================================================
    // PROBLEM 9: Fibonacci Recursive (Naive)
    // ============================================================================
    
    /**
     * Calculate nth Fibonacci number recursively.
     * 
     * QUESTION: What is the time and space complexity?
     */
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    
    /**
     * ANSWER:
     * Time Complexity: O(2^n)
     * - Each call makes 2 recursive calls
     * - Forms a binary tree of calls
     * - Tree height = n
     * - Number of nodes ≈ 2^n
     * 
     * Visualization for fib(5):
     *                    fib(5)
     *                   /      \
     *              fib(4)      fib(3)
     *              /    \      /    \
     *          fib(3) fib(2) fib(2) fib(1)
     *          ...
     * 
     * Space Complexity: O(n)
     * - Maximum recursion depth = n
     * - Call stack uses O(n) space
     * 
     * NOTE: This is extremely inefficient! Many redundant calculations.
     */
    
    
    // ============================================================================
    // PROBLEM 10: Fibonacci with Memoization
    // ============================================================================
    
    /**
     * Calculate nth Fibonacci number with memoization.
     * 
     * QUESTION: What is the time and space complexity?
     */
    public static int fibonacciMemo(int n, int[] memo) {
        if (n <= 1) {
            return n;
        }
        
        if (memo[n] != 0) {
            return memo[n]; // Already calculated
        }
        
        memo[n] = fibonacciMemo(n - 1, memo) + fibonacciMemo(n - 2, memo);
        return memo[n];
    }
    
    /**
     * ANSWER:
     * Time Complexity: O(n)
     * - Each value from 0 to n is calculated exactly once
     * - Subsequent calls return cached value in O(1)
     * - Total: n unique calculations = O(n)
     * 
     * Space Complexity: O(n)
     * - Memo array of size n: O(n)
     * - Recursion depth up to n: O(n)
     * - Total: O(n) + O(n) = O(n)
     * 
     * NOTE: Massive improvement from O(2^n) to O(n) time!
     */
    
    
    // ============================================================================
    // KEY TAKEAWAYS
    // ============================================================================
    
    /**
     * IMPORTANT PATTERNS TO RECOGNIZE:
     * 
     * 1. Single loop through n elements: O(n)
     * 2. Nested loops (both iterate n times): O(n²)
     * 3. Halving search space each iteration: O(log n)
     * 4. Creating new data structure of size n: O(n) space
     * 5. Recursion depth d: O(d) space for call stack
     * 6. String concatenation in loop: O(n²) time (use StringBuilder!)
     * 7. Binary tree recursion: Often O(2^n) time
     * 8. Memoization: Trades space for time (O(n) space for O(n) time)
     * 
     * COMMON MISTAKES:
     * 
     * 1. Forgetting that string concatenation is O(n) not O(1)
     * 2. Not accounting for recursion stack space
     * 3. Confusing n/2 iterations with O(log n) - it's still O(n)!
     * 4. Thinking nested loops are always O(n²) - depends on inner loop bounds
     */
    
    
    // ============================================================================
    // PRACTICE EXERCISES
    // ============================================================================
    
    /**
     * Analyze the complexity of these functions:
     */
    
    // Exercise 1: What is the complexity?
    public static boolean hasDuplicate(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }
    // Time: O(n²), Space: O(1)
    
    
    // Exercise 2: What is the complexity?
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;
        
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }
        
        while (i < arr1.length) result[k++] = arr1[i++];
        while (j < arr2.length) result[k++] = arr2[j++];
        
        return result;
    }
    // Time: O(n + m) where n = arr1.length, m = arr2.length
    // Space: O(n + m) for result array
    
    
    // Exercise 3: What is the complexity?
    public static void printPowersOfTwo(int n) {
        for (int i = 1; i <= n; i = i * 2) {
            System.out.println(i);
        }
    }
    // Time: O(log n) - i doubles each iteration
    // Space: O(1)
}
