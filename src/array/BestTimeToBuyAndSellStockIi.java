package array;

/**
 * @Description: 122. 买卖股票的最佳时机 II
 * @Author: 吴智慧
 * @Date: 2020/11/30 19:57
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class BestTimeToBuyAndSellStockIi {

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockIi bestTimeToBuyAndSellStockIi = new BestTimeToBuyAndSellStockIi();

        int[] prices = new int[]{7,1,5,3,6,4};

        int result = bestTimeToBuyAndSellStockIi.maxProfit(prices);

        System.out.println(result);
    }


    /**
     * 时间复杂度：O（ n ）
     * 空间复杂度：O（ 1 ）
     */
    public int maxProfit(int[] prices) {
        int sum = 0;
        int input = -1;
        for (int i = 0; i < prices.length; i++) {
            if (input == -1) {
                if (i < prices.length - 1 && prices[i] < prices[i + 1]) {
                    input = prices[i];
                }
            }else {
                if (i == prices.length - 1 || prices[i] > prices[i + 1]) {
                    sum = sum + (prices[i] - input);
                    input = -1;
                }
            }
        }
        return sum;
    }
}
