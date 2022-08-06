//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 回溯 
// 👍 1534 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//Java：全排列
public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new LinkedList<>();

        public List<List<Integer>> permute(int[] nums) {
            this.backTrack(nums, new LinkedList<>());
            return res;
        }

        public void backTrack(int[] nums, LinkedList<Integer> subRes) {

            if (subRes.size() == nums.length) {
                res.add(new LinkedList<>(subRes));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (subRes.contains(nums[i])) {
                    continue;
                }
                subRes.add(nums[i]);
                this.backTrack(nums, subRes);
                subRes.removeLast();
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}