package algorithm4.c1s3.a_Bag_Queue_Stack;

import java.util.Iterator;

/**
 * 算法1.3先进先出队列
 * @param <Item>
 */
public class Queue<Item> implements Iterable<Item> {

    // 指向最早添加的结点的链接
    private Node first;

    // 指向最后添加的结点的链接
    private Node last;

    // 队列中的元素数量
    private int N;

    // 定义了结点的嵌套类
    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;  // return N == 0;
    }

    public int size() {
        return N;
    }

    // 向表尾添加元素
    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty())
            first = last;
        else
            oldLast.next = last;
        N++;
    }

    // 从表头删除元素
    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        if (isEmpty())
            last = null;
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

}
