package code.Tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author sunmeixin
 * @description 验证二叉搜索数
 * @date 2021-05-11
 */
public class IsBinarySearcheTree {

    // 递归
    double pre = Double.MIN_EXPONENT;
    public boolean isValidBST(TreeNode root) {
        return inOrder(root);
    }

    public boolean inOrder(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = inOrder(root.left);
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        boolean right = inOrder(root.right);
        return left && right;
    }


    //  采用栈实现
    public boolean isValidBST2(TreeNode root) {
        double pre = Double.MIN_VALUE;
        Deque<TreeNode> statck = new LinkedList<>();

        while (!statck.isEmpty() || root != null) {
            while (root != null) {
                statck.push(root);
                root = root.left;
            }
            root = statck.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= pre) {
                return false;
            }
            pre = root.val;
            root = root.right;
        }
        return true;
    }


}

/**
 * 题目描述：
 *  给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *      假设一个二叉搜索树具有如下特征：
 *          节点的左子树只包含小于当前节点的数。
 *          节点的右子树只包含大于当前节点的数。
 *          所有左子树和右子树自身必须也是二叉搜索树。
 *
 *
 *   思路：采用中序遍历
 */
