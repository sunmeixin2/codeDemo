package code.Tree;

/**
 * @author sunmeixin
 * @description 二叉搜索数的第K大节点
 * @date 2021-02-28
 */
public class kthLargestOfSearchTree {

    int res, k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if(root == null) {
            return;
        }

        dfs(root.right);
        if (--k == 0) {
            res = root.val;
        }
        dfs(root.left);
    }
}

/**
 * 题目描述：给定一棵二叉搜索树，请找出其中第k大的节点。
 *
 * 思路：二叉搜索树的中序遍历为 递增序列
 *      二叉搜索树的 中序遍历倒序 为 递减序列
 *      因此，求 “二叉搜索树第 kk 大的节点” 可转化为求 “此树的中序遍历倒序的第 kk 个节点”。
 *
 *
 */
