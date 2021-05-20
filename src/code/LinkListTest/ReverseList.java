package code.LinkListTest;

/**
 * @author sunmeixin
 * @description 链表反转
 */
public class ReverseList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;

        // 反转链表
        ListNode listNode = reverseListNode(l1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode reverseListNode(ListNode head){
        if (head == null) {
            return null;
        }
        ListNode pre = null;  // 当前节点的前一个节点
        ListNode p = null;      // 当前节点的下一个节点

        while (head != null) {
            p = head.next;
            head.next = pre;
            pre = head;
            head = p;
        }
        return pre;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode pre,curr,q;
        curr = head;
        pre = null;
        while (curr != null) {
            q = curr.next;
            curr.next = pre;
            pre = curr;
            curr = q;
        }
        return pre;
    }
}

/**
 * 题目描述：输入一个链表，反转链表后，输出新链表的表头
 */


