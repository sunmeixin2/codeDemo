package code.ArrayTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunmeixin
 * @description 找到所有数组中消失的数字
 * @date 2021-02-10
 */
public class FindDisappearedNumbers {
    public static List<Integer> disappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>(2);

        int index ;
        for (int i = 0; i < nums.length; i++) {
            index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] *= -1;
            }
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] > 0) {
                res.add(i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        disappearedNumbers(nums);
    }
}

/**
 * 题目描述：
 *  给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 *  找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *
 * 题解：将数组元素减一对应为索引的位置变为负数
 *          再遍历修改后的数组，若数组元素值大于0，则说明数组下标值不存在，即消失的数字
 */
