package zwlun.learn.chapter1.stack;

public class ArrayOfStackOfString {

    private String[] s;
    private int N;

    public ArrayOfStackOfString(int capacity) {
        s = new String[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(String item) {
        s[N++] = item;
    }

    public String pop() {
        String item = s[--N];
        s[N] = null; // 避免对象游离
        return item;
    }
}
