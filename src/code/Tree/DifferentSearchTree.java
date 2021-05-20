package code.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunmeixin
 * @description 不同的二叉搜索树 2
 * @date 2021-05-10
 */
public class DifferentSearchTree {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return null;
        }
        return generateTree(1,n);
    }

    public List<TreeNode> generateTree(int start, int end) {
        List<TreeNode> allNodes = new ArrayList<>();
        // 出口为当 start>end 的时候，当前二叉搜索树为空，返回空节点即可。
        if (start > end) {
            allNodes.add(null);
            return allNodes;
        }
        for (int i = start; i <= end; i++) {
            // 获得所有可行的左子树集合
            List<TreeNode> leftNodes = generateTree(start, i-1);
            // 获得所有可行的右子树集合
            List<TreeNode> rightNodes = generateTree(i+1,end);

            // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
            for (TreeNode leftNode : leftNodes) {
                for (TreeNode rightNode : rightNodes) {
                    TreeNode curr = new TreeNode(i);
                    curr.left = leftNode;
                    curr.right = rightNode;
                    allNodes.add(curr);
                }
            }
        }
        return allNodes;
    }

    public static void main(String[] args) {
        DifferentSearchTree d = new DifferentSearchTree();
        d.generateTrees(3);
    }
}

/**
 * 题目描述：给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 */
