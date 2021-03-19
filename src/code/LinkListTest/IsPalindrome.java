package code.LinkListTest;

/**
 * @author sunmeixin
 * @description 回文链表
 * @date 2021-02-06
 */
public class IsPalindrome {

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode fast = head, slow = head;
        // 快慢指正，使slow位于链表中点
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // 反转后半部分链表
        slow = ReverseList.reverseListNode(slow.next);
        // 判断是否是回文
        fast = head;
        while (slow != null ) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;

        }
        return true;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
//        l3.next = l4;
        System.out.println(isPalindrome(l1));
    }
}
