package code.Tree;

/**
 * @author sunmeixin
 * @description 二叉树的最近公共祖先
 * @date 2021-01-24
 */
public class LowestCommonAncestor {

    // 二叉树的最近公共祖先
    public static TreeNode solution(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = solution(root.left,p,q);
        TreeNode right = solution(root.right,p,q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

    // 二叉搜索树的最近公共祖先
    public static TreeNode solution2(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val > p.val && root.val > q.val) {  // p,q都在左子树
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) { // p,q都在右子树
                root = root.right;
            } else {
                break;
            }
        }
        return root;
    }
}

/**
 * 题目描述：给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 题解：
 * solution1:
 *  根据 left 和 right ，可展开为四种情况：
 *      1.当 left 和 right 同时为空 ：说明 root 的左 / 右子树中都不包含 p,q ，返回 null ；
 *      2.当 left 和 right 同时不为空 ：说明 p, q 分列在 root 的 异侧 （分别在 左 / 右子树），因此 root 为最近公共祖先，返回 root ；
 *      3.当 left 为空 ，right不为空 ：p,q都不在 root的左子树中，直接返回 right 。具体可分为两种情况：
 *          p,q 其中一个在 root 的 右子树 中，此时 right 指向 p（假设为 p ）；
 *          p,q两节点都在 root 的 右子树 中，此时的 right指向 最近公共祖先节点 ；
 *      4.当 left不为空 ， right空 ：与情况 3. 同理；
 *
 */
