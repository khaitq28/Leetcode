package tree;


public class MaxDepth {

	 
	public static void main(String[] args) {
		
		TreeNode r1 = new TreeNode(1);
		TreeNode r2 = new TreeNode(2);
		TreeNode r3 = new TreeNode(3);
		TreeNode r4 = new TreeNode(4);
		TreeNode r5 = new TreeNode(4);

		r1.left = r2; r1.right = r3;
		r2.left = r4;
		//r4.right = r5;
		
		System.out.print(max(r1));
		
	}
	
	//   1
	//  2 3
	// 4
	//5
	
	public static int max(TreeNode root) {
		
		if (root == null) return 0;
		
		int l = 1 + max(root.left);
		int r = 1 + max(root.right);
		
		return r> l ? r: l;
	}

}
