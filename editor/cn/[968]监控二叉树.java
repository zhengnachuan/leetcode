//给定一个二叉树，我们在树的节点上安装摄像头。 
//
// 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。 
//
// 计算监控树的所有节点所需的最小摄像头数量。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[0,0,null,0,0]
//输出：1
//解释：如图所示，一台摄像头足以监控所有节点。
// 
//
// 示例 2： 
//
// 
//
// 输入：[0,0,null,0,null,0,null,null,0]
//输出：2
//解释：需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。
// 
//
// 
//提示： 
//
// 
// 给定树的节点数的范围是 [1, 1000]。 
// 每个节点的值都是 0。 
// 
// Related Topics树 | 深度优先搜索 | 动态规划 | 二叉树 
//
// 👍 462, 👎 0 
//
//
//
//

package leetcode.editor.cn;

//Java：监控二叉树
public class BinaryTreeCameras {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeCameras().new Solution();
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
        int res = 0;

        public int minCameraCover(TreeNode root) {
            // 对根节点的状态做检验,防止根节点是无覆盖状态 .
            if (this.minCam(root) == 0) {
                res++;
            }
            return res;
        }

        /**
         * 节点的状态值：
         * 0 表示无覆盖
         * 1 表示 有摄像头
         * 2 表示有覆盖
         * 后序遍历，根据左右节点的情况,来判读 自己的状态
         */
        public int minCam(TreeNode root) {
            // 空节点默认为 有覆盖状态，避免在叶子节点上放摄像头
            if (root == null) {
                return 2;
            }
            int left = this.minCam(root.left);
            int right = this.minCam(root.right);

            // 如果左右节点都覆盖了的话, 那么本节点的状态就应该是无覆盖,没有摄像头
            if (left == 2 && right == 2) {
                return 0;
            } else if (left == 0 || right == 0) {
                // 左右节点都是无覆盖状态,那 根节点此时应该放一个摄像头
                // (0,0) (0,1) (0,2) (1,0) (2,0)
                // 状态值为 1 摄像头数 ++;
                res++;
                return 1;
            } else {
                // 左右节点的 状态为 (1,1) (1,2) (2,1) 也就是左右节点至少存在 1个摄像头，
                // 那么本节点就是处于被覆盖状态
                return 2;
            }
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}