package zwlun.learn.chapter1.own;

import java.util.Scanner;
import java.util.Stack;

/*
 * 在控制台输入 （ 1 + （ 1 * 2 ） ) end 才有效， 就是说中间的空格不能省
 */
public class Evaluate {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();

        Scanner sc= new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.next();
            if (s.equals("(")) {}
            else if (s.equals("+")) {
                ops.push(s);
            } else if (s.equals("-")) {
                ops.push(s);
            } else if (s.equals("*")) {
                ops.push(s);
            } else if (s.equals("/")) {
                ops.push(s);
            } else if (s.equals("sqrt")) {
                ops.push(s);
            } else if (s.equals(")")) {
                String op = ops.pop();
                double v = vals.pop();
                if (op.equals("+")) {
                    v = vals.pop() + v;
                } else if (op.equals("-")) {
                   v = vals.pop() - v;
                } else if (op.equals("*")) {
                    v = vals.pop() * v;
                } else if (op.equals("/")) {
                    v = vals.pop() / v;
                } else if (op.equals("sqrt")) {
                    v = Math.sqrt(vals.pop());
                }
                vals.push(v);
            }else if (s.equals("end")){
               break;
            }  else {
                vals.push(Double.parseDouble(s));
            }
        }
        System.out.println(vals.pop());
    }

}
