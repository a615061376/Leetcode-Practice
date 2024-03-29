public class ArrangeCoin {

    // 迭代(暴力算法)
    public static int arrangeCoin(int n) {
        for (int i = 1; i <= n; i++) {
            n -= i;
            if (n <= i) {
                return i;
            }
        }
        return 0;
    }

    // 二分查找
    public static int arrangeCoin2(int n) {
        int low = 0, high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cost = ((mid + 1) * mid) / 2;
            if (cost == n) {
                return mid;
            } else if(cost > n) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }

    // 牛頓迭代 - 求平方根
    public static int arrangeCoin3(int n) {
        if (n == 0) {
            return 0;
        }
        return (int)sqrt(n,n);
    }

    private static double sqrt(double x, int n) {
        double res =  (x + (2 * n - x) / x) / 2;
        if (res == x) {
            return x;
        } else {
            return sqrt(res, n);
        }
    }

    public static void main(String[] args) {
        System.out.println(arrangeCoin(10));
        System.out.println(arrangeCoin(20));
        System.out.println(arrangeCoin2(20));
        System.out.println(arrangeCoin2(30));
        System.out.println(arrangeCoin3(30));
        System.out.println(arrangeCoin3(40));

    }
}
