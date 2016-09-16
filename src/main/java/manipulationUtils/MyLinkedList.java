package manipulationUtils;

import java.util.HashSet;

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

    public void removeDuplicates(Node head) {
        HashSet<Integer> set = new HashSet<>();
        Node previousNode = null;

        while (head.next != null) {
            if (set.contains(head.value)) {
                previousNode.next = head.next;

            } else {
                set.add(head.value);
                previousNode = head;
            }
            head = head.next;
        }
    }

    public void removeDuplicated2(Node head) {
        Node current = head;
        while (current.next != null) {
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.value == current.value) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    public void deleteNodeByValue(Node head, int value) {
        Node temp = head;

        while (temp.next != null) {
            if (temp.next.value == value) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
    }

    public int returnTheNthElementFromLast(Node head, int n) {
        if (head == null || head.next == null) {
            return -1;
        } else {
            Node firstRunner = head;
            Node secondRunner = head;

            for (int i=1; i < n; i ++) {
                firstRunner = firstRunner.next;
            }

            while (firstRunner.next != null) {
                secondRunner = secondRunner.next;
                firstRunner = firstRunner.next;
            }
            return secondRunner.value;
        }
    }

    public Node partition(Node head, int x) {
        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;

		/* Partition list */
        while (head != null) {
            Node next = head.next;
            head.next = null;
            if (head.value < x) {
                if (beforeStart == null) {
                    beforeStart = head;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.next = head;
                    beforeEnd = head;
                }
            } else {
                if (afterStart == null) {
                    afterStart = head;
                    afterEnd = afterStart;
                } else {
                    afterEnd.next = head;
                    afterEnd = head;
                }
            }
            head = next;
        }

		/* Merge before list and after list */
        if (beforeStart == null) {
            return afterStart;
        }

        beforeEnd.next = afterStart;
        return beforeStart;
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        Node head = new Node(4);

        myLinkedList.addToTheLast(head);
        myLinkedList.addToTheLast(new Node(5));
        myLinkedList.addToTheLast(new Node(6));
        myLinkedList.addToTheLast(new Node(7));
        myLinkedList.addToTheLast(new Node(5));
        myLinkedList.addToTheLast(new Node(8));

        Node partition = myLinkedList.partition(head, 7);
        int q = 0;
    }
}
