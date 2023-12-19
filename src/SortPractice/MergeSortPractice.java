package SortPractice;

public class MergeSortPractice {

    private static void merge(int[] array, int start, int mid, int end) {

        int[] tmp = new int[end-start+1];

        int i = start;
        int j = mid + 1;
        int k = 0;

        while(i <= mid && j <= end) {
            if (array[i] <= array[j])
                tmp[k++] = array[i++];
            else
                tmp[k++] = array[j++];
        }

        while(i <= mid)
            tmp[k++] = array[i++];

        while(j <= end)
            tmp[k++] = array[j++];

        // 将排序后的元素，全部都整合到数组a中。
        for (i = 0; i < k; i++)
            array[start + i] = tmp[i];

        tmp=null;

    }

    private static void mergeSortUpToDown(int[] array, int start, int end) {

        if ( array == null || start >= end) return;

        int mid = (start+end) / 2;

        mergeSortUpToDown(array, start, mid);
        mergeSortUpToDown(array, mid+1, end);

        merge(array, start, mid, end);
    }




    public static void main(String[] args) {

        int[] array = {80, 30, 60, 40, 20, 10, 50, 70};

        System.out.print("before sort:");
        for (int item: array) {
            System.out.print(" " + item);
        }

        System.out.println(" ");
        mergeSortUpToDown(array, 0, array.length-1);
        //mergeSortDownToUp(array);

        System.out.print("after sort:");
        for (int item: array) {
            System.out.print(" " + item);
        }
    }


}
