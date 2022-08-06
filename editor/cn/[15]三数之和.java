//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
// Related Topics数组 | 双指针 | 排序 
//
// 👍 4982, 👎 0 
//
//
//
//

package leetcode.editor.cn;

//Java：三数之和
public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            return this.nSumTarget(nums, 3, 0, 0);
        }

        public List<List<Integer>> nSumTarget(int[] nums, int n, int start, int target) {
            int sz = nums.length;
            List<List<Integer>> res = new ArrayList<>();
            if (n < 2 || sz < n) {
                return res;
            }
            if (n == 2) {
                return this.twoSumTarget(nums, start, target);
            }
            for (int i = start; i < sz; i++) {
                List<List<Integer>> sub = this.nSumTarget(nums, n - 1, i + 1, target - nums[i]);
                for (List<Integer> list : sub) {
                    list.add(nums[i]);
                    res.add(list);
                }
                while (i < sz - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
            return res;
        }

        public List<List<Integer>> twoSumTarget(int[] nums, int start, int target) {
            int left = start;
            int right = nums.length - 1;
            Set<Integer> set = new HashSet<>();
            List<List<Integer>> res = new ArrayList<>();
            for (int i = left; i < nums.length; i++) {
                int m = nums[i];
                if (set.contains(m)) {
                    // 直接使用 Arrays.asList 会导致外层的add抛出异常
                    res.add(new ArrayList(Arrays.asList(m, target - m)));
                    while (i < right && nums[i] == nums[i + 1]) {
                        i++;
                    }
                } else {
                    set.add(target - m);
                }
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}