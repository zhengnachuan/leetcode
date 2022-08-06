//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics栈 | 字符串 
//
// 👍 3425, 👎 0 
//
//
//
//

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

//Java：有效的括号
public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (c == '{') {
                    stack.push('}');
                } else if (c == '[') {
                    stack.push(']');
                } else if (c == '(') {
                    stack.push(')');
                } else if (!stack.isEmpty() && c == stack.peek()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
            return stack.empty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}