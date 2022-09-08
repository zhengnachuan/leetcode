//给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。 
//
// 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
// 
//
// 示例 2： 
//
// 
//输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
//     注意，你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 
//输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 300 
// 1 <= wordDict.length <= 1000 
// 1 <= wordDict[i].length <= 20 
// s 和 wordDict[i] 仅有小写英文字母组成 
// wordDict 中的所有字符串 互不相同 
// 
// Related Topics字典树 | 记忆化搜索 | 哈希表 | 字符串 | 动态规划 
//
// 👍 1787, 👎 0 
//
//
//
//

package leetcode.editor.cn;

import java.util.List;

//Java：单词拆分
public class WordBreak {
    public static void main(String[] args) {
        Solution solution = new WordBreak().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 本题还有特殊性，因为是要求子串，最好是遍历背包放在外循环，将遍历物品放在内循环
        // 如果要是外层for循环遍历物品，内层for遍历背包，就需要把所有的子串都预先放在一个容器里
        public boolean wordBreak(String s, List<String> wordDict) {
            boolean[] valid = new boolean[s.length() + 1];
            valid[0] = true;
            // 遍历背包
            for (int i = 1; i <= s.length(); i++) {
                // 遍历物品
                for (int j = 0; j < i; j++) {
                    // [0, i] 的字符串可被拆分，当且仅当任一子串 [0, j] 及 [j, i] 可被拆分
                    if (valid[j] && wordDict.contains(s.substring(j, i)) ) {
                        valid[i] = true;
                        break;
                    }
                }
            }
            return valid[s.length()];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}