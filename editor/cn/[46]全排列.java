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
// Related Topics数组 | 回溯 
//
// 👍 2180, 👎 0 
//
//
//
//

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

//Java：全排列
public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> result = new ArrayList<>();
        public List<Integer> path = new ArrayList<>();
        boolean[] used;

        public List<List<Integer>> permute(int[] nums) {
            used = new boolean[nums.length];
            this.backtrack(nums);
            return result;
        }

        public void backtrack(int[] nums) {
            if (path.size() == nums.length) {
                result.add(new ArrayList<>(path));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                used[i] = true;
                path.add(nums[i]);
                this.backtrack(nums);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}