//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层序遍历如下： 
//
// 
//[
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 二叉树 
// 👍 508 👎 0

package leetcode.editor.cn;

import jdk.nashorn.internal.runtime.RecompilableScriptFunctionData;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Java：二叉树的锯齿形层序遍历
public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeZigzagLevelOrderTraversal().new Solution();
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

        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            return this.iteration(root);
        }

        public List<List<Integer>> iteration(TreeNode root) {

            List<List<Integer>> res = new LinkedList<>();
            if (root == null) {
                return res;
            }
            boolean leftFlag = true;
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            LinkedList<Integer> subRes = null;
            while (!queue.isEmpty()) {
                int size = queue.size();
                subRes = new LinkedList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (leftFlag) {
                        subRes.addLast(node.val);
                    } else {
                        subRes.addFirst(node.val);
                    }

                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                leftFlag = !leftFlag;
                res.add(subRes);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}