package code.ArrayTest;


/**
 * @author sunmeixin
 * @description 零钱兑换  ???
 * @date 2021-02-22
 */
public class CoinChange {

    public static int coinChange_solution(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }

        return coinChange_solution(coins, amount, new int[amount+1]);
    }

    public static int coinChange_solution(int[] coins, int rem, int[] count) {
        if (rem < 1) {
            return -1;
        }

        if (rem == 0) {
            return 0;
        }

        //之前已经计算过这种情况，直接返回结果
        if (coins[rem] != 0) {
            return coins[rem];
        }

        int min = Integer.MAX_VALUE;

        for (int coin : coins) {
            // F[S] = F[S - C] + 1
            int res = coinChange_solution(coins,rem - coin ,count);
            //当前情况用的硬币个数更少，更新min
            if (res > 0 && res < min) {
                min = res + 1;
            }
        }

        //这么写，防止了无解的情况
        count[rem-1] = min == Integer.MAX_VALUE ? -1 : min;
        return count[rem-1];


    }

}

/**
 * 题目描述：给定不同面额的硬币 coins 和一个总金额 amount。
 *  编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 *
 * F(S)：组成金额 SS 所需的最少硬币数量
 * C(i)：是第 i 枚硬币的面值
 * 假设我们知道 F(S) ，即组成金额 S 最少的硬币数，最后一枚硬币的面值是 C：F(S)=F(S−C)+1
 */


