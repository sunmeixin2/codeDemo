package code.ArrayTest;

/**
 * @author sunmeixin
 * @description 多数元素
 * @date 2021-02-08
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (candidate == num) ? 1 : -1;
        }
        return candidate;
    }
}

/**
 * 题目描述： 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 1.哈希表
 * 2.排序
 * 3.投票法：
 *      投票法是遇到相同的则票数 + 1，遇到不同的则票数 - 1。
 *      且“多数元素”的个数> ⌊ n/2 ⌋，其余元素的个数总和<= ⌊ n/2 ⌋。
 *      因此“多数元素”的个数 - 其余元素的个数总和 的结果 肯定 >= 1。
 *      这就相当于每个“多数元素”和其他元素 两两相互抵消，抵消到最后肯定还剩余至少1个“多数元素”。
 *
 */
