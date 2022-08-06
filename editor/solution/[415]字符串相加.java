//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。 
//
// 
//
// 提示： 
//
// 
// num1 和num2 的长度都小于 5100 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式 
// 
// Related Topics 数学 字符串 模拟 
// 👍 437 👎 0

package leetcode.editor.cn;

//Java：字符串相加
public class AddStrings {
    public static void main(String[] args) {
        Solution solution = new AddStrings().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addStrings(String num1, String num2) {
            int left = num1.length() - 1;
            int right = num2.length() - 1;
            int d = 0;
            StringBuilder res = new StringBuilder();
            while (left >= 0 || right >= 0) {
                int a = left >= 0 ? num1.charAt(left) - '0' : 0;
                int b = right >= 0 ? num2.charAt(right) - '0' : 0;
                int c = (a + b + d) % 10;
                d = (a + b + d) / 10;
                res.append(c);
                left--;
                right--;
            }
            if (d > 0) {
                res.append(d);
            }
            return res.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}