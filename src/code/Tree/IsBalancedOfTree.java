package code.Tree;

/**
 * @author sunmeixin
 * @description 判断是否是平衡二叉树
 * @date 2021-03-12
 */
public class IsBalancedOfTree {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        // isBalanced(root.left) && isBalanced(root.right) 是分析任意节点的左右子树
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = depth(root.left);
        int rh = depth(root.right);
        return Math.max(lh,rh)+1;
    }
}

/**
 * 题目描述：输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 *
 * 思路分析：先计算出左子树的深度，在计算出右子树的深度，最后递归分析每个节点的左右子树的深度都要符合要求
 */
