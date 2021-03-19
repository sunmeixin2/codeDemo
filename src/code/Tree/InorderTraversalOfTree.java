package code.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author sunmeixin
 * @description 二叉树的中序遍历
 * @date 2021-02-21
 */
public class InorderTraversalOfTree {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack();

        while (root != null || !stack.empty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
    }
}