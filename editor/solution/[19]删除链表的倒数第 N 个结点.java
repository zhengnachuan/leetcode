//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
// 进阶：你能尝试使用一趟扫描实现吗？
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
//
//
// 示例 2：
//
//
//输入：head = [1], n = 1
//输出：[]
//
//
// 示例 3：
//
//
//输入：head = [1,2], n = 1
//输出：[1]
//
//
//
//
// 提示：
//
//
// 链表中结点的数目为 sz
// 1 <= sz <= 30
// 0 <= Node.val <= 100
// 1 <= n <= sz
//
// Related Topics 链表 双指针
// 👍 1542 👎 0

package leetcode.editor.cn;

import com.ke.breeze.cashcow.birch.VirtualShopTeamImportTest;

//Java：删除链表的倒数第 N 个结点
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode node = new ListNode(-1);
            node.next = head;
            ListNode fast = node;
            ListNode slow = node;
            for (int i = 1; i <= n; i++) {
                fast = fast.next;
            }
            while (fast != null && fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
            return node.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}