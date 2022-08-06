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
// Related Topics数组 | 矩阵 | 模拟 
//
// 👍 1137, 👎 0 
//
//
//
//

package leetcode.editor.cn;

//Java：螺旋矩阵
public class SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrix().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // https://leetcode.cn/problems/spiral-matrix/solution/by-da-yu-bt-szwe/
        public List<Integer> spiralOrder(int[][] matrix) {

            int left_bound = 0, right_bound = matrix[0].length - 1;
            int upper_bound = 0, lower_bound = matrix.length - 1;
            List<Integer> res = new ArrayList<Integer>();

            while (left_bound <= right_bound && upper_bound <= lower_bound) {
                // left -> right（左闭右闭）
                System.out.println("1");
                for (int j = left_bound; j <= right_bound; j++) {
                    System.out.println("(" + upper_bound + "," + j + ")");
                    res.add(matrix[upper_bound][j]);
                }
                // up -> down（上开下闭）
                System.out.println("2");
                for (int j = upper_bound + 1; j <= lower_bound; j++) {
                    System.out.println("(" + j + "," + (right_bound) + ")");
                    res.add(matrix[j][right_bound]);
                }
                if (left_bound < right_bound && upper_bound < lower_bound) {
                    // right -> left（右开左闭）
                    System.out.println("3");
                    for (int j = right_bound - 1; j >= left_bound; j--) {
                        System.out.println("(" + (lower_bound) + "," + j + ")");
                        res.add(matrix[lower_bound][j]);
                    }
                    // down -> up（下开上开）
                    System.out.println("4");
                    for (int j = lower_bound - 1; j > upper_bound; j--) {
                        System.out.println("(" + j + "," + left_bound + ")");
                        res.add(matrix[j][left_bound]);
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