public class FindPrime {

    // 暴力算法
    public static int bruteForce(int n) {
        int count = 0;
        for (int i = 2 ; i < n; i++) {
            count += isPrime(i) ? 1 : 0 ;
        }
        return count;

    }

    private static boolean isPrime(int x) {
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 埃氏篩選法
    public static int eratosthenes(int n) {
        boolean[] isPrime = new boolean[n];  // false代表質數
        int count = 0;

        for (int i = 2; i < n; i++) {
            if (!isPrime[i]) {
                count++;
                for (int j = i * i; j < n; j+= i) {   // **j就是非質數的標記位
                    isPrime[j] = true;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(bruteForce(100));
        System.out.println(eratosthenes(100));
    }
}
