//给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。 
//
// 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
// 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12
//输出：3 
//解释：12 = 4 + 4 + 4 
//
// 示例 2： 
//
// 
//输入：n = 13
//输出：2
//解释：13 = 4 + 9 
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁴ 
// 
// Related Topics广度优先搜索 | 数学 | 动态规划 
//
// 👍 1482, 👎 0 
//
//
//
//

package leetcode.editor.cn;

//Java：完全平方数
public class PerfectSquares {
    public static void main(String[] args) {
        Solution solution = new PerfectSquares().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSquares(int n) {
            int max = Integer.MAX_VALUE;
            int[] dp = new int[n + 1];
            // 初始化
            // 当和为0时，组合的个数为0
            dp[0] = 0;
            for (int j = 1; j <= n; j++) {
                dp[j] = max;
            }
            // 遍历背包
            for (int j = 1; j <= n; j++) {
                // 遍历物品
                for (int i = 1; i * i <= j; i++) {
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                }
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}