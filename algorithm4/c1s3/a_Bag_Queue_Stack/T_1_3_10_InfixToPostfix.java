package algorithm4.c1s3.a_Bag_Queue_Stack;

import algorithm4.stdlib.StdIn;
import algorithm4.stdlib.StdOut;

/******************************************************************************
 *  Windows users: replace [Ctrl-d] with [Ctrl-z] to signify end of file.
 *
 *  ( 2 + ( ( 3 + 4 ) * ( 5 * 6 ) ) )
 *  [Ctrl-d]
 *  2 3 4 + 5 6 * * +
 *
 *  ( ( ( 5 + ( 7 * ( 1 + 1 ) ) ) * 3 ) + ( 2 * ( 1 + 1 ) ) )
 *  5 7 1 1 + * + 3 * 2 1 1 + * +
 *
 *  ( 2 + ( ( 3 + 4 ) * ( 5 * 6 ) ) )
 *  2 3 4 + 5 6 * * +
 *
 *  中序表达式就是算术表达式，也就是我们常写的 3 + 4 × ( 5 + 6) - 8 / 2 这种式子，它的特点就是不包含括号，而且操作符位于两个操作数中间。
 *
 *  前序表达式也被称为前缀表达式、波兰表示法，它与中序表达式的区别就是没有括号，而且操作符位于两个操作数前面，
 *  比如上面的式子转化为前序表达式就是  - + 3 × 4 + 5 6 / 8 2
 *
 *  同理，后续表达式被称为逆波兰表示法，它也没有括号，而且操作符位于两个操作数后面。
 *  上面的式子转为后序表达式就是3 4 5 6 + × + 8 2 / -
 *
 *  先来讲讲手工算法，以后序表达式为例：
 *  先找出优先级最高的符号，然后将该操作符对应的两个操作数写到相应位置，
 *  再在后面写下操作符（注意哦，不能写括号），将写下的这部分作为一个整体，重复该操作直到没有操作符。
 ******************************************************************************/
public class T_1_3_10_InfixToPostfix {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if ("+".equals(s))
                stack.push(s);
            else if ("*".equals(s))
                stack.push(s);
            else if (")".equals(s))
                StdOut.print(stack.pop() + " ");
            else if ("(".equals(s))
                StdOut.print("");
            else
                StdOut.print(s + " ");
        }
        StdOut.println();
    }

}
