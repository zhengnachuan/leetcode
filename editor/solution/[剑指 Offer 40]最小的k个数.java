//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 
// 👍 299 👎 0

package leetcode.editor.cn;

import com.netflix.eureka.V1AwareInstanceInfoConverter;

import java.awt.font.NumericShaper;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

//Java：最小的k个数
public class ZuiXiaoDeKgeShuLcof {
    public static void main(String[] args) {
        Solution solution = new ZuiXiaoDeKgeShuLcof().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            if (k == 0 || arr == null || arr.length == 0) {
                return new int[0];
            }
//            return this.stack(arr, k);
            return this.quickSearch(arr, 0, arr.length - 1, k - 1);
        }

        public int[] stack(int[] arr, int k) {
            // 大根堆
            Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
            for (int i : arr) {
                if (pq.size() < k) {
                    pq.offer(i);
//                    System.out.println("a:" + i);
                } else {
                    pq.offer(i);
                    pq.poll();
//                    System.out.println("b:" + i);
                }
            }
//            System.out.println("size:" + pq.size());
            int[] res = new int[k];
            int idx = 0;
            for (Integer num : pq) {
//                System.out.println("res:" + num);
                res[idx++] = num;
            }
            return res;
        }

        public int[] quickSearch(int[] arr, int left, int right, int k) {
            int res = partition(arr, left, right);
            if (res < k) {
                return quickSearch(arr, left + 1, right, k);
            } else if (res > k) {
                return quickSearch(arr, left, right - 1, k);
            }
            return Arrays.copyOf(arr, k + 1);
        }

        public int partition(int[] arr, int left, int right) {
            int temp = arr[left];
            while (left < right) {
                while (left < right && arr[right] >= temp) {
                    right--;
                }
                arr[left] = arr[right];
                while (left < right && arr[left] <= temp) {
                    left++;
                }
                arr[right] = arr[left];
            }
            arr[left] = temp;
            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}