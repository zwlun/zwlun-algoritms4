package zwlun.learn.chapter1.analysisofalgorithm;

import java.util.Random;

/**
 * for 1.4.20双调查找
 */
public class BitonicMax {

    /*
     * 生成双调数组
     */
    public static int[] bitonic(int N) {
        int[] a = new int[N];
        Random r = new Random();
        int mid = r.nextInt(N - 1) + 1;
        a[0] = r.nextInt(10);
        for (int i = 1; i <= mid; i++) {
            a[i] = a[i - 1] + 1 + r.nextInt(9);
        }
        for (int i = mid + 1; i < N; i++) {
            a[i] = a[i - 1] - 1 - r.nextInt(9);
        }
        for (int i = 0; i < N; i++) {
            System.out.print(a[i] + ", ");
        }
        return a;
    }

    /**
     * @return 双调数组最大值的下标
     */
    private static int indexOfMax(int[] a, int lo, int hi) {
        if (lo == hi) return hi;
        int mid = lo + (hi - lo) / 2;
        if (a[mid] < a[mid + 1]) return indexOfMax(a, mid + 1, hi);
        if (a[mid] > a[mid + 1]) return indexOfMax(a, lo, mid);
        else return mid;
    }

    public static void main(String[] args) {
//        int[] a = new int[10];
//        for (int i = 0; i < 10; i++) {
//            System.out.println(a[i]);
//        }
        int[] a = bitonic(20);
        int iom = indexOfMax(a, 0, 19);
        System.out.println("the key is 10: " + (BinarySearch.binarySearchWithIndex(a, 0, iom, 10, true) ||
                BinarySearch.binarySearchWithIndex(a, iom + 1, 19, 10, false)));
    }
}
