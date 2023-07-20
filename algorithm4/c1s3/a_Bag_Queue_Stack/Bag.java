package algorithm4.c1s3.a_Bag_Queue_Stack;

import java.util.Iterator;

/**
 * 算法1.4背包
 * @param <Item>
 */
public class Bag<Item> implements Iterable<Item>{

    private Node first;

    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void add(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = null;
        N++;
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

}
