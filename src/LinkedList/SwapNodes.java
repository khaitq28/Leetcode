package LinkedList;

/**
 * @author Quang-Khai TRAN
 * @date 15/03/2023
 */

public class SwapNodes {

    //swap k-th node from begin and end

    public ListNode swapNodes(ListNode head, int k) {
        ListNode root = head;
        ListNode end = head;
        ListNode begin = head;
        int i =1;
        int j = 1;
        while(head.next != null) {
            head = head.next;
            i++;
            if (i - k > 0) {
                end = end.next;
            }
            if (i -1 < k) {
                begin = begin.next;
            }
        }
        int t = begin.val;
        begin.val = end.val;
        end.val = t;
        return root;
    }
}
