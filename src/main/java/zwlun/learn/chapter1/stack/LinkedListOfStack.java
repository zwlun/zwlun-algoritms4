package zwlun.learn.chapter1.stack;

import edu.princeton.cs.algs4.StdOut;

/**
 * 一切都是从first来推的
 */
public class LinkedListOfStack {
    private Node first = null;

    private class Node {
        String item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public String pop() {
        String item = first.item;
        first = first.next;
        return item;
    }

    public void push(String item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

}
