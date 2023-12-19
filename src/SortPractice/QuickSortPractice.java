package SortPractice;

public class QuickSortPractice {

    private static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int i, j, k;

            i = left;
            j = right;
            k = array[i];

            while (i < j) {
                while (i < j && array[j] > k)
                    j--;
                if (i < j)
                    array[i++] = array[j];
                while (i < j && array[i] < k)
                    i++;
                if (i < j)
                    array[j--] = array[i];
            }
            array[i] = k;
            quickSort(array, left, i - 1);
            quickSort(array, i + 1, right);
        }

    }

    public static void main(String[] args) {

        int[] array = {20, 30, 90, 40, 70, 110, 60, 10, 100, 50, 80};

        System.out.print("before sort:");
        for (int item: array) {
            System.out.print(" " + item);
        }

        System.out.println(" ");
        quickSort(array, 0, array.length-1);

        System.out.print("after sort:");
        for (int item: array) {
            System.out.print(" " + item);
        }
    }


}
