package algorithmsUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nimrod Golan on 14/08/2016.
 */
public class MyBinarySearchTree {

    private Node root;

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public boolean isValueExists(int value) {
        if (root == null) {
            System.out.println("Tree is empty.");
            return false;
        } else {
            Node currentRoot = root;
            while (currentRoot != null) {
                if (currentRoot.value == value) {
                    return true;
                } else if (currentRoot.value > value){
                    // We go to the left
                    currentRoot = currentRoot.left;
                } else if (currentRoot.value <= value) {
                    // We go to the right
                    currentRoot = currentRoot.right;
                }
            }
            return false;
        }
    }

    public void insertNewValue(int value) {
        Node node = new Node(value);

        if (root == null) {
            // Tree is empty
            root = node;
            return;
        } else {
            insert(root, node);
        }
    }

    private void insert(Node currentRoot, Node node) {
        if (currentRoot.value > node.value) {
            // We should go left
            if (currentRoot.left == null) {
                currentRoot.left = node;
            } else {
                insert(currentRoot.left, node);
            }
        } else if (currentRoot.value <= node.value) {
            // We should go right
            if (currentRoot.right == null) {
                currentRoot.right = node;
            } else {
                insert(currentRoot.right, node);
            }
        }
    }

    public void findAllLeafsBiggerThanRoot() {
        if (root == null) {
            System.out.println("No leafs were found");
            return;
        } else {
            findAllLeafsBiggerThanNode(root.right);
        }
    }

    public int findMaximum() {
        if (root == null) {
            return -1;
        }

        Node currentRoot = root;
        int max = 0;

        while (currentRoot != null) {
            max = currentRoot.value;
            currentRoot = currentRoot.right;
        }
        return max;
    }

    public void displayTree() {
        Node temp = root;
        displayTree(temp);
    }

    private void displayTree(Node currentNode) {
        if (currentNode != null) {
            displayTree(currentNode.left);
            System.out.print(currentNode.value + " ,");
            displayTree(currentNode.right);
        }
    }

    private void findAllLeafsBiggerThanNode(Node currentNode) {
        if (currentNode.left != null) {
            findAllLeafsBiggerThanNode(currentNode.left);
        }

        if (currentNode.right != null) {
            findAllLeafsBiggerThanNode(currentNode.right);
        }

        if (currentNode.left == null && currentNode.right == null) {
            System.out.println("Found new leaf with value: " + currentNode.value);
        }
    }
}
