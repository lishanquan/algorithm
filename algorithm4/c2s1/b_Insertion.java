package algorithm4.c2s1;

import algorithm4.stdlib.In;
import algorithm4.stdlib.StdOut;

public class b_Insertion {

    public static void sort(Comparable[] a) {
        // 将a[]按升序排列
        int N = a.length;
        for (int i = 1; i < N; i++) {
            // 将a[i]插入到a[i-1]、a[i-2]、a[i-3]…之中
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--)
                exch(a, j, j-1);
        }
    }

    // 比较两个元素大小
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // 交换数组中两个元素位置
    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    // 在单行中打印数组
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }

    // 检测数组元素是否有序
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1]))
                return false;
        return true;
    }

    // 从标准输入读取字符串，将它们排序并输出
    public static void main(String[] args) {
        String[] a = In.readStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }

}
