package code.ArrayTest;

/**
 * @author sunmeixin
 * @description 数组中只出现一次的数字
 * @date 2021-03-14
 */
public class SingleNumbersOfArray {

    public int[] singleNumbers(int[] nums) {
        int ans = 0;
        // 找出两个只出现一次数字的异或值
        for (int num : nums) {
            ans ^= num;
        }

        int div = 1;
        // 在异或值中找到任意为1的一位
        while ( (ans & div) == 0) {
            div <<= 1;
        }

        // 分组异或
        int a = 0, b = 0;
        for (int num : nums ) {
            if ( (num & div) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[] {a,b};
    }
}

/**
 * 题目描述：一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 *           请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *  思路分析：异或  -> 异或值任意为1的一位 ->  分组异或
 */


