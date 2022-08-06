//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯 
// 👍 1312 👎 0

package leetcode.editor.cn;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.data.redis.core.script.ReactiveScriptExecutor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Java：子集
public class Subsets {
    public static void main(String[] args) {
        Solution solution = new Subsets().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> res = new LinkedList<>();

        public List<List<Integer>> subsets(int[] nums) {
            this.recursion(nums, 0, new LinkedList<>());
            return res;
        }

        public void recursion(int[] nums, int k, LinkedList<Integer> list) {

            res.add(new ArrayList<>(list));

            for (int i = k; i < nums.length; i++) {
                list.add(nums[i]);
                this.recursion(nums, i + 1, list);
                list.removeLast();
            }
            return;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}