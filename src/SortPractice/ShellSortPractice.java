package SortPractice;

public class ShellSortPractice {

    private static void shellSort1(int[] array, int n) {

        for (int gap = n / 2; gap > 0; gap /= 2) {

            for (int i = 0; i < gap; i++) {

                for (int j = i + gap; j < n; j += gap ) {

                    if (array[j] < array[j - gap]) {
                        int temp = array[j];
                        int k = j -gap;
                        while (k >= 0 && array[k] > temp){
                            array[k + gap] = array[k];
                            k -= gap;
                        }
                        array[ k +gap] = temp;
                    }
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
        shellSort1(array, array.length);
        // shellSort2(array, array.length);

        System.out.print("after sort:");
        for (int item: array) {
            System.out.print(" " + item);
        }
    }

}
