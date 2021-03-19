package code.Tree;

/**
 * @author sunmeixin
 * @description 判断是否是对称的二叉树
 * @date 2021-03-11
 */
public class IsMirrorOfTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return recur(root.left,root.right);
    }

    public boolean recur (TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val){
            return false;
        }
        return recur(left.left,right.right) && recur(left.right,right.left);
    }
}

/**
 * 思路分析：可以想象把树劈成两半去比较
 *
 */
