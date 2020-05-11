/**
 * Here be dragons !
 *
 * @author: Ezio
 * created on 2020/5/5
 */
public class ListNode {


    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
    ListNode(int x , ListNode next) {
        val = x;
        this.next = next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
