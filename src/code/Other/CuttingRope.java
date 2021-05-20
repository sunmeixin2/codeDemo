package code.Other;

/**
 * @author sunmeixin
 * @description 剪绳子
 * @date 2021-04-01
 */
public class CuttingRope {

    public int cuttingRope(int n) {
        if (n < 4) {
            return n - 1;
        }

        int res = 1;
        while (n > 4) {
            res *= 3;
            n = n -3;
        }
        return res * n;
    }
}

/**
 * 题目描述：给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 *          每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 *          例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 题解：   核心思路是：尽可能把绳子分成长度为3的小段，这样乘积最大
 */
