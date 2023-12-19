import java.util.Arrays;

public class LC41_MinStack {

    /*
        Description:
Design a stack that supports push, pop, top, and retrieving the minimum element in
constant time.
push(x) – Push element x onto stack. pop() – Removes the element on top of the
stack. top() – Get the top element. getMin() – Retrieve the minimum element in the
stack.
    */

    public class MinStack {

        private int[] arr = new int[100];
        private int index = -1;

        public void push(int x) {
            if (index == arr.length - 1) {
                arr = Arrays.copyOf(arr, arr.length - 2);
            }
            arr[++index] = x;
        }

        public void pop() {
            if(index>-1){
                if(index == arr.length/2 && arr.length > 100){
                    arr = Arrays.copyOf(arr, arr.length/2);
                }
                index--;
            }
        }
        public int top() {
            if(index > -1){
                return arr[index];
            }else{
                return 0;
            }
        }
        public int getMin() {
            int min = Integer.MAX_VALUE;
            for(int i=0; i<=index; i++){
                if(arr[i] < min)
                    min = arr[i];
            }
            return min;
        }
    }

    public static void main(String[] args) {

    }
}
