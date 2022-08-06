//给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abab"
//输出: true
//解释: 可由子串 "ab" 重复两次构成。
// 
//
// 示例 2: 
//
// 
//输入: s = "aba"
//输出: false
// 
//
// 示例 3: 
//
// 
//输入: s = "abcabcabcabc"
//输出: true
//解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
// 
//
// 
//
// 提示： 
//
// 
//
// 
// 1 <= s.length <= 10⁴ 
// s 由小写英文字母组成 
// 
// Related Topics字符串 | 字符串匹配 
//
// 👍 733, 👎 0 
//
//
//
//

package leetcode.editor.cn;

//Java：重复的子字符串
public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        Solution solution = new RepeatedSubstringPattern().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean repeatedSubstringPattern(String s) {
            if (s.length() == 0) {
                return false;
            }
            int[] next = this.getNext(s);
            int size = s.length();
            int l = next[size - 1];
            return l != 0 && size % (size - l) == 0;
        }

        public int[] getNext(String s) {
            int[] next = new int[s.length()];
            // i：后缀末尾，j：前缀末尾
            for (int i = 1, j = 0; i < s.length(); i++) {
                // 一直和前一位置的值比较，直到遇到相等的字符或者j=0；j通过next[j-1]来回退
                while (j > 0 && s.charAt(i) != s.charAt(j)) {
                    j = next[j - 1];
                }
                if (s.charAt(i) == s.charAt(j)) {
                    j++;
                }
                next[i] = j;
            }
            return next;
        }
        // https://leetcode.cn/problems/repeated-substring-pattern/solution/jian-dan-ming-liao-guan-yu-javaliang-xing-dai-ma-s/
        public boolean repeatedSubstringPattern1(String s) {
            String str = s + s;
            return str.substring(1, str.length() - 1).contains(s);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}