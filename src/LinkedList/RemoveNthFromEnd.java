package LinkedList;

/**
 * @author Quang-Khai TRAN
 * @date 14/03/2023
 */

//https://leetcode.com/problems/remove-nth-node-from-end-of-list/

public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head.next == null) return null;

        ListNode root = head;
        int c = 1;
        while (head.next != null) {
            head = head.next;
            c ++;
        }
        if (n == c) return root.next;

        head = root;
        int k = c - n +1;

        int i = 1;
        while(head.next != null && i < k-1) {
            head = head.next;
            i++;
        }
        head.next = head.next.next;

        return root;

    }

}
