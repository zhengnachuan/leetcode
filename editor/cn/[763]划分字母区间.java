//字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
//
// 
//
// 示例： 
//
// 
//输入：S = "ababcbacadefegdehijhklij"
//输出：[9,7,8]
//解释：
//划分结果为 "ababcbaca", "defegde", "hijhklij"。
//每个字母最多出现在一个片段中。
//像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
// 
//
// 
//
// 提示： 
//
// 
// S的长度在[1, 500]之间。 
// S只包含小写字母 'a' 到 'z' 。 
// 
// Related Topics贪心 | 哈希表 | 双指针 | 字符串 
//
// 👍 807, 👎 0 
//
//
//
//

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：划分字母区间
public class PartitionLabels {
    public static void main(String[] args) {
        Solution solution = new PartitionLabels().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> partitionLabels(String s) {
            char[] chars = s.toCharArray();
            int[] edge = new int[26];
            for (int i = 0; i < chars.length; i++) {
                edge[chars[i] - 'a'] = i;
            }
            List<Integer> list = new ArrayList<>();
            int idx = 0;
            int start = -1;
            for (int i = 0; i < chars.length; i++) {
                idx = Math.max(idx, edge[chars[i] - 'a']);
                if (idx == i) {
                    list.add(idx - start);
                    start = idx;
                }
            }
            return list;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}