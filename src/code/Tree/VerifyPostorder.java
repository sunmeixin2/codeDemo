package code.Tree;

/**
 * @author sunmeixin
 * @description 二叉搜索树的后序遍历序列
 * @date 2021-03-06
 */
public class VerifyPostorder {

    public boolean verifyPostorder(int[] postorder) {
        return helper(postorder,0,postorder.length-1);
    }

    public boolean helper(int[] posrorder,int left,int right) {
        //如果left==right，就一个节点不需要判断了，
        // 如果left>right说明没有节点，也不用再看了,否则就要继续往下判断
        if (left >= right){
            return true;
        }

        //因为数组中最后一个值postorder[right]是根节点，这里从左往右找出第一个比
        //根节点大的值，他后面的都是根节点的右子节点（包含当前值，不包含最后一个值，
        //因为最后一个是根节点），他前面的都是根节点的左子节点

        int mid = left;
        while (posrorder[mid] < posrorder[right]) {
            mid++;
        }
        int temp = mid;

        //因为postorder[mid]前面的值都是比根节点root小的，
        //我们还需要确定postorder[mid]后面的值都要比根节点root大，
        //如果后面有比根节点小的直接返回false
        while (temp < right) {
            if (posrorder[temp++] < posrorder[right]) {
                return false;
            }
        }

        //然后对左右子节点进行递归调用
        return helper(posrorder,left,mid-1) && helper(posrorder,mid,right-1);
    }
}

/**
 * 题目描述：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 *          如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 *
 * 思路分析：
 *      二叉搜索树的特点是左子树的值<根节点<右子树的值。而后续遍历的顺序是：左子节点→右子节点→根节点；
 *      因为数组中最后一个值postorder[right]是根节点，这里从左往右找出第一个比根节点大的值，他后面的都是根节点的右子节点，他前面的都是根节点的左子节点
 */
