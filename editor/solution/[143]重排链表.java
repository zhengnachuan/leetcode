//给定一个单链表 L 的头节点 head ，单链表 L 表示为： 
//
// L0 → L1 → … → Ln-1 → Ln 
//请将其重新排列后变为： 
//
// L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → … 
//
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: head = [1,2,3,4]
//输出: [1,4,2,3] 
//
// 示例 2: 
//
// 
//
// 
//输入: head = [1,2,3,4,5]
//输出: [1,5,2,4,3] 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 5 * 104] 
// 1 <= node.val <= 1000 
// 
// Related Topics 栈 递归 链表 双指针 
// 👍 660 👎 0

package leetcode.editor.cn;

import com.ke.breeze.cashcow.birch.VirtualShopTeamImportTest;

import java.util.Stack;

//Java：重排链表
public class ReorderList {
    public static void main(String[] args) {
        Solution solution = new ReorderList().new Solution();
        // TO TEST
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
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
        public void reorderList(ListNode head) {
            this.stack(head);
        }

        public void stack(ListNode head) {
            if (head == null || head.next == null || head.next.next == null) {
                return;
            }
            ListNode fast = head;
            ListNode slow = head;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            slow = slow.next;
            Stack<ListNode> stack = new Stack<>();
            while (slow != null) {
                stack.push(slow);
                slow = slow.next;
            }

            ListNode temp;
            while (!stack.isEmpty()) {
                temp = head.next;
                System.out.println(stack.peek().val);
                ListNode cur = stack.pop();
                head.next = cur;
                cur.next = temp;
                head = temp;
            }
            head.next = null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}