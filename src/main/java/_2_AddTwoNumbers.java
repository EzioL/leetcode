import java.util.List;

/**
 * Here be dragons !
 * https://leetcode-cn.com/problems/add-two-numbers/
 *
 * @author: Ezio
 * created on 2020/5/11
 */
public class _2_AddTwoNumbers {
    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            ListNode result = new ListNode(0);
            ListNode p = l1;
            ListNode q = l2;
            int carry = 0;
            ListNode curr = result;
            while (p != null || q != null) {
                int x = (p != null) ? p.val : 0;
                int y = (q != null) ? q.val : 0;
                int sum = carry + x + y;
                carry = sum >= 10 ? 1 : 0;

                curr.next = new ListNode(sum % 10);
                curr = curr.next;

                if (p != null) {
                    p = p.next;
                }
                if (q != null) {
                    q = q.next;
                }
            }
            if (carry > 0) {
                curr.next = new ListNode(carry);
            }
            return result.next;
        }
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode listNode2 = new ListNode(7, new ListNode(8, new ListNode(9)));

        Solution solution = new Solution();
        ListNode res = solution.addTwoNumbers(listNode, listNode2);
        System.out.println(res);


    }


}
