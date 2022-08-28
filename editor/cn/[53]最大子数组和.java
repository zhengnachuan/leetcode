//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 子数组 是数组中的一个连续部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [5,4,-1,7,8]
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
// Related Topics数组 | 分治 | 动态规划 
//
// 👍 5249, 👎 0 
//
//
//
//

package leetcode.editor.cn;

//Java：最大子数组和
public class MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumSubarray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 贪心
        // 局部最优：当前“连续和”为负数的时候立刻放弃，从下一个元素重新计算“连续和”，因为负数加上下一个元素 “连续和”只会越来越小。
        // 全局最优：选取最大“连续和”
        public int maxSubArray1(int[] nums) {
            int sum = 0;
            int res = Integer.MIN_VALUE;
            for (int num : nums) {
                sum += num;
                res = Math.max(sum, res);
                if (sum <= 0) {
                    sum = 0;
                }
            }
            return res;
        }

        // dp
        public int maxSubArray(int[] nums) {
            // dp[i]表示包括i之前的最大连续子序列和
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            int res = dp[0];
            for (int i = 1; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
                res = Math.max(res, dp[i]);
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}