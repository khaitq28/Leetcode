package top100;

import LinkedList.ListNode;

public class SwapNodes {

	public static void main(String[] args) {

		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		l1.next = l2; l2.next = l3; l3.next = l4;
		
		
		ListNode m = swapPairs2(l1);
		
		System.out.print(m);
	}
	
	/**
	 * Input: head = [1,2,3,4]
	 * 
			 Output: [2,1,4,3]
	 * @param head
	 * @return
	 */
    public  static ListNode swapPairs2(ListNode head) {
    	
    	if (head == null || head.next == null) {
    		return head;
    	}
    	ListNode res = head.next;
    	ListNode t = head.next.next;
    	head.next.next = head;
    	head.next = swapPairs2(t);
    	
    	return res;
    }
	
    public ListNode swapPairs(ListNode head) {
    	ListNode res = head;
    	
    	if (head == null || head.next == null) {
    		return head;
    	}
    	
		int t = head.val;
		head.val = head.next.val;
		head.next.val = t;
    		
    	swapPairs(head.next.next);
    	return res;
    }

}
