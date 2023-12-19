import java.util.ArrayList;
import java.util.List;

public class LC36_PalindromePartitioning {

    /*
        Description:
Given a string s, partition s such that every substring of the partition is a palindrome.
Return all possible palindrome partitioning of s.
For example, given s = "aab", Return
        [
            ["aa","b"],
            ["a","a","b"]
        ]
    */

    public static ArrayList<ArrayList<String>> partition(String str) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        if ( str == null || str.length() == 0) return result;

        ArrayList<String> partition = new ArrayList<>();
        addPalindrome(str, 0, partition, result);
        return  result;
    }

    private static void addPalindrome(String str,
                                      int start,
                                      ArrayList<String> partition,
                                      ArrayList<ArrayList<String>> result) {
        // stop condition
        if (start == str.length()) {
            ArrayList<String> temp = new ArrayList<>(partition);
            result.add(temp);
            return;
        }

        for (int i = start + 1; i <= str.length(); i++) {
            String subString = str.substring(start, i);
            if (isPalindrome(subString)) {
                partition.add(subString);
                addPalindrome(str, i, partition, result);
                partition.remove(partition.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Dynamic Programming
    public static List<String> palindPartitioning(String str) {
        List<String> result = new ArrayList<>();

        if (str == null) return result;

        if (str.length() <= 1) {
            result.add(str);
            return result;
        }

        int length = str.length();
        int [][] table = new int[length][length];

        // l is length i is index of left boundary, j is index of right boundary
        for (int l = 1; l <= length ; l++) {
            for (int i = 0; i <= length - l; i++) {
                int j = i + l - 1;
                if (str.charAt(i) == str.charAt(j)) {
                    if (l == 1 || l == 2) {
                        table[i][j] = 1;
                    } else {
                        table[i][j] = table[i + 1][j - 1];
                    }
                    if (table[i][j] == 1) {
                        result.add(str.substring(i, j + 1));
                    }
                } else {
                    table[i][j] = 0;
                }
            }
        }
        return result;
    }



    public static void main(String[] args) {
        System.out.println(partition("aab"));
        System.out.println(palindPartitioning("aab"));
    }

}
