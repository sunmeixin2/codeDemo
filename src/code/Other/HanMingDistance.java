package code.Other;

/**
 * @author sunmeixin
 * @description 汉明距离
 * @date 2021-02-06
 */
public class HanMingDistance {

    public static int hammingDistance(int x, int y) {
        int count = 0;
        int val = x ^ y;
        while (val != 0) {
            if (val % 2 == 1) {
                count++;
            }
            val = val >> 1;
        }
        return count;
    }
    public static int hammingDistance2(int x, int y) {
        int count = 0;
        int val = x ^ y;
        while (val != 0) {
            count++;
            val = val & (val - 1); // 移除最右边的一个'1'
        }
        return count;
    }

    public static void main(String[] args) {
        hammingDistance(3,1);
    }
}

/**
 * 题目描述：两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 */
