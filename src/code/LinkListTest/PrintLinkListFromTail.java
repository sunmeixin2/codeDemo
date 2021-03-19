package code.LinkListTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author sunmeixin
 * @description  从尾到头打印链表
 * @date 2020-11-05
 */
public class PrintLinkListFromTail {

    public static int[] reversePrint(ListNode head) {

        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int size = stack.size();
        int[] res = new int[size];
        for (int i=0; i<size; i++){
            res[i] = stack.pop();
        }
        return res;
    }
    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l.next=l2;
        l2.next=l3;
        reversePrint(l);
    }
}
