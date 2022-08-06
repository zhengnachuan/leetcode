//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[
//b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）： 
//
// 
// 0 <= a, b, c, d < n 
// a、b、c 和 d 互不相同 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// 你可以按 任意顺序 返回答案 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics数组 | 双指针 | 排序 
//
// 👍 1297, 👎 0 
//
//
//
//

package leetcode.editor.cn;

//Java：四数之和
public class FourSum {
    public static void main(String[] args) {
        Solution solution = new FourSum().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            return this.nSumTarget(nums, 4, 0, target);
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
                    long sum = 0;
                    for (Integer k : list) {
                        sum += (long) k;
                    }
                    if (sum + (long) nums[i] == target) {
                        list.add(nums[i]);
                        res.add(list);
                    }

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

//        public static void main(String[] args) {
////            int target = -294967296;
////            int border = -2147483648;
//            int a = 1000000000;
//            int b = a + a;
//            int c = b + a;
//            int d = c + a;
//        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}