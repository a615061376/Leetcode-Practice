import java.util.Arrays;

public class MergeSortArray {

    // T: O((n+m)log(n+m)) S:O(n)
    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
        return nums1;
    }

    // 雙指針 O(n+m)
    public static int[] merge1(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1Copy = new int[m];
        System.arraycopy(nums1,0,nums1Copy,0, m);

        int p1 = 0; // 指向nums1Copy
        int p2 = 0; // 指向nums2
        int p = 0; // 指向nums1

        while (p1 < m && p2 < n) {
            nums1[p++] = nums1Copy[p1] < nums2[p2] ? nums1Copy[p1++] : nums2[p2++];
        }
        if (p1 < m) {
            System.arraycopy(nums1Copy, p1, nums1,p1+p2,m+n-p1-p2);
        }
        if (p2 < n) {
            System.arraycopy(nums2, p2, nums1,p1+p2,m+n-p1-p2);
        }
        return nums1;
    }

    // 空間複雜度變低 雙指針 優化 O(n) --> 做法從後面開始
    public static int[] merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1;
        int p2 = n-1;
        int p = m+n-1; // nums1最後一個下標
        while (p1 >= 0 && p2 >= 0) {
            nums1[p--] = nums1[p1] < nums2[p2] ? nums2[p2--] : nums1[p1--];
        }
        System.arraycopy(nums2,0, nums1, 0, p2+1);
        return nums1;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3,5,7,9,0,0,0,0};
        int[] nums2 = new int[]{2,4,6,8};
         System.out.println(Arrays.toString(merge(nums1, 5, nums2, 4)));
         System.out.println(Arrays.toString(merge1(nums1, 5, nums2, 4)));
        System.out.println(Arrays.toString(merge2(nums1, 5,nums2,4)));
    }
}
