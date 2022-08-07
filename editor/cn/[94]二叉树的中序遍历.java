//给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
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
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics栈 | 树 | 深度优先搜索 | 二叉树 
//
// 👍 1522, 👎 0 
//
//
//
//

package leetcode.editor.cn;

//Java：二叉树的中序遍历
public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal().new Solution();
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
        public List<Integer> inorderTraversal1(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            this.traverse(root, result);
            return result;
        }

        public void traverse(TreeNode node, List<Integer> result) {
            if (node == null) {
                return;
            }
            this.traverse(node.left, result);
            result.add(node.val);
            this.traverse(node.right, result);
        }

        // 中序遍历顺序: 左-中-右 入栈顺序： 左-右
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            while (cur != null || !stack.isEmpty()) {
                if (cur != null) {
                    stack.push(cur);
                    System.out.println("push" + cur.val);
                    cur = cur.left;
                } else {
                    cur = stack.pop();
                    result.add(cur.val);
                    System.out.println("pop" + cur.val);
                    cur = cur.right;
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}