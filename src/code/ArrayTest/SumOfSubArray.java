package code.ArrayTest;


/**
 * @author sunmeixin
 * @description 连续子数组的最大和
 * @date 2021-03-23
 */
public class SumOfSubArray {

    public static int maxSubArray(int[] nums) {

//        int[] dp = new int[2];
        // dp 代表以元素 nums[i] 为结尾的连续子数组最大和
        int dp = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // dp < 0  说明是负增长
            if (dp < 0) {
                dp = nums[i];
            } else {
                dp = dp + nums[i];
            }
            res = Math.max(res,dp);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray(nums);
    }
}
/**
 * 题目描述：输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *          要求时间复杂度为O(n)。
 *
 *   题解：动态规划
 *        类似于：  由于 dp[i]只与 dp[i-1] 和 nums[i] 有关系，因此可以将原数组 nums 用作 dp 列表，即直接在 nums上修改即可
 */
