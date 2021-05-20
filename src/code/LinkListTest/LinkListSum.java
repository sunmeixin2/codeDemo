package code.LinkListTest;

/**
 * @author sunmeixin
 * @description  链表求和
 * @date 2021-05-13
 */
public class LinkListSum {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }

        int carray = 0;
        ListNode head = l1;
        while (l1 != null && l2 != null) {
            l1.val =  (l1.val + l2.val)%10 + carray;
            carray = (l1.val + l2.val)/10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            l1.val += carray;
            carray = l1.val / 10;
            if (carray == 0) {
               break;
            }
            l1 = l1.next;

        }

        while (l2 != null) {
            l2.val += carray;
            carray = l2.val / 10;
            if (carray == 0) {
                break;
            }
            l1.next = l2;
            l1 = l1.next;
        }
        if (carray == 1) {
            l1.next = new ListNode(carray);
        }

        return head;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode curr =head;
        int carray = 0;
        while (l1 != null || l2 != null || carray != 0) {
            int sum = ((l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carray );
            carray = sum/10;
            curr.next = new ListNode(sum % 10);
            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;
            curr = curr.next;

        }
        return head.next;
    }
}

/**
 * 题目描述：给定两个用链表表示的整数，每个节点包含一个数位。
 *          这些数位是反向存放的，也就是个位排在链表首部。
 *           编写函数对这两个整数求和，并用链表形式返回结果。
 */