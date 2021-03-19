package code.ArrayTest;

/**
 * @author sunmeixin
 * @description 数组中出现次数超过一半的数字
 * @date 2021-03-16
 */
public class OverHalfNumsInArray {

    /**
     * 摩尔投票法
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int vote = 0, x = 0;

        for (int num : nums) {
            if (vote == 0) {
                x = num;
            }
            vote += (x == num) ? 1 : -1;
        }


        /**
         *  由于题目说明 给定的数组总是存在多数元素 ，因此本题不用考虑 数组不存在众数 的情况。
         *  若考虑，需要加入一个 “验证环节” ，遍历数组 nums 统计 x 的数量
         */
        // 验证 x 是否为众数
//        int count =0;
//        for(int num : nums) {
//            if (num == x) count++;
//        }
//        return count > nums.length / 2 ? x : 0; // 当无众数时返回 0


        return x;
    }
}

/**
 * 题目描述：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *          你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *   三种解法：
 *      1）哈希表统计
 *      2）排序
 *      3）摩尔投票法：核心理念为 票数正负抵消
 */
