//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。 
//
// 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
// Related Topics数组 | 哈希表 | 字符串 | 排序 
//
// 👍 1193, 👎 0 
//
//
//
//

package leetcode.editor.cn;

//Java：字母异位词分组
public class GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String s : strs) {
                String code = this.encode1(s);
                map.putIfAbsent(code, new LinkedList<>());
                map.get(code).add(s);
            }
            List<List<String>> res = new LinkedList<>();

            for (List<String> list : map.values()) {
                res.add(list);
            }
            return res;
        }

        private String encode(String s) {
            char[] count = new char[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            return new String(count);
        }

        private String encode1(String s) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            return new String(c);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}