//给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。 
//
// 
//
// 示例： 
//
// 输入：
//A: [1,2,3,2,1]
//B: [3,2,1,4,7]
//输出：3
//解释：
//长度最长的公共子数组是 [3, 2, 1] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= len(A), len(B) <= 1000 
// 0 <= A[i], B[i] < 100 
// 
// Related Topics 数组 二分查找 动态规划 滑动窗口 哈希函数 滚动哈希 
// 👍 535 👎 0

package leetcode.editor.cn;

import com.alibaba.druid.sql.visitor.functions.Left;
import com.alibaba.druid.sql.visitor.functions.Right;

//Java：最长重复子数组
public class MaximumLengthOfRepeatedSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumLengthOfRepeatedSubarray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLength(int[] nums1, int[] nums2) {
            return this.dp(nums1, nums2);
//            return nums1.length > nums2.length ? this.window(nums2, nums1) : this.window(nums1, nums2);
        }

        public int dp(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;
            // 以i,j结尾的相同子数组长度
            int[][] dp = new int[m + 1][n + 1];
            int res = 0;
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (nums1[i - 1] == nums2[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    res = Math.max(res, dp[i][j]);
                }
            }
            return res;
        }

        public int window(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;
            int res = 0;
            for (int i = 1; i <= m; i++) {
                res = Math.max(res, maxLength(nums1, 0, nums2, n - i, i));
            }
            for (int i = m - n; i >= 0; i--) {
                res = Math.max(res, maxLength(nums1, 0, nums2, i, m));
            }
            for (int i = 1; i < m; i++) {
                res = Math.max(res, maxLength(nums1, i, nums2, 0, m - i));
            }
            return res;
        }

        public int maxLength(int[] nums1, int left1, int[] nums2, int left2, int length) {
            int count = 0;
            int max = 0;
            for (int i = 0; i < length; i++) {
                if (nums1[left1 + i] == nums2[left2 + i]) {
                    count++;
                } else {
                    max = Math.max(max, count);
                    count = 0;
                }
            }
            return Math.max(max, count);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}