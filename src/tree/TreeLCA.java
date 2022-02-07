package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeLCA {

	public static void main(String[] args) {

		TreeNode r1 = new TreeNode(3);
		TreeNode r2 = new TreeNode(5);
		TreeNode r3 = new TreeNode(1);
		TreeNode r4 = new TreeNode(6);
		TreeNode r5 = new TreeNode(2);
		TreeNode r6 = new TreeNode(0);
		TreeNode r7 = new TreeNode(8);
		TreeNode r8 = new TreeNode(8); r1.left = r2; r1.right = r3;
		r2.left = r4; r2.right = r5;
		r3.left = r6; r3.right = r7;
		
		
		System.out.print(path(r1, r5));
	}
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		
		List<TreeNode> l1 = path(root, p);
		List<TreeNode> l2 = path(root, q);
		
		for (TreeNode n : l1) {
			if (n.val == l2.get(l1.indexOf(n)).val)
				return n;
		}
		return root;
        
		
		// 2 3 5 6 
		// 4 5 
    }
	
	private static List<TreeNode> path(TreeNode root, TreeNode p) {
		List<TreeNode>  list = new ArrayList<TreeNode>();
		if ((root.left != null && root.left.val == p.val) || (root.right != null && root.right.val == p.val)) {
			list.add(p);
			list.add(root);
			return list;
		}
		
		if (root.left !=null) {
			List<TreeNode> left = path(root.left, p);
			if (!left.isEmpty()) {
				list.addAll(left);
				list.add(root);
			}
		}
		if (root.right !=null) {
			List<TreeNode> left = path(root.right, p);
			if (!left.isEmpty()) {
				list.addAll(left);
				list.add(root);
			}
		}
		return list;
	}

}
