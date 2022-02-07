package easy;

import java.util.List;
import java.util.Stack;

public class MergeTrees {

	public static void main(String[] args) {
			

		
		Node n8 = new Node(8);
		Node n9 = new Node(9);
		Node n10 = new Node(10);
		Node n11 = new Node(11);
		
		Node n12 = new Node(12);
		Node n13= new Node(13);
		Node n14 = new Node(14);
		Node n15 = new Node(15);
		
		Node n4 = new Node(4, n8,n9);
		Node n5 = new Node(5, n10, n11);
		Node n6 = new Node(6, n12, n13);
		Node n7 = new Node(7, n14, n15);
		
		Node n2 = new Node(2,n4,n5);
		Node n3 = new Node(3,n6, n7);
		Node n1 = new Node(1,n2,n3);
		
		nextRightV2(n1);
	}
	
	// 			   1
	// 		 2          3
	//     4    5     6      7
	//   8  9 10 11 12 13  14 15
	
    public static Node nextRightV2(Node root) {
    	
        if (root == null) return null;
        
        root.next = null;
        Node head = root;
        
        while (head.left != null) {
        	
        	Node temp = head;
        	while(temp != null) {
            	temp.left.next = temp.right;
            	temp.right.next = temp.next != null ? temp.next.left: null;
            	
            	temp = temp.next;
        	}
        	
        	head = head.left;
        }
    	return root;
    }
    
    public static Node nextRight(Node root1) {
    	
        if (root1 == null) return null;
        
    	List<Node> list = new Stack<Node>();
    	list.add(root1);
    	int  c = 1;
    	while (list.size() > 0) {
    		Node n = list.remove(0); 
    		if (n.left != null) {
    			list.add(n.left);
    			list.add(n.right);
    			c += 2;
    			if ( isPower(c + 1)) {
        			n.left.next = n.right;
        			n.right.next = null;
        		} else {
        			n.left.next = n.right;
        			if (list.get(0) != null) 	
        				n.right.next = list.get(0).left;
        		}
    			
    		} else {
    			n.next = list.isEmpty() ? null : list.get(0);
    		}

    	}
    	
    	return root1;
    }
    
    public static boolean isPower(int t) {
    	if (t < 1 ) return false;
    	while (t > 2) {
    		if (t % 2 == 1) return false;
    		t = t / 2;
    	}
    	return true;
    }
	
	
    public Node mergeTrees(Node root1, Node root2) {
        if(root1 == null) return root2;
        if (root2 == null) return root1;
        
        root1.val = root1.val + root2.val;
        
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
    	
    	return root1;
    }

	public  static class Node {
       int val;
       Node left;
       Node right;
       Node next;
       Node() {}
       Node(int val) { this.val = val; }
       Node(int val, Node left, Node right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
       Node(int val, Node left, Node right, Node next) {
           this.val = val;
           this.next = next;
           this.left = left;
           this.right = right;
       }
	}
	 
}
