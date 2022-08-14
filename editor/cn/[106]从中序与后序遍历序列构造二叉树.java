//给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并
//返回这颗 二叉树 。 
//
// 
//
// 示例 1: 
//
// 
//输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//输出：[3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入：inorder = [-1], postorder = [-1]
//输出：[-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= inorder.length <= 3000 
// postorder.length == inorder.length 
// -3000 <= inorder[i], postorder[i] <= 3000 
// inorder 和 postorder 都由 不同 的值组成 
// postorder 中每一个值都在 inorder 中 
// inorder 保证是树的中序遍历 
// postorder 保证是树的后序遍历 
// 
// Related Topics树 | 数组 | 哈希表 | 分治 | 二叉树 
//
// 👍 816, 👎 0 
//
//
//
//

package leetcode.editor.cn;

//Java：从中序与后序遍历序列构造二叉树
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
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
        Map<Integer, Integer> inOrderMap = new HashMap<>();

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            for (int i = 0; i < inorder.length; i++) {
                inOrderMap.put(inorder[i], i);
            }
            return this.buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        }

        public TreeNode buildTree(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {

            if (inBegin > inEnd) {
                return null;
            }
            int index = inOrderMap.get(postorder[postEnd]);

            TreeNode node = new TreeNode(postorder[postEnd]);
            node.left = this.buildTree(inorder, inBegin, index - 1, postorder, postBegin, postBegin + index - inBegin - 1);
            node.right = this.buildTree(inorder, index + 1, inEnd, postorder, postBegin + index - inBegin, postEnd - 1);
            return node;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}