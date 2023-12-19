package SortPractice;

public class InsertionSortPractice {

    private static void insertSort(int[] array, int n) {

        int i, j, k;

        for (i = 0; i < n; i++) {

            for (j = i - 1; j >= 0; j--) {
                if (array[j] < array[i]) break;
            }

            if (j != i - 1) {
                int temp = array[i];
                for (k = i - 1; k > j; k--) {
                    array[k+1] = array[k];
                }
                array[k+1] = temp;
            }
        }

    }

    public static void main(String[] args) {

        int[] array = {20, 30, 90, 40, 70, 110, 60, 10, 100, 50, 80};

        System.out.print("before sort:");
        for (int item: array) {
            System.out.print(" " + item);
        }

        System.out.println(" ");
        insertSort(array, array.length);

        System.out.print("after sort:");
        for (int item: array) {
            System.out.print(" " + item);
        }
    }



}
