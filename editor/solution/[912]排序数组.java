//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50000 
// -50000 <= nums[i] <= 50000 
// 
// Related Topics 数组 分治 桶排序 计数排序 基数排序 排序 堆（优先队列） 归并排序 
// 👍 359 👎 0

package leetcode.editor.cn;

import com.alibaba.fastjson.JSON;

//Java：排序数组
public class SortAnArray {
    public static void main(String[] args) {
        Solution solution = new SortAnArray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArray(int[] nums) {
            this.quickSort(nums, 0, nums.length - 1);
            return nums;
        }

        public void quickSort(int[] nums, int left, int right) {
            if (left >= right) {
                return;
            }
            int low = left;
            int high = right;
            int num = nums[left];
            while (low < high) {
                while (low < high && nums[high] >= num) {
                    high--;
                }
                if (low < high) {
                    nums[low] = nums[high];
                }
                while (low < high && nums[low] <= num) {
                    low++;
                }
                if (low < high) {
                    nums[high] = nums[low];
                }
            }
            nums[low] = num;

            // 左
            quickSort(nums, left, low - 1);
            // 右
            quickSort(nums, low + 1, right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}