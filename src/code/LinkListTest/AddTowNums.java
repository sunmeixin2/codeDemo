package code.LinkListTest;

/**
 * @author sunmeixin
 * @description 两数相加
 * @date 2020-01-31 21:19
 */
public class AddTowNums {

    public ListNode addTwoNumbers(ListNode n1, ListNode n2) {
        ListNode pre = new ListNode(0);
        ListNode head = pre;
        int carry = 0, sum = 0;
        int x, y;
        while (n1 != null || n2 != null) {
            ListNode curr = new ListNode(0);
            x = (n1 != null) ? n1.val : 0;
            y = (n2 != null) ? n2.val : 0;
            sum = (x + y + carry) % 10;
            carry = (x + y + carry) / 10;
            curr.val = sum;
            pre.next = curr;
            pre = curr;
            if (n1 != null) {
                n1 = n1.next;
            }
            if (n2 != null) {
                n2 = n2.next;
            }
        }
        if (carry > 0) {
            pre.next = new ListNode(carry);
        }

        return head.next;
    }

    public static void main(String[] args) {
        AddTowNums addTowNums = new AddTowNums();
        ListNode l1 = new ListNode(2);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);

        l1.next = n2;
        n2.next = n3;

        ListNode l2 = new ListNode(5);
        ListNode n4 = new ListNode(6);
        ListNode n5 = new ListNode(4);

        l2.next = n4;
        n4.next = n5;
        ListNode ln = addTowNums.addTwoNumbers(l1, l2);

        while (ln != null) {
            System.out.println(ln.val);
            ln = ln.next;
        }
    }
}

