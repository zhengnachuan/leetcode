//给你一个字符串数组 words ，请你找出所有在 words 的每个字符串中都出现的共用字符（ 包括重复字符），并以数组形式返回。你可以按 任意顺序 返回答
//案。
// 
//
// 示例 1： 
//
// 
//输入：words = ["bella","label","roller"]
//输出：["e","l","l"]
// 
//
// 示例 2： 
//
// 
//输入：words = ["cool","lock","cook"]
//输出：["c","o"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 100 
// 1 <= words[i].length <= 100 
// words[i] 由小写英文字母组成 
// 
// Related Topics数组 | 哈希表 | 字符串 
//
// 👍 295, 👎 0 
//
//
//
//

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：查找共用字符
public class FindCommonCharacters {
    public static void main(String[] args) {
        Solution solution = new FindCommonCharacters().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> commonChars(String[] words) {
            int[] dict = new int[26];
            for (char c : words[0].toCharArray()) {
                dict[c - 'a']++;
            }
            for (String word : words) {
                int[] temp = new int[26];
                for (char c : word.toCharArray()) {
                    temp[c - 'a']++;
                }
                for (int i = 0; i < 26; i++) {
                    dict[i] = Math.min(dict[i], temp[i]);
                }
            }
            List<String> res = new ArrayList<>();
            for (int i = 0; i < 26; i++) {
                while (dict[i] != 0) {
                    res.add(String.valueOf((char) (i + 'a')));
                    dict[i]--;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}