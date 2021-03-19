package code.LinkListTest;

/**
 * @author sunmeixin
 * @description 相交链表
 * @date 2021-02-08
 */
public class IntersectList {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA, pB;
        pA = headA;
        pB = headB;

        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}

/**
 * 题目描述：找到两个单链表相交的起始节点。
 * 题解：双指针法：
 *      创建两个指针 pA 和 pB，分别初始化为链表 A 和 B 的头结点。然后让它们向后逐结点遍历。
 *      当 pA 到达链表的尾部时，将它重定位到链表 B 的头结点 (你没看错，就是链表 B); 类似的，当 pBpB 到达链表的尾部时，将它重定位到链表 A 的头结点。
 */
