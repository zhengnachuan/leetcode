//实现 strStr() 函数。 
//
// 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如
//果不存在，则返回 -1 。 
//
// 说明： 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。 
//
// 
//
// 示例 1： 
//
// 
//输入：haystack = "hello", needle = "ll"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：haystack = "aaaaa", needle = "bba"
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= haystack.length, needle.length <= 10⁴ 
// haystack 和 needle 仅由小写英文字符组成 
// 
// Related Topics双指针 | 字符串 | 字符串匹配 
//
// 👍 1500, 👎 0 
//
//
//
//

package leetcode.editor.cn;

//Java：实现 strStr()
public class ImplementStrstr {
    public static void main(String[] args) {
        Solution solution = new ImplementStrstr().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strStr(String haystack, String needle) {
            if (needle.length() == 0) {
                return 0;
            }
            int[] next = this.getNext(needle);
            for (int i = 0, j = 0; i < haystack.length(); i++) {
                while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                    j = next[j - 1];
                }
                if (haystack.charAt(i) == needle.charAt(j)) {
                    j++;
                }
                if (j == needle.length()) {
                    return i - needle.length() + 1;
                }
            }
            return -1;
        }

        public int[] getNext(String s) {
            int[] next = new int[s.length()];
            // i：后缀末尾，j：前缀末尾
            for (int i = 1, j = 0; i < s.length(); i++) {
                // 一直和前一位置的值比较，直到遇到相等的字符或者j=0；j通过next[j-1]来回退
                while (j > 0 && s.charAt(i) != s.charAt(j)) {
                    j = next[j - 1];
                }
                if (s.charAt(i) == s.charAt(j)) {
                    j++;
                }
                next[i] = j;
            }
            return next;
        }

        // https://leetcode.cn/problems/implement-strstr/solution/python3-sundayjie-fa-9996-by-tes/
        public int strStr1(String haystack, String needle) {
            if (needle.length() < 1) {
                return 0;
            }
            if (haystack.length() < 1) {
                return -1;
            }
            int hLength = haystack.length();
            int nLength = needle.length();
            Map<Character, Integer> offset = new HashMap<>();
            for (int i = 0; i < nLength; i++) {
                offset.put(needle.charAt(i), nLength - i);
            }

            int point = 0;
            while (point <= hLength - nLength) {
                if (needle.equals(haystack.substring(point, point + nLength))) {
                    return point;
                } else {
                    int index = point + nLength;
                    if (index > hLength - 1) {
                        return -1;
                    }
                    point += offset.get(haystack.charAt(index)) == null ? nLength + 1 : offset.get(haystack.charAt(index));
                }
            }
            return -1;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}