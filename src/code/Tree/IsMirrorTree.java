package code.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sunmeixin
 * @description 对称二叉树
 * @date 2021-01-30
 */
public class IsMirrorTree {

    public boolean solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        return checkIsMirror(root.left,root.right);
    }

    public boolean checkIsMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }

        return checkIsMirror(left.left, right.right) && checkIsMirror(left.right, right.left);
    }

    public boolean solution2 (TreeNode root){
        if (root == null) {
            return true;
        }

        TreeNode left, right;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);

        while (!queue.isEmpty()) {
            left = queue.poll();
            right = queue.poll();
            if (left == null && right == null) {
                continue;
            }

            if (left == null || right == null) {
                return false;
            }

            if (left.val != right.val) {
                return false;
            }

            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }

        return true;
    }
}
