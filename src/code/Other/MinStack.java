package code.Other;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author sunmeixin
 * @description 最小栈
 * @date 2021-02-07
 */
public class MinStack {
//    LinkedList<Integer> stack;
//    LinkedList<Integer> minStatck;
//    public MinStack() {
//        stack = new LinkedList<>();
//        minStatck = new LinkedList<>();
//        minStatck.push(Integer.MAX_VALUE);
//    }
//
//    public void push(int x) {
//        stack.push(x);
//        minStatck.push(Math.min(minStatck.peek(),x));
//    }
//
//    public void pop() {
//        stack.pop();
//        minStatck.pop();
//    }
//
//    public int top() {
//        return stack.peek();
//    }
//
//    public int getMin() {
//        return minStatck.peek();
//    }


    Stack<Integer> stack ;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        stack.push(x);
        minStack.push(Math.min(minStack.peek(),x));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
