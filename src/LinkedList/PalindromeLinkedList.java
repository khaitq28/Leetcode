package LinkedList;

import java.util.Stack;

/**
 * @author Quang-Khai TRAN
 * @date 14/03/2023
 */

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {

        Stack<Integer> stack = new Stack<>();
        ListNode l = head;
        while(head.next != null) {
            stack.add(head.val);
            head = head.next;
        }
        stack.add(head.val);
        int i = stack.size()/2;
        while (l.next != null && i>=0 ) {
            if (l.val != stack.pop()) return false;
            l = l.next;
            i--;
        }
        return true;
    }

}
