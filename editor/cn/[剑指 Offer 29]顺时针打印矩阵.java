//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
// Related Topics数组 | 矩阵 | 模拟 
//
// 👍 430, 👎 0 
//
//
//
//

package leetcode.editor.cn;

//Java：顺时针打印矩阵
public class ShunShiZhenDaYinJuZhenLcof {
    public static void main(String[] args) {
        Solution solution = new ShunShiZhenDaYinJuZhenLcof().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] spiralOrder(int[][] matrix) {

            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return new int[0];
            }
            int left_bound = 0, right_bound = matrix[0].length - 1;
            int upper_bound = 0, lower_bound = matrix.length - 1;
            int[] res = new int[matrix.length * matrix[0].length];
            int nums = 0;
            while (left_bound <= right_bound && upper_bound <= lower_bound) {
                // left -> right（左闭右闭）
                System.out.println("1");
                for (int j = left_bound; j <= right_bound; j++) {
                    System.out.println("(" + upper_bound + "," + j + ")");
                    res[nums++] = matrix[upper_bound][j];
                }
                // up -> down（上开下闭）
                System.out.println("2");
                for (int j = upper_bound + 1; j <= lower_bound; j++) {
                    System.out.println("(" + j + "," + (right_bound) + ")");
                    res[nums++] = matrix[j][right_bound];
                }
                if (left_bound < right_bound && upper_bound < lower_bound) {
                    // right -> left（右开左闭）
                    System.out.println("3");
                    for (int j = right_bound - 1; j >= left_bound; j--) {
                        System.out.println("(" + (lower_bound) + "," + j + ")");
                        res[nums++] = matrix[lower_bound][j];
                    }
                    // down -> up（下开上开）
                    System.out.println("4");
                    for (int j = lower_bound - 1; j > upper_bound; j--) {
                        System.out.println("(" + j + "," + left_bound + ")");
                        res[nums++] = matrix[j][left_bound];
                    }
                }
                left_bound++;
                upper_bound++;
                right_bound--;
                lower_bound--;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}