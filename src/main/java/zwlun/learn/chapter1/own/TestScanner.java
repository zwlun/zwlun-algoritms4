package zwlun.learn.chapter1.own;

import java.io.*;
import java.util.Scanner;

public class TestScanner {
    public static void main(String[] args) throws Exception{
        // Scanner sc = new Scanner(new BufferedReader(new FileReader("D:\\Here\\Desk\\test.txt")));
        Scanner sc = new Scanner(System.in);
        int i = 0;
        while(sc.hasNextLine() && !sc.nextLine().equals("end")) {
            i++;
            System.out.println("一共输入了： " + i + "行");
        }
        System.out.println("out");

    }
}
