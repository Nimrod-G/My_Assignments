package algorithmsUtils;

import java.util.Queue;

/**
 * Created by Nimrod Golan on 04/09/2016.
 */
public class MyFifoListClass {

    private Node first;
    private int size;

    public MyFifoListClass() {
        this.first = null;
        this.size = 0;
    }

    public static class Node {
        private int value;
        private Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public void add(int value) {
        if (first == null) {
            first = new Node(value);
        } else {
            Node newNode = new Node(value);
            Node temp = first;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        size++;
    }

    public void remove() {
        if (first == null) {
            return;
        } else {
            Node temp = first;
            first = null;
            first = temp.next;
        }
    }

    public void displayList() {
        System.out.println();
        Node temp = first;
        while (temp != null) {
            System.out.print(temp.value);
            temp = temp.next;
        }
    }

    public int peek() {
        return first.value;
    }

    public int getSize() {
        return size;
    }
}
