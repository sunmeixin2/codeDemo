package code.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunmeixin
 * @description 二叉搜索数与双向循环链表
 * @date 2021-03-06
 */
public class TreeToDoublyList {

    /**
     * 方法1  中序遍历+数组
     * @param root
     * @return
     */
    public TreeNode treeToDoublyList(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        Convert(root,list);

        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).right = list.get(i+1);
            list.get(i+1).left = list.get(i);
        }
        list.get(0).left = list.get(list.size()-1);
        list.get(list.size()-1).right = list.get(0);
        return list.get(0);
    }

    public void Convert(TreeNode root,List<TreeNode> list) {
        if (root == null) {
            return;
        }
        Convert(root.left,list);
        list.add(root);
        Convert(root.right,list);
    }

    /**
     * 方法2  中序遍历 + 双指针（pre + curr）
     * @param root
     * @return
     */

    TreeNode head ,pre;
    public TreeNode treeToDoublyList2(TreeNode root) {
        if (root == null) {
            return null;
        }
        Convert2(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    public void Convert2(TreeNode root) {
        if (root == null) {
            return;
        }
        Convert2(root.left);
        if (pre != null) {
            pre.right = root;
        } else {
            head = root;
        }
        root.left = pre;
        pre = root;
        Convert2(root.right);
    }
}

/**
 * 题目描述：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 *  思路分析：
 *      排序链表： 节点应从小到大排序，因此应使用 中序遍历 “从小到大”访问树的节点。
 *      双向链表： 在构建相邻节点的引用关系时，设前驱节点 pre 和当前节点 cur ，不仅应构建 pre.right = cur ，也应构建 cur.left = pre 。
 *      循环链表： 设链表头节点 head 和尾节点 tail ，则应构建 head.left = tail 和 tail.right = head 。
 */
