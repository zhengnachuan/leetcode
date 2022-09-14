//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
// 
//
// 示例 2： 
//
// 
//
// 
//输入： heights = [2,4]
//输出： 4 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=10⁵ 
// 0 <= heights[i] <= 10⁴ 
// 
// Related Topics栈 | 数组 | 单调栈 
//
// 👍 2155, 👎 0 
//
//
//
//

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

//Java：柱状图中最大的矩形
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution solution = new LargestRectangleInHistogram().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // dp
        public int largestRectangleArea1(int[] heights) {

            int[] lMin = new int[heights.length];
            int[] rMax = new int[heights.length];
            // 记录左边第一个小于该柱子的下标
            lMin[0] = -1;
            for (int i = 1; i < heights.length; i++) {
                int t = i - 1;
                while (t >= 0 && heights[t] >= heights[i]) {
                    t = lMin[t];
                }
                lMin[i] = t;
            }
            // 记录每个柱子 右边第一个小于该柱子的下标
            rMax[heights.length - 1] = heights.length;
            for (int i = heights.length - 2; i >= 0; i--) {
                int t = i + 1;
                while (t < heights.length && heights[t] >= heights[i]) {
                    t = rMax[t];
                }
                rMax[i] = t;
            }
            int res = 0;
            for (int i = 0; i < heights.length; i++) {
                int sum = heights[i] * (rMax[i] - lMin[i] - 1);
                res = Math.max(sum, res);
            }
            return res;
        }

        public int largestRectangleArea(int[] heights) {

            // 数组扩容，在头和尾各加入一个元素
            int[] newHeights = new int[heights.length + 2];
            System.arraycopy(heights, 0, newHeights, 1, heights.length);

            Stack<Integer> stack = new Stack<>();
            stack.push(0);
            int res = 0;

            for (int i = 0; i < newHeights.length; i++) {
                // 对栈中柱体来说，栈中的下一个柱体就是其「左边第一个小于自身的柱体」；
                // 若当前柱体 i 的高度小于栈顶柱体的高度，说明 i 是栈顶柱体的「右边第一个小于栈顶柱体的柱体」。
                // 因此以栈顶柱体为高的矩形的左右宽度边界就确定了，可以计算面积🌶️ ～
                while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {
                    int h = newHeights[stack.pop()];
                    res = Math.max(res, (i - stack.peek() - 1) * h);
                }
                stack.push(i);
            }

            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}