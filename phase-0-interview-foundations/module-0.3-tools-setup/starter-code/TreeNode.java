/**
 * TreeNode - Standard binary tree node implementation
 * 
 * This class represents a node in a binary tree. It is used extensively
 * in tree-based interview problems.
 * 
 * Usage:
 *   TreeNode root = new TreeNode(5);
 *   root.left = new TreeNode(3);
 *   root.right = new TreeNode(7);
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    
    /**
     * Constructor: Create a tree node with given value
     * @param val The value to store in this node
     */
    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
    
    /**
     * Constructor: Create a tree node with value and children
     * @param val The value to store in this node
     * @param left Left child node
     * @param right Right child node
     */
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    
    /**
     * String representation for debugging
     * @return String representation of node value
     */
    @Override
    public String toString() {
        return "TreeNode{val=" + val + "}";
    }
}
