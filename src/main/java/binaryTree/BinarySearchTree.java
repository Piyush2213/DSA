package binaryTree;

public class BinarySearchTree {
    public static Node root;
    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void add(int data){
        root = addRecursive(root, data);

    }

    private static Node addRecursive(Node current, int data) {
        if(current == null){
            return new Node(data);
        }

        if(data < current.data){
            current.left = addRecursive(current.left, data);
        } else if (data > current.data) {
            current.right = addRecursive(current.right, data);
        }
        return current;
    }

    public void printTree() {
        printTree(root, 0);
    }

    private void printTree(Node node, int level) {
        if (node != null) {
            printTree(node.right, level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println(node.data);
            printTree(node.left, level + 1);
        }
    }


    public static void main (String[] arg){
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(5);
        tree.add(4);
        tree.add(3);
        tree.add(6);

        tree.printTree();

    }
}
