package code.ArrayTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
        LinkedList<Integer> queue = new LinkedList<Integer>();
        int[] res = new int[nums.length - k + 1];
        Integer max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            if (!queue.isEmpty()) {
                max = nums[i] > queue.getLast() ? nums[i] : queue.getLast();
                queue.add(max);
            } else {
                queue.add(nums[i]);
            }
        }
        res[0] = queue.getLast();
        int j=1;
        for (int i = k; i < nums.length; i++) {
            max = nums[i] > queue.getLast() ? nums[i] : queue.getLast();
            queue.add(max);
            queue.removeFirst();
            res[j++] = queue.getLast();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        maxSlidingWindow(nums,3);
    }
}
