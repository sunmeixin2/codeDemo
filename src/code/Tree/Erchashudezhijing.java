package code.Tree;

/**
 * @author sunmeixin
 * @description 二叉树的直径
 * @date 2021-02-05
 */
public class Erchashudezhijing {

    int high = 0;
    public  int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return high ;
    }

    public int depth(TreeNode root){
        if (root == null ) {
            return 0;
        }
        int h1 = depth(root.left);
        int h2 = depth(root.right);
        // 将每个节点最大直径(左子树深度+右子树深度)当前最大值比较并取大者
        high = Math.max(high, h1 + h2 );
        // 返回该节点深度
        return Math.max(h1,h2)+1;

    }
}

/**
 * 题目描述：给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 */
