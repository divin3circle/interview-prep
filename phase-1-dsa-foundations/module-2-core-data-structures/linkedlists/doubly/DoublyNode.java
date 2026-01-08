package linkedlists.doubly;

/**
 * Definition for doubly-linked list.
 */
public class DoublyNode {
    public int val;
    public DoublyNode next;
    public DoublyNode prev;

    public DoublyNode(int val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }
    
    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
