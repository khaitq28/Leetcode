package daily;

import tree.TreeNode;

/**
 * @author Quang-Khai TRAN
 * @date 17/05/2024
 */

public class EvaluateBooleanBt {

    public static void main(String[] args) {

    }

    public static boolean evaluate(TreeNode node) {

        if (node.left == null && node.right == null) {
            return node.val == 1;
        }
        if (node.val == 2) {
            return evaluate(node.left) || evaluate(node.right);
        } else {
            return evaluate(node.left) && evaluate(node.right);
        }
    }


}
