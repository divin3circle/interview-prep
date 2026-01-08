package trees;

import java.util.*;

/**
 * Demonstrating Binary Tree Logic and Traversals.
 */
public class TreeOperations {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Tree Operations ---");

        // 1. Creation
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        /*
         * 1
         * / \
         * 2 3
         * / \
         * 4 5
         */

        // 2. DFS Traversals
        System.out.print("Pre-Order: ");
        preOrder(root);
        System.out.println();

        System.out.print("In-Order:  ");
        inOrder(root);
        System.out.println();

        System.out.print("Post-Order:");
        postOrder(root);
        System.out.println();

        // 3. BFS Traversal
        System.out.print("BFS/Level: ");
        levelOrder(root);
        System.out.println();
    }

    // Root -> Left -> Right
    private static void preOrder(TreeNode node) {
        if (node == null)
            return;
        System.out.print(node.val + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // Left -> Root -> Right
    private static void inOrder(TreeNode node) {
        if (node == null)
            return;
        inOrder(node.left);
        System.out.print(node.val + " ");
        inOrder(node.right);
    }

    // Left -> Right -> Root
    private static void postOrder(TreeNode node) {
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val + " ");
    }

    // Level by Level using Queue
    private static void levelOrder(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            System.out.print(curr.val + " ");
            if (curr.left != null)
                queue.offer(curr.left);
            if (curr.right != null)
                queue.offer(curr.right);
        }
    }
}
