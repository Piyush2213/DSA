package stack;

import java.util.LinkedList;
import java.util.Queue;

public class Stack_LL {
    public static StackNode root;
    static class StackNode{
        int data;
        StackNode next;

        StackNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static void push(int data){
        StackNode new_node = new StackNode(data);


        if(root == null){
            root = new_node;

        }else{
            StackNode temp = root;
            root = new_node;
            new_node.next = temp;
        }
    }

    public static void pop(){
        if(root == null){
            System.out.println("Stack is empty");
        }else{
            root = root.next;
        }
    }

    private int peek() {
        if(root==null){
            System.out.println("Stack is empty");
        }
        return root.data;
    }
    public static void display() {
        StackNode temp = root;
        System.out.println("Stack elements:");

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] arg){
        Queue<Integer> q = new LinkedList<>();
        Stack_LL st = new Stack_LL();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        st.pop();
        System.out.println(st.peek());
        display();


    }


}
