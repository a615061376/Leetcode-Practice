public class LC38_FIndMinimumInRotatedSortedArray {
    /*
        D
Suppose a sorted array is rotated at some pivot unknown to you beforehand. (i.e., 0 1
2 4 5 6 7 might become 4 5 6 7 0 1 2).
Find the minimum element.You may assume no duplicate exists in the array.
     */

    public static int findMin(int[] num) {
        return findMin(num, 0, num.length - 1);
    }

    public static int findMin(int[] num, int left, int right) {
        if (left == right) return num[left];

        if (right - left == 1) return Math.min(num[left], num[right]);

        int middle = (left + right) / 2;

        // not rotated
        if (num[left] < num[right]) {
            return num[left];

            // go right side
        } else if (num[middle] > num[left]) {
            return findMin(num, middle, right);

            // go left side
        } else {
            return findMin(num, left, middle);
        }
    }

    public static void main(String[] args) {
        int[] array = {4, 5, 6, 7, 1, 2};
        System.out.println(findMin(array));
    }
}
