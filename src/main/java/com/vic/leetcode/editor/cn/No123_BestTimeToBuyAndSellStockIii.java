//给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 
//输入：prices = [3,3,5,0,0,3,1,4]
//输出：6
//解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
//     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。 
//
// 示例 2： 
//
// 
//输入：prices = [1,2,3,4,5]
//输出：4
//解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。   
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。   
//     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
// 
//
// 示例 3： 
//
// 
//输入：prices = [7,6,4,3,1] 
//输出：0 
//解释：在这个情况下, 没有交易完成, 所以最大利润为 0。 
//
// 示例 4： 
//
// 
//输入：prices = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 10⁵ 
// 0 <= prices[i] <= 10⁵ 
// 
// Related Topics 数组 动态规划 👍 1003 👎 0


package com.vic.leetcode.editor.cn;

public class No123_BestTimeToBuyAndSellStockIii {
    public static void main(String[] args) {
        Solution solution = new No123_BestTimeToBuyAndSellStockIii().new Solution();
        int i = solution.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4});
        int i1 = solution.maxProfit(new int[]{1, 2, 3, 4, 5});
        System.out.println(i);
        System.out.println(i1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 优化
     * 直接使用当日的买入/卖出进行转移。
     * 例如 在计算 sell[i]时，我们直接使用 buy[i]而不是buy[i-2]进行转移。
     * buy[i]比buy[i-2]多考虑的是在第 i 天买入股票的情况，
     * 而转移到 sell[i]时，考虑的是在第 i 天卖出股票的情况，这样在同一天买入并且卖出收益为零，不会对答案产生影响。
     */
    class Solution {
        public int maxProfit(int[] prices) {
            int length = prices.length;
            int k = 2;
            int[] buy = new int[k + 1];
            int[] sell = new int[k + 1];
            buy[2] = buy[1] = -prices[0];
            sell[2] = sell[1] = 0;
            for (int i = 1; i < length; i++) {
                int price = prices[i];
                buy[1] = Math.max(buy[1], sell[0] - price);
                sell[1] = Math.max(sell[1], buy[1] + price);
                buy[2] = Math.max(buy[2], sell[1] - price);
                sell[2] = Math.max(sell[2], buy[2] + price);
            }
            return sell[2];
        }
    }

    class Solution2 {
        public int maxProfit(int[] prices) {
            int length = prices.length;
            int k = 2;
            // [抛售次数][天数]
            int[][] buy = new int[k + 1][length];
            int[][] sell = new int[k + 1][length];
            buy[2][0] = buy[1][0] = -prices[0];
            sell[2][0] = sell[1][0] = 0;
            for (int i = 1; i < length; i++) {
                int price = prices[i];
                for (int j = 1; j <= k; j++) {
                    // 前一天持有和上次抛售后购入
                    buy[j][i] = Math.max(buy[j][i - 1], sell[j - 1][i - 1] - price);

                    // 前一天抛售和前一天持有今天抛售
                    sell[j][i] = Math.max(sell[j][i - 1], buy[j][i - 1] + price);
                }
            }
            return sell[k][length - 1];
        }
    }

    class Solution1 {
        public int maxProfit(int[] prices) {
            int k = 2;
            int length = prices.length;
            // [天数][抛售次数][1-持有/0-抛售]
            int[][][] dp = new int[length][3][2];
//            dp[0][0][0] = 0;
//            dp[0][1][0] = 0;
//            dp[0][1][1] = -prices[0];
//            dp[0][2][0] = 0;
//            dp[0][2][1] = -prices[0];
            dp[0][0][0] = 0;
            dp[0][0][1] = -prices[0];
            dp[0][1][0] = 0;
            dp[0][1][1] = -prices[0];
            for (int i = 1; i < length; i++) {
                int price = prices[i];
                for (int j = k; j > 0; j--) {
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + price);
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - price);
                }
            }
            return dp[length - 1][k][0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}