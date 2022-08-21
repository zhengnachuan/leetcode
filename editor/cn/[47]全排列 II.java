//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics数组 | 回溯 
//
// 👍 1166, 👎 0 
//
//
//
//

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：全排列 II
public class PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> result = new ArrayList<>();
        public List<Integer> path = new ArrayList<>();
        boolean[] used;

        public List<List<Integer>> permuteUnique(int[] nums) {
            used = new boolean[nums.length];
            Arrays.sort(nums);
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
                    System.out.println("used" + i);
                    continue;
                }
                // used[i - 1] == true，说明同一树枝nums[i - 1]使用过
                // used[i - 1] == false，说明同一树层nums[i - 1]使用过
                // 如果同一树层nums[i - 1]使用过则直接跳过
                //  https://programmercarl.com/0047.全排列II.html#_47-全排列-ii
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    System.out.println("pass" + i);
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