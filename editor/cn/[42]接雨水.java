//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
// Related Topics栈 | 数组 | 双指针 | 动态规划 | 单调栈 
//
// 👍 3792, 👎 0 
//
//
//
//

package leetcode.editor.cn;

import java.util.Stack;

//Java：接雨水
public class TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 双指针
        public int trap1(int[] height) {

            int res = 0;
            for (int i = 0; i < height.length; i++) {
                int rHeight = height[i];
                int lHeight = height[i];
                for (int r = i; r < height.length; r++) {
                    rHeight = Math.max(rHeight, height[r]);
                }
                for (int l = i; l >= 0; l--) {
                    lHeight = Math.max(lHeight, height[l]);
                }
                res += Math.min(rHeight, lHeight) - height[i];
            }
            return res;
        }

        // dp
        public int trap2(int[] height) {

            int[] lMax = new int[height.length];
            int[] rMax = new int[height.length];
            lMax[0] = height[0];
            for (int i = 1; i < height.length; i++) {
                lMax[i] = Math.max(lMax[i - 1], height[i]);
            }
            rMax[height.length - 1] = height[height.length - 1];
            for (int i = height.length - 2; i >= 0; i--) {
                rMax[i] = Math.max(rMax[i + 1], height[i]);
            }
            int res = 0;
            for (int i = 0; i < height.length; i++) {
                res += Math.min(lMax[i], rMax[i]) - height[i];
            }
            return res;
        }

        // 单调栈 https://leetcode.cn/problems/trapping-rain-water/solution/dan-diao-zhan-jie-jue-jie-yu-shui-wen-ti-by-sweeti/
        public int trap(int[] height) {

            Stack<Integer> stack = new Stack<>();
            stack.push(0);
            int res = 0;
            for (int i = 1; i < height.length; i++) {

                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    int curIdx = stack.pop();
                    // 如果栈顶元素一直相等，那么全都pop出去，只留第一个。
                    while (!stack.isEmpty() && height[stack.peek()] == height[curIdx]) {
                        stack.pop();
                    }
                    if (!stack.isEmpty()) {
                        int stackTop = stack.peek();
                        // stackTop此时指向的是此次接住的雨水的左边界的位置。右边界是当前的柱体，即i。
                        // Math.min(height[stackTop], height[i]) 是左右柱子高度的min，减去height[curIdx]就是雨水的高度。
                        // i - stackTop - 1 是雨水的宽度。
                        int h = Math.min(height[stackTop], height[i]) - height[curIdx];
                        int w = i - stackTop - 1;
                        res += h * w;
                    }
                }
                stack.push(i);
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}