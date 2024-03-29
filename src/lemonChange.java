public class lemonChange {

    public static boolean change(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5){
                five++;
            } else if (bill == 10) {
                if (five == 0) {
                    return false;
                }
                five--;
                ten++;
            } else { // 20
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(change(new int[]{5,5,10}));
        System.out.println(change(new int[]{5,5,20}));
    }
}
