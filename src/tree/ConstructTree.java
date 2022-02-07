package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class ConstructTree {

	
	/**
	 * Input: inorder = [9,3,15,20,7], 
	 * 			postorder = [9,15,7,20,3]
		Output: 	
						3
					 9        20
			     null null   15  7
			     
			     
			     
			     
			     
			     
			     
			     
			     
			     
		 Input: inorder =  [1 9 6    3   15 20 7], 
	 		    postorder = [1 6 9   15 7 20   3]
		Output: 	
						 3
					 9        20
			     1     6   15    7

	 *
	 */
	public static void main(String[] args) {
			
		int [] inorder = {9,3,15,20,7};
		int [] postorder = {9,15,7,20,3};
		
		int i = 0; 
		
		TreeNode r1 = new TreeNode(1);
		TreeNode r2 = new TreeNode(3);
		TreeNode r3 = new TreeNode(2);
		TreeNode r4 = new TreeNode(5);
		TreeNode r5 = new TreeNode(3);
		TreeNode r6 = new TreeNode(9);
		TreeNode r7 = new TreeNode(9);

		r1.left = r2; r1.right =r3;
		r2.left=r4; r3.right = r5;
		
		r4.left=r6; r5.right = r7;
		
		
		TreeNode x1 = new TreeNode(1);
		TreeNode x2 = new TreeNode(2);
		TreeNode x3 = new TreeNode(3);
		TreeNode x4 = new TreeNode(4);
		TreeNode x5 = new TreeNode(5);
		TreeNode x6 = new TreeNode(6);
		TreeNode x7 = new TreeNode(7);
		x1.left = x2;x1.right = x3;x2.left = x4;x3.left = x5;
		x4.left = x6;x5.left = x7;
		
		System.out.print(widthOfBinaryTree(x1));
		
	}
	
		/**
		 * [                   [0
		 * 				    0                 ,0
		 *              null 0               0,null
		 *               null,0,           0,null
		 *                null,0,         0,null,
		 *                 null,0		 0,null,
		 *                  null,0,     0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,
		 *                  
		 *                    null,0,0,null]
		 *         
		 *                1
		 *              1        1
		 *           1,null     1,null
		 *        1,null       1,null
		 *      1,null       1,null,
		 *    1,null       1,null  
		 *  1,null,  1,null,
		 *1,null null,1
		*1,null     1,null,
	   *1,null   1,null,1,null]
		 *         	
		 *         
		 *         
		 *         		[1,
		 *         		  3,		2
		 *              5   null   null 9
		 *           6 null,        null,7
		 *         
		 */
	
	public static int max(TreeNode node, int level, List<Integer[]> list) {
		
		
		return 0;
	}
	
	
    public static int widthOfBinaryTree(TreeNode root) {
        
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.add(root);
    	
    	int r = Integer.MIN_VALUE;
    	while (!queue.isEmpty()) {
    		int s = queue.size();
    		int i = 0; int j = 0;
    		int k = 0;
    		boolean ok = false;
    		while (s > 0) {
    			
        		TreeNode n = queue.poll();
        		System.out.print(n != null ? n.val  + " _ ": null + " _ ");
        		
        		if (n == null) {
        			if (ok) {
        				queue.add(null);queue.add(null);	
        			}
        			if (j > 0) k++;
        		} else {
            		
            		if(n.left != null || (ok && s>1) || (s==1 && n.right !=null)) queue.add(n.left);
            		
            		if (n.left != null) ok = true;
            		
            		if(n.right != null || (ok && s > 1 )) queue.add(n.right);
            		
            		
            		if (i== 0) {
            			i++; j ++;
            		} else if (k > 0) {
						j = j + k + 1;k=0;
					} else {
						j ++;
						k = 0;
					}
        		}
        		s --;
    		}
    		
    		System.out.println();
    		
    		if (i == 0 && j == 0) return r;
    		r = Math.max(r, j-i + 1);
    	}
    	return r;
    }
	

	private static int cal(List<Integer> list) {
		int k = 0; int l = list.size() -1;
		boolean t = false, s = false;
		while (k <=l && (!t || !s)) {
			if (list.get(k) != null && !t) {
				t= true;
			} else if(!t) {
				k ++;
			}
			if (list.get(l) != null && !s) {
				s= true;
			} else if(!s) {
				 l --;
			}
			
		}
		return l -k +1;
	}

	private static TreeNode[] construct(TreeNode current, int[] inorder, int[] postorder) {

		
		if (inorder.length == 2) return new TreeNode[] { new TreeNode(inorder[0]), new TreeNode(inorder[0])};
		

		TreeNode[] nodes = new TreeNode[2];
		int i = 0;
		
		while (i < inorder.length) {
			
			TreeNode[] rights = null;
			
			int  j = i;
			for (j = i; i < postorder.length; j ++) {
				if (postorder[j] == inorder[i]) {
					
					rights = construct(current, Arrays.copyOfRange(inorder, i, j + 1), 
												Arrays.copyOfRange(postorder, i, j + 1));
					
					break;
				}
			}
			
			rights[0].left = current;
			rights[0].right = rights[0];
			
			current = rights[0];
			
			i = j + 1;
		}
		

		return nodes;
		
	}

}
