package zwlun.learn.chapter2;

public class QuickSort {
    public static void sort(int[] a) {
        quickSort(a, 0, a.length-1);
    }

    public static void quickSort(int[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        // 先分拆，再递归 （和归并排序不同，归并排序是先排序，再merge）
        int j = partition(a, lo, hi);
        quickSort(a, lo, j - 1);
        quickSort(a, j + 1, hi);
    }

    /*
     * 两个指针，一头一尾，向中间移动，找到第一个元素合适的位置，是左边的元素都小于第一个元素，右边的元素都大于第一个元素
     */
    public static int partition(int[] a, int lo, int hi) {
        int i =lo;
        int j = hi + 1;
        while (true) {
            while (a[lo] > a[++i]) {
                if (i >= hi) {
                    break;
                }
            }
            while (a[lo] < a[--j]) {
                if (j <= lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, lo, j); // 找到位置后，将该位置和第一个元素交换
        return j;
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
