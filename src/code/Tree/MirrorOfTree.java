package code.Tree;

import java.util.Stack;

/**
 * @author sunmeixin
 * @description 二叉树的镜像
 * @date 2021-03-01
 */
public class MirrorOfTree {

    public TreeNode mirrorTree(TreeNode root) {

        if (root == null) {
            return null;
        }
        TreeNode tmpNode = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmpNode);
        return root;
    }

    public TreeNode mirrorTree2(TreeNode root) {

        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (node.left != null){
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
    }


}
