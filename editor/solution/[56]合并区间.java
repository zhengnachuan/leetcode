//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
//
//
//
// 示例 1：
//
//
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//
//
// 示例 2：
//
//
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
//
//
//
// 提示：
//
//
// 1 <= intervals.length <= 104
// intervals[i].length == 2
// 0 <= starti <= endi <= 104
//
// Related Topics 数组 排序
// 👍 1090 👎 0

package leetcode.editor.cn;

import com.netflix.eureka.V1AwareInstanceInfoConverter;
import org.mockito.internal.creation.bytebuddy.SubclassLoader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：合并区间
public class MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            int length = intervals.length;
            int[][] res = new int[length][2];
            int i = 0;
            Arrays.sort(intervals, (v1, v2) -> (v1[0] - v2[0]));
            int left = intervals[0][0];
            int right = intervals[0][1];
            res[0] = intervals[0];
            for (int[] interval : intervals) {
                if (interval[0] <= right) {
                    res[i][0] = left;
                    right = Math.max(right, interval[1]);
                    res[i][1] = right;
                } else {
                    left = interval[0];
                    right = interval[1];
                    res[++i] = interval;
                }
            }
            return Arrays.copyOf(res, i + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}