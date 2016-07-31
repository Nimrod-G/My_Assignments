package manipulationUtils;

import java.util.LinkedList;

/**
 * Created by Nimrod Golan on 25/07/2016.
 */

public class MyLinkedList {

    private Node head;

    public static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public void addToTheLast(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    public Node reverseLinkedList(Node head) {
        System.out.println("Trying to reverse list:");
        Node previousNode = null;
        Node nextNode ;

        if (head == null || head.next == null) {
            return head;
        } else {
            while (head != null) {
                nextNode = head.next;
                head.next = previousNode;

                previousNode = head;
                head = nextNode;
            }
        }
        return previousNode;
    }

    public void printList(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.println(temp.value + " ");
            temp = temp.next;
        }
    }
}
