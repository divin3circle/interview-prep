import java.util.*;

/**
 * TestUtils - Utility methods for testing interview solutions
 * 
 * This class provides helper methods for:
 * - Creating test data structures
 * - Comparing results
 * - Printing formatted output
 * - Converting between formats
 */
public class TestUtils {

    // ==================== Array Utilities ====================

    /**
     * Print an array in readable format
     * 
     * @param arr The array to print
     */
    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Check if two arrays are equal
     * 
     * @param arr1 First array
     * @param arr2 Second array
     * @return true if arrays are equal, false otherwise
     */
    public static boolean arraysEqual(int[] arr1, int[] arr2) {
        return Arrays.equals(arr1, arr2);
    }

    /**
     * Print test result
     * 
     * @param testName Name of the test
     * @param expected Expected result
     * @param actual   Actual result
     */
    public static void printTestResult(String testName, Object expected, Object actual) {
        boolean passed = expected.equals(actual);
        String status = passed ? "PASS" : "FAIL";
        System.out.println(String.format("[%s] %s - Expected: %s, Actual: %s",
                status, testName, expected, actual));
    }

    // ==================== Linked List Utilities ====================

    /**
     * Create a linked list from an array
     * 
     * @param values Array of values
     * @return Head of the created linked list
     */
    public static ListNode createLinkedList(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }

        return dummy.next;
    }

    /**
     * Convert linked list to array
     * 
     * @param head Head of the linked list
     * @return Array representation of the list
     */
    public static int[] linkedListToArray(ListNode head) {
        List<Integer> result = new ArrayList<>();
        ListNode current = head;

        while (current != null) {
            result.add(current.val);
            current = current.next;
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    /**
     * Print linked list in readable format
     * 
     * @param head Head of the linked list
     */
    public static void printLinkedList(ListNode head) {
        if (head == null) {
            System.out.println("null");
            return;
        }

        StringBuilder sb = new StringBuilder();
        ListNode current = head;

        while (current != null) {
            sb.append(current.val);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }

        System.out.println(sb.toString());
    }

    /**
     * Check if two linked lists are equal
     * 
     * @param head1 Head of first list
     * @param head2 Head of second list
     * @return true if lists are equal, false otherwise
     */
    public static boolean linkedListsEqual(ListNode head1, ListNode head2) {
        ListNode curr1 = head1;
        ListNode curr2 = head2;

        while (curr1 != null && curr2 != null) {
            if (curr1.val != curr2.val) {
                return false;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        return curr1 == null && curr2 == null;
    }

    // ==================== Binary Tree Utilities ====================

    /**
     * Create a binary tree from level-order array (null for missing nodes)
     * 
     * @param values Level-order array representation
     * @return Root of the created tree
     */
    public static TreeNode createBinaryTree(Integer[] values) {
        if (values == null || values.length == 0 || values[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            TreeNode current = queue.poll();

            // Left child
            if (i < values.length && values[i] != null) {
                current.left = new TreeNode(values[i]);
                queue.offer(current.left);
            }
            i++;

            // Right child
            if (i < values.length && values[i] != null) {
                current.right = new TreeNode(values[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    /**
     * Print binary tree in level-order format
     * 
     * @param root Root of the tree
     */
    public static void printBinaryTree(TreeNode root) {
        if (root == null) {
            System.out.println("null");
            return;
        }

        List<String> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current == null) {
                result.add("null");
            } else {
                result.add(String.valueOf(current.val));
                queue.offer(current.left);
                queue.offer(current.right);
            }
        }

        // Remove trailing nulls
        while (!result.isEmpty() && result.get(result.size() - 1).equals("null")) {
            result.remove(result.size() - 1);
        }

        System.out.println(result);
    }

    /**
     * Check if two binary trees are equal
     * 
     * @param root1 Root of first tree
     * @param root2 Root of second tree
     * @return true if trees are equal, false otherwise
     */
    public static boolean treesEqual(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }

        return root1.val == root2.val
                && treesEqual(root1.left, root2.left)
                && treesEqual(root1.right, root2.right);
    }

    // ==================== General Testing Utilities ====================

    /**
     * Run a test case and print result
     * 
     * @param testName Name of the test
     * @param expected Expected result
     * @param actual   Actual result
     * @return true if test passed, false otherwise
     */
    public static boolean runTest(String testName, Object expected, Object actual) {
        boolean passed = expected.equals(actual);
        String status = passed ? "✓ PASS" : "✗ FAIL";

        System.out.println(String.format("%s - %s", status, testName));
        if (!passed) {
            System.out.println("  Expected: " + expected);
            System.out.println("  Actual:   " + actual);
        }

        return passed;
    }

    /**
     * Print a section header for test output
     * 
     * @param title Section title
     */
    public static void printSection(String title) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println(title);
        System.out.println("=".repeat(50));
    }

    /**
     * Print test summary
     * 
     * @param passed Number of tests passed
     * @param total  Total number of tests
     */
    public static void printSummary(int passed, int total) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println(String.format("Tests Passed: %d/%d (%.1f%%)",
                passed, total, (100.0 * passed / total)));
        System.out.println("=".repeat(50));
    }
}
