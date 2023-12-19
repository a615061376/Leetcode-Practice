public class LC31_MaximumProductSubarray {

    /*
        Description:
Find the contiguous subarray within an array (containing at least one number) which has the largest product.
For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has the largest product = 6.
    */

    // Brute-force | time:O(n^3)
    public static int maxProduct1(int[] A) {
        int max = Integer.MIN_VALUE;

        for(int i=0; i<A.length; i++){
            for(int j=0; j<A.length; j++) {
                if (i + 1 < A.length) {
                    int product = calProduct(A, i, j);
                    max = Math.max(product, max);
                }

            }
        }
        return max;
    }

    public static int calProduct(int[] A, int i, int j) {
        int result = 1;
        for(int m=i; m<=j; m++){
            result = result * A[m];
        }
        return result;
    }

    // Dynamic Programming | time: O(n)
    public static int maxProduct2(int[] A) {
        if (A == null || A.length == 0) return 0;

        int maxLocal = A[0];
        int minLocal = A[0];
        int global = A[0];

        for (int i = 1; i < A.length; i++) {
            int temp = maxLocal;
            maxLocal = Math.max(
                Math.max(A[i]*maxLocal, A[i]), A[i]*minLocal
            );
            minLocal = Math.min(
                Math.min(A[i]*temp, A[i]), A[i]*minLocal
            );
            global = Math.max(global, maxLocal);
        }
        return global;
    }

    public static void main(String[] args) {
        int[] array = {2, 3, -2, 4};
        int[] array1 = {-3, 4, -2, 5, 1};
        System.out.println(maxProduct1(array));
        System.out.println(maxProduct2(array));
        System.out.println(maxProduct1(array1));
        System.out.println(maxProduct2(array1));
    }
}
