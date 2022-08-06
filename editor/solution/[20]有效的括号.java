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
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2613 👎 0

package leetcode.editor.cn;

import com.alibaba.druid.sql.visitor.functions.Char;

import java.util.Stack;

//Java：有效的括号
public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Stack<Character> stack = new Stack<>();

        public boolean isValid(String s) {

            for (char c : s.toCharArray()) {
                if (!valid(c)) {
                    return false;
                }
            }
            return stack.isEmpty();
        }

        public boolean valid(char s) {
            if (s == '(' || s == '[' || s == '{') {
                stack.push(s);
                return true;
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char c = stack.pop();
                if (c == '(' && s == ')') {
                    return true;
                } else if (c == '[' && s == ']') {
                    return true;
                } else if (c == '{' && s == '}') {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}