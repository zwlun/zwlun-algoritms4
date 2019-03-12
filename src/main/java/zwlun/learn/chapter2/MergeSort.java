package zwlun.learn.chapter2;

public class MergeSort {

    private static int[] aux;

    public static void sort(int[] a) {
        int n = a.length;
        aux = new int[n];
        // sortFromBottom(a);
        sortFromTop(a, 0, n-1);
    }

    // 采用循环的方式，自底向上
    public static void sortFromBottom(int[] a) {
        int n = a.length;
        for (int sz = 1; sz < n; sz += sz) { // sz代表比较比较的个数:1、2、4、8...、[n/2,n)
            for (int i = 0; i < n - sz; i += sz + sz) {
                merge(a, i, i + sz - 1, Math.min(i + sz - 1 + sz, n - 1));
            }
        }
    }

    // 采用递归的方式，自顶向下
    public static void sortFromTop(int[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sortFromTop(a, lo, mid);
        sortFromTop(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    public static void merge(int[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        // 将数组a复制到数组aux中，然后再对a排序
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (aux[i] < aux[j]) {
                a[k] = aux[i++];
            } else {
                a[k] = aux[j++];
            }
        }
    }
}
