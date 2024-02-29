package ll;

public class Double_LL {
    public static Node head;

    private static class Node{
        int val;
        Node next;
        Node prev;


        Node(int val){
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    public static void insert(int data) {
        Node new_node = new Node(data);

        if (head == null) {
            head = new_node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new_node;
            new_node.prev = temp;
        }
    }

    public static void insertAt(int position, int data) {
        Node new_node = new Node(data);

        if (position == 0) {
            new_node.next = head;
            if (head != null) {
                head.prev = new_node; // Update the prev link of the new head to null
            }
            head = new_node;

        } else {
            Node temp = head;
            int count = 0;
            while (temp != null && count < position - 1) {
                temp = temp.next;
                count++;
            }
            if (temp != null) {
                new_node.next = temp.next;
                if (temp.next != null) {
                    temp.next.prev = new_node;
                }
                temp.next = new_node;
                new_node.prev = temp;

            } else {
                System.out.println("Invalid position. The list is not long enough.");
            }
        }
    }

    public static void deleteIndex(int position) {
        if (position == 0) {
            // Delete the head node
            if (head != null) {
                head = head.next; // Move head to the next node
                if (head != null) {
                    head.prev = null; // Update the prev link of the new head to null
                }
            }
        } else {
            // Delete a node at a specific position
            Node temp = head;
            int count = 0;
            while (temp != null && count < position - 1) {
                temp = temp.next;
                count++;
            }
            if (temp != null && temp.next != null) {
                // Remove the node at the specified position
                temp.next = temp.next.next;
                if (temp.next != null) {
                    temp.next.prev = temp; // Update the prev link of the next node
                }
            } else {
                System.out.println("Invalid position. The list is not long enough.");
            }
        }
    }


    public static void delete (int data){
        if (head == null) {
            System.out.println("List is empty. Cannot delete.");
            return;
        }
        if (head.val == data) {
            head = head.next;
            return;
        }

        Node temp = head;
        while(temp.next != null && temp.next.val != data){
            temp = temp.next;
        }
        temp.next = temp.next.next;

    }

    public static boolean isDoublyLinkedList() {
        Node temp = head;

        // Traverse the linked list
        while (temp != null) {
            // Check if the next and prev pointers are set correctly
            if (temp.next != null && temp.next.prev != temp) {
                return false;  // Not a doubly linked list
            }

            temp = temp.next;
        }

        return true;  // It is a doubly linked list
    }


    public static void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }



    public static void main(String []arg){
        insertAt(0,1);
        insertAt(1,2);
        insertAt(2,3);
        insertAt(0,0);
        insert(10);

        // Test if it is a doubly linked list
        boolean isDoubly = isDoublyLinkedList();
        System.out.println("Is doubly linked list: " + isDoubly);
    }
}
