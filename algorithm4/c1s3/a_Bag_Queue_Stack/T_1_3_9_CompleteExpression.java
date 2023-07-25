package algorithm4.c1s3.a_Bag_Queue_Stack;

import algorithm4.stdlib.In;
import algorithm4.stdlib.StdOut;

/**
 * 实现思路：
 * 初始化两个栈，一个用于保存运算符，一个用于保存操作数
 * 读取标准输入，将操作数压入操作数栈，将运算符压入运算符栈
 * 在遇到右括号时，弹出一个运算符，弹出两个操作数
 * 组合运算符和操作数，并在两端添加左右括号，将结果压入操作数栈
 */
public class T_1_3_9_CompleteExpression {

    public static String completeExpression(String s) {
        String[] params = s.split(" ");
        Stack<String> dataStack = new Stack<>();
        Stack<String> operatorStack = new Stack<>();
        for (String p : params) {
            if (isOperator(p)) {
                operatorStack.push(p);
            } else if (")".equals(p)) {
                String d1 = dataStack.pop();
                String op = operatorStack.pop();
                String d2 = dataStack.pop();
                dataStack.push("( " + d2 + " " + op + " " + d1 + " )");
            } else {
                dataStack.push(p);
            }
        }

        return dataStack.pop();
    }

    /**
     * 判断是否是操作符
     * @param s
     * @return
     */
    private static boolean isOperator(String s) {
        return "+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s);
    }

    public static void main(String[] args) {
        // diy test
//        String expression = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
//        System.out.println(completeExpression(expression));
        // Scanner
        In in = new In();
        String s = in.readAll().trim();
        StdOut.println(completeExpression(s));
    }

}
