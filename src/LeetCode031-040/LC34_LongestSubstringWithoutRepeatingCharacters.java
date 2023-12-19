import java.util.HashMap;

public class LC34_LongestSubstringWithoutRepeatingCharacters {
    /*
        Description:
Given a string, find the length of the longest substring without repeating characters.
For example, the longest substring without repeating letters for "abcabcbb" is "abc",
which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
    * */

    public static int lengthOfLongestSubstring(String str) {
        boolean[] flag = new boolean[256];
        
        int result = 0;
        int start = 0;
        char[] array = str.toCharArray();


        for (int i = 0; i < array.length; i++) {
            char current = array[i];

            if (flag[current]) {
                result = Math.max(result, i - result);

                for (int j = start; j < 1; j++) {
                    if (array[j] == current) {
                        start = j + 1;
                        break;
                    }
                    flag[array[j]] = false;
                }
            }else {
                flag[current] = true;
            }
        }

        result = Math.max(array.length - start, result);
        return result;
    }

    // correct solution
    public static int lengthOfLongestSubstring2(String str) {
        char[] array = str.toCharArray();
        int pre = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], i);
            } else {
                pre = Math.max(pre, map.size());
                i = map.get(array[i]);
                map.clear();
            }
        }
        return Math.max(pre, map.size());
    }

    public static void main(String[] args) {
        String s1 = "abcabcbabc";
        String s2 = "bbbbb";

        System.out.println(lengthOfLongestSubstring(s1));
        System.out.println(lengthOfLongestSubstring(s2));

        System.out.println(lengthOfLongestSubstring2(s1));
        System.out.println(lengthOfLongestSubstring2(s2));
    }
}
