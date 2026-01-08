package linkedlists.doubly;

/**
 * Implementation of a Doubly Linked List with Head and Tail pointers.
 */
public class DoublyLinkedList {
    
    private DoublyNode head;
    private DoublyNode tail;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // O(1)
    public void addFirst(int val) {
        DoublyNode newNode = new DoublyNode(val);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    // O(1)
    public void addLast(int val) {
        DoublyNode newNode = new DoublyNode(val);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    // O(n)
    public boolean delete(int val) {
        DoublyNode curr = head;
        while (curr != null) {
            if (curr.val == val) {
                removeNode(curr);
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    // O(1)
    private void removeNode(DoublyNode node) {
        if (node == head) {
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null;
        } else if (node == tail) {
            tail = tail.prev;
            if (tail != null) tail.next = null;
            else head = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        size--;
    }

    public void printForward() {
        DoublyNode curr = head;
        System.out.print("Fwd: ");
        while (curr != null) {
            System.out.print(curr.val + " <-> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public void printBackward() {
        DoublyNode curr = tail;
        System.out.print("Bwd: ");
        while (curr != null) {
            System.out.print(curr.val + " <-> ");
            curr = curr.prev;
        }
        System.out.println("null");
    }
}
