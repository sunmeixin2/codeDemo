package code.LinkListTest;

/**
 * @author sunmeixin
 * @description 两个链表的第一个公共节点
 * @date 2020-12-12
 */
public class FindFirstCommonNode {


    /**
     * 思路1：先计算长度，若不相等，则长的先走len1-len2 步，从长度相等出遍历判断
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode_Solution(ListNode pHead1,ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        int len1 = 0,len2 = 0;
        ListNode p1 = pHead1,p2 = pHead2;
        while (p1!= null) {
            p1 = p1.next;
            len1++;
        }
        while (p2!= null) {
            p2 = p2.next;
            len2++;
        }

        if ( len1 > len2) {
            while (len2 != len1) {
                pHead1 = pHead1.next;
                len1--;
            }
        }else if (len2 > len1) {
            while (len1 != len2) {
                pHead2 = pHead2.next;
                len2--;
            }
        }
        while (pHead1 != pHead2) {
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return pHead1;
    }

    /**
     * 思路2：pHead1 长度为 a ,  pHead2长度为 b, a+b == b+a，
     * 即当达链表 headA 的末尾时，重新定位到链表headB的头结点；当到达链表headB的末尾时，重新定位到链表 headA 的头结点
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode_Solution2(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1,p2 = pHead2;
        while (p1 != p2) {
            // 判断条件不能是p1.next 和 p2.next,否则再两个链表无公共节点时无法跳出循环
            p1 = (p1== null ? pHead2:p1.next);
            p2 = (p2 == null ? pHead1:p2.next);
        }
        return pHead1;
    }

    public static void main(String[] args) {
        FindFirstCommonNode findFirstCommonNode = new FindFirstCommonNode();
        ListNode l1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(5);
        ListNode n4 = new ListNode(7);
        l1.next = n2;
        n2.next = n3;
        n3.next =n4;


        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);


        l2.next = l3;
        l3.next = n2;
        findFirstCommonNode.FindFirstCommonNode_Solution2(l1,l2);
    }
}
