//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 
// 👍 638 👎 0

package leetcode.editor.cn;

import org.apache.commons.math.linear.ArrayRealVector;
import org.hibernate.validator.constraints.EAN;
import org.jetbrains.annotations.NotNull;

import java.util.*;

//Java：二叉树的前序遍历
public class BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePreorderTraversal().new Solution();
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
        List<Integer> res = new ArrayList<>();

        public List<Integer> preorderTraversal(TreeNode root) {
            this.iteration(root);
//            this.recursion(root);
            return res;
        }

        public void iteration(TreeNode root) {
            if (root == null) {
                return;
            }
            Stack<TreeNode> pq = new Stack<>();
            pq.push(root);
            while (!pq.isEmpty()) {
                TreeNode node = pq.pop();
                res.add(node.val);
                if (node.right != null) {
                    pq.push(node.right);
                }
                if (node.left != null) {
                    pq.push(node.left);
                }
            }
        }

        public void recursion(TreeNode root) {
            if (root == null) {
                return;
            }
            res.add(root.val);
            this.recursion(root.left);
            this.recursion(root.right);
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}