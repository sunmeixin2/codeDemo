package code.Tree;

import java.util.Arrays;

/**
 * @author sunmeixin
 * @description  重建二叉树 （前序和中序 && 中序和后序）
 * @date 2020-11-05
 */
public class ReBuildBinaryTree {

    /**
     * 前序、中序重建二叉树
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        // 中序遍历
        for (int i=0; i<in.length; i++) {
            // 找出中序序列中root的位置
            if (in[i] == pre[0]) {
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
                break;
            }
        }
        return root;
    }

    /**
     * 中序、后序重建二叉树
     * @param in
     * @param post
     * @return
     */
    public TreeNode reConstructBinaryTree2(int[] in, int[] post) {
        if (post.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(post[post.length-1]);
        for (int i=0; i<in.length; i++) {
            if (in[i] == root.val) {
                root.left = reConstructBinaryTree2( Arrays.copyOfRange(in, 0, i),Arrays.copyOfRange(post, 0, i ));
                root.right = reConstructBinaryTree2( Arrays.copyOfRange(in, i + 1, in.length),Arrays.copyOfRange(post, i , post.length-1));
                break;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        ReBuildBinaryTree reBuildBinaryTree = new ReBuildBinaryTree();
        int[] pre = {1,2,3,4,5,6,7};
        int[] in = {3,2,4,1,6,5,7};
        int[] post = {3,4,2,6,7,5,1};
//        TreeNode root = reBuildBinaryTree.reConstructBinaryTree(pre,in);
        TreeNode root = reBuildBinaryTree.reConstructBinaryTree2(in,post);
        reBuildBinaryTree.print(root);

    }

    public void print(TreeNode root){
        if (root == null)
            return;
        print(root.left);
        print(root.right);
        System.out.println(root.val);
    }


}
