public class LC01_RotateArray {

    /*
    * 將包含 n 個元素的樹組向右旋轉 k 步
    * Ex. 將數組[1,2,3,4,5,6,7] 旋轉到 [5,6,7,1,2,3,4]
    * */

    // Solution 1 -  Intermediate Array
    // Space: O(n), Time: O(n)
    public static void rotate1(int[] nums, int k) {

        if (k > nums.length)
            k = k % nums.length;

        int[] result = new int[nums.length];

        for (int i = 0; i < k; i++) {
            result[i] = nums[nums.length - k + i];
        }

        int j = 0;
        for (int i = k; i < nums.length; i++) {
            result[i] = nums[j];
            j++;
        }

        System.arraycopy(result, 0, nums, 0, nums.length);
    }


    // Solution 2 - Bubble Rotate
    // Space: O(1), Time: O(n*k).
    public static void rotate2(int[] arr, int order) throws IllegalAccessException {

        if (arr == null || order < 0) {
            throw new IllegalAccessException("Illegal argument!");
        }

        for (int i = 0; i < order; i++) {
            for (int j = arr.length - 1; j > 0; j--) {
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
            }
        }
    }

    // Solution 3 - Reversal
    // Space: O(1), Time: O(n)
    public static void rotate3(int[] arr, int order) {

        order = order % arr.length;

        if (arr == null || order < 0) {
            throw new IllegalArgumentException("Illegal argument!");
        }

        //length of first part
        int a = arr.length - order;
        reverse(arr, 0, a-1);
        reverse(arr, a, arr.length-1);
        reverse(arr, 0, arr.length-1);
    }
    static void reverse(int[] arr, int left, int right){

        if(arr == null || arr.length == 1)
            return;
        while(left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
