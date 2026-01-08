# Invert Binary Tree
**Difficulty**: Easy | **Pattern**: Trees (DFS)

## Solution
```java
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        
        return root;
    }
}
```
**Time**: O(n), **Space**: O(h)
