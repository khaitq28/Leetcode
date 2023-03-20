package tree;

/**
 * @author Quang-Khai TRAN
 *
 *
 * balanced: if diff between left and right <= 1, and left + rigtht are balanced too
 *
 */

public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {

        if (root == null) return true;

        int l = root.left != null ? height(root.left) + 1 : 0;
        int r = root.right != null ? height(root.right) + 1 : 0;

        if (Math.abs(l -r) > 1) return false;

        return isBalanced(root.left) && isBalanced(root.right);

    }

    private int height(TreeNode node) {
        if (node == null) return 0;
        int l = node.left == null ? 0 : 1 + height(node.left);
        int r = node.right == null ? 0 : 1 + height(node.right);
        return Math.max(l, r);
    }

}
