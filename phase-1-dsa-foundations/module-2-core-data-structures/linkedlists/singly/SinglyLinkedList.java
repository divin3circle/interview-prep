package linkedlists.singly;

/**
 * Implementation of a Singly Linked List.
 */
public class SinglyLinkedList {
    
    private ListNode head;
    private int size;

    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    // O(1)
    public void addFirst(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        head = newNode;
        size++;
    }

    // O(n)
    public void addLast(int val) {
        if (head == null) {
            addFirst(val);
            return;
        }
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = new ListNode(val);
        size++;
    }

    // O(n)
    public boolean delete(int val) {
        if (head == null) return false;

        if (head.val == val) {
            head = head.next;
            size--;
            return true;
        }

        ListNode curr = head;
        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
                size--;
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    // O(n)
    public void reverse() {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        head = prev;
    }

    public void print() {
        ListNode curr = head;
        System.out.print("Singly List: ");
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }
}
