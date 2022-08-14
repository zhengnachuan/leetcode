//给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。 
//
// 假设二叉树中至少有一个节点。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: root = [2,1,3]
//输出: 1
// 
//
// 示例 2: 
//
// 
//
// 
//输入: [1,2,3,4,null,5,6,null,null,7]
//输出: 7
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [1,10⁴] 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
// Related Topics树 | 深度优先搜索 | 广度优先搜索 | 二叉树 
//
// 👍 371, 👎 0 
//
//
//
//

package leetcode.editor.cn;

//Java：找树左下角的值
public class FindBottomLeftTreeValue {
    public static void main(String[] args) {
        Solution solution = new FindBottomLeftTreeValue().new Solution();
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

        public int value = 0;
        public int deep = -1;

        public int findBottomLeftValue(TreeNode root) {
            this.findLeftValue(root, 0);
            return value;
        }

        public void findLeftValue(TreeNode node, int depth) {
            if (depth > deep) {
                deep = depth;
                value = node.val;
            }
            if (node.left != null) {
                findLeftValue(node.left, depth + 1);
            }
            if (node.right != null) {
                findLeftValue(node.right, depth + 1);
            }
        }

        public int findBottomLeftValue1(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            int res = 0;
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (i == 0) {
                        res = node.val;
                    }
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}