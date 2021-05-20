package code.LinkListTest;

/**
 * @author sunmeixin
 * @description
 * @date 2020-12-06
 */
public class MergeTwoOrderlyLinkList {

    public ListNode merge(ListNode list1,ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (list1 != null && list2 != null ) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        if (list1 != null) {
            cur.next = list1;
        }
        if (list2 != null) {
            cur.next = list2;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l3 = new ListNode(3);
        ListNode l5 = new ListNode(5);
        ListNode l7 = new ListNode(7);
        l1.next = l3;
        l3.next = l5;
        l5.next = l7;

        ListNode l2 = new ListNode(2);
        ListNode l4 = new ListNode(4);
        ListNode l6 = new ListNode(6);
        ListNode l8 = new ListNode(8);
        l2.next = l4;
        l4.next = l6;
        l6.next = l8;

        ListNode head = orderList(l1,l2);
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }

    public  static ListNode orderList(ListNode l1, ListNode l2){
        if(l1 == null) {
            return l2;
        }

        if(l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while (l1 != null || l2 != null) {

            ListNode node = new ListNode(0);
            curr.next = node;
            if (l1 == null) {
                node.val = l2.val;
                l2 = l2.next;
            } else if (l2 == null) {
                node.val = l1.val;
                l1 = l1.next;
            } else {
                if (l1.val > l2.val) {
                    node.val = l2.val;
                    l2 = l2.next;
                } else {
                    node.val = l1.val;
                    l1 = l1.next;
                }
            }
            curr = node;
        }
        return head.next;
    }
}

/**
 * 题目描述：合并两个有序链表：输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
