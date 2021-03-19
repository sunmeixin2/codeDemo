package code.ArrayTest;

/**
 * @author sunmeixin
 * @description 数组中数字出现的次数 2
 * @date 2021-03-15
 */
public class AppearNumberCountOfArray {

    public int singleNumber(int[] nums) {
        int[] count = new int[32];
        for (int num : nums) {
            for (int i  = 0; i< 32; i++) {
                count[i] += num & 1;
                num >>>= 1;
            }
        }

        int res = 0;
        for (int i = 0 ; i< 32; i++) {
            res =res << 1;
            res += count[i] % 3;

        }
        return res;
    }
}

/**
 * 题目描述：在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 * 思路分析：建立一个长度为 32 的数组 counts ，记录所有数字的各二进制位的 1 的出现次数
 */
