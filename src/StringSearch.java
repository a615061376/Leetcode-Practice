import java.util.Arrays;

public class StringSearch {

    //StringSearch
    // 1. BF:暴力
    // 2. RK算法:哈希算法
    // 3. BM
    // 4. **KMP**

    static int search(char[] str, char[] pattern, int[] next) {
        int i = 0, j = 0;

        while (i < str.length && j < pattern.length) {
            if (j == -1 || str[i] == pattern[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == pattern.length) {
            return i - j;
        } else {
            return -1;
        }
    }


    static void getNext(char[] pattern, int[] next) {
        next[0] = -1;
        int i = 0, j = -1;

        while (i < pattern.length) {
            if (j == -1) {
                i++;
                j++;
            } else if (pattern[i] == pattern[j]) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
    }

    public static void main(String[] args) {
        String str1 = "ABCABCAABCABCD";
        String strPattern = "ABCABCD";
        int[] next = new int[strPattern.length()];
        getNext(strPattern.toCharArray(), next);
        int i = search(str1.toCharArray(), strPattern.toCharArray(), next);
        System.out.println(Arrays.toString(next));
        System.out.println(i);
        System.out.println(str1.indexOf(strPattern));
    }
}
