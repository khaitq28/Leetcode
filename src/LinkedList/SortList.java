package LinkedList;

/**
 * @author Quang-Khai TRAN
 * 20/03/2023
 */

public class SortList {

    public ListNode sortList(ListNode head) {
        ListNode root = head;
        if (head == null) return head;
        int i = 1;
        while (head.next != null) {
            i++;
            head = head.next;
        }
        return sort(root, i);
    }

    ListNode sort(ListNode root, int n) {
        if (n == 1) return root;
        int m = n/2;
        ListNode s1 = root;
        ListNode s2 = root;
        int i = 1;
        while ( i < m) {
            s2 = s2.next;
            i++;
        }
        ListNode t = s2;
        s2 = s2.next;
        t.next = null;

        return merge( sort(s1, i), sort(s2, n -i));
    }
    ListNode merge(ListNode s1, ListNode s2) {
        if (s1.val > s2.val) {
            ListNode temp = s1;
            s1 = s2;
            s2 = temp;
        }
        ListNode ret =s1;    //-1,5  = 0,3,4 //
        while (s1.next !=null && s2 != null) {
            int t1 = s1.next.val; // 3
            int t2 = s2.val;     //2
            if (t1 <= t2) {
                s1 = s1.next;
            } else {
                ListNode tem = s1.next;
                s1.next=s2;

                ListNode xx = s2;
                s2 = s2.next;
                xx.next = null;
                s1= s1.next;
                s1.next =tem;
            }
        }
        if (s1.next != null) return ret;
        else s1.next =s2;
        return   ret;
    }
}
