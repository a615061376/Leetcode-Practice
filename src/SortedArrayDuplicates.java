public class SortedArrayDuplicates {

    //  刪除重複元素 - 雙指針算法
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0 ) return 0;

        int i = 0;
        for (int j = 1 ; j < nums.length; j++) {
            if (nums[j] != nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }
        // i是指針，如果要取得長度的話+1
        return i + 1;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0,1,2,2,3,3,4,5}));
    }
}
