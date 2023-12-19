public class LC37_ReverseWordsInAString {
    /*
        Description:
This problem is pretty straightforward. We first split the string to words array, and
then iterate through the array and add each element to a new string. Note: String-
Builder should be used to avoid creating too many Strings. If the string is very long,
using String is not scalable since String is immutable and too many objects will be
created and garbage collected.
    */

    public static String reverseWords(String str) {
        if (str == null || str.length() == 0) return "";

        // split to words by space
        String[] arr = str.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = arr.length - 1; i >= 0; --i) {
            if (!arr[i].equals("")) {
                sb.append(arr[i]).append(" ");
            }
        }
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("sky is blue color"));
    }
}
