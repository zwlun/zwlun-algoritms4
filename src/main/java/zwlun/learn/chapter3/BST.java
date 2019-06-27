package zwlun.learn.chapter3;

public class BST {
    private Node root;

    private class Node {
        private int key;
        private int val;
        private Node left, right;
        private int N;

        public Node (int key, int val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    public int size() {
        return size(root);
    }

    public int size(Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.N;
        }
    }

    public Integer get(int key) {
        return get(root, key);
    }

    public Integer get(Node x, int key) {
        if (x == null) {
            return null;
        }
        if (key < x.key) {
            return get(x.left, key);
        } else if (key > x.key) {
            return get(x.right, key);
        } else {
            return x.val;
        }
    }


    public void put(int key, int val) {
        root = put(root, key, val);
    }

    private Node put(Node x, int key, int val) {
        if (x == null) {
            return new Node(key, val, 1);
        }
        if (x.key > key) {
            x.right = put(x.right, key, val);
        } else if (x.key < key) {
            x.left = put(x.left, key, val);
        } else {
            x.val = val;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public int min() {
        return min(root).key;
    }

    public Node min(Node x) {
        if (x.left == null) {
            return x;
        }
        return min(x.left);
    }

    public int max() {
        return max(root).key;
    }

    public Node max(Node x) {
        if (x.right == null) {
            return x;
        }
        return max(x.right);
    }
}
