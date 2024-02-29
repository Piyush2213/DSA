package customArrayList;

import java.util.Arrays;

public class CustomArrayList {
   private int []arr;
   private int DEFAULT_SIZE = 10;
   private int count = 0;

   public CustomArrayList(){
       arr = new int [DEFAULT_SIZE];
   }

   public void add(int data){
       if(isFUll()){
           resize();
       }
       this.arr[count++] = data;
   }
   public int size(){
       return count;
   }

   public void set(int index, int data){
        arr[index] = data;
   }

   public boolean isFUll(){
       return count == arr.length;
   }
   public void resize(){
       int temp[] = new int[arr.length*2];
       for(int i = 0; i < arr.length; i++){
           temp[i] = arr[i];
       }
       arr = temp;
   }

    @Override
    public String toString() {
        return "CustomArrayList{" +
                "arr=" + Arrays.toString(arr) +
                ", DEFAULT_SIZE=" + DEFAULT_SIZE +
                ", count=" + count +
                '}';
    }

    public static void main (String[] args){
        CustomArrayList list = new CustomArrayList();
        list.add(12);
        list.add(30);
        list.size();
        list.set(1, 1);
        System.out.println(list);
    }
}
