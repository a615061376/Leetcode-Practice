package SortPractice;

public class BubbleSortPractice {

    private static void bubbleSort(int[] array, int n) {

        for (int i = n - 1; i > 0; i--) {

            for (int j = 0; j < i; j++) {

                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
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
        bubbleSort(array, array.length);

        System.out.print("after sort:");
        for (int item: array) {
            System.out.print(" " + item);
        }
    }



}
