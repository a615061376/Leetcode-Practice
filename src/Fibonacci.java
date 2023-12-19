public class Fibonacci {

    // 斐波那契數列 [0,1,1,2,3,5,8...]

    // 暴力遞歸 --> O(2^n)
    public static int calculate(int num) {
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        return calculate(num-1) + calculate(num-2);
   }

    // 去重遞歸 --> T:O(n) S:O(n)
    public static int calculate2(int num) {
        int[] arr = new int[num + 1];
        return recurse(arr,num);
    }

    private static int recurse(int[] arr, int num) {
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        if (arr[num] != 0) {
            return arr[num];
        }
        arr[num] = recurse(arr,num-1) + recurse(arr,num-2);
        return arr[num];
    }

    // 雙指針 --> O(1)
    private static int iterate(int num) {
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        int low = 0, high = 1;
        for (int i = 2; i <= num; i++) {
            int sum = low + high;
            low = high;
            high = sum;
        }
        return high;
    }

    public static void main(String[] args) {
        System.out.println(calculate(10));
        System.out.println(calculate2(11));
        System.out.println(iterate(12));
        System.out.println(iterate(13));
    }
}
