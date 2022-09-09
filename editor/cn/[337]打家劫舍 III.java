//小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。 
//
// 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接
//相连的房子在同一天晚上被打劫 ，房屋将自动报警。 
//
// 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: root = [3,2,3,null,3,null,1]
//输出: 7 
//解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7 
//
// 示例 2: 
//
// 
//
// 
//输入: root = [3,4,5,1,3,null,1]
//输出: 9
//解释: 小偷一晚能够盗取的最高金额 4 + 5 = 9
// 
//
// 
//
// 提示： 
//
// 
//
// 
// 树的节点数在 [1, 10⁴] 范围内 
// 0 <= Node.val <= 10⁴ 
// 
// Related Topics树 | 深度优先搜索 | 动态规划 | 二叉树 
//
// 👍 1429, 👎 0 
//
//
//
//

package leetcode.editor.cn;

//Java：打家劫舍 III
public class HouseRobberIii {
    public static void main(String[] args) {
        Solution solution = new HouseRobberIii().new Solution();
        // TO TEST
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public int rob(TreeNode root) {
            int[] res = dp(root);
            return Math.max(res[0], res[1]);
        }

        // 状态标记递归
        // 不偷：Max(左孩子不偷，左孩子偷) + Max(右孩子不偷，右孩子偷)
        // 偷：左孩子不偷+ 右孩子不偷 + 当前节点偷
        // root[1] = rob(root.left)[0] + rob(root.right)[0] + root.val;
        public int[] dp(TreeNode root) {
            int[] dp = new int[2];
            if (root == null) {
                return dp;
            }

            int[] left = dp(root.left);
            int[] right = dp(root.right);

            dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
            dp[1] = root.val + left[0] + right[0];
            return dp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}