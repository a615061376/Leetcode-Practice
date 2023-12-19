package SortPractice;

public class RadixSortPractice {

    static void radixSort(int[] array) {

        int max = getMax(array);

        for (int exp = 1; max/exp > 0; exp *= 10) {
            countSort(array, exp);
        }
    }

    private static int getMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    private static void countSort(int[] array, int exp) {
        int[] output = new int[array.length];
        int[] bucket = new int[10];

        for (int i = 0; i < array.length; i++) {
            bucket[(array[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            bucket[i] += bucket[i - 1];
        }

        for (int i = array.length - 1; i >= 0; i--) {
            output[ bucket[(array[i] / exp) % 10 ] - 1] = array[i];
            bucket[(array[i] / exp) % 10]--;
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = output[i];
        }

    }

    public static void main(String[] args) {
        int[] array = {53, 3, 542, 748, 14, 214, 154, 63, 616};

        System.out.print("before sort:");
        for (int item: array) {
            System.out.print(" " + item);
        }

        System.out.println("");
        radixSort(array);

        System.out.print("after sort:");
        for (int item: array) {
            System.out.print(" " + item);
        }

    }
}
