package zwlun.learn.chapter1.unionfind;

/**
 * 压缩路径的带权快速合并算法
 */
public class UnionFind_QuickUnion {
    private int[] id;
    private int[] sz;

    public UnionFind_QuickUnion(int N) {
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
        for (int i = 0; i < N; i++) {
            sz[i] = 1;
        }

    }

    private int root(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];//压缩路径，搜索时把节点向上移动
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (i != j) {
            // 带权
            if (sz[i] > sz[j]) {
                id[j] = i;
                sz[i] += sz[j];
            } else {
                id[i] = j;
                sz[j] += sz[i];
            }
        }

    }
}
