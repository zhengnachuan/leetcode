//给你一个字符串 s ，颠倒字符串中 单词 的顺序。 
//
// 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。 
//
// 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。 
//
// 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "the sky is blue"
//输出："blue is sky the"
// 
//
// 示例 2： 
//
// 
//输入：s = "  hello world  "
//输出："world hello"
//解释：颠倒后的字符串中不能存在前导空格和尾随空格。
// 
//
// 示例 3： 
//
// 
//输入：s = "a good   example"
//输出："example good a"
//解释：如果两个单词间有多余的空格，颠倒后的字符串需要将单词间的空格减少到仅有一个。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 包含英文大小写字母、数字和空格 ' ' 
// s 中 至少存在一个 单词 
// 
//
// 
// 
//
// 
//
// 进阶：如果字符串在你使用的编程语言中是一种可变数据类型，请尝试使用 O(1) 额外空间复杂度的 原地 解法。 
// Related Topics双指针 | 字符串 
//
// 👍 596, 👎 0 
//
//
//
//

package leetcode.editor.cn;

//Java：颠倒字符串中的单词
public class ReverseWordsInAString {
    public static void main(String[] args) {
        Solution solution = new ReverseWordsInAString().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {

            StringBuilder sb = this.eraseSpace(s);
            this.reverseWord(sb, 0, sb.length() - 1);
            int i = 0;
            while (i < sb.length()) {
                int j = i;
                while (j < sb.length() && sb.charAt(j) != ' ') {
                    j++;
                }
                this.reverseWord(sb, i, j - 1);
                i = j + 1;
            }
            return sb.toString();
        }

        private StringBuilder eraseSpace(String s) {

            int left = 0;
            int right = s.length() - 1;
            while (s.charAt(left) == ' ') {
                left++;
            }
            while (s.charAt(right) == ' ') {
                right--;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = left; i <= right; i++) {
                if (s.charAt(i) != ' ' || s.charAt(i - 1) != ' ') {
                    sb.append(s.charAt(i));
                }
            }
            return sb;
        }

        private void reverseWord(StringBuilder sb, int left, int right) {
            while (left < right) {
                char temp = sb.charAt(left);
                sb.setCharAt(left, sb.charAt(right));
                sb.setCharAt(right, temp);
                left++;
                right--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}