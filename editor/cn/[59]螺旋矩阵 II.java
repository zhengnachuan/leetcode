//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
// Related Topics数组 | 矩阵 | 模拟 
//
// 👍 756, 👎 0 
//
//
//
//

package leetcode.editor.cn;

//Java：螺旋矩阵 II
public class SpiralMatrixIi {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrixIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {

            int[][] res = new int[n][n];
            int num = 1;
            int i = -1;
            while (i++ < n / 2) {
                // 中心
                if (i * 2 == n - 1) {
                    res[i][i] = num;
                    break;
                }
                // left -> right
                for (int j = i; j < n - i - 1; j++) {
                    System.out.println("(" + i + "," + j + "," + num + ")");
                    res[i][j] = num++;
                }
                // up -> down
                for (int j = i; j < n - i - 1; j++) {
                    System.out.println("(" + j + "," + (n - i - 1) + "," + num + ")");
                    res[j][n - i - 1] = num++;
                }
                // right -> left
                for (int j = n - i - 1; j > i; j--) {
                    System.out.println("(" + (n - i) + "," + j + "," + num + ")");
                    res[n - i - 1][j] = num++;
                }
                // down -> up
                for (int j = n - i - 1; j > i; j--) {
                    System.out.println("(" + j + "," + i + "," + num + ")");
                    res[j][i] = num++;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}