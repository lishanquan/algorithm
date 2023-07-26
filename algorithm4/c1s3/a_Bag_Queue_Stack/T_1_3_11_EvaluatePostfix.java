package algorithm4.c1s3.a_Bag_Queue_Stack;

import algorithm4.stdlib.StdIn;
import algorithm4.stdlib.StdOut;

/******************************************************************************
 *  Evaluates postfix expresions using a stack.
 *
 *  3 4 5 + *
 *  27
 *
 *  1 2 3 4 5 * + 6 * * +
 *  277
 *
 *  7 16 16 16 * * * 5 16 16 * * 3 16 * 1 + + +
 *  30001
 *
 *  7 16 * 5 + 16 * 3 + 16 * 1 +
 *  30001
 *
 ******************************************************************************/
public class T_1_3_11_EvaluatePostfix {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if ("+".equals(s))
                stack.push(stack.pop() + stack.pop());
            else if ("*".equals(s))
                stack.push(stack.pop() * stack.pop());
            else
                stack.push(Integer.parseInt(s));
        }
        StdOut.println(stack.pop());
    }

}
