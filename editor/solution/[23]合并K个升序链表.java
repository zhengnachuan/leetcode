//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
// Related Topics 链表 分治 堆（优先队列） 归并排序 
// 👍 1492 👎 0

package leetcode.editor.cn;

import com.ke.breeze.cashcow.birch.VirtualShopTeamImportTest;
import com.netflix.eureka.V1AwareInstanceInfoConverter;

import java.util.PriorityQueue;
import java.util.Queue;

//Java：合并K个升序链表
public class MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
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
        public ListNode mergeKLists(ListNode[] lists) {
//            return this.queue(lists);
            return this.divided(lists, 0, lists.length - 1);
        }

        ListNode queue(ListNode[] lists) {

            Queue<ListNode> pq = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
            for (ListNode list : lists) {
                if (node != null) {
                    pq.offer(list);
                }
            }
            ListNode sentinel = new ListNode(-1);
            ListNode pre = sentinel;
            while (!pq.isEmpty()) {
                ListNode poll = pq.poll();
                pre.next = poll;
                pre = poll;
                if (poll.next != null) {
                    pq.offer(poll.next);
                }
            }
            return sentinel.next;
        }
//
//        public ListNode divided(ListNode[] lists, int left, int right) {
//            if (left == right) {
//                return lists[left];
//            }
//            int mid = left + (right - left) / 2;
//            ListNode l1 = divided(lists, left, mid);
//            ListNode l2 = divided(lists, mid + 1, right);
//            return merge(l1, l2);
//        }
//
//        public ListNode merge(ListNode l1, ListNode l2) {
//            if (l1 == null) return l2;
//            if (l2 == null) return l1;
//            if (l1.val < l2.val) {
//                l1.next = merge(l1.next, l2);
//                return l1;
//            } else {
//                l2.next = merge(l1, l2.next);
//                return l2;
//            }
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}