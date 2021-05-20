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

        //利用 左移操作 和 或运算 ，可将 counts 数组中各二进位的值恢复到数字 res 上
//        for (int i = 31 ; i >= 0; i--) {
        for (int i = 0 ; i< 32; i++) {
            res <<= 1;
//            res += count[i] % 3;
            res += count[31-i] % 3;

        }
        return res;
    }


}

/**
 * 题目描述：在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 * 思路分析：建立一个长度为 32 的数组 counts ，记录所有数字的各二进制位的 1 的出现次数。
 *          将 counts 各元素对 3 求余，则结果为 “只出现一次的数字” 的各二进制位。
 *          利用 左移操作 和 或运算 ，可将 counts 数组中各二进位的值恢复到数字 res 上
 */
