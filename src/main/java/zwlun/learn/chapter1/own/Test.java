package zwlun.learn.chapter1.own;

public class Test {
    public static void main(String[] args) {
        String[] s = new String[3];
        String[] c = new String[] {"a", "b"};
        s = c;
        for (String cha : s) {
            System.out.println(cha);
        }
    }
}
