//给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 
//输入: prices = [7,1,5,3,6,4]
//输出: 7
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
// 
//
// 示例 2: 
//
// 
//输入: prices = [1,2,3,4,5]
//输出: 4
//解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
// 
//
// 示例 3: 
//
// 
//输入: prices = [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 3 * 104 
// 0 <= prices[i] <= 104 
// 
// Related Topics 贪心 数组 动态规划 
// 👍 1514 👎 0


package com.vic.leetcode.editor.cn;

public class No122_BestTimeToBuyAndSellStockIi {
    public static void main(String[] args) {
        Solution solution = new No122_BestTimeToBuyAndSellStockIi().new Solution();
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        int maxProfit = solution.maxProfit(prices);
        System.out.println(maxProfit);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            // 贪心
            int maxProfit = 0;
            for (int i = 1; i < prices.length; i++) {
                int spread = prices[i] - prices[i - 1];
                if (spread > 0)
                    maxProfit += spread;
            }
            return maxProfit;
        }

        public int maxProfitDP(int[] prices) {
            // 动态规划
            int length = prices.length;
            if (length < 2) return 0;
            // 0 - 卖出状态 1 - 买入状态 | dp为当前情景下的现金
            int[][] dp = new int[length][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            for (int i = 1; i < length; i++) {
                // 第 i 天手里没有股票的最大利润
                // 比较前一天没有时的利润 和 前一天有股票今天卖出时的利润 取最大值
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                // 第 i 天手里持有一支股票的最大利润
                // 比较前一天有股票时的利润 和 前一天没有股票今天买入时的利润 取最大值
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
            return dp[length - 1][0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}