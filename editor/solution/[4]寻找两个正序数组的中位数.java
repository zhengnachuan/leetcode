//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 
//输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 
//输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
//
// 
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？ 
// Related Topics 数组 二分查找 分治 
// 👍 4471 👎 0

package leetcode.editor.cn;

import com.alibaba.druid.sql.visitor.functions.Left;
import com.alibaba.druid.sql.visitor.functions.Right;

import java.time.temporal.Temporal;

//Java：寻找两个正序数组的中位数
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int l1 = 0, r1 = nums1.length - 1;
            int l2 = 0, r2 = nums2.length - 1;
            int k = (r1 + r2 + 1) / 2;
            int m = r1 / 2;
            int n = k - m;
            int a = nums1[m];
            int b = nums2[n];
            while (true) {
                System.out.println("m:" + m + ",n:" + n);
                if (a == b) {
                    return a;
                } else if (a < b) {
                    r2 = n - 1;
                    n = (l2 + r2) / 2;
                    l1 = m + 1;
                    m = k - n;
                } else if (a > b) {
                    r1 = m - 1;
                    m = (l1 + r1) / 2;
                    l2 = n + 1;
                    n = k - m;
                }

                a = nums1[m];
                b = nums2[n];
            }
//            return a;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}