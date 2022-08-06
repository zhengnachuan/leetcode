//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
// Related Topics哈希表 | 字符串 | 滑动窗口 
//
// 👍 943, 👎 0 
//
//
//
//

package leetcode.editor.cn;

//Java：找到字符串中所有字母异位词
public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {

            int sLen = s.length(), pLen = p.length();
            if (sLen < pLen) {
                return new ArrayList<Integer>();
            }
            int[] sCount = new int[26];
            int[] pCount = new int[26];
            for (int i = 0; i < pLen; i++) {
                sCount[s.charAt(i) - 'a']++; //记录s中前pLen个字母的词频
                pCount[p.charAt(i) - 'a']++; //记录要寻找的字符串中每个字母的词频(只用进行一次来确定)
            }
            List<Integer> ans = new ArrayList<Integer>();

            for (int i = 0; i <= sLen - pLen; i++) {
                //判断放置处是否有异位词
                if (Arrays.equals(sCount, pCount)) {
                    ans.add(i);
                }
                if (i == sLen - pLen) {
                    break;
                }
                sCount[s.charAt(i) - 'a']--;
                sCount[s.charAt(i + pLen) - 'a']++;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}