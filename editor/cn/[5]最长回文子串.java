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
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// s 仅由数字和英文字母组成
//
// Related Topics字符串 | 动态规划
//
// 👍 5715, 👎 0
//
//
//
//

package leetcode.editor.cn;

//Java：最长回文子串
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 1、中心扩散；2、dp
        public String longestPalindrome(String s) {

            boolean[][] dp = new boolean[s.length()][s.length()];
            int left = 0;
            int right = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                for (int j = i; j < s.length(); j++) {
                    if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i + 1][j - 1])) {
                        dp[i][j] = true;
                    }
                    if (dp[i][j] && j - i + 1 > right - left + 1) {
                        left = i;
                        right = j;
                    }
                }
            }
            return s.substring(left, right + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}