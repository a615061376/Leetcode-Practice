package SortPractice;

public class BucketSortPractice {

    private static void bucketSort(int[] array, int max) {

        if (array == null || max < 1) return;

        int[] bucket = new int[max];

        for (int i : array) {
            bucket[i]++;
        }

        for (int i = 0, j = 0; i < max; i++) {
            while (bucket[i]-- > 0) {
                array[j++] = i;
            }
        }

    }

    public static void main(String[] args) {

        int[] array = {8, 2, 3, 4, 3, 6, 6, 3, 9};

        System.out.print("before sort:");
        for (int item: array) {
            System.out.print(" " + item);
        }

        System.out.println("");
        bucketSort(array, 10);

        System.out.print("after sort:");
        for (int item: array) {
            System.out.print(" " + item);
        }
    }


}
