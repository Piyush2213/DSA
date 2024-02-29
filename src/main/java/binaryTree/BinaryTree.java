package binaryTree;

import java.util.Scanner;

public class BinaryTree {
    private Node root;

    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public void populate(Scanner scanner) {
        System.out.println("Enter the root node value: ");
        int value = scanner.nextInt();
        root = new Node(value);
        insert(scanner, root);
    }

    private void insert(Scanner scanner, Node currentNode) {
        System.out.println("Do you want to enter left of the node " + currentNode.data + "? (Y/N)");

        // Read the input as a string and check for 'Y' or 'N'
        String leftInput = scanner.next().toUpperCase();
        boolean left = leftInput.equals("Y");

        // Consume the newline character
        scanner.nextLine();

        if (left) {
            System.out.println("Enter the value for the left side of " + currentNode.data);
            int leftValue = scanner.nextInt();
            currentNode.left = new Node(leftValue);
            insert(scanner, currentNode.left);
        }

        System.out.println("Do you want to enter right of the node " + currentNode.data + "? (Y/N)");

        // Read the input as a string and check for 'Y' or 'N'
        String rightInput = scanner.next().toUpperCase();
        boolean right = rightInput.equals("Y");

        // Consume the newline character
        scanner.nextLine();

        if (right) {
            System.out.println("Enter the value for the right side of " + currentNode.data);
            int rightValue = scanner.nextInt();
            currentNode.right = new Node(rightValue);
            insert(scanner, currentNode.right);
        }
    }



    public void display() {
        display(root, "");
    }

    private void display(Node currentNode, String indent) {
        if (currentNode == null) {
            return;
        }
        System.out.println(indent + currentNode.data);
        display(currentNode.left, indent + "\t");
        display(currentNode.right, indent + "\t");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);
        tree.display();
    }
}
