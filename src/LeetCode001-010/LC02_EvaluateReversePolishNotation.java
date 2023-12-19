import java.io.IOException;
import java.util.Stack;

public class LC02_EvaluateReversePolishNotation {

    /*
    *
    * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
    * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
    * */

    public static void main(String[] args) throws IOException {
        String[] str = new String[] { "2", "1", "+", "3", "*" };
        System.out.println(evalRPN1(str));
        System.out.println(evalRPN2(str));
    }

    // Navie Approach
    public static int evalRPN1(String[] str) {
        int returnValue = 0;
        String operators = "+-*/";

        Stack<String> stack = new Stack<>();

        for (String s : str) {
            if (!operators.contains(s)) {
                stack.push(s);
            } else {
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                switch (s) {
                    case "+":
                        stack.push(String.valueOf(a + b));
                        break;
                    case "-":
                        stack.push(String.valueOf(b - a));
                        break;
                    case "*":
                        stack.push(String.valueOf(a * b));
                        break;
                    case "/":
                        stack.push(String.valueOf(b / a));
                        break;
                }
            }
        }

        returnValue = Integer.valueOf(stack.pop());

        return returnValue;
    }

    public static int evalRPN2(String[] str) {

        int returnValue = 0;
        String operators = "+-*/";

        Stack<String> stack = new Stack<String>();

        for (String s: str) {
            if (!operators.contains(s)) {
                stack.push(s);
            } else {
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                int index = operators.indexOf(s);
                switch (index) {
                    case 0:
                        stack.push(String.valueOf(a + b));
                        break;
                    case 1:
                        stack.push(String.valueOf(b - a));
                        break;
                    case 2:
                        stack.push(String.valueOf(a * b));
                        break;
                    case 3:
                        stack.push(String.valueOf(b / a));
                        break;
                }
            }
        }

        returnValue = Integer.valueOf(stack.pop());

        return returnValue;
    }
}
