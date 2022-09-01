//给定一个整数数组 prices，其中 prices[i]表示第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。 
//
// 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。 
//
// 返回获得利润的最大值。 
//
// 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。 
//
// 
//
// 示例 1： 
//
// 
//输入：prices = [1, 3, 2, 8, 4, 9], fee = 2
//输出：8
//解释：能够达到的最大利润:  
//在此处买入 prices[0] = 1
//在此处卖出 prices[3] = 8
//在此处买入 prices[4] = 4
//在此处卖出 prices[5] = 9
//总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8 
//
// 示例 2： 
//
// 
//输入：prices = [1,3,7,5,10,3], fee = 3
//输出：6
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 5 * 10⁴ 
// 1 <= prices[i] < 5 * 10⁴ 
// 0 <= fee < 5 * 10⁴ 
// 
// Related Topics贪心 | 数组 | 动态规划 
//
// 👍 779, 👎 0 
//
//
//
//

package leetcode.editor.cn;

//Java：买卖股票的最佳时机含手续费
public class BestTimeToBuyAndSellStockWithTransactionFee {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockWithTransactionFee().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // dp
        public int maxProfit2(int[] prices, int fee) {
            // dp[i][0]第i天持有股票后的最多现金
            // dp[i][1]第i天持有的最多现金
            int[][] dp = new int[prices.length][2];
            dp[0][0] = -prices[0];
            dp[0][1] = 0;
            for (int i = 1; i < prices.length; i++) {
                // 第i天持股票所剩最多现金 = max(第i-1天持股票所剩现金, 第i-1天持现金-买第i天的股票)
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
                // 第i天持有最多现金 = max(第i-1天持有的最多现金，第i-1天持有股票的最多现金+第i天卖出股票)
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
            }
            return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
        }

        // 贪心
        public int maxProfit(int[] prices, int fee) {
            int maybeBuy = prices[0] + fee;
            int sum = 0;
            for (int p : prices) {
                // 找到递减最低买入点
                if (maybeBuy > p + fee) {
                    maybeBuy = p + fee;
                    // 找到递增最高卖出点
                } else if (maybeBuy < p) {
                    sum += p - maybeBuy;
                    maybeBuy = p;
                }
            }
            return sum;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}