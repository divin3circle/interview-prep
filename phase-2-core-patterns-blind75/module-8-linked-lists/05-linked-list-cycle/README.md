# Linked List Cycle
**Difficulty**: Easy | **Pattern**: Linked Lists (Floyd's Cycle Detection)

## Solution
```java
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                return true;
            }
        }
        
        return false;
    }
}
```
**Time**: O(n), **Space**: O(1)
