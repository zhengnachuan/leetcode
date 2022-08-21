import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }
        this.backtrack(n, 0, chessboard);
        return res;
    }

    public void backtrack(int n, int row, char[][] chessboard) {
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (char[] c : chessboard) {
                list.add(String.valueOf(c));
            }
            res.add(list);
        }
        for (int col = 0; col < n; col++) {
            if (this.isValid(row, col, n, chessboard)) {
                chessboard[row][col] = 'Q';
                this.backtrack(n, row + 1, chessboard);
                chessboard[row][col] = '.';
            }
        }
    }

    public boolean isValid(int row, int col, int n, char[][] chessboard) {
        // 检查列
        for (int i = 0; i < row; i++) {
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }
        // 检查45度对角线
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        // 检查135度对角线
        for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
