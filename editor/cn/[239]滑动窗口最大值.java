//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回 滑动窗口中的最大值 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
// Related Topics队列 | 数组 | 滑动窗口 | 单调队列 | 堆（优先队列） 
//
// 👍 1764, 👎 0 
//
//
//
//

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

//Java：滑动窗口最大值
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class MyQueue {
        Deque<Integer> deque = new ArrayDeque<>();

        void poll(Integer val) {
            if (!deque.isEmpty() && Objects.equals(deque.peek(), val)) {
                deque.poll();
            }
        }

        void add(Integer val) {
            while (!deque.isEmpty() && deque.getLast() < val) {
                deque.removeLast();
            }
            deque.add(val);
        }

        Integer peek() {
            return deque.peek();
        }

    }

    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            MyQueue queue = new MyQueue();
            int i = 0;
            for (; i < k; i++) {
                queue.add(nums[i]);
            }
            int[] res = new int[nums.length - k + 1];
            res[0] = queue.peek();
            System.out.println(i);
            for (; i < nums.length; i++) {
                queue.add(nums[i]);
                queue.poll(nums[i - k]);
                res[i - k + 1] = queue.peek();
            }

            return res;
        }

    }

//leetcode submit region end(Prohibit modification and deletion)

}