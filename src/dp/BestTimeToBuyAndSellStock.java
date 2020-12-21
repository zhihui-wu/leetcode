package dp;

/**
 * @Description: 121. 买卖股票的最佳时机
 * @Author: 吴智慧
 * @Date: 2020/12/21 20:27
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {

        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();

        int result = bestTimeToBuyAndSellStock.maxProfit(new int[]{1,2,3});

        System.out.println(result);

    }

    /**
     * 动态规划
     * 不断更新最低价位，并计算当前价与当前历史最低价的差值
     * 时间复杂度：O（ N ）
     * 空间复杂度：O（ 1 ）
     */
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min){
                min = prices[i];
            }else if (prices[i] >= min + profit) {
                profit = prices[i] - min;
            }
        }
        return profit;
    }


}
