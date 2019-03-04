package zwlun.learn.chapter2;

import edu.princeton.cs.algs4.Selection;

public class SortTest {
    public static void main(String[] args) {
        int[] a = {2, 1, 8, 4, 3, 9, 7, 6, 5};
        InsertionSort.sort(a);
        for (int val : a) {
            System.out.println(val);
        }
    }
}
