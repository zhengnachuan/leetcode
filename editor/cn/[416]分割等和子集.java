//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
// Related Topics数组 | 动态规划 
//
// 👍 1473, 👎 0 
//
//
//
//

package leetcode.editor.cn;

//Java：分割等和子集
public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        Solution solution = new PartitionEqualSubsetSum().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum % 2 == 1) {
                return false;
            }
            int target = sum / 2;
            //dp[i]代表背包容量为j的情况下，背包内容量的最大价值
            int[] dp = new int[target + 1];
            for (int num : nums) {
                for (int j = target; j >= num; j--) {
                    dp[j] = Math.max(dp[j], dp[j - num] + num);
                }
            }
            return dp[target] == target;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}