//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 4047 👎 0

package leetcode.editor.cn;

//Java：最长回文子串
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            return expand(s);
        }

        public String expand(String s) {
            if (s == null || s.length() < 1) {
                return "";
            }
            int length = s.length();
            int left = 0;
            int right = 0;
            for (int i = 0; i < length; i++) {
                int len1 = checkSize(s, i, i);
                int len2 = checkSize(s, i, i + 1);
                int len = Math.max(len1, len2);
                if (right - left < len) {
                    left = i - (len - 1) / 2;
                    right = i + len / 2;
                }
            }
            return s.substring(left, right + 1);
        }

        public int checkSize(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            return right - left - 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}