//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
// Related Topics回溯 
//
// 👍 1094, 👎 0 
//
//
//
//

package leetcode.editor.cn;

//Java：组合
public class Combinations {
    public static void main(String[] args) {
        Solution solution = new Combinations().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            this.backtrack(1, n, k);
            return result;
        }

        public void backtrack(int start, int n, int k) {
            if (path.size() == k) {
                result.add(new ArrayList<>(path));
                return;
            }
            // 剪枝：i <= n - (k - path.size()) + 1，https://programmercarl.com/0216.组合总和III.html#回溯三部曲
            for (int i = start; i <= n; i++) {
                path.add(i);
                this.backtrack(i + 1, n, k);
                path.remove(path.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}