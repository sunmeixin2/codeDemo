package code.Tree;

/**
 * @author sunmeixin
 * @description 翻转二叉树
 * @date 2021-02-08
 */
public class FanzhuanTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right  = left;
        return root;
    }
}
