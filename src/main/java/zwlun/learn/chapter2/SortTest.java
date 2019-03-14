package zwlun.learn.chapter2;

public class SortTest {
    public static void main(String[] args) {
        int[] a = {2, 1, 8, 4, 3, 9, 7, 6, 5};
        QuickSort.sort(a);
        for (int val : a) {
            System.out.println(val);
        }
    }
}
