//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 请必须使用时间复杂度为 O(log n) 的算法。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,3,5,6], target = 5
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,3,5,6], target = 2
//输出: 1
// 
//
// 示例 3: 
//
// 
//输入: nums = [1,3,5,6], target = 7
//输出: 4
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 为 无重复元素 的 升序 排列数组 
// -10⁴ <= target <= 10⁴ 
// 
// Related Topics数组 | 二分查找 
//
// 👍 1611, 👎 0 
//
//
//
//

package leetcode.editor.cn;

//Java：搜索插入位置
public class SearchInsertPosition {
    public static void main(String[] args) {
        Solution solution = new SearchInsertPosition().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1; // 定义target在左闭右闭的区间里，[left, right]
            while (left <= right) { // 当left==right，区间[left, right]依然有效
                int mid = left + (right - left) / 2;
                if (target == nums[mid]) {
                    return mid;
                } else if (target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            // 分别处理如下四种情况
            // 目标值在数组所有元素之前  [0, -1]
            // 目标值等于数组中某一个元素  return middle;
            // 目标值插入数组中的位置 [left, right]，return  right + 1
            // 目标值在数组所有元素之后的情况 [left, right]， 因为是右闭区间，所以 return right + 1
            return right + 1;
        }

        public int searchInsert1(int[] nums, int target) {
            int left = 0;
            int right = nums.length; // 定义target在左闭右开的区间里，[left, right)
            while (left <= right) { // 当left==right，区间[left, right)无效
                int mid = left + (right - left) / 2;
                if (target == nums[mid]) {
                    return mid; // target 在左区间，在[left, middle)中
                } else if (target > nums[mid]) {
                    left = mid + 1; // target 在右区间，在 [middle+1, right)中
                } else {
                    right = mid;
                }
            }
            // 分别处理如下四种情况
            // 目标值在数组所有元素之前 [0,0)
            // 目标值等于数组中某一个元素 return middle
            // 目标值插入数组中的位置 [left, right) ，return right 即可
            // 目标值在数组所有元素之后的情况 [left, right)，因为是右开区间，所以 return right
            return right + 1;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}