# Kth Smallest Element in a BST
**Difficulty**: Medium | **Pattern**: Trees (BST)

## Solution
```java
public class Solution {
    private int count = 0;
    private int result = 0;
    
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return result;
    }
    
    private void traverse(TreeNode root, int k) {
        if (root == null) return;
        
        traverse(root.left, k);
        
        count++;
        if (count == k) {
            result = root.val;
            return;
        }
        
        traverse(root.right, k);
    }
}
```
**Time**: O(n), **Space**: O(h)
