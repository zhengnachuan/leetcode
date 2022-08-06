//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
//
//
//
// 示例 1：
//
//
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
//
//
// 示例 2：
//
//
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
//
//
//
//
// 提示：
//
//
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 10
// -100 <= matrix[i][j] <= 100
//
// Related Topics 数组 矩阵 模拟
// 👍 862 👎 0

package leetcode.editor.cn;

import javax.swing.tree.FixedHeightLayoutCache;

//Java：螺旋矩阵
public class SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrix().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> res = new ArrayList<>();
            int height = matrix.length;
            int width = matrix[0].length;
            int count = (Math.min(height, width) + 1) / 2;
            // 圈数
            for (int i = 0; i < count; i++) {
                // 左 -> 右
                for (int j = i; j < width - i; j++) {
                    System.out.println("1:" + i + "," + j);
                    res.add(matrix[i][j]);
                }
                // 上 -> 下
                for (int k = i + 1; k < height - i; k++) {
                    System.out.println("2:" + k + "," + (width - i - 1));
                    res.add(matrix[k][width - i - 1]);
                }
                // 右 -> 左（注意是否只有一行）
                for (int j = width - i - 2; j >= i && height != 2 * i + 1; j--) {
                    System.out.println("3:" + (height - i - 1) + "," + j + "-w" + height);
                    res.add(matrix[height - i - 1][j]);
                }
                // 下 -> 上（注意是否只有一列）
                for (int k = height - i - 2; k > i && width != 2 * i + 1; k--) {
                    System.out.println("4:" + k + "," + i);
                    res.add(matrix[k][i]);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}