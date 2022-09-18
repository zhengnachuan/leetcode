//你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。 
//
// 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。 
//
// 
//
// 示例 1： 
//
// 
//输入：name = "alex", typed = "aaleex"
//输出：true
//解释：'alex' 中的 'a' 和 'e' 被长按。
// 
//
// 示例 2： 
//
// 
//输入：name = "saeed", typed = "ssaaedd"
//输出：false
//解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= name.length, typed.length <= 1000 
// name 和 typed 的字符都是小写字母 
// 
// Related Topics双指针 | 字符串 
//
// 👍 246, 👎 0 
//
//
//
//

package leetcode.editor.cn;

//Java：长按键入
public class LongPressedName {
    public static void main(String[] args) {
        Solution solution = new LongPressedName().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isLongPressedName(String name, String typed) {
            int i = 0;
            int j = 0;
            int m = name.length();
            int n = typed.length();
            while (i < m && j < n) {
                if (name.charAt(i) == typed.charAt(j)) {
                    i++;
                    j++;
                    continue;
                }
                if (j == 0) {
                    return false;
                }
                while (typed.charAt(j) == typed.charAt(j - 1) && j < n - 1) {
                    j++;
                }
                if (name.charAt(i) != typed.charAt(j)) {
                    return false;
                }
                i++;
                j++;
            }
            if (i < m) {
                return false;
            }
            while (j < n) {
                if (typed.charAt(j) != typed.charAt(j - 1)) {
                    return false;
                }
                j++;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}