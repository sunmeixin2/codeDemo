package code.ArrayTest;

/**
 * @author sunmeixin
 * @description 最佳买卖股票时机含冷冻期
 * @date 2021-02-21
 */
public class SaleStockMaxProfit2 {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }


        int len = prices.length;
        // f[i][0] : 持有股票
        // f[i][1] : 不持有股票，本日卖出，下一天为冷冻期
        // f[i][2] : 不持有股票，本日无卖出，下一天非冷冻期
        int[][] f = new int[len][3];
        // 1: 第一天持有，只有可能是买入
        f[0][0] = -prices[0];
        // 2. 第0天，相当于当天买入卖出，没有收益，并造成下一天冷冻期，减少选择。综合认为是负收益
        f[0][1] = 0;
        // 3. 相当于没买入，收益自然为0
        f[0][2] = 0;

        for (int i=1; i<len; i++) {
            // 持有股票： 1.昨天持有股票 2.本日买入（条件：昨天不持有，且不是卖出）
            f[i][0] = Math.max(f[i-1][0],f[i-1][2]-prices[i]);
            //本日卖出 : (条件:昨天持有)
            f[i][1] = f[i-1][0]+prices[i];
            // 不持有，但也不是卖出 : 1.昨天卖出，不持有  2.昨天没卖出，但也不持有
            f[i][2] = Math.max(f[i-1][1],f[i-1][2]);
        }
        // 最后一天还持有股票是没有意义的,肯定是不持有的收益高，不用对比 f[len-1][0]
        return Math.max(f[len-1][1],f[len-1][2]);

    }
}
