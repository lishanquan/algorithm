package algorithm4.c1s3.a_Bag_Queue_Stack;

import java.util.Iterator;

/**
 * 算法1.1下压（LIFO）栈:（能够动态调整数组大小的实现）
 * @param <Item>
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {

    private Item[] a = (Item[]) new Object[1];  // 栈元素
    private int N = 0;                          // 元素数量

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    // 将栈移动到一个大小为max的新数组
    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++)
            temp[i] = a[i];
        a = temp;
    }

    // 将元素添加到栈顶
    public void push(Item item) {
        if (N == a.length)
            resize(2*a.length);
        a[N++] = item;
    }

    // 从栈顶删除元素
    public Item pop() {
        Item item = a[--N];
        a[N] = null; //避免对象游离
        // TODO 这里为什么使用 N == a.length/4 的标准？
        if (N > 0 && N == a.length/4)
            resize(a.length/2);
        return item;
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    // 支持先进后出的迭代
    private class ReverseArrayIterator implements Iterator<Item> {

        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return a[--i];
        }

        @Override
        public void remove() {

        }
    }
}
