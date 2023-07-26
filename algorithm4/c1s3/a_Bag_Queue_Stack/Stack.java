package algorithm4.c1s3.a_Bag_Queue_Stack;

import algorithm4.stdlib.StdIn;
import algorithm4.stdlib.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

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

    // 获取栈顶元素
    public Item peek() {
        // diy
//        if (first == null)
//            return null;
//        else
//            return first.item;

        // reference
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return first.item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    /**
     * ListIterator维护了一个实例变量current来记录链表的当前结点。
     * hasNext()方法会检测current是否为null, next()方法会保存当前元素的引用，将current变量指向链表中的下个结点并返回所保存的引用。
     */
    private class ListIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {

        }
    }

    public Stack<Item> copy(Stack<Item> s) {
        Iterator it = s.iterator();
        Stack<Item> result = new Stack<>();
        Stack<Item> temp = new Stack<>();

        while (it.hasNext()) {
            temp.push((Item)it.next());
        }

        it = temp.iterator();
        while (it.hasNext()) {
            result.push((Item)it.next());
        }

        return result;
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
