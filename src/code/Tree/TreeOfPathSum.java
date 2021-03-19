package code.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sunmeixin
 * @description 二叉树中和为某一值的路径
 * @date 2021-03-07
 */
public class TreeOfPathSum {

    LinkedList<List<Integer>> list  = new LinkedList<>();
    LinkedList<Integer> temp = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root,sum);
        return list;
    }

    public void dfs(TreeNode root,int target) {
        if (root == null) {
            return;
        }

        target -= root.val;
        temp.add(root.val);
        if (target == 0 && root.left == null && root.right == null ){
            list.add(new LinkedList<>(temp));
        }
        dfs(root.left,target);
        dfs(root.right,target);
        temp.removeLast();
    }
}

/**
 * 题目描述：输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * 思路分析：
 *      先序遍历： 按照 “根、左、右” 的顺序，遍历树的所有节点。
 *      路径记录： 在先序遍历中，记录从根节点到当前节点的路径。当路径为 ① 根节点到叶节点形成的路径 且 ② 各节点值的和等于目标值 sum 时，将此路径加入结果列表。
 *      路径恢复： 向上回溯前，需要将当前节点从路径  中删除，即执行移除操作。
 *
 *
 */
