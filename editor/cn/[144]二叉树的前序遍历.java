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
// Related Topics栈 | 树 | 深度优先搜索 | 二叉树 
//
// 👍 878, 👎 0 
//
//
//
//

package leetcode.editor.cn;

//Java：二叉树的前序遍历
public class BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePreorderTraversal().new Solution();
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
        public List<Integer> preorderTraversal1(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            this.traverse(root, result);
            return result;
        }

        public void traverse(TreeNode node, List<Integer> result) {
            if (node == null) {
                return;
            }
            result.add(node.val);
            this.traverse(node.left, result);
            this.traverse(node.right, result);
        }

        // 前序遍历顺序：中-左-右，入栈顺序：中-右-左
        public List<Integer> preorderTraversal(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                result.add(node.val);
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
            return result;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}