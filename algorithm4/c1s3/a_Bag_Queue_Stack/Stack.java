package algorithm4.c1s3.a_Bag_Queue_Stack;

import algorithm4.stdlib.StdIn;
import algorithm4.stdlib.StdOut;

import java.util.Iterator;

/**
 * 算法1.2下压堆栈（链表实现）
 * @param <Item>
 */
public class Stack<Item> implements Iterable<Item> {

    private Node first; // 栈顶（最近添加的元素）

    private int N;      // 元素数量

    // 定义结点的嵌套类
    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return N == 0; // 或者 first == null
    }

    public int size() {
        return N;
    }

    // 向栈顶添加元素
    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    // 从栈顶删除元素
    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    public static void main(String[] args) {
        Stack<String> s = new Stack<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                s.push(item);
            else if (!s.isEmpty())
                StdOut.print(s.pop() + "");
        }
        StdOut.println("(" + s.size() + " left on stack)");
    }

}
