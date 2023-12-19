import java.util.Arrays;

public class Triangles {

    // 貪心算法
    public static int largestPerimeter(int[] a) {
        Arrays.sort(a);
        for (int i = a.length-1; i >= 2; i--) {
            if (a[i-1] + a[i-2] > a[i]) {
                return a[i-1] + a[i-2] + a[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(largestPerimeter(new int[]{3,6,2,3}));
    }
}
