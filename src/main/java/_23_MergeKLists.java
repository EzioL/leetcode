import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Here be dragons !
 *
 * @author: Ezio
 * created on 2020/5/5
 */
public class _23_MergeKLists {


    // 分治
    static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode res = null;
            for (ListNode list : lists) {
                res = mergeTwoLists(res, list);
            }
            return res;
        }

        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            if (l1.val < l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }
        }
    }

    // 优先队列
    static class Solution2 {
        public ListNode mergeKLists(ListNode[] lists) {
            Queue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(v -> v.val));

            for (ListNode node : lists) {
                if (node != null) {
                    pq.offer(node);
                }
            }

            ListNode dummyHead = new ListNode(0);
            ListNode tail = dummyHead;
            while (!pq.isEmpty()) {
                ListNode minNode = pq.poll();
                tail.next = minNode;
                tail = minNode;
                if (minNode.next != null) {
                    pq.offer(minNode.next);
                }
            }
            return dummyHead.next;
        }
    }

}
