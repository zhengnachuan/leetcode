//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
// Related Topics字符串 | 动态规划 | 回溯 
//
// 👍 1244, 👎 0 
//
//
//
//

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：分割回文串
public class PalindromePartitioning {
    public static void main(String[] args) {
        Solution solution = new PalindromePartitioning().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<String>> result = new ArrayList<>();
        public List<String> path = new ArrayList<>();

        public List<List<String>> partition(String s) {

            this.backtrack(s, 0);
            return result;
        }

        public void backtrack(String s, int start) {

            if (start == s.length()) {
                result.add(new ArrayList<>(path));
                return;
            }

            for (int i = start; i < s.length(); i++) {
                if (!isPalindrome(s, start, i)) {
                    continue;
                }
                path.add(s.substring(start, i + 1));
                this.backtrack(s, i + 1);
                path.remove(path.size() - 1);
            }
        }

        public boolean isPalindrome(String s, int left, int right) {
            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}