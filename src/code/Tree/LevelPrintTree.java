package code.Tree;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author sunmeixin
 * @description 从上到下打印二叉树 II
 * @date 2021-03-03
 */
public class LevelPrintTree {

    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> tmpList = new ArrayList<>(size);
            while (size-- != 0) {

                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                tmpList.add(node.val);

            }
            res.add(tmpList);
        }
        return res;
    }

    public int[] levelOrder2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return new int[0];
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            list.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        int[] ans = new int[list.size()];

        for (int i=0; i<list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    /**
     * 之字形打印二叉树
     * 题目描述：请实现一个函数按照之字形顺序打印二叉树，
     *          即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，
     *          其他行以此类推。
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> tmpList = new ArrayList<>(size);
            while (size-- != 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                tmpList.add(node.val);
            }
            if (res.size() % 2 == 1) {
                Collections.reverse(tmpList);
            }
            res.add(tmpList);
        }
        return res;
    }
}

/**
 * 题目描述：从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * 思路分析：队列
 *
 */


