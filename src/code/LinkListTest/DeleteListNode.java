package code.LinkListTest;

/**
 * @author sunmeixin
 * @description 删除链表节点
 * @date 2021-03-03
 */
public class DeleteListNode {

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        }
        ListNode curr ,pre;
        pre = head;
        curr = head.next;
        while (curr != null) {
            if (curr.val == val) {
                pre.next = curr.next;
                break;
            }
            pre = curr;
            curr = curr.next;
        }
        return head;
    }
}
