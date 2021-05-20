package code.LinkListTest;

/**
 * @author sunmeixin
 * @description 部分链表反转2
 * @date 2021-05-13
 */
public class ReverseLinkList2 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        //设置头节点方便统一操作
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        //找到起点
        for (int i = 0; i < left -1; i++) {
            pre = pre.next;
        }
        ListNode curr = pre.next;
        ListNode next ;
        //头插法，pre是固定的头插位置
        for (int i = 0; i < right - left; i++) {
            next = curr.next;
            curr.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }
}
/**
 * 题目描述：
 *  给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
 *      请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 *   思路：一次遍历「穿针引线」反转链表（头插法）
 */
