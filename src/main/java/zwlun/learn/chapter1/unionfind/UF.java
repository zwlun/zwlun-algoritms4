package zwlun.learn.chapter1.unionfind;

import edu.princeton.cs.algs4.StdOut;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class UF {
    private int[] parent;
    //private int[] size; // 一个连通域里元素的个数
    private byte[] height;// 一个连通域组成的树的高度
    private int count; // 连通域的个数

    public UF(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        count = n;
        parent = new int[n];
        // size = new int[n];
        height = new byte[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            // size[i] = 1;
            height[i] = 1;
        }
    }


    /**
     * 检查输入的p是否合法
     */
    private void validate(int p) {
        int n = parent.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n - 1));
        }
    }

    /**
     * 带压缩路径的求根
     */
    public int root(int p) {
        validate(p);
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];  //在将某个元素比较之后，将这个元素向数的根部上移两个（即移到它的祖父节点）
        }
//        //解法2
//        int root = p;
//        while (root != parent[root]) { //先将根节点求出来，并存放到root中
//            root = parent[root];
//        }
//        while (p != root) { //一个个网上找，每找完一个元素后，都将该元素移到根节点下面
//            int newp = parent[p];
//            parent[p] = root;
//            p = newp;
//        }

        return p;
    }

    /*
     * root方法的递归形式
     */
    public int root1 (int p) {
        if (p != parent[p]) {
            parent[p] = root1(parent[p]);
        }
        return parent[p];
    }

    public int count() {
        return count;
    }

    /**
     * 如果两个元素的根节点相同，就认为两个元素是相连的
     */
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    /**
     * 带权重的union算法，这可以减少root()时的搜索次数
     */
    public void union(int p, int q) {
        int rootP = root(p);
        int rootQ = root(q);
        if (rootP == rootQ) { //两个元素的根相同代表这两个元素已经是相连的了，直接return
            return;
        }
//        if (size[rootP] > size[rootQ]) { //p所在的树比q所在的树大，将q的根节点指向p的根节点即可
//            parent[rootQ] = rootP;
//            size[rootP] += size[rootQ];
//        } else {
//            parent[rootP] = rootQ;
//            size[rootQ] += size[rootP];
//        }

        if (height[rootP] > height[rootQ]) parent[rootQ] = rootP;
        else if (height[rootP] < height[rootQ]) parent[rootP] = rootQ;
        else {
            parent[rootP] = rootQ;
            height[rootQ]++;
        }

        count--; //一次union后，连通区域数量会减1
    }

    public static void main(String[] args) throws Exception {
        // Scanner sc = new Scanner(new FileInputStream(new File("D://Here//Desk//tinyint.txt")));
        Scanner sc = new Scanner(new BufferedReader(new FileReader("E:/MyCode/idea/test_file/union_find/mediumUF.txt")));
        int n = sc.nextInt();
        UF uf = new UF(n);
        while (sc.hasNextLine()) {
            int p = sc.nextInt();
            int q = sc.nextInt();
            if (uf.connected(p, q)) {
                continue;
            }
            uf.union(p, q);
            StdOut.println(p + "'s root: " + uf.root(p) + " -- " + q + "'s root: " + uf.root(q));
            StdOut.println(p + " " + q + " -- " + uf.count());
        }
        StdOut.print(uf.count() + " components");
    }
}
