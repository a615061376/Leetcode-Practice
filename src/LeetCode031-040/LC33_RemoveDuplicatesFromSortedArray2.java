public class LC33_RemoveDuplicatesFromSortedArray2 {

    /*
        Description:
Follow up for "Remove Duplicates": What if duplicates are allowed at most twice?
For example, given sorted array A = [1,1,1,2,2,3], your function should return length
= 5, and A is now [1,1,2,2,3].
    */

    public static int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) return 0;

        int pre = A[0];
        boolean flag = false;
        int count = 0;

        // index for updating
        int o = 1;

        for (int i = 1; i < A.length; i++) {
            int curr = A[i];

            if (curr == pre) {
                if(!flag) {
                    flag = true;
                    A[o++] = curr;
                    continue;
                } else {
                    count++;
                }
            }else {
                pre = curr;
                A[o++] = curr;
                flag = false;
            }
        }

        return A.length - count;
    }

    // Better solution
    public static int removeDuplicates2(int[] A) {
        if (A.length <= 2) return A.length;

        int prev = 1;   // point to previous
        int curr = 2;   // point to current

        while (curr < A.length) {
            if (A[curr] == A[prev] && A[curr] == A[prev - 1]) {
                curr++;
            }else {
                prev++;
                A[prev] = A[curr];
                curr++;
            }
        }

        return prev + 1;
    }

    public static void main(String[] args) {
        int[] array = {1,1,1,2,2,3};
        System.out.println(removeDuplicates(array));
        System.out.println(removeDuplicates2(array));
    }
}
