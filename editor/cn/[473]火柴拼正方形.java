//你将得到一个整数数组 matchsticks ，其中 matchsticks[i] 是第 i 个火柴棒的长度。你要用 所有的火柴棍 拼成一个正方形。你 不能
//折断 任何一根火柴棒，但你可以把它们连在一起，而且每根火柴棒必须 使用一次 。 
//
// 如果你能使这个正方形，则返回 true ，否则返回 false 。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: matchsticks = [1,1,2,2,2]
//输出: true
//解释: 能拼成一个边长为2的正方形，每边两根火柴。
// 
//
// 示例 2: 
//
// 
//输入: matchsticks = [3,3,3,3,4]
//输出: false
//解释: 不能用所有火柴拼成一个正方形。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= matchsticks.length <= 15 
// 1 <= matchsticks[i] <= 10⁸ 
// 
// Related Topics位运算 | 数组 | 动态规划 | 回溯 | 状态压缩 
//
// 👍 438, 👎 0 
//
//
//
//

package leetcode.editor.cn;

import java.util.HashMap;

//Java：火柴拼正方形
public class MatchsticksToSquare {
    public static void main(String[] args) {
        Solution solution = new MatchsticksToSquare().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        HashMap<Integer, Boolean> memo = new HashMap<>();

        public boolean makesquare(int[] matchsticks) {
            int sum = 0;
            for (int v : matchsticks) {
                sum += v;
            }
            if (sum % 4 != 0) {
                return false;
            }
            int target = sum / 4;
            int used = 0;// 使用位图技巧
            return this.backtrack(4, 0, matchsticks, 0, used, target);
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