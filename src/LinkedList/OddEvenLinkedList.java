package LinkedList;

/**
 * @author Quang-Khai TRAN
 * @date 15/03/2023
 *
 * https://leetcode.com/problems/odd-even-linked-list/
 */

public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        ListNode root = head;
        if (root == null || root.next == null) return root;

        ListNode s1 = head.next;
        ListNode f = head;
        ListNode s = head.next;

        while (s.next != null) {
            f.next = s.next;
            f = f.next;
            if (s.next.next != null) {
                s.next = s.next.next;
                s = s.next;
            } else {
                s.next = null;
            }
        }
        f.next = s1;
        return head;
    }

}
