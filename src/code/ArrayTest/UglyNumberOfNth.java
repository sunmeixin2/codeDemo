package code.ArrayTest;

/**
 * @author sunmeixin
 * @description 丑数
 * @date 2021-02-28
 */
public class UglyNumberOfNth {

    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        int a = 0, b = 0, c = 0;
        dp[0] = 1;
        for (int i=1; i<n; i++){
            int n2 = dp[a]*2, n3 = dp[b]*3, n5 = dp[c]*5;
            dp[i] = Math.min(Math.min(n2,n3),n5);
            if (dp[i] == n2) {
                a++;
            }
            if (dp[i] == n3) {
                b++;
            }
            if (dp[i] == n5){
                c++;
            }
        }
        return dp[n-1];
    }
}

/**
 * 题目描述：把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 *  解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 *
 *  思路：
 *      丑数只包含因子 2, 3, 5 ，因此有 丑数 == 某较小丑数 × 某因子
 *      我的简单理解是 设置三个指针a,b,c,从第一个元素开始 *2（对应指针a）,  *3 （对应指针b）, *5（对应指针c）,  取最小的,
 *      每当某个指针对应结果为最小值后，对应指针+1， 。。。。
 */
