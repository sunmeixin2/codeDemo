package code.ArrayTest;

/**
 * @author sunmeixin
 * @description 非递减数列
 * @date 2021-02-07
 */
public class CheckPossibility {

    public static boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] > nums[i+1]) {
                count++;
                if (count > 1) {
                    return false;
                }
                if (i > 0 && nums[i-1] > nums[i+1]) {
                    nums[i+1] = nums[i];
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,1,8};
        boolean flag = checkPossibility(nums);
        System.out.println(flag);
    }
}
/**
 * 题目描述：给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 */
