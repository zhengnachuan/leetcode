//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层序遍历结果： 
//
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 二叉树 
// 👍 988 👎 0

package leetcode.editor.cn;

import apple.laf.JRSUIUtils;
import org.apache.commons.collections.CollectionUtils;

import java.util.*;

//Java：二叉树的层序遍历
public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)

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
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return res;
            }
//            this.recursion(Arrays.asList(root));
            this.iteration(root);
            return res;
        }

        // 递归
        public void recursion(List<TreeNode> list) {
            List<TreeNode> subList = new ArrayList<>();
            List<Integer> subRes = new ArrayList<>();
            for (TreeNode treeNode : list) {
                subRes.add(treeNode.val);
                if (treeNode.left != null) {
                    subList.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    subList.add(treeNode.right);
                }
            }
            res.add(subRes);
            if (!subList.isEmpty()) {
                this.recursion(subList);
            }
        }

        // 迭代
        public void iteration(TreeNode root) {

            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            List<Integer> subRes = null;
            while (!queue.isEmpty()) {
                int size = queue.size();
                subRes = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    subRes.add(node.val);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                res.add(subRes);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}