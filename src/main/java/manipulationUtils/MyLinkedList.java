package manipulationUtils;

import java.util.LinkedList;
import java.util.List;

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

        public Node() {}

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

    public void addWithIndex(int index, int data) {
        Node runner = new Node();
        runner.next = head;
        if (index == 0) {
           runner.value = data;
            head = runner;
        } else {

            for (int i = 0; i < index; i++) {
                runner = runner.next;
            }

            Node node = new Node();
            node.value = data;
            node.next = runner.next;
            runner.next = node;
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

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        Node head = new Node(4);

        myLinkedList.addToTheLast(head);
        myLinkedList.addToTheLast(new Node(5));
        myLinkedList.addToTheLast(new Node(6));
        myLinkedList.addToTheLast(new Node(7));
        myLinkedList.addWithIndex(7, 10);
        int q = 0;
    }
}
