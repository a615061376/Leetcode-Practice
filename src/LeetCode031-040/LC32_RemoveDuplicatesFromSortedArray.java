import java.util.Arrays;

public class LC32_RemoveDuplicatesFromSortedArray {

    /*
        Description:
Given a sorted array, remove the duplicates in place such that each element appear
only once and return the new length. Do not allocate extra space for another array,
you must do this in place with constant memory.
For example, given input array A = [1,1,2], your function should return length = 2,
and A is now [1,2].
    */


    // Manipulate original array
    public static int removeDuplicatesNaive(int[] A) {
        if (A.length < 2)
            return A.length;
        int j = 0;
        int i = 1;
        while (i < A.length) {
            if (A[i] == A[j]) {
                i++;
            } else {
                j++;
                A[j] = A[i];
                i++;
            }
        }
        return j + 1;
    }

    // Create an array with all unique elements
    public static int[] removeDuplicates(int[] A) {
        if (A.length < 2) return A;
        int j = 0;
        int i = 1;
        while (i < A.length) {
            if (A[i] == A[j]) {
                i++;
            } else {
                j++;
                A[j] = A[i];
                i++;
            }
        }
        int[] B = Arrays.copyOf(A, j + 1);
        return B;
    }

    // Count the number of unique elements
    public static int countUnique(int[] A) {
        int count = 0;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] == A[i + 1]) {
                count++;
            }
        }
        return (A.length - count);
    }

    public static void main(String[] args) {
        int[] array = {1,2,2,3,4,5,5,5};
        System.out.println(removeDuplicatesNaive(array));
        System.out.println(removeDuplicates(array).length);
        System.out.println(countUnique(array));
    }
}
