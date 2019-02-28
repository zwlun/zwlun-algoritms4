package zwlun.learn.chapter1.stack;

import java.util.ArrayList;

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
        if (N == s.length) {
            resizeTheArray(2 * s.length);
        }
        s[N++] = item;
    }

    public void resizeTheArray(int size) {
        String[] copy = new String[size];
        for (int i = 0; i < N; i++) {
            copy[i] = s[i];
        }
        s = copy;
    }

    public String pop() {
        String item = s[--N];
        s[N] = null; // 避免对象游离
        if (N > 0 && N == s.length / 4) {
            resizeTheArray(s.length / 2);
        }
        return item;
    }
}
