/**
 * Here be dragons !
 * https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * @author: Ezio
 * created on 2020/5/5
 */
public class _206_ReverseList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }


    static class Solution1 {
        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode nextTemp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextTemp;
            }
            return prev;
        }
    }


    static class Solution2 {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode p = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return p;
        }
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        listNode1.setNext(new ListNode(3));
        listNode.setNext(listNode1);

//        Solution1 solution1 = new Solution1();
//        ListNode listNode2 = solution1.reverseList(listNode);
//        System.out.println(listNode2);

        Solution2 solution2 = new Solution2();
        ListNode listNode3 = solution2.reverseList(listNode);
        System.out.println(listNode3);

    }
}
