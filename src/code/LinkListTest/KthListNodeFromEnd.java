package code.LinkListTest;

/**
 * @author sunmeixin
 * @description 链表中倒数第K个节点
 * @date 2021-03-26
 */
public class KthListNodeFromEnd {

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode pre = head,post = head;

        while (pre != null) {
            if (k-- > 0) {
                pre = pre.next;
            } else {
                pre = pre.next;
                post = post.next;
            }
        }
        return post;
    }
}

/**
 * 题目描述：输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *          例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 *
 *  题解：双指针
 *       前指针 pre 先向前走 k 步，post再开始，知道pre走过链表 尾节点 时跳出
 */
