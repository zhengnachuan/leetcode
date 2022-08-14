//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。 
//
// 
//
// 示例 1: 
//
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
// Related Topics树 | 数组 | 哈希表 | 分治 | 二叉树 
//
// 👍 1690, 👎 0 
//
//
//
//

package leetcode.editor.cn;

//Java：从前序与中序遍历序列构造二叉树
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            for (int i = 0; i < inorder.length; i++) {
                inOrderMap.put(inorder[i], i);
            }
            return this.buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        public TreeNode buildTree(int[] preorder, int preBegin, int preEnd, int[] inorder, int inBegin, int inEnd) {

            if (inBegin > inEnd) {
                return null;
            }

            int index = inOrderMap.get(preorder[preBegin]);

            TreeNode node = new TreeNode(preorder[preBegin]);
            node.left = this.buildTree(preorder, preBegin + 1, preBegin + index - inBegin, inorder, inBegin, index - 1);
            node.right = this.buildTree(preorder, preBegin + index - inBegin + 1, preEnd, inorder, index + 1, inEnd);
            return node;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}