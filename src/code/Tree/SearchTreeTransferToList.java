package code.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunmeixin
 * @description
 * @date 2020-12-06
 */
public class SearchTreeTransferToList {

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null){
            return null;
        }
        List<TreeNode> list = new ArrayList<>();
        Convert(pRootOfTree,list);
        for (int i = 0; i < list.size() -1; i++) {
            list.get(i).right = list.get(i+1);
            list.get(i+1).left = list.get(i);
        }
        return list.get(0);
    }

    /**
     * 中序遍历，并将节点放入到list中
     * @param root
     * @param list
     */
    public void Convert(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        Convert(root.left,list);
        list.add(root);
        Convert(root.right,list);
    }

}

/**
 * 题目描述：二叉搜索数与双向链表：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 思路：中序遍历二叉树，然后用一个List保存遍历的结果，然后再来修改指针
 */
