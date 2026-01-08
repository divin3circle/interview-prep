# Lowest Common Ancestor of a BST
**Difficulty**: Medium | **Pattern**: Trees (BST Property)

## Solution
```java
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        
        // If both values are smaller than root, look in left subtree
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        
        // If both values are larger than root, look in right subtree
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        
        // Otherwise, root is the split point (LCA)
        return root;
    }
}
```
**Time**: O(h), **Space**: O(h)
