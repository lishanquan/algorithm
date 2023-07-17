package sort;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[] {2, 6, 3, 8, 1, 5, 9, 7};
        print(arr);
        mergeSort(arr);
        System.out.println("排序后数组：");
        print(arr);
    }

    private static void mergeSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int left, int right) {

        if (left >= right) return;

        //中间索引
        int middle = (left + right) / 2;

        //对左边索引进行递归
        sort(arr, left, middle);

        //对右边索引进行递归
        sort(arr, middle + 1, right);

        //合并
        merge(arr, left, middle, right);

        print(arr);
    }

    private static void merge(int[] arr, int left, int middle, int right) {
        int[] temp = new int[] {arr.length};
        int i = left, j = middle + 1, k = left;
        while (i <= middle && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        //剩余部分放入临时数组
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        while (i <= middle) {
            temp[k++] = arr[i++];
        }

        //将临时数组复制回原数组
        int l = left;
        while (l <= right) {
            arr[l] = temp[l++];
        }
    }

    public static void print(int[] data) {
        for (int i : data) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }

}
