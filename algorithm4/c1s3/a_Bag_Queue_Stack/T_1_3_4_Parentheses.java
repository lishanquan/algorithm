package algorithm4.c1s3.a_Bag_Queue_Stack;

import algorithm4.stdlib.In;
import algorithm4.stdlib.StdOut;

public class T_1_3_4_Parentheses {

    private static final char LEFT_PAREN = '(';
    private static final char RIGHT_PAREN = ')';
    private static final char LEFT_BRACE = '{';
    private static final char RIGHT_BRACE = '}';
    private static final char LEFT_BRACKET = '[';
    private static final char RIGHT_BRACKET = ']';

    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == LEFT_PAREN)
                stack.push(LEFT_PAREN);
            else if (s.charAt(i) == LEFT_BRACE)
                stack.push(LEFT_BRACE);
            else if (s.charAt(i) == LEFT_BRACKET)
                stack.push(LEFT_BRACKET);

            if (s.charAt(i) == RIGHT_PAREN) {
                if (stack.isEmpty())
                    return false;
                if (stack.pop() != LEFT_PAREN)
                    return false;
            } else if (s.charAt(i) == RIGHT_BRACE) {
                if (stack.isEmpty())
                    return false;
                if (stack.pop() != LEFT_BRACE)
                    return false;
            } else if (s.charAt(i) == RIGHT_BRACKET) {
                if (stack.isEmpty())
                    return false;
                if (stack.pop() != LEFT_BRACKET)
                    return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        In in = new In();
        String s = in.readAll().trim();
        StdOut.println(isBalanced(s));
    }

}
