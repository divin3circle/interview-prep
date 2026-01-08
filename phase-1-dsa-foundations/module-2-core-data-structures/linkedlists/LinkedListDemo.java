package linkedlists;

import linkedlists.singly.SinglyLinkedList;
import linkedlists.doubly.DoublyLinkedList;

/**
 * Demo class to showcase usage of Singly and Doubly Linked Lists.
 */
public class LinkedListDemo {

    public static void main(String[] args) {
        demonstrateSinglyLinkedList();
        System.out.println("--------------------------------------------------");
        demonstrateDoublyLinkedList();
    }

    private static void demonstrateSinglyLinkedList() {
        System.out.println("=== Singly Linked List Demo ===");
        SinglyLinkedList sList = new SinglyLinkedList();

        System.out.println("1. Adding elements: 10, 20, 30");
        sList.addLast(10);
        sList.addLast(20);
        sList.addLast(30);
        sList.print();

        System.out.println("2. Adding to front: 5");
        sList.addFirst(5);
        sList.print();

        System.out.println("3. Deleting value 20");
        boolean deleted = sList.delete(20);
        System.out.println("Deleted: " + deleted);
        sList.print();

        System.out.println("4. Reversing list");
        sList.reverse();
        sList.print();
    }

    private static void demonstrateDoublyLinkedList() {
        System.out.println("=== Doubly Linked List Demo ===");
        DoublyLinkedList dList = new DoublyLinkedList();

        System.out.println("1. Adding elements: 100, 200, 300");
        dList.addLast(100);
        dList.addLast(200);
        dList.addLast(300);
        dList.printForward();
        dList.printBackward();

        System.out.println("2. Adding to front: 50");
        dList.addFirst(50);
        dList.printForward();

        System.out.println("3. Deleting value 200");
        boolean deleted = dList.delete(200);
        System.out.println("Deleted: " + deleted);
        dList.printForward();
        dList.printBackward();
    }
}
