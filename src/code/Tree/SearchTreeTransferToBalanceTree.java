package code.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunmeixin
 * @description 将二叉搜索树变为平衡二叉树
 * @date 2021-05-19
 */
public class SearchTreeTransferToBalanceTree {


    public TreeNode balanceBST(TreeNode root) {
        List<Integer> sortList = new ArrayList<>();
        inOrder(root,sortList);
        return bulid(sortList,0,sortList.size()-1);
    }

    public void inOrder(TreeNode root,List<Integer> sortList) {
        if (root != null) {
            inOrder(root.left,sortList);
            sortList.add(root.val);
            inOrder(root.right,sortList);
        }
    }

    public TreeNode bulid(List<Integer> sortList,int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = (l + r)/2;
        TreeNode root = new TreeNode(sortList.get(mid));
        root.left = bulid(sortList,l,mid-1);
        root.right = bulid(sortList,mid + 1, r);

        return root;
    }
}
/**
 * 题目描述：
 *  给你一棵二叉搜索树，请你返回一棵 平衡后 的二叉搜索树，新生成的树应该与原来的树有着相同的节点值。
 *
 * 如果一棵二叉搜索树中，每个节点的两棵子树高度差不超过 1 ，我们就称这棵二叉搜索树是 平衡的 。
 *
 * 思路分析： 先把二叉搜索树中序遍历为一个有序序列，然后再根据二分查找法
 */
