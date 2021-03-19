package code.Other;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author sunmeixin
 * @description
 * @date 2021-01-29
 */
public class youxiaodekuohao {

    public static boolean isVaild(String s) {

        if (s == null || s.length() == 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        int i=0;
        char ch = s.charAt(i);
        stack.push(ch);
        while (s.length() > ++i) {
            ch = s.charAt(i);
            if (stack.empty()) {
                stack.push(ch);
            } else {
                if ((stack.peek() == '(' && ch == ')')
                        || (stack.peek() == '[' && ch == ']')
                        || stack.peek() == '{' && ch == '}')  {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }


        }
        if (stack.empty()) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isVaild(s));
    }
}
