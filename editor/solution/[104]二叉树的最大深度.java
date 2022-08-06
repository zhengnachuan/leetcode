//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 957 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

//Java：二叉树的最大深度
public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfBinaryTree().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
//    public class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//
//        TreeNode() {
//        }
//
//        TreeNode(int val) {
//            this.val = val;
//        }
//
//        TreeNode(int val, TreeNode left, TreeNode right) {
//            this.val = val;
//            this.left = left;
//            this.right = right;
//        }
//    }

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

        public int maxDepth(TreeNode root) {
//            return this.recursion(root);
            return this.iteration(root);
        }

        public int recursion(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(this.recursion(root.left), this.recursion(root.right)) + 1;
        }

        public int iteration(TreeNode root) {
            int res = 0;
            if (root == null) {
                return res;
            }
            Queue<TreeNode> pq = new ArrayDeque<>();
            pq.offer(root);

            while (!pq.isEmpty()) {
                res++;
                int size = pq.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = pq.poll();
                    if (node.left != null) {
                        pq.offer(node.left);
                    }
                    if (node.right != null) {
                        pq.offer(node.right);
                    }
                }
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}