package algorithm4.c1s3.a_Bag_Queue_Stack;

import algorithm4.stdlib.StdIn;
import algorithm4.stdlib.StdOut;

/******************************************************************************
 *  1.3.12 编写一个可迭代的Stack用例，它含有一个静态的copy()方法，接受一个字符串的栈作为参数并返回该栈的一个副本。
 *  注意：这种能力是迭代器价值的一个重要体现，因为有了它我们无需改变基本API就能够实现这种功能。
 *
 ******************************************************************************/
public class T_1_3_12_StackCopy {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        while (!StdIn.isEmpty()) {
            stack.push(StdIn.readString());
        }
        stack = stack.copy(stack);
        while (!stack.isEmpty())
            StdOut.print(stack.pop());
    }

}
