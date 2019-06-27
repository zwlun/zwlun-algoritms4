package zwlun.learn.chapter3;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String test = in.next();
        System.out.println("name");
        String name = in.nextLine();
        System.out.println("age");
        int age = in.nextInt();
        System.out.println("n:" + name + "\nA:" + age);
    }
}
