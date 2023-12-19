package SortPractice;

public class HeapSortPractice {

    private static void maxHeapDown(int[] array, int start, int end) {

        int curr = start;
        int left = 2 * curr + 1;
        int temp = array[curr];

        for ( ;left <= end; curr = left, left = 2 * left + 1) {
            // "l"是左孩子，"l+1"是右孩子
            if ( left < end && array[left] < array[left+1])
                left++;        // 左右两孩子中选择较大者，即m_heap[l+1]
            if (temp >= array[left])
                break;        // 调整结束
            else {            // 交换值
                array[curr] = array[left];
                array[left]= temp;
            }
        }
    }

    private static void heapSortAsc(int[] array, int n) {

        int i, temp;

        for (i = n / 2 - 1; i >= 0; i--)
            maxHeapDown(array, i, n-1);

        for (i = n - 1; i > 0; i--) {
            temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            maxHeapDown(array, 0, i - 1);
        }

    }

    public static void main(String[] args) {

        int[] array = {20, 30, 90, 40, 70, 110, 60, 10, 100, 50, 80};

        System.out.print("before sort:");
        for (int item: array) {
            System.out.print(" " + item);
        }

        System.out.println(" ");
        heapSortAsc(array, array.length);
        //heapSortDesc(array, array.length);

        System.out.print("after sort:");
        for (int item: array) {
            System.out.print(" " + item);
        }
    }


}
