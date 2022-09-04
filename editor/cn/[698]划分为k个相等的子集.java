//给定一个整数数组 nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。 
//
// 
//
// 示例 1： 
//
// 
//输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
//输出： True
//说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。 
//
// 示例 2: 
//
// 
//输入: nums = [1,2,3,4], k = 3
//输出: false 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= len(nums) <= 16 
// 0 < nums[i] < 10000 
// 每个元素的频率在 [1,4] 范围内 
// 
// Related Topics位运算 | 记忆化搜索 | 数组 | 动态规划 | 回溯 | 状态压缩 
//
// 👍 650, 👎 0 
//
//
//
//

package leetcode.editor.cn;

import java.util.HashMap;

//Java：划分为k个相等的子集
public class PartitionToKEqualSumSubsets {
    public static void main(String[] args) {
        Solution solution = new PartitionToKEqualSumSubsets().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        HashMap<Integer, Boolean> memo = new HashMap<>();

        public boolean canPartitionKSubsets(int[] nums, int k) {
            int sum = 0;
            for (int v : nums) {
                sum += v;
            }
            if (sum % k != 0) {
                return false;
            }
            int target = sum / k;
            int used = 0;// 使用位图技巧
            return this.backtrack(k, 0, nums, 0, used, target);
        }

        boolean backtrack(int k, int bucket, int[] nums, int start, int used, int target) {

            if (k == 0) {
                // 所有桶都被装满了，而且 nums 一定全部用完了
                return true;
            }
            if (bucket == target) {
                // 装满了当前桶，递归穷举下一个桶的选择 // 让下一个桶从 nums[0] 开始选数字
                boolean res = this.backtrack(k - 1, 0, nums, 0, used, target);
                // 缓存结果
                memo.put(used, res);
                return res;
            }
            if (memo.containsKey(used)) {
                // 避免冗余计算
                return memo.get(used);
            }
            for (int i = start; i < nums.length; i++) {
                // 剪枝
                // 判断第 i 位是否是 1
                if (((used >> i) & 1) == 1) {
                    // nums[i] 已经被装入别的桶中
                    continue;
                }
                if (nums[i] + bucket > target) {
                    continue;
                }
                // 将第 i 位置为 1
                used |= 1 << i;
                // 递归穷举下一个数字是否装入当前桶
                if (this.backtrack(k, bucket + nums[i], nums, i + 1, used, target)) {
                    return true;
                }
                // 将第 i 位置为 0
                used ^= 1 << i;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}