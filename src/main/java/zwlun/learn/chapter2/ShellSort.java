package zwlun.learn.chapter2;

public class ShellSort {
    public static void sort(int[] a) {
        int N = a.length;
        int step = 1;
        // 采用 3*step+1 的步长
        while (step <  N / 3) {
            step = 3 * step + 1;
        }

        //
        while (step >= 1) {
            for (int i = step; i < N; i++) {
                for (int j = i - step; j >= 0; j-=step) {
                    if (a[j+step] < a[j]) {
                        int temp = a[j];
                        a[j] = a[j+step];
                        a[j+step] = temp;
                    }
                }
            }
            step = step / 3;
        }
    }
}
