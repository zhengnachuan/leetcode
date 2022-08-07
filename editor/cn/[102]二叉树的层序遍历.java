//给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[9,20],[15,7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics树 | 广度优先搜索 | 二叉树 
//
// 👍 1414, 👎 0 
//
//
//
//

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

//Java：二叉树的层序遍历
public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
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
        public List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> levelOrder(TreeNode root) {

//            this.fun1(root);
            this.fun2(root, 0);
            return result;
        }

        public void fun1(TreeNode node) {
            if (node == null) {
                return;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(node);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> list = new ArrayList<>();
                while (size > 0) {
                    TreeNode temp = queue.poll();
                    list.add(temp.val);
                    if (temp.left != null) {
                        queue.offer(temp.left);
                    }
                    if (temp.right != null) {
                        queue.offer(temp.right);
                    }
                    size--;
                }
                result.add(list);
            }
        }

        public void fun2(TreeNode node, int deep) {
            if (node == null) {
                return;
            }
            deep++;
            if (result.size() < deep) {
                //当层级增加时，list的Item也增加，利用list的索引值进行层级界定
                List<Integer> item = new ArrayList<>();
                result.add(item);
            }
            result.get(deep - 1).add(node.val);

            this.fun2(node.left, deep);
            this.fun2(node.right, deep);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}