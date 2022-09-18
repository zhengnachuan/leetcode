//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。 
//
// 返回符合要求的 最少分割次数 。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：1
//解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：s = "ab"
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2000 
// s 仅由小写英文字母组成 
// 
// 
// 
// Related Topics字符串 | 动态规划 
//
// 👍 619, 👎 0 
//
//
//
//

package leetcode.editor.cn;

//Java：分割回文串 II
public class PalindromePartitioningIi {
    public static void main(String[] args) {
        Solution solution = new PalindromePartitioningIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCut(String s) {
            int length = s.length();
            // 计算是否回文串
            boolean[][] dp = new boolean[length][length];
            for (int i = length - 1; i >= 0; i--) {
                for (int j = i; j < length; j++) {
                    if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i + 1][j - 1])) {
                        dp[i][j] = true;
                    }
                }
            }
            int[] cnt = new int[length];
            for (int i = 0; i < length; i++) {
                cnt[i] = i;
            }
            for (int i = 1; i < length; i++) {
                if (dp[0][i]) {
                    cnt[i] = 0;
                    continue;
                }
                for (int j = 0; j < i; j++) {
                    if (dp[j + 1][i]) {
                        cnt[i] = Math.min(cnt[i], cnt[j] + 1);
                    }
                }
            }
            return cnt[length - 1];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}