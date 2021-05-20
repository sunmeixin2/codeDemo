package code.ArrayTest;

import java.util.LinkedList;

/**
 * @author sunmeixin
 * @description 滑动窗口的最大值
 * @date 2021-03-18
 */
public class MaxSlidingWindow {

    public static int[] maxSlidingWindow(int[] nums, int k) {

        if (nums.length <= 0 || k == 0) {
            return new int[0];
        }
        //队列按从大到小放入
        LinkedList<Integer> queue = new LinkedList<Integer>();
        int[] res = new int[nums.length - k + 1];
        // 未形成窗口区间
        for (int i = 0; i < k; i++) {
            //队列不为空时，当前值与队列尾部值比较，如果大于，删除队列尾部值
            //一直循环删除到队列中的值都大于当前值，或者删到队列为空
            while (!queue.isEmpty() && nums[i] > queue.peekLast()) {
                queue.removeLast();
            }
            //执行完上面的循环后，队列中要么为空，要么值都比当前值大，然后就把当前值添加到队列中
            queue.add(nums[i]);
        }
        int j=0;
        res[j++] = queue.peekFirst();
        for (int i = k; i < nums.length; i++) {
            //i-k是已经在区间外了，如果首位等于nums[i-k]，那么说明此时首位值已经不再区间内了，需要删除
            if (queue.peekFirst() == nums[i-k]) {
                queue.removeFirst();
            }
            // 删除队列中比当前值大的值
            while (!queue.isEmpty() && nums[i] > queue.peekLast()) {
                queue.removeLast();
            }
            //把当前值添加到队列中
            queue.addLast(nums[i]);
            //把队列的首位值添加到arr数组中
            res[j++] = queue.peekFirst();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {7,2,4};
        maxSlidingWindow(nums,2);
    }
}

/**
 * 题目描述：给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 */
