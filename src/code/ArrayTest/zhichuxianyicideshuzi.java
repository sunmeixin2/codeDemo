package code.ArrayTest;

/**
 * @author sunmeixin
 * @description 只出现一次的数字
 * @date 2021-02-06
 */
public class zhichuxianyicideshuzi {

    public int singleNumber(int[] nums) {
        int ans = 0;
        if (nums.length == 0) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }
}

/**
 * 题目描述：给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素
 */
