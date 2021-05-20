package code.LinkListTest;

/**
 * @author sunmeixin
 * @description 删除链表的倒数第 N 个结点
 * @date 2021-05-14
 */
public class RemoveNthFromEndLinkList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //设置头节点方便统一操作
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode first = head;
        // 使second指向dummy (相当于要删除节点的pre)
        ListNode second = dummy;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
/**
 * 题目描述：给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。进阶：你能尝试使用一趟扫描实现吗？
 *
 *  思路：双指针
 *
 */
