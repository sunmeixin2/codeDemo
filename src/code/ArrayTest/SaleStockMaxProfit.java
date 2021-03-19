package code.ArrayTest;

/**
 * @author sunmeixin
 * @description 买卖股票的最佳时机
 * @date 2021-02-10
 */
public class SaleStockMaxProfit {

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit){
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}
