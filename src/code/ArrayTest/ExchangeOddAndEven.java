package code.ArrayTest;

/**
 * @author sunmeixin
 * @description 调整数组顺序使奇数位于偶数前面
 * @date 2021-03-23
 */
public class ExchangeOddAndEven {

    public int[] exchange(int[] nums) {
        if (nums.length == 0) {
            return nums;
        }

        int i = 0, j = nums.length -1;
        while (i < j) {
            while (i < j && nums[i] % 2 == 1) {
                i++;
            }
            while (i < j && nums[j] % 2 == 0) {
                j--;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }

}

/**
 * 题目描述：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * 思路：双指针
 */
