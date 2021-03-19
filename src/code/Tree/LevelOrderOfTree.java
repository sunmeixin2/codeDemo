package code.Tree;

import java.util.*;

/**
 * @author sunmeixin
 * @description 二叉树的层序遍历
 * @date 2021-02-21
 */
public class LevelOrderOfTree {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int n = queue.size();
            // 在每一层遍历开始前，先记录队列中的结点数量 n（也就是这一层的结点数量），然后一口气处理完这一层的 n 个结点
            for (int i=0; i<n; i++) {
                root = queue.poll();
                level.add(root.val);
                if (root.left != null) {
                    queue.add(root.left);
                }
                if (root.right != null) {
                    queue.add(root.right);
                }
            }
            if (!level.isEmpty()) {
                ans.add(level);
            }
        }


        return ans;
    }
}
