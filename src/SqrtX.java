public class SqrtX {

    // 二分查找
    public static int binarySearch(int x) {
        int index = -1, left = 0, right = x ;

        while ( left <= right) {
            int mid =  left + ( right - left )/2;
            if ( mid * mid <= x ) {
                index = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }

    // 牛頓迭代算法- (微積分)
    public static int newton(int x) {
        if ( x == 0 ) return 0;
        return (int)sqrt(x,x);
    }

    private static double sqrt(double i, int x) {
        double result = ( i + x/i )/2;
        return result == i ? i : sqrt(result, x);
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(100));
        System.out.println(newton(5));
    }
}
