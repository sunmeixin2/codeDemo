package code.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sunmeixin
 * @description 二叉树的深度
 * @date 2020-11-29
 */
public class TreeDepth {

    /**
     * 非递归 ： 队列 + 记录每层的节点数
     * @param root
     * @return
     */
    public int getDepth(TreeNode root){

        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        // 当前层级的节点个数
        int count = 0;
        int depth = 0;
        q.add(root);
        while (q.size() != 0) {
            count = q.size();
            depth++;
            while (count-- != 0) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }

        }
        return depth;
    }


    /**
     * 递归
     * @param root
     * @return
     */
    public int getDepth1(TreeNode root){

        if (root == null) {
            return 0;
        }

        int left_depth = getDepth1(root.left);
        int right_depth = getDepth1(root.right);
        return Math.max(left_depth,right_depth) + 1;
    }

}

/**
 * 题目描述：输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * 讨论：每一层，需使用一个变量count记录该层的结点个数，也就是队列的当前长度，然后依次在队列中访问该层的count个结点（将队列中count个元素出队列），并将下一层如队列。
 */
