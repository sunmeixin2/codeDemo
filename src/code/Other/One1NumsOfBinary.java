package code.Other;

/**
 * @author sunmeixin
 * @description 二进制中1的个数
 * @date 2021-03-01
 */
public class One1NumsOfBinary {

    public int hammingWeight(int n) {

        if (n < 0) {
            n= -n;
        }
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            // 无符号右移
            n = n >>> 1;
        }
        return count;
    }

    public int hammingWeigh2t(int n) {
        int count = 0;

        while (n != 0) {
            count++;
            // n&(n−1)： 二进制数字n最右边的1变成0 ，其余不变。
            n = n & (n-1);
        }
        return count;
    }
}
