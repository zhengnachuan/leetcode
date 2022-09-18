//给你一棵二叉搜索树，请你返回一棵 平衡后 的二叉搜索树，新生成的树应该与原来的树有着相同的节点值。如果有多种构造方法，请你返回任意一种。 
//
// 如果一棵二叉搜索树中，每个节点的两棵子树高度差不超过 1 ，我们就称这棵二叉搜索树是 平衡的 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,null,2,null,3,null,4,null,null]
//输出：[2,1,3,null,null,null,4]
//解释：这不是唯一的正确答案，[3,1,4,null,2,null,null] 也是一个可行的构造方案。
// 
//
// 示例 2： 
//
// 
//
// 
//输入: root = [2,1,3]
//输出: [2,1,3]
// 
//
// 
//
// 提示： 
//
// 
// 树节点的数目在 [1, 10⁴] 范围内。 
// 1 <= Node.val <= 10⁵ 
// 
// Related Topics贪心 | 树 | 深度优先搜索 | 二叉搜索树 | 分治 | 二叉树 
//
// 👍 144, 👎 0 
//
//
//
//

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：将二叉搜索树变平衡
public class BalanceABinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new BalanceABinarySearchTree().new Solution();
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
        List<Integer> list = new ArrayList<>();

        public TreeNode balanceBST(TreeNode root) {
            this.traverse(root);
            return this.buildTree(0, list.size() - 1);
        }

        public void traverse(TreeNode node) {
            if (node == null) {
                return;
            }
            this.traverse(node.left);
            list.add(node.val);
            this.traverse(node.right);
        }

        public TreeNode buildTree(int start, int end) {
            if (start > end) {
                return null;
            }
            int mid = (end - start) / 2 + start;
            TreeNode result = new TreeNode(list.get(mid));
            result.left = this.buildTree(start, mid - 1);
            result.right = this.buildTree(mid + 1, end);
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}