import java.util.HashSet;

public class LC35_LongestSubstringWhichContains2UniqueCharacters {

    /*
        Description:
Given a string, find the longest substring that contains only two unique characters. For
example, given "abcbbbbcccbdddadacb", the longest substring that contains 2 unique
character is "bcbbbbcccb".
   */

    // Naive Solution
    public static String subString(String str) {
        // Checking
        char[] arr = str.toCharArray();
        int max = 0;
        int j = 0;
        int m = 0;
        int n = 0;

        HashSet<Character> set = new HashSet<>();
        set.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (set.add(arr[i])) {
                String subString = str.substring(j, i);

                // Keep the last character only
                set.clear();
                set.add(arr[i - 1]);

                if ((i-j) > max) {
                    m = j;
                    n = i - 1;
                    max = i - j;
                }

                j = i - helper(subString);
            }
        }
        return  str.substring(m, n + 1);
    }

    // This method returns the length that contains only one character from right side.
    public static int helper(String subString) {
        // null & illegel checking here
        if (subString == null) return 0;
        if (subString.length() == 1) return 1;

        char[] arr = subString.toCharArray();
        char p = arr[arr.length - 1];
        int result = 1;

        for (int i = arr.length - 2; i >= 0; i--) {
            if (p == arr[i])
                result++;
            else
                break;
        }
        return  result;
    }

    public static void main(String[] args) {
        System.out.println(subString("abcbbbbcccbdddadacb"));
    }
}


