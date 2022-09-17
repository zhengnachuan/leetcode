//给定一个整数数组 arr，如果它是有效的山脉数组就返回 true，否则返回 false。 
//
// 让我们回顾一下，如果 arr 满足下述条件，那么它是一个山脉数组： 
//
// 
// arr.length >= 3 
// 在 0 < i < arr.length - 1 条件下，存在 i 使得：
// 
// arr[0] < arr[1] < ... arr[i-1] < arr[i] 
// arr[i] > arr[i+1] > ... > arr[arr.length - 1] 
// 
// 
// 
//
// 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [2,1]
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：arr = [3,5,5]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：arr = [0,3,2,1]
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10⁴ 
// 0 <= arr[i] <= 10⁴ 
// 
// Related Topics数组 
//
// 👍 191, 👎 0 
//
//
//
//

package leetcode.editor.cn;

//Java：有效的山脉数组
public class ValidMountainArray {
    public static void main(String[] args) {
        Solution solution = new ValidMountainArray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validMountainArray(int[] arr) {
            if (arr.length < 3) {
                return false;
            }
            int index = 0;
            while (index < arr.length - 1 && arr[index] < arr[index + 1]) {
                index++;
            }
            System.out.println(index);
            if (index == 0 || index == arr.length - 1) {
                return false;
            }
            while (index < arr.length - 1 && arr[index] > arr[index + 1]) {
                index++;
            }
            System.out.println(index);
            return index == arr.length - 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}