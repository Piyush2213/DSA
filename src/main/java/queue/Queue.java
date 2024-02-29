package queue;

import java.util.LinkedList;
import java.util.Stack;

public class Queue {
    int size = 20;
    int front, rear;
    int arr[] = new int[size];

    Queue(){
        this.front = 0;
        this.rear = 0;
    }

    public void peek(){
        if(front == rear){
            System.out.println("Queue UnderFlow");
        }else{
            System.out.println(arr[front]);
        }

    }

    public void queue(int data){
        if(rear >= size-1){
            System.out.print("Queue Overflow");
        }else{
            arr[rear] = data;
            rear++;
        }
    }

    public void dequeue(){
        if(front == rear){
            System.out.println("Queue UnderFlow");
        }else{
            front++;
        }
    }

    public void display(){
        if(front == rear){
            System.out.println("Queue UnderFlow");
        }else{
            for(int i = front; i < rear; i++){
                System.out.println(arr[i]);
            }
        }

    }

    public static void main(String[] arg){

        Queue q = new Queue();
        q.queue(1);
        q.queue(2);
        q.queue(3);
        q.dequeue();
        q.peek();
        q.display();
    }
}
