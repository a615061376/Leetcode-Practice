public class LC03_SolutionOfLongestPalindromicSubstring {

    // time: O(nˆ 3)
    public static String longestPalindrome1(String s) {

        int maxPalinLength = 0;
        String longestPalindrome = null;
        int length = s.length();

        // Check all possible subStrings
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int len = j - 1;
                String current = s.substring(i, j+1);
                if (isPalindrome(current)) {
                    if (len > maxPalinLength) {
                        longestPalindrome = current;
                        maxPalinLength = len;
                    }
                }
            }
        }

        return longestPalindrome;
    }

    private static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
    // Time: O(nˆ2) ; Space:  O(nˆ2)
//    public static String longestPalindrome2(String s) {
//
//        if (s == null) return null;
//        if (s.length() <= 1) return s;
//
//        int maxLen = 0;
//        String longestStr = null;
//        int length = s.length();
//
//        int[][] table = new int[length][length];
//
//        // every single letter is palindrome
//        for (int i = 0; i < length; i++) {
//            table[i][i] = 1;
//        }
//        printTable(table);
//
//    }

    private static void printTable(int[][] x){
        for(int [] y : x){
            for(int z: y){
                System.out.print(z + " ");
            }
            System.out.println();
        }
        System.out.println("------");
    }
}
