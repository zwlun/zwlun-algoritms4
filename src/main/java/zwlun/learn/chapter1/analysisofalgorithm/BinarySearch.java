package zwlun.learn.chapter1.analysisofalgorithm;

public class BinarySearch {
    public static int binarySearch(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;
        while(low < high) {
            int middle = (low + high) / 2;
            if (a[middle] > key) {
                high = middle -1;
            } else if (a[middle] < key){
                low = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public static boolean binarySearchWithIndex(int[] a, int lo, int hi, int key, boolean increase) {
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2 ;
            if (increase) {
                if(key < a[mid]) {
                    hi = mid - 1;
                } else if (key > a[mid]) {
                    lo = mid + 1;
                } else {
                    return true;
                }
            } else {
                if(key > a[mid]) {
                    hi = mid - 1;
                } else if (key < a[mid]) {
                    lo = mid + 1;
                } else {
                    return true;
                }
            }

        }
        return false;
    }

}
