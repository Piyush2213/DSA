package ll;

public class LL {
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
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new_node;
        }
    }

    public static void insertAt(int position, int data) {
        Node new_node = new Node(data);

        if (position == 0) {
            new_node.next = head;
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
                temp.next = new_node;
            } else {
                System.out.println("Invalid position. The list is not long enough.");
            }
        }
    }

    public static void deleteIndex (int position){
        if(position == 0){
            head = head.next;
        }else{
            Node temp = head;
            int count = 0;
            while(temp!=null && count < position-1){
                temp = temp.next;
                count++;
            }
            temp.next = temp.next.next;
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


    public static void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }



    public static void main(String []arg){
        insert(1);
        insert(2);
        insert(4);
        insertAt(2, 3);
        deleteIndex(2);
        delete(2);


        // Display the linked list
        display();
    }
}
