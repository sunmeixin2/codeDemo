package code.LinkListTest;

/**
 * @author sunmeixin
 * @description 环形链表
 * @date 2021-02-08
 */
public class CycleLinkList {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode fast = head,slow = head;
        fast = fast.next.next;
        slow = slow.next;

        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode fast = head.next,slow = head;
        while (fast != null && fast.next != null) {
            if (fast == slow ) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
