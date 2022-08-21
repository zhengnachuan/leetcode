//有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
// 
//
// 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新
//排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// s 仅由数字组成 
// 
// Related Topics字符串 | 回溯 
//
// 👍 998, 👎 0 
//
//
//
//

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：复原 IP 地址
public class RestoreIpAddresses {
    public static void main(String[] args) {
        Solution solution = new RestoreIpAddresses().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<String> result = new ArrayList<>();
        public List<String> path = new ArrayList<>();

        public List<String> restoreIpAddresses(String s) {
            this.backtrack(s, 0);
            return result;
        }

        public void backtrack(String s, int start) {
            if (path.size() == 4) {
                if (start == s.length()) {
                    StringBuilder sb = new StringBuilder();
                    for (String str : path) {
                        sb.append(str).append('.');
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    result.add(sb.toString());
                }
                return;
            }

            for (int i = start; i < s.length(); i++) {
                if (!isIpAddress(s, start, i)) {
                    continue;
                }
                System.out.println(s.substring(start, i + 1));
                path.add(s.substring(start, i + 1));
                this.backtrack(s, i + 1);
                path.remove(path.size() - 1);
            }
        }

        public boolean isIpAddress(String s, int left, int right) {

            if (left != right && s.charAt(left) == '0') {
                return false;
            }
            int num = 0;
            for (int i = left; i <= right; i++) {
                num = num * 10 + s.charAt(i) - '0';
                if (num > 255) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}