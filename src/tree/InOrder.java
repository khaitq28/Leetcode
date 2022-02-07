package tree;

import java.util.ArrayList;
import java.util.List;

import tree.PreOrder.TreeNode;

public class InOrder {

	/**
	 * In-order traversal is to traverse the left subtree first. 
	 * Then visit the root. 
	 * Finally, traverse the right subtree.
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
		
		
		List<Integer> list = new ArrayList<>();

		inorderTraversal(root, list);
		System.out.print(list);
		
		
	}
	
    public static List<Integer> inorderTraversal(TreeNode root, List<Integer> list) {
    	
		if (root == null) return list;

		if (root.left != null) {
			inorderTraversal(root.left, list);
		}
		
		list.add(root.val);
		
		if (root.right != null) {
			inorderTraversal(root.right, list);
		}
		
		return list;
        
    }

}
