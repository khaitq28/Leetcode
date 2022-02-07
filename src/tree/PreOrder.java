package tree;

import java.util.ArrayList;
import java.util.List;

public class PreOrder {
	
	/**
	 * Pre-order traversal is to visit the root first. 
	 * Then traverse the left subtree.
	 * Finally, traverse the right subtree. Here is an example:
	 *
	 */
	
	 public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode() {}
	     TreeNode(int val) { this.val = val; }
	     TreeNode(int val, TreeNode left, TreeNode right) {
	         this.val = val;
	         this.left = left;
	         this.right = right;
	     }
	}
	 

	public static void main(String[] args) {

		//[1,null,2,3]
			
		TreeNode root = new TreeNode(1);
		TreeNode r2 = new TreeNode(2);
		TreeNode r3 = new TreeNode(3);

		root.right = r2; r2.left = r3;
		
		System.out.print(preorderTraversal(root));
		
	}
	
	public static List<Integer> preorderTraversal(TreeNode root) {
		
		List<Integer> list = new ArrayList<>();
		
		list.add(root.val);

		if (root.left != null) {
			list.addAll(preorderTraversal(root.left));
		}
		
		if (root.right != null) {
			list.addAll(preorderTraversal(root.right));
		}
		
		return list;
    }


}
