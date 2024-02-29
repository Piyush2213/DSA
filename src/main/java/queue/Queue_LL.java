package queue;

public class Queue_LL {
    QueueNode front, rear;


    public class QueueNode{
        int data;
        QueueNode next;

        QueueNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void queue(int data){
        QueueNode new_node = new QueueNode(data);

        if(front == null || rear == null){
            front = new_node;
            rear = new_node;
        }else{
            rear.next = new_node;
            rear = new_node;
        }
    }

    public void dequeue(){
        if(front == null || rear == null){
            System.out.println("Underflow can't pop");
        }else{
            front = front.next;
        }
    }

    public void display(){
        if(front == rear){
            System.out.println("Underflow");
        }else{
            QueueNode temp = front;
            System.out.println("Queue elements:");

            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }

            System.out.println();
        }
    }

    public static void main(String[] arg){
        Queue_LL q = new Queue_LL();
        q.queue(1);
        q.queue(2);
        q.queue(3);
        q.dequeue();
        q.display();
    }
}
