# Maximum Depth of Binary Tree
**Difficulty**: Easy | **Pattern**: Trees (DFS)

## Solution
```java
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
```
**Time**: O(n), **Space**: O(h) where h is height
