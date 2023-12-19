package Algorithm.Easy;

import static java.lang.Integer.sum;

public class AplusBProblem {


    // Hint: a+b = a ^ b + (a & b) << 1;

    private static int solution(int a, int b) {

        if (a == 0) return b;

        if (b == 0) return a;

        int sum = a ^ b;
        int carry = (a & b ) << 1;

        System.out.println(sum);
        System.out.println(carry);

        return sum(sum, carry);
    }

    public static void main(String[] args) {
        System.out.println(solution(5, 6));
    }


}
