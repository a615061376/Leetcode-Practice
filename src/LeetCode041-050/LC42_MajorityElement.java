import java.util.Arrays;

public class LC42_MajorityElement {

    /*
        Description:
Problem:
Given an array of size n, find the majority element. The majority element is the
element that appears more than b n/2 c times. You may assume that the array is
non-empty and the majority element always exist in the array.
    * */

    public static int majorityElement(int[] num) {

        if (num.length == 1) return num[0];

        Arrays.sort(num);

        int prev = num[0];
        int count = 1;

        for (int i = 1; i < num.length; i++) {
            if (num[i] == prev) {
                count++;
                if (count > num.length / 2) return num[i];
            } else {
                count = 1;
                prev = num[i];
            }
        }

        return 0;
    }

    public static int majorityElement2(int[] num) {

        if (num.length == 1) {
            return num[0];
        }

        Arrays.sort(num);
        return num[num.length / 2];
    }


    public static void main(String[] args) {
        int[] array = {1,2,3};
        System.out.println(majorityElement(array));
        System.out.println(majorityElement2(array));
    }
}
