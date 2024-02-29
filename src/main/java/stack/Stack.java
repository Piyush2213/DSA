package stack;

public class Stack {
    int size = 20;
    int top ;
    int arr[] = new int[size];

    Stack(){
        top=-1;
    }

    public int peek(){
        if (top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        }
        else {
            return arr[top];
        }
    }

    public int[] push(int data){
        if(top >= (size-1)){
            System.out.println("Stack Overflow");
        }else{
            arr[++top] = data;
        }
        return arr;
    }

    public int[] pop(){
        if(top < 0){
            System.out.println("Stack underflow");
        }else{
            top--;
        }
        return arr;
    }
    void print(){
        for(int i = top;i>-1;i--){
            System.out.print(" "+ arr[i]);
        }
    }

    public static void main(String []arg){
        Stack st = new Stack();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.pop();
        System.out.println(st.peek());
        st.print();

    }

}
