package code.ArrayTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sunmeixin
 * @description 三数之和
 * @date 2021-02-20
 */
public class ThreeSum {

    public List<List<Integer>> threeSum_Solution(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return list;
        }
        Arrays.sort(nums);
        for (int i=0; i<nums.length; ++i) {
            // 若num[i] > 0 则后边不可能相加等于0
            if (nums[i] > 0 ) {
                return list;
            }
            // nums[i] == nums[i-1] 对于重复元素跳过，避免重复计算
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int left = i+1, right = nums.length-1;
            int curr = nums[i];

            while (left < right) {
                List<Integer> tmpList = new ArrayList<>();
                int sum = curr + nums[left] + nums[right];
                if ( sum == 0) {
                    tmpList.add(curr);
                    tmpList.add(nums[left]);
                    tmpList.add(nums[right]);
                    list.add(tmpList);
                    // 判断左届和右届是否和下一位相同，避免重复
                    while (left < right && nums[left] == nums[left+1]){
                        left++;
                    }
                    while (left < right && nums[right] == nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return list;
    }
}

/**
 * 题目描述：给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * 解题思路：排序+双指针
 *  1.特判，对于数组长度 n，如果数组为 null 或者数组长度小于 3，返回 []。
 *  2.对数组进行排序。
 *  3.遍历排序后数组：
 *      若 nums[i]>0：因为已经排序好，所以后面不可能有三个数加和等于 0，直接返回结果。
 *      对于重复元素：跳过，避免出现重复解
 *      令左指针 L=i+1，右指针 R=n-1，当 L<R时，执行循环：
 *          当 nums[i]+nums[L]+nums[R]==0，执行循环，判断左界和右界是否和下一位置重复，去除重复解。并同时将 L,R 移到下一位置，寻找新的解
 *          若和大于 0，说明 nums[R] 太大，R 左移
 *          若和小于 0，说明 nums[L] 太小，L 右移
 */
