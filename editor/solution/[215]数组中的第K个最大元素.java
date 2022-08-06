//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 
// 👍 1256 👎 0

package leetcode.editor.cn;

import javafx.geometry.Pos;

import java.util.PriorityQueue;

//Java：数组中的第K个最大元素
public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
//            return queqe(nums, k);
            return quickSort(nums, k);
        }

        // 优先队列
        public int queqe(int[] nums, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            int i = 0;

            while (i < nums.length) {
                queue.add(nums[i]);
                if (queue.size() > k) {
                    queue.poll();
                }
                i++;
            }
            return queue.peek();
        }

        // 快排
        public int quickSort(int[] nums, int k) {
            int length = nums.length;
            int left = 0;
            int right = length - 1;

            int target = length - k;

            while (true) {
                int pos = quickSort(left, right, nums);
                if (pos == target) {
                    return nums[pos];
                } else if (pos > target) {
                    right = pos - 1;
                } else {
                    left = pos + 1;
                }
            }
        }

        // 快排
        public int quickSort(int left, int right, int[] nums) {
            int num = nums[left];
            while (left < right) {
                while (left < right && nums[right] >= num) {
                    right--;
                }
                nums[left] = nums[right];
                while (left < right && nums[left] <= num) {
                    left++;
                }
                nums[right] = nums[left];
            }
            nums[left] = num;
            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}