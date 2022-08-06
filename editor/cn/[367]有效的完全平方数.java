//给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。 
//
// 进阶：不要 使用任何内置的库函数，如 sqrt 。 
//
// 
//
// 示例 1： 
//
// 
//输入：num = 16
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：num = 14
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num <= 2^31 - 1 
// 
// Related Topics数学 | 二分查找 
//
// 👍 408, 👎 0 
//
//
//
//

package leetcode.editor.cn;

//Java：有效的完全平方数
public class ValidPerfectSquare {
    public static void main(String[] args) {
        Solution solution = new ValidPerfectSquare().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPerfectSquare(int num) {
            if (num == 1) {
                return true;
            }
            int min = 1;
            int max = num / 2;
            while (min <= max) {
                int mid = min + (max - min) / 2;
                int res = num / mid;
                if (mid == res) {
                    return mid * mid == num;
                } else if (res > mid) {
                    min = mid + 1;
                } else {
                    max = mid - 1;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}