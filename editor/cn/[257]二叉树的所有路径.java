//给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。 
//
// 叶子节点 是指没有子节点的节点。 
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3,null,5]
//输出：["1->2->5","1->3"]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：["1"]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 100] 内 
// -100 <= Node.val <= 100 
// 
// Related Topics树 | 深度优先搜索 | 字符串 | 回溯 | 二叉树 
//
// 👍 794, 👎 0 
//
//
//
//

package leetcode.editor.cn;

//Java：二叉树的所有路径
public class BinaryTreePaths {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePaths().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            List<Integer> paths = new ArrayList<>();
            this.traversal(root, paths, res);
            return res;
        }

        private void traversal(TreeNode root, List<Integer> paths, List<String> res) {
            paths.add(root.val);
            // 找到叶子节点，就开始结束的处理逻辑
            if (root.left == null && root.right == null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < paths.size() - 1; i++) {
                    sb.append(paths.get(i)).append("->");
                }
                sb.append(paths.get(paths.size() - 1));
                res.add(sb.toString());
                return;
            }
            if (root.left != null) {
                this.traversal(root.left, paths, res);
                paths.remove(paths.size() - 1);
            }
            if (root.right != null) {
                this.traversal(root.right, paths, res);
                paths.remove(paths.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}