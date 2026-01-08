# Reverse Linked List
**Difficulty**: Easy | **Pattern**: Linked Lists

## Solution
```java
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}
```
**Time**: O(n), **Space**: O(1)
