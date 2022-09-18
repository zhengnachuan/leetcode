//给定一个未排序的整数数组 nums ， 返回最长递增子序列的个数 。 
//
// 注意 这个数列必须是 严格 递增的。 
//
// 
//
// 示例 1: 
//
// 
//输入: [1,3,5,4,7]
//输出: 2
//解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
// 
//
// 示例 2: 
//
// 
//输入: [2,2,2,2,2]
//输出: 5
//解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
// 
//
// 
//
// 提示: 
//
// 
//
// 
// 1 <= nums.length <= 2000 
// -10⁶ <= nums[i] <= 10⁶ 
// 
// Related Topics树状数组 | 线段树 | 数组 | 动态规划 
//
// 👍 657, 👎 0 
//
//
//
//

package leetcode.editor.cn;

import java.util.Arrays;

//Java：最长递增子序列的个数
public class NumberOfLongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new NumberOfLongestIncreasingSubsequence().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findNumberOfLIS(int[] nums) {
            // i之前（包括i）最长递增序列的长度
            int[] dp = new int[nums.length];
            Arrays.fill(dp, 1);
            //以nums[i]为结尾的字符串，最长递增子序列的个数
            int[] cnt = new int[nums.length];
            Arrays.fill(cnt, 1);
            int maxLength = 1;
            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        if (dp[j] + 1 > dp[i]) {
                            dp[i] = dp[j] + 1;
                            cnt[i] = cnt[j];
                        } else if (dp[j] + 1 == dp[i]) {
                            cnt[i] += cnt[j];
                        }
                    }
                    if (dp[i] > maxLength) {
                        maxLength = dp[i];
                    }
                }
            }
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                if (maxLength == dp[i]) {
                    res += cnt[i];
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}