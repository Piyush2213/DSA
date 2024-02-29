package ll;

public class Circular_LL {
    public static Node head;

    private static class Node{
        int val;
        Node next;

        Node(int val){
            this.val = val;
            this.next = null;
        }
    }

    public static void insert(int data) {
        Node new_node = new Node(data);

        if (head == null) {
            head = new_node;
            head.next = head;
        } else {
            Node temp = head;
            while(temp.next != head){
                temp = temp.next;
            }
            temp.next = new_node;
            new_node.next = head;
        }
    }

    public static void insertAt(int position, int data) {
        Node new_node = new Node(data);

        if (position == 0) {
            if (head == null) {
                insert(data);
            } else {
                Node temp = head;
                while (temp.next != head) {
                    temp = temp.next;
                }
                temp.next = new_node;
                new_node.next = head;
                head = new_node;
            }
        } else {
            Node temp = head;
            int count = 0;
            while (temp != null && count < position - 1) {
                temp = temp.next;
                count++;
            }
            if (temp != null) {
                new_node.next = temp.next;
                temp.next = new_node;
            } else {
                System.out.println("Invalid position. The list is not long enough.");
            }
        }
    }

    public static void deleteIndex(int position) {
        if (head == null) {
            System.out.println("List is empty. Cannot delete.");
            return;
        }

        if (position == 0) {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            if (head == head.next) {
                // If there is only one node in the list
                head = null;
            } else {
                temp.next = head.next;
                head = head.next;
            }
        } else {
            Node temp = head;
            int count = 0;
            while (temp != null && count < position - 1) {
                temp = temp.next;
                count++;
            }
            if (temp != null && temp.next != null) {
                temp.next = temp.next.next;
            } else {
                System.out.println("Invalid position. The list is not long enough.");
            }
        }
    }

    public static void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.val + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }


    public static boolean isCircularLinkedList() {
        if (head == null) {
            return false;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
            if (temp.next == head) {
                return true;
            }
        }

        return false;
    }




    public static void main(String []arg){
        insert(1);
        insert(2);

        insert(4);
        insertAt(2, 3);




        display();

        boolean isCircular = isCircularLinkedList();
        System.out.println("Is circular linked list: " + isCircular);

    }
}
