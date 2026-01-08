/**
 * ListNode - Standard singly linked list node implementation
 * 
 * This class represents a node in a singly linked list. It is used extensively
 * in linked list interview problems.
 * 
 * Usage:
 * ListNode head = new ListNode(1);
 * head.next = new ListNode(2);
 * head.next.next = new ListNode(3);
 */
public class ListNode {
    public int val;
    public ListNode next;

    /**
     * Constructor: Create a list node with given value
     * 
     * @param val The value to store in this node
     */
    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    /**
     * Constructor: Create a list node with value and next pointer
     * 
     * @param val  The value to store in this node
     * @param next The next node in the list
     */
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * String representation for debugging
     * 
     * @return String representation of node value
     */
    @Override
    public String toString() {
        return "ListNode{val=" + val + "}";
    }
}
