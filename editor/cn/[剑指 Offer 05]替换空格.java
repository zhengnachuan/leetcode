//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// Related Topics字符串 
//
// 👍 314, 👎 0 
//
//
//
//

package leetcode.editor.cn;

//Java：替换空格
public class TiHuanKongGeLcof {
    public static void main(String[] args) {
        Solution solution = new TiHuanKongGeLcof().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String replaceSpace(String s) {
            char[] c = s.toCharArray();
            int cnt = 0;
            for (char i : c) {
                if (i == ' ') {
                    cnt++;
                }
            }
            char[] res = new char[cnt * 2 + c.length];
            int i = c.length - 1;
            int j = res.length - 1;
            while (i >= 0) {
                if (c[i] == ' ') {
                    res[j] = '0';
                    res[j - 1] = '2';
                    res[j - 2] = '%';
                    j -= 3;
                } else {
                    res[j--] = c[i];
                }
                i--;
            }
            return new String(res);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}