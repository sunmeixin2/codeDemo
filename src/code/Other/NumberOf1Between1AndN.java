package code.Other;

/**
 * @author sunmeixin
 * @description 1~n整数中1出现的次数
 * @date 2020-12-12
 */
public class NumberOf1Between1AndN {

    /**
     * 思路1：当n位数较大时，时间复杂度会比较高
     * @param n
     * @return
     */
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;

        while (n > 0) {
            String str = String.valueOf(n);
            char[] c = str.toCharArray();
            for (int i = 0; i < c.length; i++) {
                if (c[i] == '1') {
                    count++;
                }
            }
            n--;
        }
        return count;
    }

    /**
     * 思路2:
     * @param n
     * @return
     */
    public int NumberOf1Between1AndN_Solutio2n(int n) {
        // todo:  有点复杂 看不懂
        return 0;
    }
}

/**
 * 题目：输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 *      例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 */
