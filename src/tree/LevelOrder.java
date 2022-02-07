package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import tree.InOrder.TreeNode;

public class LevelOrder {

	/**
	 * Breadth-First Search is an algorithm to traverse or search in data structures like a tree or a graph. 
	 * The algorithm starts with a root node and visit the node itself first. Then traverse its neighbors,
	 * traverse its second level neighbors, traverse its third level neighbors, so on and so forth.
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



		
		TreeNode r1 = new TreeNode(1);
		TreeNode r2 = new TreeNode(2);
		TreeNode r3 = new TreeNode(3);
		TreeNode r4 = new TreeNode(4);

		r1.left = r2; r1.right = r3;
		r2.left = r4;
		
		System.out.print(levelOrder(r1));
		
	}
	//[1
	// 2 3 
	// 4
	public static List<List<Integer>> levelOrder(TreeNode node) {
		
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		
		queue.add(node);
		
		TreeNode temp = null;
		
		while (!queue.isEmpty()) {
			
			List<Integer> subList = new ArrayList<Integer>();
			int size = queue.size();
			
			while (size > 0) {
				temp = queue.pop();
				
				subList.add(temp.val);
				
				if (temp.left != null) {
					queue.add(temp.left);			
				}
				if (temp.right != null) {
					queue.add(temp.right);	

				}
				size --;
			}
			list.add(subList);
		}
		return list;
	}

}
