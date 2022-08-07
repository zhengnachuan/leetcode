//给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[15,7],[9,20],[3]]
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
// 👍 604, 👎 0 
//
//
//
//

package leetcode.editor.cn;

//Java：二叉树的层序遍历 II
public class BinaryTreeLevelOrderTraversalIi {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversalIi().new Solution();
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

        public LinkedList<List<Integer>> result = new LinkedList<>();

        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            this.fun1(root);
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
                result.addFirst(list);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}