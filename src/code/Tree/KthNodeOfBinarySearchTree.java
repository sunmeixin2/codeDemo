package code.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author sunmeixin
 * @description
 * @date 2020-11-29
 */
public class KthNodeOfBinarySearchTree {

    /**
     * 递归实现
     * @param root
     * @param k
     * @return
     */
    public TreeNode KthNode(TreeNode root, int k){

        if (root == null || k < 1) {
            return null;
        }
        List<TreeNode> listNode = new ArrayList<>();
        getKthNode(root, listNode);
        if (k > listNode.size()) {
            return null;
        }

        return listNode.get(k-1);

    }
    public void getKthNode(TreeNode node, List<TreeNode> listNode) {
        if (node != null) {
            getKthNode(node.left,listNode);
            listNode.add(node);
            getKthNode(node.right,listNode);
        }
    }

    public TreeNode getKthNode1(TreeNode root, int k) {
        if (root == null || k < 1) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        TreeNode node = root;
        while (node != null || !stack.empty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            count++;
            if (count == k) {
                return node;
            }
            node = node.right;
        }


        return null;
    }


}

/**
 * 题目描述：给定一棵二叉搜索树，请找出其中的第k小的结点。输入 {5,3,7,2,4,6,8}  ,  3   返回：{4}
 * 讨论：递归：1.二叉搜索数的 中序遍历  是递增有序的
 *      非递归：2.非递归版中序遍历，左节点不断入栈直到为空，弹出栈顶，令其右孩子入栈，重复以上操作，直到遍历结束或者访问第k个节点为止。
 *
 */


